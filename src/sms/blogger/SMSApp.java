package sms.blogger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

public class SMSApp extends BroadcastReceiver
{
	private static boolean isOn;
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		if(!SMSApp.isOn)
		{
			return;
		}
		
		Bundle bundle = intent.getExtras();

		Object messages[] = (Object[]) bundle.get("pdus");
		SmsMessage smsMessage[] = new SmsMessage[messages.length];
		for (int n = 0; n < messages.length; n++) 
		{
			smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
		}

		// show first message
		SmsMessage sms = null;
		for(int i=0; i<smsMessage.length; i++)
		{
			sms = smsMessage[i];

			//chances are we don't want to send any of these
			//TODO: perhaps make this configurable
			if(sms.isMWIClearMessage() || sms.isCphsMwiMessage() || sms.isMWISetMessage() || sms.isStatusReportMessage())
			{
				continue;
			}
			
			//display the message as a test
			Toast toast = Toast.makeText(context,"Received SMS from: " + 
					sms.getOriginatingAddress()+" body: "+sms.getMessageBody(), Toast.LENGTH_LONG);
			toast.show();
			
			//delete the message to keep it from cluttering shit up
			
		}
	}
	
	public static void activate()
	{
		SMSApp.isOn = true;
	}
	
	public static void deActivate()
	{
		SMSApp.isOn = false;
	}
	
	public static boolean isOn()
	{
		return SMSApp.isOn;
	}
}