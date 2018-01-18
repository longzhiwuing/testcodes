/**
 * Project Name:TestCodes
 * File Name:AjaxCall.java
 * Package Name:com.test.servlet
 * Date:2017年8月8日上午9:00:34
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:AjaxCall <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2017年8月8日 上午9:00:34 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(name = "ajaxCall", urlPatterns = "/network/ajaxCall")
public class AjaxCall extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("AjaxCall----init");
		System.out.println("sayHello:" + sayHello());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doActionPage(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doActionPage(request, response);
	}

	public void doActionPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			doProcess(request, response);
		} catch (Exception rre) {
			throw new IOException(rre);
		}
	}

	public static void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getOutputStream()
				.write(("[[\"RLOG:2017080714:350104488099736\",\"237984\"],[\"RLOG:2017080708:350102488099840\",\"2294\"],[\"RLOG:2017080608:350102488099840\",\"7253\"],[\"RLOG:2017080518:350111488083048\",\"36524\"],[\"RLOG:2017080512:35010448809971X\",\"183697\"],[\"RLOG:2017080511:35010448809971X\",\"797098\"],[\"RLOG:2017080618:350111488083048\",\"26199\"],[\"RLOG:2017080718:350111488083048\",\"23438\"]]")
						.getBytes("UTF-8"));
	}

	public static String sayHello() {
		return "AjaxCall testing.....";
	}
}
