package cn.edi.gdmec.s07131040.smsfilter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
				Bundle bundle = intent.getExtras();   
				      
		        Object[] object = (Object[])bundle.get("pdus");   
		      
		        SmsMessage sms[]=new SmsMessage[object.length];   
		        for(int i=0;i<object.length;i++)   
		        {   
		            sms[0] = SmsMessage.createFromPdu((byte[])object[i]);  
					
		    		if(sms[i].getDisplayOriginatingAddress().toString().equals("110")){
		                Toast.makeText(context, "号码："+sms[i].getDisplayOriginatingAddress()+" 发来的短信已被拦截，内容是："+sms[i].getDisplayMessageBody(), Toast.LENGTH_SHORT).show();   
		    			abortBroadcast();                                  
		    		};
		        }   

	}

}
