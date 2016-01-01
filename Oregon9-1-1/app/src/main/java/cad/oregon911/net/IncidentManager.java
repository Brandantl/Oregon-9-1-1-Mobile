package cad.oregon911.net;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Brandan on 12/28/2015.
 */
public class IncidentManager {

    private ArrayList<Incident> List;
    private int updateNum;

    public IncidentManager() {
        List = new ArrayList<>();
        updateNum = 0;
    }

    public IncidentManager(ArrayList<Incident> list) {
        List = list;
    }

    public int getUpdateNum() {
        return updateNum;
    }

    public void setUpdateNum(int updateNum) {
        this.updateNum = updateNum;
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

    public Incident getCallByIndex(int index) {
        return List.get(index);
    }

    public int getCallCount() {
        return List.size();
    }

    public boolean doesIncidentExistByIndex(int index) {
        return false;
    }

    public void updateIncident(Incident thing) {
        for (int i = 0; i < List.size(); i++) {
            if (thing.getMyID() == List.get(i).getMyID()) {
                List.set(i, thing);
                return;
            }
        }
        addIncident(thing);
    }


    public boolean doesIncidentExistByCallNumber(int callNumber, char county) {
        for (int i = 0; i < List.size(); i++) {
            if (
                    List.get(i).getCallInfo().getCallNumber() == callNumber &&
                            List.get(i).getCallInfo().getCounty() == county
                    ) {
                return true;
            }
        }
        return false;
    }

    public Incident getCallByCallNumber(int callNumber, char county) {
        for (int i = 0; i < List.size(); i++) {
            if (
                    List.get(i).getCallInfo().getCallNumber() == callNumber &&
                            List.get(i).getCallInfo().getCounty() == county
                    ) {
                return List.get(i);
            }
        }
        return null;
    }

    public Incident getCallByCallNumberAndType(int callNumber, char county, char type) {
        for (int i = 0; i < List.size(); i++) {
            if (
                    List.get(i).getCallInfo().getCallNumber() == callNumber &&
                            List.get(i).getCallInfo().getCounty() == county &&
                            List.get(i).getCallInfo().getType() == type
                    ) {
                return List.get(i);
            }
        }
        return null;
    }

    public int getIncidentIndex(int callNumber, char county) {
        for (int i = 0; i < List.size(); i++) {
            if (
                    List.get(i).getCallInfo().getCallNumber() == callNumber &&
                            List.get(i).getCallInfo().getCounty() == county
                    ) {
                return i;
            }
        }
        return -1;
    }

    public void setIncidentByIndex(int index, Incident thing) {
        if ((List.size() < index) && (List.size() > -1)) {
            List.set(index, thing);
        }
    }


    public boolean removeCallByCallNumber(int callNumber, char county) {
        for (int i = 0; i < List.size(); i++) {
            if (
                    List.get(i).getCallInfo().getCallNumber() == callNumber &&
                            List.get(i).getCallInfo().getCounty() == county
                    ) {
                List.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeCall(Incident thing) {
        for (int i = 0; i < List.size(); i++) {
            if (
                    List.get(i).getCallInfo().getCallNumber() == thing.getCallInfo().getCallNumber() &&
                            List.get(i).getCallInfo().getCounty() == thing.getCallInfo().getCounty() &&
                            List.get(i).getCallInfo().getType() == thing.getCallInfo().getType()
                    ) {
                List.remove(i);
                return true;
            }
        }
        return false;
    }

    public void clearIncidents() {
        List.clear();
    }

    public void sortByDate() {
        Collections.sort(List, new IncidentDateComparator());
    }

}