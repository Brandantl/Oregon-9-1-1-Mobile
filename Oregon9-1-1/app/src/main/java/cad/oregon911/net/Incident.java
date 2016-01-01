package cad.oregon911.net;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Brandan on 12/28/2015.
 */
public class Incident {

    private callinfo CallInfo;
    private ArrayList<callLogEntry> callLogEntryList;
    private ArrayList<unit> UnitList;
    private ArrayList<changeLog> changeLogList;
    private int updateNum; // This tells us if some calls wasn't updated (ie deleted)

    public int getUpdateNum() {
        return updateNum;
    }

    public void setUpdateNum(int updateNum) {
        this.updateNum = updateNum;
    }

    public Incident() {
        CallInfo = new callinfo();
        callLogEntryList = new ArrayList<>();
        UnitList = new ArrayList<>();
        changeLogList = new ArrayList<>();
        updateNum = 0;
    }

    public Incident(callinfo callInfo, ArrayList<callLogEntry> callLogEntryList, ArrayList<unit> unitList, ArrayList<changeLog> changeLogList) {
        CallInfo = callInfo;
        this.callLogEntryList = callLogEntryList;
        UnitList = unitList;
        this.changeLogList = changeLogList;
    }

    public ArrayList<changeLog> getChangeLogList() {
        return changeLogList;
    }

    public void setChangeLogList(ArrayList<changeLog> changeLogEntryList) {
        this.changeLogList = changeLogEntryList;
    }

    public callinfo getCallInfo() {
        return CallInfo;
    }

    public void setCallInfo(callinfo callInfo) {
        CallInfo = callInfo;
    }

    public ArrayList<callLogEntry> getCallLogEntryList() {
        return callLogEntryList;
    }

    public void setCallLogEntryList(ArrayList<callLogEntry> callLogEntryList) {
        this.callLogEntryList = callLogEntryList;
    }

    public ArrayList<unit> getUnitList() {
        return UnitList;
    }

    public void setUnitList(ArrayList<unit> unitList) {
        UnitList = unitList;
    }

    public void updateUnit(unit thing) {
        for (int i = 0; i < UnitList.size(); i++) {
            if ( thing.getName().equals(UnitList.get(i).getName())) {
                UnitList.get(i).setStatus(thing.getStatus());
                return;
            }
        }
        addUnit(thing);
    }

    public void addUnit(unit Thing) {
        UnitList.add(Thing);
    }

    public void addCallLogEntry(callLogEntry Thing) {
        callLogEntryList.add(Thing);
    }

    public void addChangeLog(changeLog Thing) {
        changeLogList.add(Thing);
    }

    public void removeUnit(int index) {
        UnitList.remove(index);
    }

    public void removeCallLogEntry(int index) {
        callLogEntryList.remove(index);
    }

    public void removeChangeLoy(int index) {
        changeLogList.remove(index);
    }

    public int getMyID() {
        return CallInfo.getId();
    }
}
class IncidentDateComparatorDesc implements Comparator<Incident> {
    public int compare(Incident incident1, Incident incident2) {
        Boolean incident1IsNewer = false;
        timestamp int1ts = incident1.getCallInfo().getTs();
        timestamp int2ts = incident2.getCallInfo().getTs();

        // This can be optimised but I don't care.
        if (int1ts.getYear() > int2ts.getYear()) {
            incident1IsNewer = true;
        } else {
            if (int1ts.getMonth() > int2ts.getMonth()) {
                incident1IsNewer = true;
            } else {
                if (int1ts.getDay() > int2ts.getDay()) {
                    incident1IsNewer = true;
                } else {
                    if (int1ts.getHour() > int2ts.getHour()) {
                        incident1IsNewer = true;
                    } else {
                        if (int1ts.getMinute() > int2ts.getMinute()) {
                            incident1IsNewer = true;
                        } else {
                            if (int1ts.getMinute() > int2ts.getMinute()) {
                                incident1IsNewer = true;
                            }
                        }
                    }
                }
            }
        }
        return incident1IsNewer ? -1 : 0;
    }
}
