package net.oregon91.cad.oregon9_1_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import cad.oregon911.net.Incident;
import cad.oregon911.net.Oregon911;
import cad.oregon911.net.callinfo;
import cad.oregon911.net.timestamp;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    Oregon911 OR911;
    CallListAdapter CallListAdapt;
    ListView calllist;
    public MainActivity() {
        OR911 = new Oregon911();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OR911.setContext(this);
        OR911.updateIncidentManager();
        calllist = (ListView) findViewById(R.id.CallListView);
        calllist.setAdapter(new CallListAdapter(OR911.getContext(), OR911.getIntMan().getList()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.call_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void refreshButton(MenuItem menuItem) {
        OR911.updateIncidentManager();
        calllist.setAdapter(null);
        calllist.setAdapter(new CallListAdapter(OR911.getContext(), OR911.getIntMan().getList()));
    }

    private void createTestCall(int callNumber, String callSum, String address, timestamp ts, String station) {
        Incident oops = new Incident();
        callinfo callheader = new callinfo();
        callheader.setCallNumber(callNumber);
        callheader.setCallSum(callSum);
        callheader.setAddress(address);
        callheader.setStation(station);
        callheader.setTs(ts);
        oops.setCallInfo(callheader);
        OR911.getIntMan().addIncident(oops);
    }

}