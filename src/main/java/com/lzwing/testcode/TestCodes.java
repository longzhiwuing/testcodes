/**
 * Project Name:TestCodes
 * File Name:TestCodes.java
 * Package Name:com.test
 * Date:2016年12月10日下午5:31:11
 * Copyright (c) 2016, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName:TestCodes <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2016年12月10日 下午5:31:11 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class TestCodes {

	static String readFirstLineFromFile(String path) throws IOException {  
	    try (BufferedReader br = new BufferedReader(new FileReader(path))) {  
	        return br.readLine();
	    }  
	}  
	
	public static boolean isDateStr(String dateStr){
		String janPattern = "(0?[13578]|1[02])-(0?[1-9]|[12][0-9]|3[01])";  
		String febPattern = "0?2-(0?[1-9]|[12][0-9])";  
		String aprPattern = "(0?[469]|11)-(0?[1-9]|[12][0-9]|30)";  
		String dayPattern = String.format("^[0-9]{4}-(%s|%s|%s)$", janPattern, febPattern, aprPattern);
		return Pattern.compile(dayPattern).matcher(dateStr).matches();
	}
	
	/**
	 * 环境变量信息
	 * showInfo:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Administrator
	 * @throws Exception
	 * @since JDK 1.8
	 */
	public static void showInfo() throws Exception{
		System.out.println("java.home : "+System.getProperty("java.home"));  
		  
        System.out.println("java.class.version : "+System.getProperty("java.class.version"));  

        System.out.println("java.class.path : "+System.getProperty("java.class.path"));  

        System.out.println("java.library.path : "+System.getProperty("java.library.path"));  

        System.out.println("java.io.tmpdir : "+System.getProperty("java.io.tmpdir"));  

        System.out.println("java.compiler : "+System.getProperty("java.compiler"));  

        System.out.println("java.ext.dirs : "+System.getProperty("java.ext.dirs"));  

        System.out.println("user.name : "+System.getProperty("user.name"));  

        System.out.println("user.home : "+System.getProperty("user.home"));  

        System.out.println("user.dir : "+System.getProperty("user.dir"));  

        System.out.println("===================");  

        System.out.println("package: "+TestCodes.class.getPackage().getName());  

        System.out.println("package: "+TestCodes.class.getPackage().toString());  

        System.out.println("=========================");  

        String packName = TestCodes.class.getPackage().getName();  

        /*URL packurl = new URL(packName); 

        System.out.println(packurl.getPath());*/  

        URI packuri = new URI(packName);  

        System.out.println(packuri.getPath());  

        //System.out.println(packuri.toURL().getPath());  

        System.out.println(packName.replaceAll("//.", "/"));  

        System.out.println(System.getProperty("user.dir")+"/"+(TestCodes.class.getPackage().getName()).replaceAll("//.", "/")+"/");  
	}
	
	public static void jodaTimeCase(){
		DateTime dateTime = new DateTime(2017,6,29,15,47,07,123);
		
		dateTime = new DateTime();
		
		System.out.println(dateTime.plusDays(30).toString("E yyyy-MM-dd HH:mm:ss.SSS"));
		
		//45 天之后的某天在下一个月的当前周的最后一天的日期
		System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek().withMaximumValue().toString("E yyyy-MM-dd HH:mm:ss.SSS"));
		
		Date jdkDate = dateTime.toDate();
		
//		DateTime dateTime = SystemFactory.getClock().getDateTime();
		
		// Use a Calendar
		java.util.Calendar calendar = Calendar.getInstance();
		dateTime = new DateTime(calendar);
		// Use another Joda DateTime
		DateTime anotherDateTime = dateTime;
		dateTime = new DateTime(anotherDateTime);
		// Use a String (must be formatted properly)
		String timeString = "2006-01-26T13:30:00-06:00";
		dateTime = new DateTime(timeString);
		timeString = "2006-01-26";
		dateTime = new DateTime(timeString);
		
		System.out.println(dateTime.toString("E yyyy-MM-dd HH:mm:ss.SSS"));
		
