package com.lzwing.testcode.utils.vjkit.io;

import com.vip.vjtools.vjkit.io.IOUtil;
import com.vip.vjtools.vjkit.io.ResourceUtil;
import com.vip.vjtools.vjkit.io.type.StringBuilderWriter;
import com.vip.vjtools.vjkit.text.Charsets;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class IOUtilTest {

	@Test
	public void read() throws IOException {
		assertThat(IOUtil.toString(ResourceUtil.asStream("test.txt"))).isEqualTo("ABCDEFG\nABC");
		assertThat(IOUtil.toLines(ResourceUtil.asStream("test.txt"))).hasSize(2).containsExactly("ABCDEFG", "ABC");
	}

	@Test
	public void write() throws IOException {
		StringBuilderWriter sw = new StringBuilderWriter();
		IOUtil.write("hahahaha", sw);
		assertThat(sw.toString()).isEqualTo("hahahaha");

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		IOUtil.write("hahahaha", out);
		assertThat(new String(out.toByteArray(), Charsets.UTF_8)).isEqualTo("hahahaha");

		IOUtil.closeQuietly(out);
		IOUtil.closeQuietly((Closeable) null);
	}

}
