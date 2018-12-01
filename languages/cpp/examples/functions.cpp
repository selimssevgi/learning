#include <iostream>
#include <ctime>

using namespace std;

double getAverage(int arr[], int size);

int main(int argc, char *argv[]) {
  return 0;
}

double getAverage(int arr[], int size) {
  int sum = 0;

  for (int i = 0; i < size; ++i) {
    sum += arr[i];
  }

  double average = sum / size;
  return average;
}

int* getRandom() {
  const int n = 10;
  static int randomNumbers[n];

  srand((unsigned)time(NULL));

  for (int i = 0; i < n; ++i) {
    randomNumbers[i] = rand() % 100;
  }

  return randomNumbers;
}
