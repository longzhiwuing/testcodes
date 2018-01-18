/**
 * Project Name:testcode
 * File Name:Test.java
 * Package Name:com.lzwing.testcode.file
 * Date:2018年1月17日下午5:54:29
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2018年1月17日 下午5:54:29 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class FileWriter {

	public void writeTo(String path, String content) throws IOException {
	    Path target = Paths.get(path);
	    if (Files.exists(target)) {
	        throw new IOException("file already exists");
	    }
	    Files.copy(new ByteArrayInputStream(content.getBytes("UTF8")), target);
	}
}

