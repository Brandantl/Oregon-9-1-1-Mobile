#pragma once
#include <string>

#define DISPATCHED 0
#define ENROUTE    1
#define ONSCENE    2
#define CLEAR	   3
#define MAX_STATUS 4

class Unit {
public:
	Unit(unsigned int _id, std::string _name, std::string _agency, std::string _station, std::string _status[MAX_STATUS]);
	Unit();
	~Unit();

	unsigned int getid();
	std::string getName();
	std::string getAgency();
	std::string getStation();
	std::string getStatus(const unsigned int& _status);

	void setName(const std::string& _name);
	void setAgency(const std::string& _agency);
	void setStation(const std::string& _station);
	void setStatus(const unsigned int& _status, const std::string& _value);
private:
	unsigned int id;
	std::string name;
	std::string agency;
	std::string station;
	std::string status[MAX_STATUS];
};