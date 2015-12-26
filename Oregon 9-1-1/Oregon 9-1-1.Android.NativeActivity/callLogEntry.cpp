#include "Oregon911.h"

callLogEntry::callLogEntry(unsigned int _id, timestamp _ts, std::string _message)
{
	id = _id;
	ts = _ts;
	message = _message;
}

callLogEntry::callLogEntry() {
	id = 0;
}

callLogEntry::~callLogEntry()
{

}

unsigned int callLogEntry::getid()
{
	return id;
}

std::string callLogEntry::getMessage()
{
	return message;
}

timestamp callLogEntry::getTimestamp()
{
	return ts;
}

void callLogEntry::setid(const unsigned int & _id)
{
	id = _id;
}

void callLogEntry::setMessage(const std::string & _message)
{
	message = _message;
}

void callLogEntry::setTimestamp(const timestamp & _ts)
{
	ts = _ts;
}
