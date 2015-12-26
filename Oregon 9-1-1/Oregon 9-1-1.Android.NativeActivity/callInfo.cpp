#include "Oregon911.h"

callInfo::callInfo(unsigned int _id, std::string _callSum, unsigned int _callNumber, std::string _address, std::string _agency, std::string _station, std::string _units, unsigned int _unitCount, bool _active, double _lat, double _lon, timestamp _ts)
{
	id = _id;
	callSum = _callSum;
	callNumber = _callNumber;
	address = _address;
	agency = _agency;
	station = _station;
	units = _units;
	unitCount = _unitCount;
	active = _active;
	lat = _lat;
	lon = _lon;
	ts = _ts;
}

callInfo::callInfo()
{
	id = 0;
	callNumber = 0;
	unitCount = 0;
	active = false;
	lat = 0.0;
	lon = 0.0;
}

callInfo::~callInfo()
{

}

unsigned int callInfo::getid()
{
	return id;
}

std::string callInfo::getCallSum()
{
	return callSum;
}

unsigned int callInfo::getCallNumber()
{
	return callNumber;
}

std::string callInfo::getAddress()
{
	return address;
}

std::string callInfo::getAgency()
{
	return agency;
}

std::string callInfo::getStation()
{
	return station;
}

std::string callInfo::getUnits()
{
	return units;
}

unsigned int callInfo::getUnitCount()
{
	return unitCount;
}

bool callInfo::getActive()
{
	return active;
}

double callInfo::getLat()
{
	return lat;
}

double callInfo::getLon()
{
	return lon;
}

timestamp callInfo::getTimeStamp()
{
	return ts;
}

void callInfo::setid(const unsigned int& _id)
{
	id = _id;
}

void callInfo::setCallSum(const std::string& _callsum)
{
	callSum = _callsum;
}

void callInfo::setCallNumber(const unsigned int& _callnumber)
{
	callNumber = _callnumber;
}

void callInfo::setAddress(const std::string& _address)
{
	address = _address;
}

void callInfo::setAgency(const std::string& _agency)
{
	agency = _agency;
}

void callInfo::setStation(const std::string& _station)
{
	station = _station;
}

void callInfo::setUnits(const std::string& _units)
{
	units = _units;
}

void callInfo::setUnitCount(const unsigned int& _unitcount)
{
	unitCount = _unitcount;
}

void callInfo::setActive(const bool& _active)
{
	active = _active;
}

void callInfo::setLat(const double& _lat)
{
	lat = _lat;
}

void callInfo::setLon(const double& _lon)
{
	lon = _lon;
}

void callInfo::setTimeStamp(const timestamp& _ts)
{
	ts = _ts;
}
