#pragma once
#include <string>

extern size_t write_to_string(void *ptr, size_t size, size_t count, void *stream);
extern std::string utils_http(std::string url);