cmake_minimum_required(VERSION 3.6)
project(Esercizio_1_26102016)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES es10.c)
add_executable(Esercizio_1_26102016 ${SOURCE_FILES} es10.c)