package net.openfiresecurity.remotecodeexecution;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import eu.chainfire.libsuperuser.Shell;

public class CommandExecutor extends AsyncTask<String, Void, String> {

	MainActivity c;
	ProgressDialog diag;
	boolean su;

	public CommandExecutor(boolean root) {
		su = root;
	}

	@Override
	protected void onPreExecute() {
		// diag = new ProgressDialog(c);
		// diag.setMessage("Executing");
		// diag.setTitle("Executing");
		// diag.show();
	}

	@Override
	protected String doInBackground(String... params) {

		if (su) {
			Shell.SU.run(params);
		} else {
			Shell.SH.run(params);
		}

		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		// diag.dismiss();
		// c.setResult(result);

	}
}
