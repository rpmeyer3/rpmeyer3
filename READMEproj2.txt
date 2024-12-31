//READMEproj2
Ryan Meyer 
811274184

CSCI1730 Project 2

This project is a simple C program that reads a list of grades from the user, stores them dynamically in memory, computes the average of the grades, and prints whether each grade is above or below the average. The program also tracks memory allocations and frees.

Files

- proj2.c: The main source code file containing the implementation of the grade average calculator.

input1.txt
input2.txt
output1.txt
output2.txt

- Makefile: The makefile to compile the program.

Compilation

To compile the program, use the provided Makefile. Run the following command in the terminal:

gcc -Wall proj2.c -o proj2.out
make ./proj2.out
make run

This will compile the proj2.c file and generate an executable named proj2.out. That can interface with the makefile.

Usage

To run the program, use the following command:

./proj2.out

The program will prompt you to enter a list of grades, each separated by a newline character. After entering the last grade, enter a negative value to end the list. The program will then compute and display the average of the grades and indicate whether each grade is above or below the average.

Example

Enter a list of grades below where each grade is separated by a newline character.
After the last grade is entered, enter a negative value to end the list.
85.5
90.0
78.0
92.5
88.0
-1
The average of 5 grades is 86.800000.
1. The grade of 85.500000 is < the average.
2. The grade of 90.000000 is >= the average.
3. The grade of 78.000000 is < the average.
4. The grade of 92.500000 is >= the average.
5. The grade of 88.000000 is >= the average.
total heap usage: 2 allocs, 2 frees, 80 bytes allocated

Memory Management

The program dynamically allocates memory to store the grades and reallocates memory if the initial capacity is exceeded. It also tracks the number of memory allocations and frees, as well as the total bytes allocated.

This should be it!
