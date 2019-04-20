#include <iostream>

using namespace std;

int main(int argc, char *argv[]) {

  int var = 20; // normal variable declaration and init
  int *ip;      // pointer variable

  ip = &var; // store the address of var

  cout << "value of var : " << var << endl;
  cout << "value of ip : " << ip << endl;
  cout << "value at the address ip is pointing : " << *ip << endl;
  return 0;
}
