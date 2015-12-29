package net.oregon91.cad.oregon9_1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.concurrent.ExecutionException;

import cad.oregon911.net.HTTP;
import cad.oregon911.net.Incident;
import cad.oregon911.net.Oregon911;
import cad.oregon911.net.callinfo;
import cad.oregon911.net.timestamp;

public class MainActivity extends AppCompatActivity {
    Oregon911 OR911;

    // **** TESTING TESTING TESTING **** ///
    private static String url = "http://www.api.oregon911.net/api/1.0/?method=getAndroidData&key=android&type=JSON";
    // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- ///

    public MainActivity() {
        OR911 = new Oregon911();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // **** TESTING TESTING TESTING **** ///

        // Gets the complete JSON from OREGON 911 API
        HTTP thing = new HTTP(this);
        String responce = "HI!";
        try {
            responce = thing.execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- ///

        createTestCall(151204891, "CARDIAC ARREST", "66535 SW KINNAMAN RD", new timestamp(2015, 12, 28, 18, 1, 30), "ALO");
        createTestCall(151204892, "*** TEST ***", "17911 NW Evergreen Pkwy", new timestamp(2015,10,28,18,1,30), "RCK" );
        createTestCall(151204893, "Detector Problem", "Singletree St & Doubletree St", new timestamp(2015, 11, 28, 18, 1, 30), "FGF");
        createTestCall(151204893, "Sick Person/Unko", "18th Av & 19th Av", new timestamp(2015, 12, 25, 18, 1, 30), "FGF");
        createTestCall(151204891, "CARDIAC ARREST", "66535 SW KINNAMAN RD", new timestamp(2015, 12, 28, 18, 1, 30), "ALO");
        createTestCall(151204892, "*** TEST ***", "17911 NW Evergreen Pkwy", new timestamp(2015,10,28,18,1,30), "RCK" );
        createTestCall(151204893, "Detector Problem", "Singletree St & Doubletree St", new timestamp(2015,11,28,18,1,30), "FGF" );
        createTestCall(151204893, "Sick Person/Unko", "18th Av & 19th Av", new timestamp(2015,12,25,18,1,30), "FGF" );
        createTestCall(151204891, "CARDIAC ARREST", "66535 SW KINNAMAN RD", new timestamp(2015, 12, 28, 18, 1, 30), "ALO");
        createTestCall(151204892, "*** TEST ***", "17911 NW Evergreen Pkwy", new timestamp(2015,10,28,18,1,30), "RCK" );
        createTestCall(151204893, "Detector Problem", "Singletree St & Doubletree St", new timestamp(2015,11,28,18,1,30), "FGF" );
        createTestCall(151204893, "Sick Person/Unko", "18th Av & 19th Av", new timestamp(2015,12,25,18,1,30), "FGF" );

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