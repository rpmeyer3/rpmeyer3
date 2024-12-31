// README 
Ryan Meyer
811274184
rpm04447@uga.edu

How do download and run project1 submission.

download compress.h
	 compress.c
         decompress.h
	 decompress.c
	 proj1.c

compile with: 

gcc -o proj1.out proj1.c compress.c decompress.c

make a directory with all files in it along with a make file to run all files collectively.
	
	sample input:

rpm04447@csci-odin:~/csci1730/proj1$ ./proj1.out -d 52 170 76 204 204 235 53 128 216 2 161 102 102 155

	sample output:

rpm04447@csci-odin:~/csci1730/proj1$ ./proj1.out -d 52 170 76 204 204 235 53 128 216 2 161 102 102 155
AGTACCCCTAGAGAGAGAGAGCCGAGTTCAAAGTCAAAACCCATTCTCTCTCCTCG

to run the make file:
make sure it is in the same directory:
	make run
	make clean

this should take care of compiling and building the program.
