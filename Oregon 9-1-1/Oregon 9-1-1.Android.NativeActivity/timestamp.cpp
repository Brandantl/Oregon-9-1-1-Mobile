#include "Oregon911.h"
#include <sstream>

timestamp::timestamp(unsigned int _year, unsigned char _month, unsigned char _day, unsigned char _hour, unsigned char _minute, unsigned char _second) {
	year = _year;
	month = _month;
	day = _day;

	hour = _hour;
	minute = _minute;
	second = _second;
}

timestamp::timestamp() {
	year = 0;
	month = 0;
	day = 0;

	hour = 0;
	minute = 0;
	second = 0;
}

timestamp::~timestamp() {

}

unsigned int timestamp::getYear() {
	return year;
}

unsigned char timestamp::getMonth() {
	return month;
}

unsigned char timestamp::getDay() {
	return day;
}

unsigned char timestamp::getHour() {
	return hour;
}

unsigned char timestamp::getMinute() {
	return minute;
}

unsigned char timestamp::getSecond() {
	return hour;
}

void timestamp::setYear(unsigned int _year)
{
	year = _year;
}

void timestamp::setMonth(unsigned char _month)
{
	month = _month;
}

void timestamp::setDay(unsigned char _day)
{
	day = _day;
}

void timestamp::setHour(unsigned char _hour)
{
	hour = _hour;
}

void timestamp::setMinute(unsigned char _minute)
{
	minute = _minute;
}

void timestamp::setSecond(unsigned char _second)
{
	second = _second;
}

std::string timestamp::toString() {
	std::ostringstream ss;
	ss << year << "-" << month << "-" << day << " " << hour << ":" << minute << ":" << second;
	return ss.str();
}