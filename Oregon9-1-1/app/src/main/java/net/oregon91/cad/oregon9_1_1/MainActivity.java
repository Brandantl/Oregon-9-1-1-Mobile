package net.oregon91.cad.oregon9_1_1;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import cad.oregon911.net.Incident;
import cad.oregon911.net.IncidentManager;
import cad.oregon911.net.callinfo;
import cad.oregon911.net.timestamp;

public class MainActivity extends AppCompatActivity {

    IncidentManager intman;

    public MainActivity() {
        intman = new IncidentManager();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createTestCalls();

        ListAdapter CallListAdapt = new CallListAdapter(this,intman.getList() );
        ListView CLV = (ListView) findViewById(R.id.CallListView);
        CLV.setAdapter(CallListAdapt);



    }

    private void createTestCalls() {
        // Get Data from class
        int    single_callNumber = 1010101;
        String single_callSum = "CARDIAC ARREST";
        String single_station = "BVM";
        String single_timedate = "2015-12-28 17:45:44";
        String single_address = "NW 229TH AV & DEAD END";
        String single_units = "<font color=\"" + ContextCompat.getColor(this, R.color.enroute) + "\">" + "MW80" + "</font>";

        Incident oops = new Incident();
        callinfo callheader = new callinfo();

        timestamp ts = new timestamp(2015,12,28,18,1,30);
        callheader.setCallNumber(single_callNumber);
        callheader.setCallSum(single_callSum);
        callheader.setAddress(single_address);
        callheader.setStation(single_station);
        callheader.setTs(ts);
        oops.setCallInfo(callheader);
        intman.addIncident(oops);
    }

}