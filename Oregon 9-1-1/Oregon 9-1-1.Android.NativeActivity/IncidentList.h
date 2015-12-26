#pragma once
#include <vector>
#include "Oregon911.h"
class IncidentList {
public:
	IncidentList();
	~IncidentList();

	void addIncident(Incident thing);
	bool removeIncident(unsigned int index);
private:
	std::vector<Incident> List;
};