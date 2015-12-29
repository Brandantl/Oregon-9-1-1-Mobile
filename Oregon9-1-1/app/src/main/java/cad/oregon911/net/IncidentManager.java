package cad.oregon911.net;

import java.util.ArrayList;

/**
 * Created by Brandan on 12/28/2015.
 */
public class IncidentManager {

    public IncidentManager() {
        List = new ArrayList<>();
    }

    public IncidentManager(ArrayList<Incident> list) {
        List = list;
    }

    public ArrayList<Incident> getList() {
        return List;
    }

    public void setList(ArrayList<Incident> list) {
        List = list;
    }

    public void addIncident(Incident thing) {
        List.add(thing);
    }

    public void removeIncident(int index) {
        List.remove(index);
    }

    public Incident getCallByIndex(int index){
        return List.get(index);
    }

    public int getCallCount() {
        return List.size();
    }

    public boolean doesIncidentExistByIndex(int index) {
        return false;
    }

    public boolean doesIncidentExistByCallNumber(int callNumber) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getCallInfo().getCallNumber() == callNumber) {
                return true;
            }
        }
        return false;
    }

    public Incident getCallByCallNumber(int callNumber) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getCallInfo().getCallNumber() == callNumber) {
                return List.get(i);
            }
        }
        return null;
    }

    public boolean removeCallByCallNumber(int callNumber) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getCallInfo().getCallNumber() == callNumber) {
                List.remove(i);
                return true;
            }
        }
        return false;
    }

    private ArrayList<Incident> List;
}
