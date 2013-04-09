package net.openfiresecurity.remotecodeexecution;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SecretReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		context.startActivity(new Intent(context, MainActivity.class)
				.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
	}

}
