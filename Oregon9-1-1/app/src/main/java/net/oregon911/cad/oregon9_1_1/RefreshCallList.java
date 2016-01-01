package net.oregon91.cad.oregon9_1_1;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import cad.oregon911.net.Oregon911;

/**
 * Created by Brandan on 12/30/2015.
 */
public class RefreshCallList extends AsyncTask<Void, Void, Boolean> {
    private Oregon911 OR911;
    private ListView calllist;
    private int index;
    private int top;

    public RefreshCallList(Oregon911 thing, ListView otherThing) {
        OR911 = thing;
        calllist = otherThing;
    }

    @Override
    protected void onPreExecute() {
        // save index and top position
        index = calllist.getFirstVisiblePosition();
        View v = calllist.getChildAt(0);
        top = (v == null) ? 0 : (v.getTop() - calllist.getPaddingTop());
        // Maybe a refresh gif?
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        OR911.updateIncidentManager();
        return true;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        // Stop refresh gif?
        calllist.setAdapter(new net.oregon91.cad.oregon9_1_1.CallListAdapter(OR911.getContext(), OR911.getIntMan().getList()));
        calllist.setSelectionFromTop(index, top);
    }

}