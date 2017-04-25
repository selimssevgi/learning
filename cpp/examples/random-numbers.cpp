#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

int main(int argc, char *argv[]) {
  int i,j;

  srand( (unsigned) time(NULL) );

  for (i=0; i < 10; i++) {
    j = rand() % 1000;
    cout << "A random number : " << j << endl;
  }
  return 0;
}
