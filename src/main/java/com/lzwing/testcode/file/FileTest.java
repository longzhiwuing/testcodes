/**
 * Project Name:testcode
 * File Name:FileTest.java
 * Package Name:com.lzwing.testcode.file
 * Date:2018年1月18日下午4:30:29
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.file;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * ClassName:FileTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2018年1月18日 下午4:30:29 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
public class FileTest {

	static int fileCount = 0;

	public static void main(String[] args) throws Exception {

		 String path = "D:\\Projects";
//		String path ="D:\\Projects\\AndroidProjects\\CommonDemo\\app\\src\\test\\java\\com\\lzw\\commondemo";
//		String path = "D:\\Projects\\VueProjects";
		Path dir = Paths.get(path);

		 getAlldirsWalkFileTree(dir);

	
//		 getDir(dir);
		 
		 System.out.println(fileCount);

//		 listDir(dir);
	}

	public static void listDir(Path dir) {
		try (Stream<Path> stream = Files.list(dir)) {
			Iterator<Path> ite = stream.iterator();
			while (ite.hasNext()) {
				Path pp = ite.next();
				System.out.println(pp.getFileName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getDir(Path dir) throws IOException {
		// try (DirectoryStream<Path> entries =
		// Files.newDirectoryStream(dir,"*.java")) {
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir)) {
			for (Path entry : entries) {
				if (entry.toFile().isFile()) {
					System.out.println(entry);
					fileCount++;
				} else {
					getDir(entry);
				}
			}
		}
	}

	public static void getAlldirsWalkFileTree(Path dir) throws IOException {
		/* 传入一个FileVisitor子类的匿名对象 */
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
			// walkFileTree回调此方法来遍历所有子孙
			public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
				// if (attrs.isDirectory()) //自定义的选择，属于业务代码，这和walkFileTree的宗旨(遍历所有子孙成员)无关
				if(path.toString().endsWith(".java")){
					fileCount++;
					System.out.println(path);
				}
				return FileVisitResult.CONTINUE;
			}

			public FileVisitResult visitFileFailed(Path path, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});
	}

}
