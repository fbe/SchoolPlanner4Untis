/* SchoolPlanner4Untis - Android app to manage your Untis timetable
    Copyright (C) 2011  Mathias Kub <mail@makubi.at>
			Sebastian Chlan <sebastian@schoolplanner.at>
			Christian Pascher <christian@schoolplanner.at>
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package edu.htl3r.schoolplanner.backend.preferences.loginSets.asyncUpdateTasks;

import android.os.AsyncTask;
import edu.htl3r.schoolplanner.backend.preferences.loginSets.LoginSetManager;
import edu.htl3r.schoolplanner.gui.WelcomeScreen;

/**
 * Diese Klasse updated die LoginSet-Liste des WelcomeScreens, indem sie die Methode {@link WelcomeScreen#loginSetListUpdated()} aufruft und dadurch das UI aktualisiert.<br>
 * Ableitende Klassen muessen die Methode {@link #editList()} implementieren, um bestimmte Aktionen durchzufuehren. Danach wird die UI aktualisiert.<br>
 * Bekannte Implementierungen: {@link LoginSetAddAsyncTask}, {@link LoginSetRemoveAsyncTask}
 */
public abstract class LoginSetUpdateAsyncTask extends AsyncTask<Void, Void, Void>{
	
	private WelcomeScreen parent;
	
	public LoginSetUpdateAsyncTask(WelcomeScreen parent) {
		this.parent = parent;
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		editList();
		publishProgress();
		return null;
	}
	
	/**
	 * Fuehrt Operationen auf die {@link LoginSet}-Liste des {@link LoginSetManager}s aus.
	 */
	protected abstract void editList();

	@Override
	protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
		parent.loginSetListUpdated();
	}	

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		parent.setLoginListEnabled(false);
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		parent.setLoginListEnabled(true);
	}

}