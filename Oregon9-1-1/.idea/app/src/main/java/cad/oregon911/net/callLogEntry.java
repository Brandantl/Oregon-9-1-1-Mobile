package cad.oregon911.net;

/**
 * Created by Brandan on 12/28/2015.
 */
public class callLogEntry {

    private int id;
    private int userid;
    private String username;
    private timestamp ts;
    private String message;

    public callLogEntry() {
        this.id = 0;
        ts = new timestamp();
    }

    public callLogEntry(int id, timestamp ts, int userid, String username, String message) {
        this.id = id;
        this.ts = ts;
        this.userid = userid;
        this.username = username;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
