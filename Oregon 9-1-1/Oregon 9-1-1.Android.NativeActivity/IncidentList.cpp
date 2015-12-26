#include "Oregon911.h"

IncidentList::IncidentList()
{
}

IncidentList::~IncidentList()
{
}

void IncidentList::addIncident(const Incident& thing)
{
	List.push_back(thing);
}

bool IncidentList::removeIncident(const unsigned int& index)
{
	if (index < List.size()) {
		List.erase(List.begin() + index);
		return true;
	}
	return false;
}

Incident IncidentList::getCallByIndex(const unsigned int& index)
{
	if (index < List.size())
		return List[index];
	return Incident();
}

unsigned int IncidentList::getCallCount()
{
	return List.size();
}

bool IncidentList::doesIncidentExist(const unsigned int& callNumber)
{
	for (std::vector<Incident>::iterator it = List.begin(); it != List.end(); ++it) {
		if ((*it).getCallInfo().getCallNumber() == callNumber) {
			return true;
		}
	}
	return false;
}

Incident IncidentList::getCallByCallNumber(const unsigned int& callNumber)
{
	for (std::vector<Incident>::iterator it = List.begin(); it != List.end(); ++it) {
		if ((*it).getCallInfo().getCallNumber() == callNumber) {
			return (*it);
		}
	}
	return Incident();
}

bool IncidentList::removeCallByCallNumber(const unsigned int& callNumber)
{
	for (std::vector<Incident>::iterator it = List.begin(); it != List.end(); ++it) {
		if ((*it).getCallInfo().getCallNumber() == callNumber) {
			List.erase(List.begin() + std::distance(List.begin(), it));
		}
	}
	return false;
}
