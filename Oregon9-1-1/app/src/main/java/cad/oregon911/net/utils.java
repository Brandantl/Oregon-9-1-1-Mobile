package cad.oregon911.net;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/**
 * Created by Brandan on 12/28/2015.
 */

public class utils {

    public String http_get(String url, Context context) {
        HTTP thing = new HTTP(context);
        String response = "";
        try {
            response = thing.execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return response;
    }

    public ArrayList<Incident> ReadJSONCallList(JSONObject CALLS_LIST, char county) {
        ArrayList<Incident> List = new ArrayList<>();
        Iterator<?> keys = CALLS_LIST.keys();
        while( keys.hasNext() ) {
            String key = (String)keys.next();
            try {
                if ( CALLS_LIST.get(key) instanceof JSONObject ) {
                    JSONObject call = CALLS_LIST.getJSONObject(key);
                    Incident thing = new Incident();
                    callinfo ci = new callinfo();

                    char type;

                    ci.setCallNumber(Integer.parseInt(key));
                    ci.setCounty(county);
                    ci.setId(call.getInt("id"));
                    ci.setCallSum(call.getString("callsum"));

                    // JSONObject doesn't have getChar, dumb!
                    switch (call.getString("type")) {
                        case "F":
                            ci.setType('F');
                            break;
                        case "M":
                            ci.setType('M');
                            break;
                        case "P":
                            ci.setType('P');
                            break;

                        default:
                            ci.setType('?');
                    }

                    ci.setAddress(call.getString("address"));
                    ci.setAgency(call.getString("agency"));
                    ci.setStation(call.getString("station"));
                    ci.setUnits(call.getString("units"));
                    ci.setActive(call.getBoolean("active"));
                    ci.setLat(call.getDouble("lat"));
                    ci.setLon(call.getDouble("lon"));
                    ci.setFlags(call.getString("flags"));
                    ci.setTs(new timestamp(call.getInt("year"), call.getInt("month"), call.getInt("day"), call.getInt("hour"), call.getInt("minute"), call.getInt("second")));
                    thing.setCallInfo(ci);
                    List.add(thing);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return List;
    }

    public static enum changelogType {
        CALLSUM_CHANGED,
        ADDRESS_CHANGED,
        GPS_CHANGED
    }

    public static enum unitStatus {
        DISPATCHED,
        ENROUTE,
        ONSCENE,
        CLEAR
    }

    public static enum agency {
        WCCCA,
        WCCCA_POLICE,
        CCOM
    }

    public static String[] unitColor = {"#C82620", "#FFCC33", "#00CC00", "#787878"};
    public static String[] callHeaderColor = {"#c10c0c", "#C82620", "#69c773" };
}