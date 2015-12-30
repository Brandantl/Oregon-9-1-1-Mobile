package net.oregon91.cad.oregon9_1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.concurrent.ExecutionException;
import cad.oregon911.net.HTTP;
import cad.oregon911.net.Incident;
import cad.oregon911.net.Oregon911;
import cad.oregon911.net.callinfo;
import cad.oregon911.net.timestamp;

public class MainActivity extends AppCompatActivity {
    Oregon911 OR911;

    // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- ///

    public MainActivity() {
        OR911 = new Oregon911();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OR911.setContext(this);
        OR911.updateIncidentManager();

        ListAdapter CallListAdapt = new CallListAdapter(this,OR911.getIntMan().getList() );
        ListView CLV = (ListView) findViewById(R.id.CallListView);
        CLV.setAdapter(CallListAdapt);

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