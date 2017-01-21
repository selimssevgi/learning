## Types of Test Double

- Dummy
- Fake
- Stub
- Mock

#### Dummy

- All methods dummied out
- Passed around but never used
- Used to fill parameter list of a method
- IDE generated implementations

#### Fake

- Working implementation.
- Much simpler than real one.
- Ex: in memory database

#### Stub

- A ready-made answer to method calls
- Only what is required for a test
- Some methods return known values
- partial implementation
- Ex: size() always returns 1

#### Mock

- a dummy implementation for an interface or a class in which you define the
  output of certain method calls.
- Tests the interactions with the object
- May also stub out return values
- Can do something useful, can have "expectations"
- Ex: must invoke size() once
