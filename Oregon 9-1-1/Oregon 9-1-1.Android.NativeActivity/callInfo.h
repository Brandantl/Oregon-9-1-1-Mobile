#pragma once
#include "Oregon911.h"

class callInfo {
public:
	callInfo(unsigned int _id, std::string _callSum, unsigned int _callNumber, std::string _address,std::string _agency,
		std::string _station, std::string _units, unsigned int _unitCount, bool _active, double _lat, double _lon,
		timestamp _ts);
	callInfo();
	~callInfo();

	unsigned int getid();
	std::string getCallSum();
	unsigned int getCallNumber();
	std::string getAddress();
	std::string getAgency();
	std::string getStation();
	std::string getUnits();
	unsigned int getUnitCount();
	bool getActive();
	double getLat();
	double getLon();
	timestamp getTimeStamp();
	
	void setid(const unsigned int& _id);
	void setCallSum(const std::string& _callsum);
	void setCallNumber(const unsigned int& _callnumber);
	void setAddress(const std::string& _address);
	void setAgency(const std::string& _agency);
	void setStation(const std::string& _station);
	void setUnits(const std::string& _units);
	void setUnitCount(const unsigned int& _unitcount);
	void setActive(const bool& _active);
	void setLat(const double& _lat);
	void setLon(const double& _lon);
	void setTimeStamp(const timestamp& _ts);
private:
	unsigned int id;
	std::string callSum;
	unsigned int callNumber;
	std::string address;
	std::string agency;
	std::string station;
	std::string units;
	unsigned int unitCount;
	bool active;
	double lat;
	double lon;
	timestamp ts;
};
