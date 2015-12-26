#pragma once
#include <string>
#include "Oregon911.h"

class callInfo {
public:


private:
	unsigned int id;
	std::string callSum;
	unsigned int callNumber;
	std::string address;
	std::string Agency;
	std::string Station;
	std::string Units;
	unsigned int unitCount;
	bool Active;
	double lat;
	double lon;
	timestamp tc;
};