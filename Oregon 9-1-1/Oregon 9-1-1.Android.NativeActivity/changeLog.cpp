#include "Oregon911.h"

changeLog::changeLog(unsigned int _id, timestamp _ts, unsigned char _type, double _lat, double _lon, std::string _callSum, std::string _address)
{
	id = _id;
	ts = _ts;
	type = _type;
	lat = _lat;
	lon = _lon;
	callSum = _callSum;
	address = _address;
}

changeLog::changeLog() {
	id = 0;
	type = 0;
	lat = 0.0;
	lon = 0.0;
}

changeLog::~changeLog()
{

}

unsigned int changeLog::getid()
{
	return id;
}

timestamp changeLog::getTimeStamp()
{
	return ts;
}

unsigned char changeLog::getType()
{
	return type;
}

double changeLog::getLat()
{
	return lat;
}

double changeLog::getLon()
{
	return lon;
}

std::string changeLog::getCallSum()
{
	return callSum;
}

std::string changeLog::getAddress()
{
	return address;
}

void changeLog::setid(unsigned int _id)
{
	id = _id;
}

void changeLog::setTimeStamp(const timestamp & _ts)
{
	ts = _ts;
}

void changeLog::setType(const unsigned char & _type)
{
	type = _type;
}

void changeLog::setLat(const double & _lat)
{
	lat = _lat;
}

void changeLog::setLon(const double & _lon)
{
	lon = _lon;
}

void changeLog::setCallSum(const std::string& _callsum)
{
	callSum = _callsum;
}

void changeLog::setAddress(const std::string& _address)
{
	address = _address;
}
