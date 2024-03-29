package com.lzwing.testcode.utils.vjkit.io;

import com.vip.vjtools.vjkit.io.FileUtil;
import com.vip.vjtools.vjkit.io.IOUtil;
import com.vip.vjtools.vjkit.io.URLResourceUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class URLResourceTest {

	@Test
	public void resource() throws IOException {
		File file = URLResourceUtil.asFile("classpath://application.properties");
		assertThat(FileUtil.toString(file)).isEqualTo("springside.min=1\nspringside.max=10");

		InputStream is = URLResourceUtil.asStream("classpath://application.properties");
		assertThat(IOUtil.toString(is)).isEqualTo("springside.min=1\nspringside.max=10");
		IOUtil.closeQuietly(is);

		try {
			URLResourceUtil.asFile("classpath://notexist.properties");
			fail("should fail");
		} catch (Throwable t) {
			assertThat(t).isInstanceOf(IllegalArgumentException.class);
		}

		try {
			URLResourceUtil.asStream("classpath://notexist.properties");
			fail("should fail");
		} catch (Throwable t) {
			assertThat(t).isInstanceOf(IllegalArgumentException.class);
		}

	}

	@Test
	public void file() throws IOException {
		File file = FileUtil.createTempFile().toFile();
		FileUtil.write("haha", file);
		try {
			File file2 = URLResourceUtil.asFile("file://" + file.getAbsolutePath());
			assertThat(FileUtil.toString(file2)).isEqualTo("haha");

			File file2NotExist = URLResourceUtil.asFile("file://" + file.getAbsolutePath() + ".noexist");

			File file3 = URLResourceUtil.asFile(file.getAbsolutePath());
			assertThat(FileUtil.toString(file3)).isEqualTo("haha");
			File file3NotExist = URLResourceUtil.asFile(file.getAbsolutePath() + ".noexist");

		} finally {
			FileUtil.deleteFile(file);
		}

	}

}
