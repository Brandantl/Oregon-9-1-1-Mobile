#include "Oregon911.h"

Unit::Unit(unsigned int _id, std::string _name, std::string _agency, std::string _station, std::string _status[MAX_STATUS]) {

}

Unit::Unit() {
	id = 0;
}

Unit::~Unit()
{
}

unsigned int Unit::getid()
{
	return id;
}

std::string Unit::getName()
{
	return name;
}

std::string Unit::getAgency()
{
	return agency;
}

std::string Unit::getStation()
{
	return station;
}

void Unit::setName(const std::string& _name)
{
	name = _name;
}

void Unit::setAgency(const std::string& _agency)
{
	agency = _agency;
}

void Unit::setStation(const std::string& _station)
{
	station = _station;
}

void Unit::setStatus(const unsigned int& _status, const std::string& _value)
{
	if (_status < MAX_STATUS) {
		status[_status] = _value;
	}
}

std::string Unit::getStatus(const unsigned int& _status)
{
	if (_status < MAX_STATUS) {
		return status[_status];
	}
	return std::string();
}
