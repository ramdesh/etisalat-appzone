package appzone.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		SmsMessage[] msgs = null;
		String str = "";
		if ( bundle != null ) {
			Object[] pdus = (Object[]) bundle.get("pdus");
			msgs = new SmsMessage[pdus.length];
			msgs[msgs.length - 1] = SmsMessage.createFromPdu((byte[])pdus[msgs.length - 1]);
			if ( msgs[msgs.length - 1].getDisplayOriginatingAddress().equals(AppZoneConstants.SERVICE_NO) ) {
				str += "You have received a message from Etisalat AppZone";
				str += " :\n ";
				str += msgs[msgs.length - 1].getMessageBody().toString();
				str += "\n";
			}
				
			
			Intent broadcastIntent = new Intent();
			broadcastIntent.setAction("SMS_RECEIVED_ACTION");
			broadcastIntent.putExtra("sms", str);
			context.sendBroadcast(broadcastIntent);
		}
	}
}