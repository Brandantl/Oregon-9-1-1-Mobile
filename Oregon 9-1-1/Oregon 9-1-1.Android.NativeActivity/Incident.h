#pragma once
#include <vector>
#include "Oregon911.h"

class Incident {
public:
	callInfo		getCallInfo();

	Unit			getUnit(const unsigned int& index);
	callLogEntry	getCallLogEntry(const unsigned int& index);
	changeLog		getChangeLog(const unsigned int& index);

	void addUnit(const Unit& thing);
	void addCallLogEntry(const callLogEntry& thing);
	void addChangeLog(const changeLog& thing);

	bool removeUnit(const unsigned int& index);
	bool removeCallLogEntry(const unsigned int& index);
	bool removeChangeLog(const unsigned int& index);

	unsigned int getUnitCount();
	unsigned int getChangeLogCount();
	unsigned int getCallLogCount();

	bool doesCallLogExist(const unsigned int& id);
	bool doesUnitExist(const unsigned int& id);
	bool doesChangeLogExist(const unsigned int& id);
	
	unsigned int getMyId();
private:
	callInfo				  CallInfo;
	std::vector<callLogEntry> callLogList;
	std::vector<Unit>		  UnitList;
	std::vector<changeLog>	  ChangeLogList;
};