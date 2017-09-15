package com.techguideandroid.widgets;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by mac on 08/09/2017.
 */

public class WidgetAdapter implements RemoteViewsService.RemoteViewsFactory {

    Context jContext;
    String[] list = {"SmartSoft","Android","Java","Kotlin","Anko"};

    public WidgetAdapter(Context context) {

        this.jContext = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews remoteViews = new RemoteViews(jContext.getPackageName(), R.layout.list_item);
        remoteViews.setTextViewText(R.id.textView,list[i]);
        Intent intent = new Intent();
        intent.putExtra(WidgetProvider.KEY_ITEM, list[i]);
        remoteViews.setOnClickFillInIntent(R.id.list_item, intent);
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
