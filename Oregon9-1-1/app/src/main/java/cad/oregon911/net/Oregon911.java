package cad.oregon911.net;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Brandan on 12/28/2015.
 *
 *  THIS IS A DRIVER!
 */
public class Oregon911 {

    public Oregon911() {
        IntMan = new IncidentManager();
        utils = new utils();
    }

    public Oregon911(Context context) {
        this.context = context;
    }

    public Oregon911(IncidentManager intMan) {
        IntMan = intMan;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void updateIncidentManager() {
        String JSONHTTP = utils.http_get(APIUrl, context);

        if (!JSONHTTP.isEmpty() && JSONHTTP != "null") {
            JSONObject reader;
            try{
                reader = new JSONObject(JSONHTTP);
                JSONObject callheader  = reader.getJSONObject("callheader");
                Incident thing;

                // Process Washington County
                if (callheader.has("W")) {
                    ArrayList<Incident> WC_CALLS = utils.ReadJSONCallList(callheader.getJSONObject("W"), 'W');

                    // **** TEMP!!!! ****
                    for (int i = 0; i < WC_CALLS.size(); i++) {
                        IntMan.addIncident(WC_CALLS.get(i));
                    }

                }

                // Process Clackamas County
                if (callheader.has("C")) {
                    ArrayList<Incident> CC_CALLS = utils.ReadJSONCallList(callheader.getJSONObject("C"), 'C');

                    // **** TEMP!!!! ****
                    for (int i = 0; i < CC_CALLS.size(); i++) {
                        IntMan.addIncident(CC_CALLS.get(i));
                    }

                }

            }catch(JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public IncidentManager getIntMan() {
        return IntMan;
    }

    public void setIntMan(IncidentManager intMan) {
        IntMan = intMan;
    }

    private IncidentManager IntMan;
    private Context context;
    private utils utils;
    private String APIUrl = "http://www.api.oregon911.net/api/1.0/?method=getAndroidData&key=android&type=JSON";
}
