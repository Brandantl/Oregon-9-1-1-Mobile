package cad.oregon911.net;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

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
            }catch(JSONException e) {
                e.printStackTrace();
            } finally {

                






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
