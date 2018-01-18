/**
 * Project Name:TestCodes
 * File Name:MpushTest.java
 * Package Name:com.test
 * Date:2017年10月12日上午9:40:38
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode;

import java.util.concurrent.FutureTask;

import com.mpush.api.push.AckModel;
import com.mpush.api.push.MsgType;
import com.mpush.api.push.PushCallback;
import com.mpush.api.push.PushContext;
import com.mpush.api.push.PushMsg;
import com.mpush.api.push.PushResult;
import com.mpush.api.push.PushSender;

/**
 * ClassName:MpushTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年10月12日 上午9:40:38 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MpushTest {
	public static void main(String[] args) throws Exception{
		PushSender sender = PushSender.create();
        sender.start().join();
        Thread.sleep(1000);

        PushMsg msg = PushMsg.build(MsgType.MESSAGE, "fucking....");
        msg.setMsgId("msgId_lzwing");

        PushContext context = PushContext.build(msg)
                .setAckModel(AckModel.AUTO_ACK)
                .setUserId("user-0")
                .setBroadcast(false)
                //.setTags(Sets.newHashSet("test"))
                //.setCondition("tags&&tags.indexOf('test')!=-1")
                //.setUserIds(Arrays.asList("user-0", "user-1"))
                .setTimeout(2000)
                .setCallback(new PushCallback() {
                    @Override
                    public void onResult(PushResult result) {
                        System.err.println("\n\n" + result);
                    }
                });
        FutureTask<PushResult> future = sender.send(context);
	}
}

