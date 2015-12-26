#include "Oregon911.h"

callLogEntry::callLogEntry(unsigned int _id, timestamp _tc, std::string _message)
{

}

callLogEntry::callLogEntry() {

}

callLogEntry::~callLogEntry()
{

}

std::string callLogEntry::getMessage()
{
	return std::string();
}

timestamp callLogEntry::getTimestamp()
{
	return timestamp();
}

void callLogEntry::setid(unsigned int _id)
{
}

void callLogEntry::setMessage(std::string _message)
{
}

void callLogEntry::setTimestamp(timestamp _ts)
{
}
