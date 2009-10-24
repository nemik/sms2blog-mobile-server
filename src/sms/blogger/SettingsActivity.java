package sms.blogger;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends Activity
{
	public static final String PREFS_NAME = "smsbloggerSettings";
	@Override	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		// Restore preferences
		final SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		String sendURLString = settings.getString("sendURL", "http://");
		String sendPasswordString = settings.getString("sendPassword", "");
		
		final EditText sendURL = (EditText) findViewById(R.settings.sendURL);
		sendURL.setText(sendURLString);
		
		final EditText sendPassword = (EditText) findViewById(R.settings.sendPassword);
		sendPassword.setText(sendPasswordString);
		
		Button saveButton = (Button) findViewById(R.settings.saveButton);
		saveButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				SharedPreferences.Editor editor = settings.edit();
				editor.putString("sendURL", sendURL.getText().toString());
				editor.putString("sendPassword", sendPassword.getText().toString());
				editor.commit();
				
				TextView savedLabel = (TextView) findViewById(R.settings.savedLabel);
				savedLabel.setText("Saved!");
			}
		}
		);
		
		Button backButton = (Button) findViewById(R.settings.backButton);
		backButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent i = new Intent(SettingsActivity.this, MainActivity.class);
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
