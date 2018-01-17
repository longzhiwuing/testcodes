package com.lzwing.testcode.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintUtils {

	private static final Logger log = LoggerFactory.getLogger(PrintUtils.class);
	
	public static void printLog(String info){
		if(log==null){
			System.out.println("PrintUtils--sysout-:"+info);
			return;
		}
		log.info(info);
	}
	
	public static void printErrLog(String info){
		if(log==null){
			System.err.println("PrintUtils--sysout-:"+info);
			return;
		}
		log.error(info);
	}
	
	public static void printErrLog(String info,Throwable t){
		if(log==null){
			System.err.println("PrintUtils--sysout-:"+info+",Throwable:"+t.getMessage());
			return;
		}
		log.error(info, t);
	}
}