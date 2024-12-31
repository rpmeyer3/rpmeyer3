Ryan Meyer	
811274184

Project 4: Multithreaded Diagonal Sums

Instructions to Compile and Run:
--------------------------------
1. Ensure all project files (proj4.c, proj4.h, main.c, Makefile) are in the same directory.
2. Open a terminal and navigate to the project directory.
3. Compile the project using the provided Makefile:

make
make run

or 

gcc -Wall -pedantic-errors proj4.c -g -c -pthread
gcc -Wall -pedantic-errors main.c -g -c
gcc -Wall -pedantic-errors main.o proj4.o -g -o proj4.out -pthread


4. Run the program with the following command:

./proj4.out <input_file> <output_file> <sum> <threads>

- <input_file>: Name of the input file containing the n-by-n grid.
- <output_file>: Name of the output file to write the results.
- <sum>: The target sum to find in the diagonals.
- <threads>: Number of threads to use (1, 2, or 3).

Example:

./proj4.out in1.txt out1.txt 10 1

./proj4.out in1.txt out1.txt 10 1
Computing the diagonal sums equal to 10 in a 5-by-5 grid using 1 thread(s).
Elapsed time for computing the diagonal sums using 1 thread(s): 0.000006 seconds.
Writing the diagonal sums equal to 10 to the file out1.txt.
Program is complete. Goodbye!
rpm04447@csci-vcf3:~/csci1730/proj4$  ./proj4.out in1.txt out1.txt 10 1; diff out1.txt correctOut1.txt | wc -c;
Computing the diagonal sums equal to 10 in a 5-by-5 grid using 1 thread(s).
Elapsed time for computing the diagonal sums using 1 thread(s): 0.000006 seconds.
Writing the diagonal sums equal to 10 to the file out1.txt.
Program is complete. Goodbye!
0
rpm04447@csci-vcf3:~/csci1730/proj4$  ./proj4.out in2.txt out2.txt 19 2; diff out2.txt correctOut2.txt | wc -c;
Computing the diagonal sums equal to 19 in a 17-by-17 grid using 2 thread(s).
Elapsed time for computing the diagonal sums using 2 thread(s): 0.000096 seconds.
Writing the diagonal sums equal to 19 to the file out2.txt.
Program is complete. Goodbye!
0
rpm04447@csci-vcf3:~/csci1730/proj4$  ./proj4.out in5.txt out5.txt 1222 3; diff out5.txt correctOut5.txt | wc -c;
Computing the diagonal sums equal to 1222 in a 3567-by-3567 grid using 3 thread(s).
Elapsed time for computing the diagonal sums using 3 thread(s): 2.609457 seconds.
Writing the diagonal sums equal to 1222 to the file out5.txt.
Program is complete. Goodbye!
0



Findings:
---------
For large grids, the program using two threads computes all of the diagonal sums faster than using a single thread. Similarly, using three threads computes all of the diagonal sums faster than using two threads. However, for small grids, the performance difference is negligible or may even favor fewer threads due to the overhead of thread creation and management.

Testing:
--------
To investigate the performance differences, create various input files with different grid sizes and test the program with 1, 2, and 3 threads. Measure the elapsed time for each run and compare the results.

Example Input and Output:
-------------------------
Input File:

1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7


Command:

./proj4.out in1.txt out1.txt 10 1


Output File:

0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0


Note: The actual output will depend on the input file and the target sum.

Additional Notes:
-----------------
- Ensure that the input files are correctly formatted and contain valid data.
- The program assumes valid command line arguments and input files.
- Use valgrind to check for memory leaks and ensure proper memory management.

That should be it on my end...
