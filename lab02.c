#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Prototype definitions
void toBinary(unsigned long num, char *binStr, int length);
int hammingDistance(const char  *binStr1, const char *binStr2);

// Function to convert some non-negative integer to its binary representation
void toBinary(unsigned long num, char *binStr, int length) {
    for (int i = length - 1; i >= 0; i--) {
        binStr[i] = (num % 2) + '0';
        num /= 2;
    }
    binStr[length] = '\0';
}

// Function to calculate the Hamming distance between the two binary strings
int hammingDistance(const char *binStr1, const char *binStr2) {
    int distance = 0;
    for (int i = 0; binStr1[i] != '\0'; i++) {
        if (binStr1[i] != binStr2[i]) {
            distance++;
        }
    }
    return distance;
}

//start of the main function to intake cli arguements and operate on them
int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: %s <integer1> <integer2>\n", argv[0]);
        return 1;
    }

    unsigned long num1 = atol(argv[1]);
    unsigned long num2 = atol(argv[2]);

    // Find the length of the binary strings based on the larger number
    int length1 = snprintf(NULL, 0, "%lx", num1) * 4;
    int length2 = snprintf(NULL, 0, "%lx", num2) * 4;
    int maxLength = (length1 > length2) ? length1 : length2;

    char binStr1[maxLength + 1];
    char binStr2[maxLength + 1];

    // Convert both numbers to binary strings with leading zeros
    toBinary(num1, binStr1, maxLength);
    toBinary(num2, binStr2, maxLength);

    printf("%s is the bit string for %lu\n", binStr1, num1);
    printf("%s is the bit string for %lu\n", binStr2, num2);

    // Calculate and print the Hamming distance
    int distance = hammingDistance(binStr1, binStr2);
    printf("%d is the Hamming distance between the bit strings\n", distance);

    return 0;
}
//end of main function
