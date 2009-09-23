package sms.blogger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class SMSBloggerService extends Service
{
	public void onCreate(Bundle savedInstanceState)
	{
		
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}
}