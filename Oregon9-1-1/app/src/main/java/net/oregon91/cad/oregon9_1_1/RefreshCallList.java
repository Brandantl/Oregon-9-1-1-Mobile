package net.oregon91.cad.oregon9_1_1;

import android.os.AsyncTask;
import android.widget.ListView;
import cad.oregon911.net.Oregon911;

/**
 * Created by Brandan on 12/30/2015.
 */
public class RefreshCallList extends AsyncTask<Void,Void,Boolean > {
    private Oregon911 OR911;
    private ListView calllist;

    public RefreshCallList(Oregon911 thing, ListView otherThing) {
        OR911 = thing;
        calllist = otherThing;
    }

    @Override
    protected void onPreExecute() {
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
        calllist.setAdapter(new CallListAdapter(OR911.getContext(), OR911.getIntMan().getList()));
    }

}