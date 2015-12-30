package cad.oregon911.net;

import android.content.Context;

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

    public static String[] unitColor = {"#C82620", "#FFCC33", "#00CC00", "#787878"};

}