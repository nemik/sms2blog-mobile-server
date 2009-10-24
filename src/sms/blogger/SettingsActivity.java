package sms.blogger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends Activity
{
	@Override	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		Button cancelButton = (Button) findViewById(R.settings.cancelButton);
		cancelButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent i = new Intent(SettingsActivity.this, SMSBlogger.class);
				startActivity(i);
			}
		}
		);
		
	}
	
	@Override
    protected void onDestroy() 
	{
        super.onDestroy();
    }

}
