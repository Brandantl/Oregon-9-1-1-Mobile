#pragma once
#include <string>
#include "timestamp.h"

class callLogEntry {
public:
	callLogEntry(unsigned int _id, timestamp _tc, std::string _message);
	callLogEntry();
	~callLogEntry();

	std::string getMessage();
	timestamp getTimestamp();

	void setid(unsigned int _id);
	void setMessage(std::string _message);
	void setTimestamp(timestamp _ts);
private:
	unsigned int id;
	timestamp ts;
	std::string message;
};