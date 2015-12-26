#pragma once
#include <string>
#include "timestamp.h"

class callLogEntry {
public:
	callLogEntry(unsigned int _id, timestamp _tc, std::string _message);
	~callLogEntry();

	std::string getMessage();
	unsigned int getTimestamp();
private:
	unsigned int id;
	timestamp ts;
	std::string message;
};