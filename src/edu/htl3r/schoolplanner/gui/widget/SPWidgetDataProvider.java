package edu.htl3r.schoolplanner.gui.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;
import edu.htl3r.schoolplanner.R;

public class SPWidgetDataProvider extends AppWidgetProvider{

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		Log.d("basti", "die Widgets wollen futter");
	}
	
	
}
