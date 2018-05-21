/**
 * Project Name:testcode
 * File Name:Test.java
 * Package Name:com.lzwing.testcode.file
 * Date:2018年1月17日下午5:54:29
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2018年1月17日 下午5:54:29 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class SpringBootJarsDependency {

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

}

