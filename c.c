#include <stdio.h>
#include <stdlib.h>

int main() {
    double *grades = NULL;     // Pointer to store grades
    double grade;              // Temporary variable to hold input grades
    int count = 0;             // Counter for number of grades
    int capacity = 5;          // Initial capacity for 5 grades
    double sum = 0.0;          // To compute the total sum of grades
    int allocations = 0;       // Track the number of allocations
    int frees = 0;             // Track the number of frees
    size_t total_bytes_allocated = 0; // Track total bytes allocated

    // Prompt the user to enter grades
    printf("Enter a list of grades below where each grade is separated by a newline character.\n");
    printf("After the last grade is entered, enter a negative value to end the list.\n");

    // Read the first grade
    scanf("%lf", &grade);

    // Handle the case where no valid grades are entered (first input is negative)
    if (grade < 0) {
        printf("The average of 0 grades is 0.000000.\n");
        printf("total heap usage: 0 allocs, 0 frees, 0 bytes allocated\n");
        return 0;  // Exit the program
    }

    // Allocate initial memory for 5 grades (40 bytes)
    grades = (double *)malloc(capacity * sizeof(double));
    if (grades == NULL) {
        printf("Memory allocation failed.\n");
        return 1;
    }

    allocations++;
    total_bytes_allocated += capacity * sizeof(double);
    printf("Allocated 40 bytes to the heap at %p.\n", (void*)grades);

    // Store the first valid grade and sum it
    grades[0] = grade;
    printf("Stored %lf in the heap at %p.\n", grades[0], (void*)&grades[0]);
    sum += grade;
    count++;

    // Read the next grades
    while (1) {
        scanf("%lf", &grade);

        if (grade < 0) {
            break;  // Stop reading when a negative value is entered
        }

        // Check if the heap is full and reallocate memory if necessary
        if (count == capacity) {
            // Print the message when the first 5 grades are stored
            printf("Stored %d grades (%lu bytes) to the heap at %p.\n", count, capacity * sizeof(double), (void*)grades);
            printf("Heap at %p is full.\n", (void*)grades);

            capacity += 5;  // Increase capacity by 5 grades (additional 40 bytes)
            double *new_grades = (double *)malloc(capacity * sizeof(double));
            if (new_grades == NULL) {
                printf("Memory reallocation failed.\n");
                free(grades);  // Free the original memory before exiting
                return 1;
            }

            // Copy existing grades to new memory
            for (int i = 0; i < count; i++) {
                new_grades[i] = grades[i];
            }

            printf("Allocated %lu bytes to the heap at %p.\n", capacity * sizeof(double), (void*)new_grades);
            printf("Copied %d grades from %p to %p.\n", count, (void*)grades, (void*)new_grades);

            // Free the old memory and point to the new block
            printf("Freed %lu bytes from the heap at %p.\n", (capacity - 5) * sizeof(double), (void*)grades);
            free(grades);
            frees++;

            grades = new_grades;

            allocations++;
            total_bytes_allocated += 5 * sizeof(double);  // Additional allocation of 40 bytes
        }

        // Store the grade and update the sum
        grades[count] = grade;
        printf("Stored %lf in the heap at %p.\n", grades[count], (void*)&grades[count]);
        sum += grade;
        count++;
    }

    // If grades were entered, compute the average and print the results
    if (count > 0) {
        double average = sum / count;
        printf("The average of %d grades is %lf.\n", count, average);

        // Print whether each grade is >= or < the average
        for (int i = 0; i < count; i++) {
            if (grades[i] >= average) {
                printf("%d. The grade of %lf is >= the average.\n", i + 1, grades[i]);
            } else {
                printf("%d. The grade of %lf is < the average.\n", i + 1, grades[i]);
            }
        }

        // Free the allocated memory and print the heap usage
        printf("Freed %lu bytes from the heap at %p.\n", capacity * sizeof(double), (void*)grades);
        free(grades);
        frees++;

        // Output total heap usage (allocations, frees, and bytes allocated)
        printf("total heap usage: %d allocs, %d frees, %lu bytes allocated\n", allocations, frees, total_bytes_allocated);
    }

    return 0;
}
