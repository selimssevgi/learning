# Testing Hierarchy

1. Unit
2. Aggregate
3. System

## Unit Test

- Test just a single unit of functionality
- Math.min(1, 0) == 0
- One class, method or small module
- No non-trivial dependencies
- Fast, but possibly brittle

## Aggregate Test

- Does a component do its job?
- Persistence repository can list saved albums for an an artist
- Slower, less brittle

## System or "End to End" Test

- Check that the application meets its requirements
- We can buy widgets from our E-commerce website
- Slowest, least brittle
- Requires the ability to run the application
