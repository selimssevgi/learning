# Constructors in C++

- Exact same name of class
- No return value, type


```cpp
class Line {
  public:
    void setLength(double len);
    double getLength(void);
    Line(); // constructor
    Line(double len); // parameterized constructor
    ~Line(); // deconstructor: no arg no return

  private:
    double length;
};

Line::Line(void) {
  cout << "object being created" << endl;
}

Line::Line(double len) {
  length = len;
}

Line::~Line() {
  cout << "Object being destroyed" << endl;
}

Line line;
Line line(10.0);
```
