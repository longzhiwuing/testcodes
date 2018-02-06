/**
 * Project Name:testcode
 * File Name:FileTest.java
 * Package Name:com.lzwing.testcode.file
 * Date:2018年1月18日下午4:30:29
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

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

//		test1();

//		testSed();
		
		testHsTable();
		
//		testReplaceAll();
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

	/**
	 * 获取springboot 引用的jar包路径，放入maven plugin goupids标签中
	 * @throws Exception
	 */
	public static void testSed() throws Exception{
		/**
		 * mvn dependency:tree|grep -e "compile" -e "runtime"|sed 's/"[INFO]"//g'
         *
         * <plugin>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-maven-plugin</artifactId>
             <!--执行命令：java -Dloader.path="lib/" -jar common-service.jar-->
             <!--<configuration>
             <fork>true</fork>
             <layout>ZIP</layout>
             <excludeGroupIds>
             ognl,org.slf4j,org.thymeleaf,ch.qos.logback,org.javassist,nz.net.ultraq.thymeleaf,org.hibernate,org.unbescape,com.fasterxml.jackson.core,org.apache.tomcat.embed,org.springframework.boot,org.springframework,org.apache.tomcat,org.codehaus.groovy,org.jboss.logging,org.yaml,javax.validation,com.fasterxml,
             </excludeGroupIds>
             <mainClass>com.lzwing.dockerdemo.DockerDemoApplication</mainClass>
             </configuration>
             <executions>
             <execution>
             <goals>
             <goal>repackage</goal>
             </goals>
             </execution>
             </executions>-->
             </plugin>
		 *
		 */
		String path = "D:\\test.txt";

		Path dir = Paths.get(path);

		List<String> infos = Files.readAllLines(dir);

		Set<String> sets = new HashSet<>();

		for (String info : infos) {
//			System.out.println(info);
//			System.out.println();
			System.out.println();
			String pakageInfo = info.replaceAll("\\[INFO\\]", "")
					.replaceAll("[-+\\|\\\\]", "")
					.replaceAll("\\s", "");
			String packageName = pakageInfo.split(":")[0];
			sets.add(packageName);
		}

		String info = "";

		for (String packageStr : sets) {
			info += packageStr + ",";
		}

		System.out.println(info);



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

}
