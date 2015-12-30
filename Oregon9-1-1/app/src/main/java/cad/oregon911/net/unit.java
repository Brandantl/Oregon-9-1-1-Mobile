package cad.oregon911.net;

/**
 * Created by Brandan on 12/28/2015.
 */
public class unit {

    public unit() {

    }

    public unit(int id, String name, String agency, String station, String[] status) {
        this.id = id;
        this.name = name;
        this.agency = agency;
        this.station = station;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    private int id;
    private String name;
    private String agency;
    private String station;
    private String[] status;
}