//		LocalTime localTime = new LocalTime(13, 30, 26, 0);// 1:30:26PM
		LocalDate now = new LocalDate();
		System.out.println(now.minusMonths(1).dayOfMonth().withMaximumValue().toString("E yyyy-MM-dd HH:mm:ss.SSS"));
	}
	
	public static Long test(Long value) {
        return value;
    }
	
	public static String getKeyVal(Map<String, String> properties, String key) {
		String totalValue = "";
		String express = "(\\{\\w+\\})";
		Pattern pattern = Pattern.compile(express);
		String originVal = properties.get(key);
		Matcher matcher = pattern.matcher(originVal);
		if(matcher.find()){
			String group = matcher.group(1);
			String groupKey = group.replace("{", "").replace("}","");
			String midleVal = properties.get(groupKey);
			totalValue =originVal.replaceAll(express, getKeyVal(properties, groupKey));
		}else{
			totalValue = originVal;
		}
		return totalValue;
	}
	
	public static void demo(){
		Map<String,String> properties = new LinkedHashMap();
		properties.put("a", "123");
		properties.put("b", "{a}456");
		properties.put("c", "{b}789");
		
		String key = "c";
		
		String value = getKeyVal(properties,key);
		
		System.out.println("value:"+value);
	}
	
	public static String finalTest(){
		try {
			System.out.println("try...");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally...");
		}
		return "bbb";
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(finalTest());
		
		/*int max=45;
        int min=10;
		Random random = new Random();
		
		for(int i=0;i<5;i++){
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(int j=0;j<8;j++){
				sb.append(random.nextInt(max)%(max-min+1) + min);
				if(j!=7)
				sb.append(",");
			}
			sb.append("]");
			System.out.println(sb.toString());
		}*/
		
		
		
		/*String seriesStr = "[{name:'公立医院',type:'bar',stack:'医院',data:[13069,12708]},{name:'民营医院',type:'bar',stack:'医院',data:[14518,16432]},{name:'社区卫生服务中心站',type:'bar',stack:'基层医疗卫生机构',data:[34321,32327]},{name:'乡镇卫生院',type:'bar',stack:'基层医疗卫生机构',data:[36817,36795]},{name:'疾病预防控制中心',type:'bar',stack:'专业公共卫生机构',data:[3478,3481]},{name:'专科疾病防治机构',type:'bar',stack:'专业公共卫生机构',data:[1234,1213]},{name:'妇幼保健机构',type:'bar',stack:'专业公共卫生机构',data:[3078,3063]},{name:'卫生计生监督机构',type:'bar',stack:'专业公共卫生机构',data:[2986,2986]}]";
		
		JSONArray parseObject = JSONObject.parseArray(seriesStr);
		
		System.out.println(parseObject);*/
		
		
		/*String warPath = "D:\\usr\\local\\apache\\hsdata\\cecd\\deploy\\1508315787856\\test.txt";
//		String warName = warPath.split(File.separator)[warPath.split(File.separator).length-1];
		
		String warName = new File(warPath).getName();
		
		String contextName = warName.split("\\.")[0];
		
		System.out.println(contextName);*/
		
		
		/*String resContent = "{\"buildWarPipeline\":1,\"buildSqlPipeline\":1}";
		JSONObject resContentObject = JSON.parseObject(resContent);
		System.out.println("build result:" + resContentObject);*/
		
		
		
		/*int val2pow = 4;
		double pow = Math.pow(2, (val2pow-1));
		
		System.out.println(pow);*/
		
		/*String showColumnStr = "";
		if(showColumnStr!=null&&showColumnStr.contains("|")){
			System.out.println("aaa");
		}*/
		
//		System.out.println("aasdf".contains("|"));
		
		/*List<String> showColumns = new ArrayList<>();
		
		showColumns.add("aaaa");
		showColumns.add("bbbb");
		showColumns.add("cccc");
		showColumns.add("dddd");
		
		List<Integer> indexList = new ArrayList<>();
		
		indexList.add(1);
		indexList.add(2);
		
		List<String> selectedShowColumns = new ArrayList<>();
		
		for(int i=0;i<showColumns.size();i++){
			if(indexList.contains(i)){
				selectedShowColumns.add(showColumns.get(i));
			}
		}
		
		System.out.println(selectedShowColumns);*/
		
		
//		StringUtils.isEmpty(str)
		
//		ToStringBuilder.reflectionToString(this);
		
		/*Long value = null;
		
		test(value);*/
		
		
		/*String json = "[[\"2017081211\",\"123501814885463726\",\"0\",\"123501814885463726\",\"123501814885463726\",\"0\",\"0\",0,299,186,0,0,\"2017081211:123501814885463726\"],[\"2017081212\",\"123501814885463726\",\"0\",\"123501814885463726\",\"123501814885463726\",\"0\",\"0\",0,12485,134,0,0,\"2017081212:123501814885463726\"],[\"2017081212\",\"12350181488546276W\",\"0\",\"12350181488546276W\",\"12350181488546276W\",\"0\",\"0\",0,1138,0,0,0,\"2017081212:12350181488546276W\"],[\"2017081211\",\"12350181488546292J\",\"0\",\"12350181488546292J\",\"12350181488546292J\",\"0\",\"0\",0,176777,28696,0,0,\"2017081211:12350181488546292J\"],[\"2017081212\",\"12350181488546284P\",\"0\",\"12350181488546284P\",\"12350181488546284P\",\"0\",\"0\",0,6071,4507,0,0,\"2017081212:12350181488546284P\"],[\"2017081212\",\"12350100488099736A\",\"0\",\"12350100488099736A\",\"12350100488099736A\",\"0\",\"0\",0,1060,0,0,0,\"2017081212:12350100488099736A\"],[\"2017081211\",\"12350181488546284P\",\"0\",\"12350181488546284P\",\"12350181488546284P\",\"0\",\"0\",0,0,5056,0,0,\"2017081211:12350181488546284P\"],[\"2017081212\",\"123501814885462682\",\"0\",\"123501814885462682\",\"123501814885462682\",\"0\",\"0\",0,11789,2802,0,0,\"2017081212:123501814885462682\"],[\"2017081212\",\"12350100488083048N\",\"0\",\"12350100488083048N\",\"12350100488083048N\",\"0\",\"0\",0,228,0,0,0,\"2017081212:12350100488083048N\"],[\"2017081212\",\"12350181488546292J\",\"0\",\"12350181488546292J\",\"12350181488546292J\",\"0\",\"0\",0,108894,25947,0,0,\"2017081212:12350181488546292J\"],[\"2017081211\",\"123501814885462682\",\"0\",\"123501814885462682\",\"123501814885462682\",\"0\",\"0\",0,0,3059,0,0,\"2017081211:123501814885462682\"],[\"2017081211\",\"12350100488099840E\",\"0\",\"12350100488099840E\",\"12350100488099840E\",\"0\",\"0\",0,955,126,0,0,\"2017081211:12350100488099840E\"],[\"2017081212\",\"12350100488099840E\",\"0\",\"12350100488099840E\",\"12350100488099840E\",\"0\",\"0\",0,548,135,0,0,\"2017081212:12350100488099840E\"]]";
		
		JSONArray jsonArr = (JSONArray)JSON.parse(json);
		JSONArray dataArr = new JSONArray();
		
		for(int i=0;i<jsonArr.size();i++){
			JSONArray itmArr = (JSONArray)jsonArr.get(i);
			JSONObject itmObj = new JSONObject();
			for(int j=0;j<itmArr.size();j++){
				itmObj.put("col"+(j+1),itmArr.get(j));
			}
			dataArr.add(itmObj);
		}
		
		System.out.println(dataArr);*/
		
		/*int max=1500;
        int min=0;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        
        
		System.out.println(s);*/
		
		
		
/*		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		
		System.out.println(uuid);*/
		
		
		/*String path = "D:\\usr\\local\\apache\\hsdata\\cecd\\deploy\\1499390051452\\福州地址.txt";
		
		File file = new File(path);
		
		String fileName = file.getName().split("\\.")[0];
		
		System.out.println(fileName);*/
		
		
//		System.out.println(filePath.split("\\")[0]);
		
		/*String fileName = filePath.split(File.separator)[filePath.split(File.separator).length-1];
		
		System.out.println(fileName);*/
		
//		Thread.sleep(3000);
		
		
//		jodaTimeCase();
		
//		showInfo();
		
//		System.out.println(System.getProperty("user.dir"));
		
/*		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
        }

        // 将资料解码
        String reqBody = sb.toString();
        return URLDecoder.decode(reqBody, HTTP.UTF_8);*/
		
//		System.out.println(System.currentTimeMillis());
		
		/*System.out.println(isDateStr("2017-06-16"));
		System.out.println(isDateStr("1900-01-01"));
		System.out.println(isDateStr("2000-2-30"));
		System.out.println(isDateStr("2000-11-31"));
		System.out.println(isDateStr("2000-12-31"));
		System.out.println(isDateStr("aaaa-bb-cc"));*/
		
		
		
		
		/*String s = "a,b,c,";
		String substring = s.substring(0, s.length()-1);
		
		System.out.println(substring);*/
		
//		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		
		/*String fid = "1,01dbf01d734f";
		
		if (fid.contains(",")) {
			System.out.println("ok!!!");
		}
		
		 Map<String,Object> dataMap = new HashMap<>();
		 */
		 
		 
		 
/*		String readFirstLineFromFile = readFirstLineFromFile("D:\\key.txt");
		System.out.println(readFirstLineFromFile);
		
		ReturnCodeEnum forbid1 = ReturnCodeEnum.FORBIDDEN_ERROR;
		ReturnCodeEnum string = ReturnCodeEnum.FORBIDDEN_ERROR_DESC;
		
		System.out.println(forbid1);
		System.out.println(string);*/
		
//		Hashtable<String, Object> ht = new Hashtable<>();
		
/*		HashMap<String, Object> ht = new HashMap<>();
		
		ht.put(null, null);
		
		System.out.println("aaa:"+ht);*/
		
/*		try {
			
			for (int i = 0; i < 10; i++) {
				int nextInt = SecureRandom.getInstance("SHA1PRNG").nextInt();
				System.out.println(nextInt);
			}
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			
		}*/
		
//		System.out.println("asdfasfd");
		
//		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		
		/*int compareTo = "007626f716e644cb83dd10510d432418".compareTo("007626f716e644cb83dd10510d432418");
		System.out.println(compareTo);*/
		
		/*Date date = new Date(172800);
		
		System.out.println();*/
		
		/*Map<Object,Object> map = new HashMap<>();
		
		map.put(null, 1);
		
		Object object = map.get(null);
		
		System.out.println(object);
		
		Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>();
		
		hashtable.put(null, 1);
		
		System.out.println(hashtable.get(null));*/
	}

	
}

