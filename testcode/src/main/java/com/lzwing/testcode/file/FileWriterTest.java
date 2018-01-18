package com.lzwing.testcode.file;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import static org.fest.assertions.api.Assertions.*;
//import static org.fest.assertions.Assertions.*;

public class FileWriterTest {

	private FileWriter fileWriter = new FileWriter();

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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