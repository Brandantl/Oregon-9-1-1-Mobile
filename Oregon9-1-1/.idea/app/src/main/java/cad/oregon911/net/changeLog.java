package cad.oregon911.net;

/**
 * Created by Brandan on 12/28/2015.
 */
public class changeLog {

    private int id;
    private timestamp ts;
    private int type;
    private double lat;
    private double lon;
    private String callSum;
    private String address;

    public changeLog() {
        this.id = 0;
        this.type = 0;
        this.lat = 0.0;
        this.lon = 0.0;
        ts = new timestamp();
    }

    public changeLog(int id, timestamp ts, int type, double lat, double lon, String callSum, String address) {
        this.id = id;
        this.ts = ts;
        this.type = type;
        this.lat = lat;
        this.lon = lon;
        this.callSum = callSum;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public timestamp getTs() {
        return ts;
    }

    public void setTs(timestamp ts) {
        this.ts = ts;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCallSum() {
        return callSum;
    }

    public void setCallSum(String callSum) {
        this.callSum = callSum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
