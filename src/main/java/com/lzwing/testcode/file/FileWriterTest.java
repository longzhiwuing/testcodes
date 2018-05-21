package com.lzwing.testcode.file;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
//import static org.fest.assertions.Assertions.*;

public class FileWriterTest {

	private PathFilesTest fileWriter = new PathFilesTest();

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Rule
	public ExpectedException thrown = ExpectedException.none();


	@Test
	public void PathApiTest() throws Exception{
		//使用绝对路径
		Path pathAbs= Paths.get("c:\\data\\myfile.txt");

		//使用相对路径
		Path pathRel = Paths.get("/home/jakobjenkov/myfile.txt");

		//下面这种创建方式和上面等效：
		Path pathRel2 = FileSystems.getDefault().getPath("c:\\data\\myfile.txt");


		//File和Path之间的转换，File和URI之间的转换
		File file = new File("C:/my.ini");
		Path p1 = file.toPath();
		p1.toFile();
		file.toURI();

		//使用Paths工具类的get()方法创建
		Path path = Paths.get("D:\\XMind\\bcl-java.txt");
/*        //使用FileSystems工具类创建
        Path path2 = FileSystems.getDefault().getPath("c:\\data\\myfile.txt");*/
		System.out.println("文件名：" + path.getFileName());
		System.out.println("名称元素的数量：" + path.getNameCount());
		System.out.println("父路径：" + path.getParent());
		System.out.println("根路径：" + path.getRoot());
		System.out.println("是否是绝对路径：" + path.isAbsolute());
		//startsWith()方法的参数既可以是字符串也可以是Path对象
		System.out.println("是否是以为给定的路径D:开始：" + path.startsWith("D:\\") );
		System.out.println("该路径的字符串形式：" + path.toString());


		//.表示的是当前目录
		Path currentDir = Paths.get(".");
		System.out.println(currentDir.toAbsolutePath());//输出C:\Users\Administrator\NIODemo\.
		Path currentDir2 = Paths.get(".\\NIODemo.iml");
		System.out.println("原始路径格式："+currentDir2.toAbsolutePath());
		System.out.println("执行normalize（）方法之后："+currentDir2.toAbsolutePath().normalize());
		System.out.println("执行toRealPath()方法之后："+currentDir2.toRealPath());

		//..表示父目录或者说是上一级目录：
		Path currentDir3 = Paths.get("..");
		System.out.println("原始路径格式："+currentDir3.toAbsolutePath());
		System.out.println("执行normalize（）方法之后："+currentDir3.toAbsolutePath().normalize());
		System.out.println("执行toRealPath()方法之后："+currentDir3.toRealPath());
	}

	@Test
	public void testFiles() throws Exception{
		Path path = Paths.get("D:\\XMind\\bcl-java.txt");

		//注意Files.exists()的的第二个参数。它是一个数组，这个参数直接影响到Files.exists()如何确定一个路径是否存在。在本例中，这个数组内包含了LinkOptions.NOFOLLOW_LINKS，表示检测时不包含符号链接文件。
		boolean pathExists =
				Files.exists(path,
						new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
		System.out.println(pathExists);//true

		//Files.createDirectories()会首先创建所有不存在的父目录来创建目录，而Files.createDirectory()方法只是创建目录，如果它的上级目录不存在就会报错。比如下面的程序使用Files.createDirectory() 方法创建就会报错，这是因为我的D盘下没有data文件夹，加入存在data文件夹的话则没问题。
		path = Paths.get("D://data//test");

		try {
			Path newDir = Files.createDirectories(path);
		} catch(FileAlreadyExistsException e){
			// the directory already exists.
		} catch (IOException e) {
			//something else went wrong
			e.printStackTrace();
		}



		//delete....
		path = Paths.get("data/subdir/logging-moved.properties");

		try {
			Files.delete(path);
		} catch (IOException e) {
			//deleting file failed
			e.printStackTrace();
		}

		//file copy
		Path sourcePath      = Paths.get("data/logging.properties");
		Path destinationPath = Paths.get("data/logging-copy.properties");

		try {
			Files.copy(sourcePath, destinationPath);
		} catch(FileAlreadyExistsException e) {
			//destination file already exists
		} catch (IOException e) {
			//something else went wrong
			e.printStackTrace();
		}


		//获取文件属性
		path = Paths.get("D:\\XMind\\bcl-java.txt");
		System.out.println(Files.getLastModifiedTime(path));
		System.out.println(Files.size(path));
		System.out.println(Files.isSymbolicLink(path));
		System.out.println(Files.isDirectory(path));
		System.out.println(Files.readAttributes(path, "*"));


		//遍历一层文件
		Path dir = Paths.get("D:\\Java");
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
			for(Path e : stream){
				System.out.println(e.getFileName());
			}
		}catch(IOException e){

		}

		//遍历一个目录的所有文件
		Path startingDir = Paths.get("D:\\apache-tomcat-9.0.0.M17");
		List<Path> result = new LinkedList<Path>();
		Files.walkFileTree(startingDir, new FindJavaVisitor(result));
		System.out.println("result.size()=" + result.size());
	}

	private static class FindJavaVisitor extends SimpleFileVisitor<Path>{
		private List<Path> result;
		public FindJavaVisitor(List<Path> result){
			this.result = result;
		}
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
			if(file.toString().endsWith(".java")){
				result.add(file.getFileName());
			}
			return FileVisitResult.CONTINUE;
		}
	}

	@Test
	public void throwsErrorWhenTargetFileExists() throws IOException {
		// arrange
		File output = temporaryFolder.newFile("output.txt");

		thrown.expect(IOException.class);
		thrown.expectMessage("file already exists");

		// act
		fileWriter.writeTo(output.getPath(), "test");
	}

	@Test
	public void writesContentToFile() throws IOException {
		// arrange
		File output = temporaryFolder.newFolder("reports").toPath().resolve("output.txt").toFile();

		// act
		fileWriter.writeTo(output.getPath(), "test");
		
		// assert
		assertThat(output).hasContent("test");
//		assertThat(output).hasContent("test").hasExtension("txt").hasParent(resolvePath("reports"));
	}

	private String resolvePath(String folder) {
		return temporaryFolder.getRoot().toPath().resolve(folder).toString();
	}
}