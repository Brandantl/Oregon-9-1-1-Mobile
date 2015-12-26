#include "Oregon911.h"

callInfo Incident::getCallInfo()
{
	return callInfo();
}

Unit Incident::getUnit(unsigned int index)
{
	return Unit();
}

callLogEntry Incident::getCallLogEntry(unsigned int index)
{
	return callLogEntry();
}

changeLog Incident::getChangeLog(unsigned int index)
{
	return changeLog();
}

void Incident::addUnit(Unit thing)
{
}

void Incident::addCallLogEntry(callLogEntry thing)
{
}

void Incident::addChangeLog(changeLog thing)
{
}

bool Incident::removeUnit(unsigned int index)
{
	return false;
}

bool Incident::removeCallLogEntry(unsigned int index)
{
	return false;
}

bool Incident::removeChangeLog(unsigned int index)
{
	return false;
}

unsigned int Incident::getUnitCount()
{
	return 0;
}

unsigned int Incident::getChangeLogCount()
{
	return 0;
}

unsigned int Incident::getCallLogCount()
{
	return 0;
}

bool Incident::doesCallLogExist(unsigned int id)
{
	return false;
}

bool Incident::doesUnitExist(unsigned int id)
{
	return false;
}

bool Incident::doesChangeLogExist(unsigned int id)
{
	return false;
}

unsigned int Incident::getMyId()
{
	return 0;
}
