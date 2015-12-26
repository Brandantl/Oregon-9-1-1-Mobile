#pragma once
#include <string>
#include "timestamp.h"

#define CALLSUM_CHANGED	0
#define ADDRESS_CHANGED	1
#define GPS_CHANGED		2

class changeLog {
public:
	changeLog(timestamp _tc, unsigned char _type, double _lat,
		double _lon, std::string _callSum, std::string _address);
	changeLog();
	~changeLog();

	timestamp getTimeStamp();
	unsigned char getType();
	double getLat();
	double getLon();
	std::string getCallSum();
	std::string getAddress();

	void  setTimeStamp(timestamp _ts);
	void  setType(unsigned char _type);
	void  setLat(double _lat);
	void  setLon(double _lon);
	void  setCallSum(std::string _callsum);
	void  setAddress(std::string _address);

private:
	timestamp tc;
	unsigned char type;

	double lat;
	double lon;

	std::string callSum;
	std::string address;
};