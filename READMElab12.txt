Ryan Meyer
811274184

Description
This lab involves designing and implementing a C program that uses the pipe and dup2 system calls for interprocess communication between a parent process and a child process. The program will use a single call to pipe and a single call to fork to create a parent and child process that communicate through a pipe. The child process will execute a command, and its output will be piped to the parent process, which will then execute another command.

Requirements
System Calls: Use pipe, fork, wait, dup2, and execvp appropriately.
No system Call: Do not use the system function.
Single pipe and fork Calls: Only one call to pipe and one call to fork.
Error Handling: Print error messages and terminate gracefully if a function call fails.
Compilation: Use the provided Makefile to compile the program without any modifications.
Memory Management: Ensure no memory leaks using valgrind.
Compilation and Execution
To compile and run the program, follow these steps:

Compile the Program:
make lab12.out
make run

or 

gcc -Wall lab12.c -o lab12.out
make lab12.out
make run

Run the Program:
./lab12.out [command1] -pipe [command2]

Replace [command1] with the first command and its arguments.
Replace [command2] with the second command and its arguments.

Examples
Here are some examples of how to run the program:

Example 1:
./lab12.out head -4 words.txt -pipe grep r

Example 2:
./lab12.out echo -e "Your program should handle any number of valid command line arguments." -pipe grep -i P

Example 3:
./lab12.out sort -r words.txt -pipe uniq -i

Example 4:
./lab12.out cat words.txt -pipe wc -l


Example Output: 
rpm04447@csci-odin:~/csci1730/lab12$ ./lab12.out cat words.txt -pipe sort
assignment
declaration
double
function
int
int
ipc
library call
long
netstat
object
pipe
pipe
PIPE
pointer
reference
shell
signal
signal
struct
struct
system call
value

Notes
Ensure that the words.txt file is in the same directory as lab12.out.
Test your program with various valid inputs to ensure correctness.

Use the provided Makefile for compilation.

that should be it...