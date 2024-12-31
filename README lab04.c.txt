//README lab04.c
811274184
Ryan Meyer
rpm04447@uga.edu

Instructions for compiling and running the program:

1. Ensure you are on the Odin server, or an environment with GCC version 11.2.0 or higher.
2. To compile the program, use the following command:

gcc -Wall lab04.c -o lab04.out

This will create an executable file named `lab04.out`.

3. To run the program, use the following commands, depending on the operation you want to perform:

- For bitwise NOT operation:
  ```
  ./lab04.out -not [bit string]
  ```

- For left shift operation:
  ```
  ./lab04.out [bit string] -leftshift [amount]
  ```

- For right shift operation:
  ```
  ./lab04.out [bit string] -rightshift [amount]
  ```

4. Examples:

rpm04447@csci-odin:~/csci1730/lab04$ ./lab04.out 10010 -rightshift 3
10010 >> 00011 evaluates to 00010 using bit strings of length 5
18 >> 3 evaluates to 2 using unsigned 5-bit integers

- Bitwise NOT:
  ```
  ./lab04.out -not 1010
  ```

- Left shift:
  ```
  ./lab04.out 1010 -leftshift 2
  ```

- Right shift:
  ```
  ./lab04.out 1010 -rightshift 2
  ```

5. The program will output the result in both binary and base-10 formats, demonstrated in the assignment examples.

This should be it, have a lovely time.

