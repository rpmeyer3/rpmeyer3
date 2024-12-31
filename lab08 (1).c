#include <stdio.h>
#include <stdlib.h>

// Function prototype (do not modify)
int sum(int *x, int n);

int main(int argc, char *argv[]) {
    // Allocate memory for an array of integers
    int *x = (int *)malloc((argc - 1) * sizeof(int));
    if (x == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        return 1;
    }

    // Fill the array with the command line arguments
    for (int i = 1; i < argc; i++) {
        x[i - 1] = atoi(argv[i]);  // Convert each argument to an integer
    }

    // Output the first element
    printf("*x is %d\n", x[0]);

    // Calculate the sum of the array elements
    int y = sum(x, argc - 1);
    printf("y is %d\n", y);

    // z should be -1, as p is a NULL pointer
    int *p = NULL;
    int z = sum(p, argc - 1);
    printf("z is %d\n", z);

    // Free the allocated memory
    free(x);

    return 0;
}

// Function to calculate the sum of the array
int sum(int *x, int n) {
    if (x == NULL) {
        return -1;  // If x is NULL, return -1
    }

    if (n == 0) {
        return 0;   // If n is 0, return 0
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += x[i];  // Add each element to sum
    }

    return sum;  // Return the computed sum
}
