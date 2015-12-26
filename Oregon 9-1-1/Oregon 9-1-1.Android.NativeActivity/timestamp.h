#pragma once
#include <string>

class timestamp {
public:
	timestamp(unsigned int _year, unsigned char _month, unsigned char _day, 
			  unsigned char _hour, unsigned char _minute, unsigned char _second);
	timestamp();
	~timestamp();

	unsigned int getYear();
	unsigned char getMonth();
	unsigned char getDay();

	unsigned char getHour();
	unsigned char getMinute();
	unsigned char getSecond();

	void setYear(unsigned int _year);
	void setMonth(unsigned char _month);
	void setDay(unsigned char _day);

	void setHour(unsigned char _hour);
	void setMinute(unsigned char _minute);
	void setSecond(unsigned char _second);

	std::string toString();
private:
	unsigned int year;
	unsigned char month;
	unsigned char day;

	unsigned char hour;
	unsigned char minute;
	unsigned char second;
};