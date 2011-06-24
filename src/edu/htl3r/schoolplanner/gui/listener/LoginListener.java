package edu.htl3r.schoolplanner.gui.listener;

import java.util.Map;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import edu.htl3r.schoolplanner.backend.preferences.loginSets.LoginSet;
import edu.htl3r.schoolplanner.gui.SelectScreen;
import edu.htl3r.schoolplanner.gui.WelcomeScreen;

public class LoginListener implements OnItemClickListener {

	private WelcomeScreen welcomescreen;

	public LoginListener(WelcomeScreen ws) {
		welcomescreen = ws;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		final Map<String, String> selectedEntry = welcomescreen.getLoginManager().getAllLoginSetsForListAdapter().get(position);

		AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {

				// TODO: Do login here
				
				Intent t = new Intent(welcomescreen, SelectScreen.class);
				
				LoginSet loginEntry = new LoginSet(selectedEntry);
				
				Bundle extras = new Bundle();
				extras.putSerializable("entry", loginEntry);
				t.putExtras(extras);
				welcomescreen.startActivity(t);
			
				return null;
			}

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				welcomescreen.setInProgress("Login in progress...", true);
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				welcomescreen.setInProgress("", false);
			}
		};

		task.execute();
	}

}
