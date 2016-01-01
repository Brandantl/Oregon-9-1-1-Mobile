package net.oregon91.cad.oregon9_1_1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import cad.oregon911.net.Incident;
import cad.oregon911.net.Oregon911;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class calllist_page extends AppCompatActivity {
    Oregon911 OR911;
    private net.oregon91.cad.oregon9_1_1.CallListAdapter CallListAdapt;
    private ListView calllist;
    private Thread autoRefresh;
    public calllist_page() {
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
                //TextView calltxt = (TextView)view.findViewById(R.id.call_text);

            }
        });
        registerForContextMenu(calllist);
        autoRefresh();
    }

    void autoRefresh() {
        autoRefresh = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(10000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshButton(null);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        autoRefresh.start();
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        refreshButton(null);
        if (!autoRefresh.isAlive())
            autoRefresh();
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
        autoRefresh.interrupt(); // Stop AutoRefresh
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(R.menu.call_list_contextmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        View callitem = calllist.getAdapter().getView(info.position, null, calllist);
        TextView string_callNumber = (TextView)callitem.findViewById(R.id.callNumber);
        TextView string_county = (TextView)callitem.findViewById(R.id.county);
        TextView string_type = (TextView)callitem.findViewById(R.id.type);

        // Conversion
        int callNumber = Integer.parseInt(string_callNumber.getText().toString());
        char county = string_county.getText().toString().charAt(0);
        char type = string_type.getText().toString().charAt(0);

        Incident call = OR911.getIntMan().getCallByCallNumberAndType(callNumber, county, type);
        double lat = call.getCallInfo().getLat();
        double lon = call.getCallInfo().getLon();

        if (call != null) {
            // Open Maps
            String uri = String.format(Locale.ENGLISH, "geo:%f,%f?q=%f,%f", lat,lon, lat,lon);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            try
            {
                OR911.getContext().startActivity(intent);
            }
            catch(ActivityNotFoundException ex) {
                Toast.makeText(this, "Please install a maps application", Toast.LENGTH_LONG).show();
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.call_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void refreshButton(MenuItem menuItem) {
        net.oregon91.cad.oregon9_1_1.RefreshCallList thing = new net.oregon91.cad.oregon9_1_1.RefreshCallList(OR911, calllist);
        thing.execute();
    }

}