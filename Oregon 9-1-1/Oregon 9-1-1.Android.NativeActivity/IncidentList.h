#pragma once
#include <vector>
#include "Oregon911.h"
class IncidentList {
public:
	IncidentList();
	~IncidentList();

	void addIncident(const Incident& thing);
	bool removeIncident(const unsigned int& index);

	Incident getCallByIndex(const unsigned int& index);

	unsigned int getCallCount();

	bool doesIncidentExist(const unsigned int& callNumber);
	Incident getCallByCallNumber(const unsigned int& callNumber);
	bool removeCallByCallNumber(const unsigned int& callNumber);

private:
	std::vector<Incident> List;
};