Ryan Meyer
811274184

Instructions to compile and run the program:
1. Navigate to the directory containing the lab11.c file. make sure all other attached files are located in the same directory

- compile the program using gcc -Wall lab11.c -o lab11.out
2. Use the provided Makefile to compile the program by running the following command:
   make lab11.out
   make run

3. To run the program, use the following command:
   ./lab11.out 
   ./lab11.out < <input.txt>

4. The program will start and display its process ID (pid). Enter a list of doubles to sum.
5. To end the program, run one of the following Unix commands in another terminal to terminate it
   kill -8 <pid>
   kill -10 <pid>
   kill -12 <pid>

6. If input is redirected from a file, the program will read inputs one line at a time and go to sleep for 60 seconds at the end of the input. If no signal is received during sleep, the program will end after 60 seconds.

This should be it 

example output: 

rpm04447@csci-odin:~/csci1730/lab11$ ./lab11.out
Program started with pid = 18123
Enter a list of doubles to sum,
and to end the program,
run one of the following unix commands
  kill -8 18123
  kill -10 18123
  kill -12 18123
Tyrion Lannister
Error: please input a numeric value.
5.75
Zoey Stark
Error: please input a numeric value.
1.75
abc
Error: please input a numeric value.
def
Error: please input a numeric value.
An entire line counts as one error
Error: please input a numeric value.
2
quit
Error: please input a numeric value.
The sum is 9.500000
Program ended by handling the signal from kill -10 18123.

