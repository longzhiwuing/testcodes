/**
 * Project Name:TestCodes
 * File Name:Test.java
 * Package Name:com.test.liudemo
 * Date:2017年12月27日上午11:05:55
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.liudemo;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年12月27日 上午11:05:55 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class Test {
	
	/**
	 * 以后可以扩展想要的规则
	 * 
	 * @author Administrator
	 * @return
	 * @since JDK 1.8
	 */
	public static Map<String,String> initRegMap(){
		Map<String,String> regMap = new HashMap<String,String>();
		regMap.put("SFZH_REGX", "^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$");
		regMap.put("SFZH_HIDDEN", "(\\d{4})\\d{10}(\\w{4})");
		regMap.put("SFZH_HIDDEN_TYPE", "$1****$2");
		regMap.put("MOBILE_REGX", "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
		regMap.put("MOBILE_HIDDEN", "(\\d{3})\\d{4}(\\d{4})");
		regMap.put("MOBILE_HIDDEN_TYPE", "$1****$2");
		regMap.put("NAME_REGX", "[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*");
		regMap.put("NAME_HIDDEN", "([\u4E00-\u9FA5]{1})[\u4E00-\u9FA5]+");
		regMap.put("NAME_HIDDEN_TYPE", "$1**");
		
		return regMap;
	}
	
	/**
	 * 
	 * 如果符合规则隐藏信息、如果不符合原样返回
	 * 
	 * @author Administrator
	 * @param value 原始字符串
	 * @param type 想要隐藏的类型 比如SFZH、MOBILE等
	 * @return
	 * @since JDK 1.8
	 */
	public static String remoteKey(String value,String type){
		
		Map<String,String> regMap = initRegMap();
		
		String regx = regMap.get(String.format("%s_REGX", type));
		String hidden = regMap.get(String.format("%s_HIDDEN", type));
		String hiddenType = regMap.get(String.format("%s_HIDDEN_TYPE", type));
		
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(value);
		
		if(matcher.matches()){
			return value.replaceAll(hidden, hiddenType);
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		
		System.out.println(remoteKey("张三", "NAME"));
		System.out.println(remoteKey("刘福宁", "NAME"));
		System.out.println(remoteKey("欧阳夏丹", "NAME"));
		System.out.println(remoteKey("阿沛·买合木提", "NAME"));//可以，新疆名字
		System.out.println(remoteKey("卡尔·马克思", "NAME"));//可以，国外人名（不超过5个字）
		System.out.println(remoteKey("这是一段很长的文字哈哈哈", "NAME"));//不可以，中文字符不在2~5个范围的
		System.out.println(remoteKey("包含1245以及abcd还有@等特殊符号的文字", "NAME"));//不可以，包含数字、字母、特殊符号的字符串
		
		System.out.println("=========================");
		
		String origin_sfz = "61010319650604367X";
//		String origin_sfz = "220502198809170053";
		String origin_mobile = "13811158907";
		String otherInfo = "abcd1234567中文测试";
		
		String sfz_hidden = remoteKey(origin_sfz,"SFZH");
		String mobile_hidden = remoteKey(origin_mobile, "MOBILE");
		String infoNotHidden = remoteKey(otherInfo, "NAME");
		
		System.out.println(sfz_hidden);
		System.out.println(mobile_hidden);
		System.out.println(infoNotHidden);
	}
}

