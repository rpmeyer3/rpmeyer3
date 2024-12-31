int * p;

/*
 * Return the sum of the n values in x starting at index 0.
 * If x is NULL, then return -1.
 * If n is 0 and x is not NULL, then return 0.
 */
int sum(int * x, int n);

int main(int argc, char * argv[]){
  // x should point to a new array of ints stored on the heap
  int * x = int[argc];
  for(int i = 0; i <= argc; i++){
    x[i] = (int) *argv[i];
  }

  printf("*x is %d\n", *x);
  int y = sum(x, argc);
  printf("y is %d\n", y);
  int z = sum(p, argc);
  printf("z is %d\n", z);

  return 0;
}

int sum(int * x, int n){
  int sum;
  for(int i = 0; i <= n; i++){
    sum = sum + x[i]; 
  }
}

