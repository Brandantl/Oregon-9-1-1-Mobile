#include "Oregon911.h"

callInfo Incident::getCallInfo()
{
	return callInfo();
}

Unit Incident::getUnit(const unsigned int& index)
{
	if (index < UnitList.size())
		return UnitList[index];
	return Unit();
}

callLogEntry Incident::getCallLogEntry(const unsigned int& index)
{
	if (index < callLogList.size())
		return callLogList[index];
	return callLogEntry();
}

changeLog Incident::getChangeLog(const unsigned int& index)
{
	if (index < ChangeLogList.size())
		return ChangeLogList[index];
	return changeLog();
}

void Incident::addUnit(const Unit& thing)
{
	UnitList.push_back(thing);
}

void Incident::addCallLogEntry(const callLogEntry& thing)
{
	callLogList.push_back(thing);
}

void Incident::addChangeLog(const changeLog& thing)
{
	ChangeLogList.push_back(thing);
}

bool Incident::removeUnit(const unsigned int& index)
{
	if (index < UnitList.size()) {
		UnitList.erase(UnitList.begin() + index);
		return true;
	}
	return false;
}

bool Incident::removeCallLogEntry(const unsigned int& index)
{
	if (index < callLogList.size()) {
		callLogList.erase(callLogList.begin() + index);
		return true;
	}
	return false;
}

bool Incident::removeChangeLog(const unsigned int& index)
{
	if (index < ChangeLogList.size()) {
		ChangeLogList.erase(ChangeLogList.begin() + index);
		return true;
	}
	return false;
}

unsigned int Incident::getUnitCount()
{
	return UnitList.size();
}

unsigned int Incident::getChangeLogCount()
{
	return callLogList.size();
}

unsigned int Incident::getCallLogCount()
{
	return ChangeLogList.size();
}

bool Incident::doesCallLogExist(const unsigned int& id)
{
	for (std::vector<Unit>::iterator it = UnitList.begin(); it != UnitList.end(); ++it) {
		if ((*it).getid() == id) {
			return true;
		}
	}
	return false;
}

bool Incident::doesUnitExist(const unsigned int& id)
{
	for (std::vector<callLogEntry>::iterator it = callLogList.begin(); it != callLogList.end(); ++it) {
		if ((*it).getid() == id) {
			return true;
		}
	}
	return false;
}

bool Incident::doesChangeLogExist(const unsigned int& id)
{
	for (std::vector<changeLog>::iterator it = ChangeLogList.begin(); it != ChangeLogList.end(); ++it) {
		if ((*it).getid() == id) {
			return true;
		}
	}
	return false;
}

unsigned int Incident::getMyId()
{
	return CallInfo.getid();
}
