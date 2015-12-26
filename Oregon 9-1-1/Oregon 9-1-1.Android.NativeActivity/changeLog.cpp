#include "Oregon911.h"

changeLog::changeLog(unsigned int _id, timestamp _tc, unsigned char _type, double _lat, double _lon, std::string _callSum, std::string _address)
{
}

changeLog::changeLog() {

}

changeLog::~changeLog()
{

}

unsigned int changeLog::getid()
{
	return 0;
}

timestamp changeLog::getTimeStamp()
{
	return timestamp();
}

unsigned char changeLog::getType()
{
	return 0;
}

double changeLog::getLat()
{
	return 0.0;
}

double changeLog::getLon()
{
	return 0.0;
}

std::string changeLog::getCallSum()
{
	return std::string();
}

std::string changeLog::getAddress()
{
	return std::string();
}

void changeLog::setid(unsigned int _id)
{
}

void changeLog::setTimeStamp(timestamp _ts)
{
}

void changeLog::setType(unsigned char _type)
{
}

void changeLog::setLat(double _lat)
{
}

void changeLog::setLon(double _lon)
{
}

void changeLog::setCallSum(std::string _callsum)
{
}

void changeLog::setAddress(std::string _address)
{
}
