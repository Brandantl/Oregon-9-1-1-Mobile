#pragma once
#include <string>
#include "timestamp.h"

class callLogEntry {
public:
	callLogEntry(unsigned int _id, timestamp _ts, std::string _message);
	callLogEntry();
	~callLogEntry();

	unsigned int	getid();
	std::string getMessage();
	timestamp getTimestamp();

	void setid(const unsigned int & _id);
	void setMessage(const std::string & _message);
	void setTimestamp(const timestamp & _ts);
private:
	unsigned int id;
	timestamp ts;
	std::string message;
};