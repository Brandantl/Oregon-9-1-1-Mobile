package net.oregon91.cad.oregon9_1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import cad.oregon911.net.Incident;
import cad.oregon911.net.Oregon911;
import cad.oregon911.net.callinfo;
import cad.oregon911.net.timestamp;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Oregon911 OR911;
    private CallListAdapter CallListAdapt;
    private ListView calllist;

    public MainActivity() {
        OR911 = new Oregon911();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calllist_page);
        OR911.setContext(this);
        calllist = (ListView) findViewById(R.id.CallListView);

        calllist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.findViewById(R.id.call_text);
                TextView calltxt = (TextView)parent.findViewById(R.id.call_text);
                Toast.makeText(MainActivity.this, calltxt.getText(), Toast.LENGTH_LONG).show();
            }
        });

        refreshButton(null);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.call_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void refreshButton(MenuItem menuItem) {
        RefreshCallList thing = new RefreshCallList(OR911, calllist);
        thing.execute();
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