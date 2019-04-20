#include <stdio.h>

enum { max_string = 127 };
static char string[max_string + 1] = "";

int main( int argc, char **argv ) {
  printf("Enter your full name: ");
  fgets(string, max_string, stdin);
  printf("Your full name is %s\n", string);
  return 0;
}
