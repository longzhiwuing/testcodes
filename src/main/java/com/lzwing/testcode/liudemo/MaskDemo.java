/**
 * Project Name:TestCodes
 * File Name:MaskDemo.java
 * Package Name:com.test.liudemo
 * Date:2018年1月8日上午10:51:46
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.liudemo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName:MaskDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2018年1月8日 上午10:51:46 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MaskDemo {

	public static void main(String[] args) {
		String data = "反复右上腹痛 1 月余。（促使患者就诊的主要症状或体征及持续时间。高度概括，简明扼要，不超过 20 个字。个别确实没有症状而是通过体检发现的检查结果可作为主诉。）"
				+ "（促使患者就诊的主要症状或体征及持续时间。高度概括，简明扼要，不超过 20 个字。个别确实没有症状而是通过体检发现的检查结果可作为主诉。）"
				+ "现病史：缘于 2003 年 2 月初无明显诱因出现右上腹持续性闷痛，无阵发性加剧，无向它处放射，随体位改变不能缓解，伴有恶心、呕吐，呕吐数次，"
				+ "为胃内容物呕吐为反射性，无咖啡样液体。无头痛、头晕，无畏寒、发热，无心悸、胸闷、气促，无腹胀、腹泻、便秘，"
				+ "无粘液脓血便及黑便，无黄疸，无尿频、尿急、尿痛。就诊于福州市第一医院，诊断为“胆囊炎”，"
				+ "查血常规、B 超未见明显异常，给予“654-2、非那根、依诺沙星、25%硫酸镁”处理（具体用量不详）后，"
				+ "症状缓解。1 周前上述症状再次发作，就诊于福州市第一医院，服药（具体药名及用量不详）后病情无明显改善，"
				+ "3 天前行 B 超检查提示：1、慢性胆囊炎；2、轻度脂肪肝。今为进一步诊治，就诊于我院，门诊查血常规示："
				+ "WBC18.20×109/L，N73%，以“慢性胆囊炎急性发作”收入我科。发病以来，患者精神、睡眠、饮食尚可，大小便无异常，"
				+ "体重无明显变化。（本次疾病发生、演变、诊疗等方面的详细情况，按时间顺序书写。"
				+ "内容包括：发病时间、症状、演变及伴随症状的细节；与鉴别诊断有关的阳性及阴性资料；外单位（注明医疗机构，不写“当地”）"
				+ "诊疗经过及结果（治疗情况不写“具体治疗情况不详”））";
		
		System.out.println("before:"+data);
		System.out.println("========================");
		System.out.println("after:"+mask(data));
		System.out.println("========================");
		System.out.printf("Stringutils:%s%n", StringUtils.abbreviate(data, 100));

	}
	
	public static String mask(String data){
		if(data==null||data.length()==0){
			return "";
		}
		
		if(data.length()<=10){
			return data;
		}
		
		StringBuilder sb = new StringBuilder();
		
		List<Integer> randomList = new ArrayList<>();
		
	     int min=10;
	     int max=20;
		
        int rest = data.length();
        
        while(rest>0){
        	int randomNum = new Random().nextInt(max)%(max-min+1) + min;
        	int inputNum = randomNum;
        	if(rest<=randomNum){
        		inputNum = rest;
        	}
        	rest -=randomNum;
        	randomList.add(inputNum);
        }
        
        List<String> dataParts = new ArrayList<>();
        
        int now = 0;
        for(int i=0;i<randomList.size();i++){
        	int inputSize = randomList.get(i);
        	dataParts.add(data.substring(now, now+inputSize));
        	now +=inputSize;
        }
        
        for(int i=0;i<dataParts.size();i++){
        	if(i%2!=0){
        		sb.append(dataParts.get(i).replaceAll(".","*"));
        	}else{
        		sb.append(dataParts.get(i));
        	}
        }
        
		return sb.toString();
	}
}

