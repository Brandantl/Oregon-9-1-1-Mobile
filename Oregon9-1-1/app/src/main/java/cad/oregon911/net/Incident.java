package cad.oregon911.net;

import java.util.ArrayList;

/**
 * Created by Brandan on 12/28/2015.
 */
public class Incident {

    public Incident() {
        CallInfo = new callinfo();
        callLogEntryList = new ArrayList<>();
        UnitList = new ArrayList<>();
        changeLogList  = new ArrayList<>();
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

    private callinfo CallInfo;
    private ArrayList<callLogEntry> callLogEntryList;
    private ArrayList<unit> UnitList;
    private ArrayList<changeLog> changeLogList;
}
