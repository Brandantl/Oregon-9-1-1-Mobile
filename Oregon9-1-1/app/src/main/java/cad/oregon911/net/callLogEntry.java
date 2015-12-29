package cad.oregon911.net;

/**
 * Created by Brandan on 12/28/2015.
 */
public class callLogEntry {

    public callLogEntry() {
        this.id = 0;
        ts = new timestamp();
    }

    public callLogEntry(int id, timestamp ts, String message) {
        this.id = id;
        this.ts = ts;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int id;
    private timestamp ts;
    private String message;
}
