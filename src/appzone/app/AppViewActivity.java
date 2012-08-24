package appzone.app;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class AppViewActivity extends Activity { 
	public final int DIALOG_HELP_ID = 1;
	public final int DIALOG_EXIT_ID = 2;
	public final int DIALOG_SHOW_MESSAGE = 3;
	public final int DIALOG_TEXT_EMPTY = 4;
	public static int buttons;
	public static TableRow row;
	
	IntentFilter intentFilter;
	
	private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			Common.message = intent.getExtras().getString("sms");
			showDialog(DIALOG_SHOW_MESSAGE);
		}
	};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appview);
        intentFilter = new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");
        viewSingleApp(Common.currentAppId);
        
    }
    @Override
    protected void onResume() {
    	registerReceiver(intentReceiver, intentFilter);
    	super.onResume();
    }
    @Override
    protected void onPause() {
    	unregisterReceiver(intentReceiver);
    	super.onPause();
    }
    public void viewSingleApp(String appId) {
    	TextView dText = (TextView)findViewById(R.id.appdescription);
    	HashMap<String, Object> singleApp = new HashMap<String, Object>();
    	for ( String key : AppStorage.apps.keySet() ) {
    		if ( appId.equals(key) ) {
    			singleApp = AppStorage.apps.get(key);
    			break;
    		}
    	}
    	if ( singleApp.isEmpty() ) {
    		dText.setText("App not available");
    	} 
    	else {
    		Common.currentAppId = appId;
    		/*Adding appname, image and description*/
    		TextView appname = (TextView)findViewById(R.id.appname);
    		appname.setText(singleApp.get("appname").toString());
    		TextView appdescription = (TextView)findViewById(R.id.appdescription);
    		appdescription.setText(singleApp.get("description").toString());
    		ImageView appimage = (ImageView)findViewById(R.id.appimage);
    		appimage.setImageResource((Integer)singleApp.get("appimg"));
    		
    		/*Adding buttons to send SMS*/
    		LinearLayout mainLayout = (LinearLayout)findViewById(R.id.linearLayout2);
    		
    		LinearLayout textFieldLayout = new LinearLayout(this);
    		LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
    				LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    		textFieldLayout.setLayoutParams(linearLayoutParams);
    		EditText textField = new EditText(this);
    		textField.setId(11);
    		textField.setHint("Type your message here..");
    		textField.setLines(1);
    		textField.setMinEms(20);
    		textField.setLayoutParams(linearLayoutParams);
    		textFieldLayout.addView(textField);
    		
    		
    		TableLayout buttonTable = new TableLayout(this);
    		buttonTable.setLayoutParams(new TableLayout.LayoutParams(
    				TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
    		buttonTable.setShrinkAllColumns(true);
    		
    		row = new TableRow(this);
    		TableRow.LayoutParams tableLayoutParams = new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT);
    		row.setLayoutParams(tableLayoutParams);
    		mainLayout.addView(textFieldLayout);
    		mainLayout.addView(buttonTable);
    		
    		String messageParams = singleApp.get("fields").toString();
    		String textReplacements = singleApp.get("button_replacements").toString();
    		//fields are separated by commas
    		Pattern commas = Pattern.compile("[,]");
    		String[] fields = commas.split(messageParams);
    		String[] replacements = commas.split(textReplacements);
    		
    		Pattern space = Pattern.compile("[\\s]");
			//fields for user input are shown by dollar sign
			Pattern dollar = Pattern.compile("[*$*]");
			
			Matcher dollarMatcherOnParams = dollar.matcher(messageParams);
			if ( !dollarMatcherOnParams.find() ) {
				//make text field invisible
				textField.setVisibility(View.INVISIBLE);
			}
			
    		for (int i = 0; i<fields.length; i++) {
    			Matcher dollarMatcherOnFields = dollar.matcher(fields[i]);
    			if ( dollarMatcherOnFields.find() ) {
    				
    				final String[] buttonValue = space.split(fields[i]);
    				Button sendButton = new Button(this);
    				sendButton.setText(replacements[i]);
    				sendButton.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							EditText txtParam = (EditText)findViewById(11);
							if ( txtParam.getText().toString().equals("") ) {
								showDialog(DIALOG_TEXT_EMPTY);
								return;
							}
							String thirdValue = "";
							if ( buttonValue.length == 3 ) {
								thirdValue = buttonValue[1];
							}
							sendAppZoneSms(buttonValue[0]+" "+thirdValue+" "+txtParam.getText());	
						}
					});
    				sendButton.setMinEms(5);
    				if (  i == (fields.length-1) ) {
    					row.addView(sendButton);
    					buttonTable.addView(row);
    					buttons = 0;
    					row = null;
    				}
    				else if ( buttons < 3 ) {
    					row.addView(sendButton);
    					buttons += 1;
    				}
    				else {
    					buttonTable.addView(row);
    					buttons = 0;
    					row = new TableRow(this);
    					row.setLayoutParams(new TableRow.LayoutParams(
    							TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
    					row.addView(sendButton);	
    				}
    			}
    			else {
    				
    				Button sendButton = new Button(this);
    				sendButton.setText(replacements[i]);
    				final String message = fields[i];
    				sendButton.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							sendAppZoneSms(message);
							
						}
					});
    				sendButton.setMinEms(5);
    				if (  i == (fields.length-1) ) {
    					row.addView(sendButton);
    					buttonTable.addView(row);
    					buttons = 0;
    				}
    				
    				else if ( buttons < 3 ) {
    					row.addView(sendButton);
    					buttons += 1;
    					
    				}
    				else {
    					buttonTable.addView(row);
    					buttons = 0;
    					row = new TableRow(this);
    					row.setLayoutParams(new TableRow.LayoutParams(
    							TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
    					row.addView(sendButton);
    				}
    			}
    			
    		}
    		
    	}
    
	 		
    }
	public void showHelp(View v) {
    	showDialog(DIALOG_HELP_ID);
    }
    /**
     * Method to send an SMS to the AppZone SMS Server
     * @param message The message to be sent
     */
    public void sendAppZoneSms(String message) {
    	CharSequence text = "Sending message...";
    	int duration = Toast.LENGTH_LONG;
    	Toast toast = Toast.makeText(this, text, duration);
    	toast.show();
    	SmsManager manager = SmsManager.getDefault();
    	manager.sendTextMessage(AppZoneConstants.SERVICE_NO, null, message, null, null);
    }
    /**
     * Method for creating the options menu (to show help)
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }
    /**
     * Method that gets invoked when an item in the options menu is selected
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.help:
            showDialog(DIALOG_HELP_ID);
            return true;
        case R.id.exit:
        	showDialog(DIALOG_EXIT_ID);
        	return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    protected Dialog onCreateDialog(int id, Bundle bundle) {
    	AlertDialog dialog = null;
    	String appid = Common.currentAppId;
    	String helpMessage = AppStorage.apps.get(appid).get("help").toString();
    	switch( id ) {
    	case DIALOG_HELP_ID:
    		AlertDialog.Builder helpDialogBuilder = new AlertDialog.Builder(this);
    		helpDialogBuilder.setMessage(helpMessage)
    		       .setCancelable(true)
    		       .setTitle("Info")
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                dialog.cancel();
    		           }
    		       });
    		dialog = helpDialogBuilder.create();
    		return dialog;
    	case DIALOG_EXIT_ID:
    		AlertDialog.Builder exitDialogBuilder = new AlertDialog.Builder(this);
    		exitDialogBuilder.setMessage("Are you sure you want to exit?")
    		       .setCancelable(false)
    		       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                AppViewActivity.this.finish();
    		           }
    		       })
    		       .setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						
					}
				});
    		dialog = exitDialogBuilder.create();
    		return dialog;
    	case DIALOG_SHOW_MESSAGE:
    		final Dialog messageDialog = new Dialog(this);

    		messageDialog.setContentView(R.layout.message_dialog_layout);
    		messageDialog.setTitle("Message Received");

    		TextView text = (TextView) messageDialog.findViewById(R.id.message_text);
    		text.setText(Common.message);
    		Button send_message_button = (Button)messageDialog.findViewById(R.id.send_reply_button);
    		Button cancel_button = (Button)messageDialog.findViewById(R.id.cancel_button);
    		send_message_button.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					EditText textField = (EditText)messageDialog.findViewById(R.id.reply_text);
					sendAppZoneSms(textField.getText().toString());
					messageDialog.cancel();
					
				}
			});
    		cancel_button.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					messageDialog.cancel();
					
				}
			});
    		return messageDialog;
    	case DIALOG_TEXT_EMPTY:
    		AlertDialog.Builder textEmptyDialogBuilder = new AlertDialog.Builder(this);
    		textEmptyDialogBuilder.setMessage("You haven't entered anything in the text field!")
    		       .setCancelable(true)
    		       .setTitle("Warning")
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                dialog.cancel();
    		           }
    		       });
    		dialog = textEmptyDialogBuilder.create();
    		return dialog;
    	default:
    		return null;
    	}
    	
    }
    public void shareApp(View v) {
    	Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"Your friend's email"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Check out this app on AppZone!");
        i.putExtra(Intent.EXTRA_TEXT   , "Hi, check out this cool app on Etisalat's AppZone!\n" +
        		"App Name: " +AppStorage.apps.get(Common.currentAppId).get("appname").toString()+"\n"+
        		"App Description: "+AppStorage.apps.get(Common.currentAppId).get("description").toString()+"\n"+
        		"Link: "+AppStorage.apps.get(Common.currentAppId).get("link").toString());
        try {
            startActivity(Intent.createChooser(i, "Share App..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "There are no suitable clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
