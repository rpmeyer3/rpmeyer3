// Read Me
Ryan Meyer
811274174
rpm04447@uga.edu

Instructions to download, compile, and run this program.

Download the proper Makefile and program file lab05.c

in the command line the program lab05.c needs to be compiled into a .out file. 

This is done with the command gcc -Wall lab05.c -o lab05.out 

This should create the .out file necessary to compile the program. 

Then make sure that the Makefile is downloaded correctly into teh correct directory. Since the Makefile is the program used to test the success of the file the next steps with follow.

type into your command line:
make lab05.out 
make run 

This should run the program with the expected output:

./lab05.out -decimal -16 -bits 12
-16 in decimal is equal to 111111110000 in binary using 12-bit two's complement representation
./lab05.out -bits 15 -decimal -119
-119 in decimal is equal to 111111110001001 in binary using 15-bit two's complement representation
./lab05.out -binary 110101
110101 in binary is equal to -11 in decimal using 6-bit two's complement representation

When this is done the file should have been run correctly with no issues.

This should be it.