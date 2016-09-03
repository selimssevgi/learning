#include <iostream>
using namespace std;

int main( int argc, char **argv ) {
  string inputString;
  cout << "Enter your full name : ";
  //  cin >> inputString; read only one word
  getline(cin, inputString);
  cout << "Your full name is " << inputString << endl;
  return 0;
}
