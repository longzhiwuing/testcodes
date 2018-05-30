/**
 * Project Name:testcode
 * File Name:FileTest.java
 * Package Name:com.lzwing.testcode.file
 * Date:2018年1月18日下午4:30:29
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
public class PathFilesTest {

	static int fileCount = 0;

	public static void main(String[] args) throws Exception {

//		testCodeFromProj();
		testCodeFromProjWithStream();

//		testCode60();

//		test1();

//		testSed();
		
//		testHsTable();

//		testReplaceAll();
	}

	private static void testCodeFromProj() throws IOException {
		String pathDir = "D:\\Projects\\eclipseWorkSpace\\networksrc\\src\\com";

        String destPath = "C:\\Users\\Administrator\\Desktop\\test\\code.txt";

        File destFile = new File(destPath);

        Collection collection = FileUtils.listFiles(new File(pathDir), new String[]{"java"}, true);
        for (Object o : collection) {
            File javaFile = (File) o;
            doAppend(javaFile,destFile);
        }
    }

    private static void doAppend(File javaFile,File destFile) throws IOException {
        List<String> lines = FileUtils.readLines(javaFile, Charset.forName("utf-8"));

        FileUtils.writeLines(destFile,"utf-8",lines,true);

        System.out.println(javaFile.getPath()+" finished...");
    }

    private static void testCodeFromProjWithStream() throws IOException {
        String pathDir = "D:\\Projects\\eclipseWorkSpace\\networksrc\\src\\com";

        String destPath = "C:\\Users\\Administrator\\Desktop\\test\\code.txt";

        File destFile = new File(destPath);

        FileUtils.listFiles(new File(pathDir), new String[]{"java"}, true).stream().forEach(new Consumer<File>() {
            @Override
            public void accept(File file) {
                try {
                    doAppend(file,destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

	private static void testCode60() {
		String path = "C:\\Users\\Administrator\\Desktop\\test\\code.txt";
		Path dir = Paths.get(path);

		String desPath = "C:\\Users\\Administrator\\Desktop\\test\\result.txt";

		Path des = Paths.get(desPath);

		try {
			Stream<String> lines = Files.lines(dir);
			List<String> linesList = lines.filter(new Predicate<String>() {
				@Override
				public boolean test(String s) {
					return !StringUtils.isEmpty(s)&&(!s.trim().startsWith("//"));
				}
			}).collect(Collectors.toList());

			Path write = Files.write(des, linesList);

			System.out.println(write);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void testReplaceAll() throws Exception {
//		String path = "D:\\Apache\\web\\OA\\sdc\\oa\\RES_PROJ";
		String path = "C:\\Users\\Administrator\\Desktop\\test";
		File dir = new File(path);
		for(String fileName:dir.list()){
			boolean is2Change = false;
			File itemFile = new File(path+"\\"+fileName);
			List<String> readLines = FileUtils.readLines(itemFile);
			List<String> lines2Write = new ArrayList<>();
			for(String line:readLines){
				if(line.contains("hsTable")){
					is2Change = true;
					line = line.replace("hsTable", "cec-table");
				}
				lines2Write.add(line);
			}
			if(is2Change){
				System.out.println(fileName);
				FileUtils.writeLines(itemFile, lines2Write);
			}else{
				lines2Write = null;
			}
		}
	}

	private static void testHsTable() throws Exception{
		String path = "C:\\Users\\Administrator\\Desktop\\test1";
		Path dir = Paths.get(path);
		Files.list(dir).filter(new Predicate<Path>(){
			@Override
			public boolean test(Path path) {
				try {
					List<String> collect = Files.lines(path).filter(new Predicate<String>() {
						@Override
						public boolean test(String t) {
							return t.contains("cec-table");
						}
					}).collect(Collectors.toList());
					return collect.size()>0;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return false;
			}
		}).forEach(System.out::println);
	}

	private static void test1() throws IOException {
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


	public void writeTo(String path, String content) throws IOException {
		Path target = Paths.get(path);
		if (Files.exists(target)) {
			throw new IOException("file already exists");
		}
		Files.copy(new ByteArrayInputStream(content.getBytes("UTF8")), target);
	}

}
