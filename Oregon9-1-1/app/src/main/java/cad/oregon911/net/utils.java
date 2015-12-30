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

    public static unitStatus getUnitStatus(unit thing) {
        String status[] = thing.getStatus();

        int clearidx = utils.unitStatus.CLEAR.ordinal();

        if (!status[utils.unitStatus.CLEAR.ordinal()].equals("00:00:00")) {
            return unitStatus.CLEAR;
        } else if (!status[utils.unitStatus.ONSCENE.ordinal()].equals("00:00:00")) {
            return unitStatus.ONSCENE;
        } else if (!status[utils.unitStatus.ENROUTE.ordinal()].equals("00:00:00")) {
            return unitStatus.ENROUTE;
        } else if (!status[unitStatus.DISPATCHED.ordinal()].equals("00:00:00")) {
            return unitStatus.CLEAR;
        }
        return unitStatus.CLEAR; // This should never happen.
    }

    public static ArrayList<unit> ReadJSONUnitList(JSONObject UNIT_LIST) {
        ArrayList<unit> List = new ArrayList<>();
        Iterator<?> keys = UNIT_LIST.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            try {
                if (UNIT_LIST.get(key) instanceof JSONObject) {
                    JSONObject jobjunit = UNIT_LIST.getJSONObject(key);
                    unit u = new unit();
                    String[] status = new String[4];

                    u.setName(key);
                    u.setAgency(jobjunit.getString("agency"));
                    u.setStation(jobjunit.getString("station"));

                    status[utils.unitStatus.DISPATCHED.ordinal()] = jobjunit.getString("dispatched");
                    status[utils.unitStatus.ENROUTE.ordinal()] = jobjunit.getString("enroute");
                    status[utils.unitStatus.ONSCENE.ordinal()] = jobjunit.getString("onscene");
                    status[utils.unitStatus.CLEAR.ordinal()] = jobjunit.getString("clear");

                    u.setStatus(status);

                    List.add(u);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return List;
    }

    public static ArrayList<Incident> ReadJSONCallList(JSONObject CALLS_LIST, char county) {
        ArrayList<Incident> List = new ArrayList<>();
        Iterator<?> keys = CALLS_LIST.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            try {
                if (CALLS_LIST.get(key) instanceof JSONObject) {
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
    public static String[] callHeaderColor = {"#c10c0c", "#0066ff", "#69c773"};
}