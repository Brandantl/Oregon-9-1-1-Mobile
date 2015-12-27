#include "Oregon911.h"
#include <curl\curl.h>
using namespace std;

std::string utils_http(std::string url) {
	char * result;
	CURL *curl;
	CURLcode res;
	string response;
	curl = curl_easy_init();
	if (curl) {
		curl_easy_setopt(curl, CURLOPT_URL, "http://www.browsarity.com/");
		curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_to_string);
		curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);
		res = curl_easy_perform(curl);
		curl_easy_cleanup(curl);
	}
	return response;
}

size_t write_to_string(void *ptr, size_t size, size_t count, void *stream) {
	((string*)stream)->append((char*)ptr, 0, size*count);
	return size*count;
}