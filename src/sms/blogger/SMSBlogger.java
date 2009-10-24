package sms.blogger;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SMSBlogger extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		// LOGIC
		final Button switchButton = (Button) findViewById(R.id.switchButton);
		final TextView statusText = (TextView) findViewById(R.id.statusText);
		statusText.setBackgroundColor(Color.RED);
		statusText.setTextColor(Color.BLACK);
		switchButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				if(SMSApp.isOn())
				{
					SMSApp.deActivate();
					statusText.setBackgroundColor(Color.RED);
					statusText.setText("STOPPED");
					switchButton.setText("TURN ON");
				}
				else
				{
					SMSApp.activate();
					statusText.setBackgroundColor(Color.GREEN);
					statusText.setText("RUNNING");
					switchButton.setText("TURN OFF");
				}
					
			}
		}
		);
		
		Button settingsButton = (Button) findViewById(R.id.settingsButton);
		settingsButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent i = new Intent(SMSBlogger.this, SettingsActivity.class);
				startActivity(i);
			}
		}
		);
		
	}
}