#include "Oregon911.h"

Unit::Unit(unsigned int _id, std::string _name, std::string _agency, std::string _station, std::string _status[MAX_STATUS]) {

}

Unit::Unit() {

}

Unit::~Unit()
{
}

unsigned int Unit::getId()
{
	return 0;
}

std::string Unit::getName()
{
	return std::string();
}

std::string Unit::getAgency()
{
	return std::string();
}

std::string Unit::getStation()
{
	return std::string();
}

void Unit::getName(std::string _name)
{
}

void Unit::getAgency(std::string _agency)
{
}

void Unit::getStation(std::string _station)
{
}

void Unit::setStatus(unsigned int index, std::string status)
{
}

std::string Unit::getStatus(unsigned int status)
{
	return std::string();
}
