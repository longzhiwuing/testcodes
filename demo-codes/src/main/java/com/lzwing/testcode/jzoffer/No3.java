package com.lzwing.testcode.jzoffer;

import java.util.Arrays;

public class No3 {
	/**
	 * 在一个二维数组中，每一行都按照从左到右递增 的顺序排序，每一列都按照从上到下递增的顺序排序。 请完成一个函数，输入这样的一个二维数组
	 * 和一个整数，判断数组中是否函数该整数。
	 */
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 8, 9, 11 }, { 2, 4, 9, 12, 15 }, { 4, 7, 10, 13, 18 }, { 6, 8, 14, 16, 21 } };
		/*
		 * int[][] arr={ {1,2,8}, {2,4,9,12,17}, {4,7,10,13}, {6,8} };
		 */
		System.out.println(search(arr, 18));
	}

	private static boolean search(int[][] arr, int searchNum) {

		boolean res = false;

		int columnCountMax = arr[0].length;
		int[] rowMaxArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int rowMaxIndex = arr[i].length - 1;
			if (rowMaxIndex + 1 > columnCountMax) {
				columnCountMax = rowMaxIndex + 1;
			}
			int rowMax = arr[i][rowMaxIndex];
			rowMaxArr[i] = rowMax;
		}

		int[] columnMaxArr = new int[columnCountMax];

		// 保存当前列最大数组的index
		int columnMaxArrIndex = 0;

		// 先把最后一行数字填充到列最大数组中
		for (int j = 0; j < arr[arr.length - 1].length; j++) {
			columnMaxArr[j] = arr[arr.length - 1][j];
			columnMaxArrIndex++;
		}

		if (arr[arr.length - 1].length < columnCountMax) {
			for (int i = arr.length - 1; i >= 0 && columnMaxArrIndex <= columnCountMax - 1; i--) {
				int startIndex = columnMaxArrIndex;
				for (int j = startIndex; j < arr[i].length; j++) {
					columnMaxArr[j] = arr[i][j];
					columnMaxArrIndex++;
				}
			}
		}

		System.out.println(Arrays.toString(rowMaxArr));
		System.out.println(Arrays.toString(columnMaxArr));

		int rowIndex = 0;
		for (int i = 0; i < rowMaxArr.length; i++) {
			if (rowMaxArr[i] > searchNum) {
				rowIndex = i;
				break;
			}
			if (i == rowMaxArr.length - 1) {
				rowIndex = i;
			}
		}

		int columnIndex = 0;
		for (int j = 0; j < columnMaxArr.length; j++) {
			if (columnMaxArr[j] > searchNum) {
				columnIndex = j;
				break;
			}
			if (j == columnMaxArr.length - 1) {
				columnIndex = j;
			}
		}

		System.out.println(rowIndex);
		System.out.println(columnIndex);

		int findCount = 0;
		for (int i = rowIndex; i < arr.length; i++) {
			for (int j = columnIndex; j < arr[i].length; j++) {
				findCount++;
				if (arr[i][j] == searchNum) {
					System.out.println("searchNum:" + searchNum + "  i,j==>" + i + "," + j + ",findCount:" + findCount);
					res = true;
					break;
				}
			}
		}

		System.out.println("=========");

		int commonFindCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				commonFindCount++;
				if (arr[i][j] == searchNum) {
					System.out.println("commonMethods:searchNum:" + searchNum + "  i,j==>" + i + "," + j
							+ ",commonFindCount:" + commonFindCount);
					res = true;
					break;
				}
			}
		}

		return res;
	}
}