#include <iostream>

using namespace std;

class Box {
  public:
    double length;
    double breadth;
    double height;
    // double getVolume(void); // Box::getVolume() define somewhere else
    double getVolume2(void);

    double getVolume(void) {
      return length * breadth * height;
    }
};

double Box::getVolume2() {
  return length * breadth * height;
}

int main(int argc, char *argv[]) {
  Box box1;
  Box box2;

  box1.length = 5;
  box1.breadth = 6;
  box1.height = 7;

  box2.length = 10.0;
  box2.breadth = 11.0;
  box2.height = 12.0;

  double vol1 = box1.getVolume();
  cout << "Volume of Box1 : " << vol1 << endl;

  double vol2 = box2.length * box2.breadth * box2.height;
  cout << "Volue of Box2 : " << vol2 << endl;
  return 0;
}
