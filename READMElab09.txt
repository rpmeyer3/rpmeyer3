
READMElab09.txt.txt

Ryan Meyer
811274184

Lab 09 - Unions and IEEE 754

Instructions to Compile and Run the Program:
--------------------------------------------

1. Make sure you have all the necessary files in the "lab09" directory:
   - lab09.c

2. Compile the program using the provided Makefile. In the terminal, navigate to the "lab09" directory and run the following command:

   ```bash
   make
   ```

or make lab09.out
	make run

3. Run the program with the appropriate flag and value:
   
   For float conversion to binary:
   ```bash
   ./lab09.out -f <float_value>
   ```

   For double conversion to binary:
   ```bash
   ./lab09.out -d <double_value>
   ```

   Examples:
   ```bash
   ./lab09.out -f -18.5
   ./lab09.out -d 18.5
   ```

Program Description:
--------------------
This program takes a floating-point or double-precision number as input and converts it to its binary representation following the IEEE 754 standard using union data structures. The user can specify whether the input is a float or a double by using the "-f" or "-d" flags, respectively. The program then prints the binary representation, along with the breakdown of the sign bit, exponent, and fraction fields.

Files Included:
---------------
1. lab09.c      - Source code for the program.
2. README.txt   - This file.

Notes:
------
- Ensure that the program compiles without warnings or errors using GCC version 11.2.0.
- Used valgrind to check for memory leaks before submitting.
