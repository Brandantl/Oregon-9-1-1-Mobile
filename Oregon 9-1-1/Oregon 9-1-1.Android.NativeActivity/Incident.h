#pragma once
#include <vector>
#include "Oregon911.h"

class Incident {
public:
	callInfo getCallInfo();

	Unit			getUnit(unsigned int index);
	callLogEntry	getCallLogEntry(unsigned int index);
	changeLog		getChangeLog(unsigned int index);

	void addUnit(Unit thing);
	void addCallLogEntry(callLogEntry thing);
	void addChangeLog(changeLog thing);

	bool removeUnit(unsigned int index);
	bool removeCallLogEntry(unsigned int index);
	bool removeChangeLog(unsigned int index);

	unsigned int getUnitCount();
	unsigned int getChangeLogCount();
	unsigned int getCallLogCount();

	bool doesCallLogExist(unsigned int id);
	bool doesUnitExist(unsigned int id);
	bool doesChangeLogExist(unsigned int id);
	
	unsigned int getMyId();
private:
	callInfo				  CallInfo;
	std::vector<callLogEntry> callLogList;
	std::vector<Unit>		  UnitList;
	std::vector<changeLog>	  ChangeLogList;
};