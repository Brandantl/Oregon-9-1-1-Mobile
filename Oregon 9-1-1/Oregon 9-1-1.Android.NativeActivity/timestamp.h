#pragma once
#include <string>

class timestamp {
	timestamp(unsigned int _year, unsigned char _month, unsigned char _day, 
			  unsigned char _hour, unsigned char _minute, unsigned char _second);
	~timestamp();

	unsigned int getYear();
	unsigned char getMonth();
	unsigned char getDay();

	unsigned char getHour();
	unsigned char getDay();
	unsigned char getHour();

	std::string toString();
private:
	unsigned int year;
	unsigned char month;
	unsigned char day;

	unsigned char hour;
	unsigned char minute;
	unsigned char second;
};