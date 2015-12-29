package cad.oregon911.net;

/**
 * Created by Brandan on 12/28/2015.
 */
public class callinfo {

    public callinfo() {
        this.id = 0;
        this.callNumber = 0;
        this.active = false;
        this.lat = 0.0;
        this.lon = 0.0;
        ts = new timestamp();
    }

    public callinfo(int id, String callSum, int callNumber, String address, String agency, String station, String units, int unitCount, boolean active, double lat, double lon, timestamp ts) {
        this.id = id;
        this.callSum = callSum;
        this.callNumber = callNumber;
        this.address = address;
        this.agency = agency;
        this.station = station;
        this.units = units;
        this.unitCount = unitCount;
        this.active = active;
        this.lat = lat;
        this.lon = lon;
        this.ts = ts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCallSum() {
        return callSum;
    }

    public void setCallSum(String callSum) {
        this.callSum = callSum;
    }

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public timestamp getTs() {
        return ts;
    }

    public void setTs(timestamp ts) {
        this.ts = ts;
    }

    private int id;
    private String callSum;
    private int callNumber;
    private String address;
    private String agency;
    private String station;
    private String units;
    private int unitCount;
    private boolean active;
    private double lat;
    private double lon;
    private timestamp ts;
}
