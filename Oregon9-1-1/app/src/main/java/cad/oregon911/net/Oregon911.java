package cad.oregon911.net;

/**
 * Created by Brandan on 12/28/2015.
 *
 *  THIS IS A DRIVER!
 */
public class Oregon911 {

    public Oregon911() {
        IntMan = new IncidentManager();
    }

    public Oregon911(IncidentManager intMan) {
        IntMan = intMan;
    }

    public void updateIncidentManager() {

    }






    public IncidentManager getIntMan() {
        return IntMan;
    }

    public void setIntMan(IncidentManager intMan) {
        IntMan = intMan;
    }

    private IncidentManager IntMan;
}
