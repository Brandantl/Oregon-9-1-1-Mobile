package cad.oregon911.net;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Brandan on 12/28/2015.
 *
 * THIS IS A DRIVER!
 */
public class Oregon911 {

    private IncidentManager IntMan;
    private Context context;
    private utils utils;
    private String APIUrl = "http://www.api.oregon911.net/api/1.0/?method=getAndroidData&key=android&type=JSON";

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
        String JSONHTTP = HTTP.get(APIUrl, 10000);

        if (JSONHTTP != null && !JSONHTTP.isEmpty()) {
            if (JSONHTTP != "null") {
                JSONObject reader;
                try {
                    reader = new JSONObject(JSONHTTP);
                    Incident thing;

                    process_callHeader(reader.getJSONObject("callheader"));

                    // Make sure there's even units!
                    if (reader.has("units"))
                        process_units(reader.getJSONObject("units"));

                    clean_intman();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                // Theres no calls.
                IntMan.clearIncidents();
            }
        }
    }

    private void clean_intman() {
        int updateNum = IntMan.getUpdateNum();
        ArrayList<Incident> IncidentsToRemoveFromIntMan = new ArrayList<>();
        ArrayList<Incident> List = IntMan.getList();
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getUpdateNum() != updateNum) {
                IncidentsToRemoveFromIntMan.add(List.get(i));
            }
        }
        for (int i = 0; i < IncidentsToRemoveFromIntMan.size(); i++) {
            IntMan.removeCall(IncidentsToRemoveFromIntMan.get(i));
        }
    }

    private void process_callHeader(JSONObject callheader) {
        try {
            int updateNum = IntMan.getUpdateNum();

            updateNum = (updateNum + 1) % 4;
            IntMan.setUpdateNum(updateNum);

            // Process Washington County
            if (callheader.has("W")) {
                ArrayList<Incident> WC_CALLS = utils.ReadJSONCallList(callheader.getJSONObject("W"), 'W');
                for (int i = 0; i < WC_CALLS.size(); i++) {
                    Incident call  = WC_CALLS.get(i);
                    call.setUpdateNum(updateNum);
                    IntMan.updateIncident(call);
                }
            }

            // Process Clackamas County
            if (callheader.has("C")) {
                ArrayList<Incident> CC_CALLS = utils.ReadJSONCallList(callheader.getJSONObject("C"), 'C');
                for (int i = 0; i < CC_CALLS.size(); i++) {
                    Incident call  = CC_CALLS.get(i);
                    call.setUpdateNum(updateNum);
                    IntMan.updateIncident(call);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void process_units(JSONObject units) {
        try {

            if (units.has("W")) {
                JSONObject county = units.getJSONObject("W");

                Iterator<?> keys = county.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    if (county.get(key) instanceof JSONObject) {
                        int callNumber = Integer.parseInt(key);
                        ArrayList<unit> unitList = utils.ReadJSONUnitList(county.getJSONObject(key));
                        for (int i = 0; i < unitList.size(); i++) {
                            IntMan.getCallByCallNumber(callNumber, 'W').updateUnit(unitList.get(i));
                        }
                    }
                }
            }

            if (units.has("C")) {
                JSONObject county = units.getJSONObject("C");
                Iterator<?> keys = county.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    if (county.get(key) instanceof JSONObject) {
                        int callNumber = Integer.parseInt(key);
                        ArrayList<unit> unitList = utils.ReadJSONUnitList(county.getJSONObject(key));
                        for (int i = 0; i < unitList.size(); i++) {
                            IntMan.getCallByCallNumber(callNumber, 'C').updateUnit(unitList.get(i));
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public IncidentManager getIntMan() {
        return IntMan;
    }

    public void setIntMan(IncidentManager intMan) {
        IntMan = intMan;
    }
}
