# Literate Testing

These are examples of how to use naming conventions and grouping to write unit tests in a highly readable manner,
resembling a specification so that the reader may gain a deeper understanding of the code being tested.

The examples here are fleshed out and runnable versions based on those described in the talk "Structure and Interpretation of Test Cases" by Kevlin Henney

## Examples

[Leap year testing](src/test/kotlin/org/example/LeapYearSpec.kt)

[Stacks](src/test/kotlin/org/example/StackSpec.kt)

[Queues](src/test/kotlin/org/example/QueueSpec.kt)

See below for [test output](#test-output)

## See Also

[Structure and Interpretation of Test Cases](https://www.youtube.com/watch?v=tWn8RA_DEic)

[Stylish Unit Tests](https://capgemini.github.io/development/unit-test-structure/)

[JUnit docs](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-name-generator) showing these naming conventions

## Test Output

```
% ./gradlew clean build

> Task :test

org.example.LeapYearSpec

  A year is a leap year

    A year is a leap year -> if it is divisible by 4 but not by 100 (int)

      Test [1] 2004 PASSED
      Test [2] 1984 PASSED
      Test [3] 4 PASSED

    A year is a leap year -> if it is divisible by 400 (int)

      Test [1] 2000 PASSED
      Test [2] 1600 PASSED
      Test [3] 400 PASSED

  A year is not a leap year

    A year is not a leap year -> if it is not divisible by 4 (int)

      Test [1] 2022 PASSED
      Test [2] 2019 PASSED
      Test [3] 1999 PASSED
      Test [4] 1 PASSED

    A year is not a leap year -> if it is divisible by 100 but not by 400 (int)

      Test [1] 2100 PASSED
      Test [2] 1900 PASSED
      Test [3] 100 PASSED

  A year is not supported

    Test A year is not supported -> if it is zero PASSED

    A year is not supported -> if it is negative (int)

      Test [1] -1 PASSED
      Test [2] -4 PASSED
      Test [3] -100 PASSED
      Test [4] -400 PASSED
      Test [5] -2147483648 PASSED

  A year is supported

    A year is supported -> if it is positive (int)

      Test [1] 1 PASSED
      Test [2] 2147483647 PASSED

org.example.QueueSpec

  A new queue

    Test A new queue -> rejects a zero bounding capacity PASSED
    Test A new queue -> preserves positive bounding capacity PASSED
    Test A new queue -> is empty PASSED

  A non empty queue

    Test A non empty queue -> dequeues values in order enqueued PASSED
    Test A non empty queue -> becomes shorter when dequeued PASSED

    A non empty queue -> that is full

      Test A non empty queue -> that is full -> dequeues values in order enqueued PASSED
      Test A non empty queue -> that is full -> ignores further enqueued values PASSED
      Test A non empty queue -> that is full -> becomes non full when dequeued PASSED

    A non empty queue -> that is not full

      Test A non empty queue -> that is not full -> becomes full when enqueued up to capacity PASSED
      Test A non empty queue -> that is not full -> becomes longer when a value is enqueued PASSED

  An_empty_queue

    Test dequeues a null() PASSED
    Test becomes non empty when value enqueued() PASSED

org.example.StackSpec

  A new stack

    Test A new stack -> is empty PASSED

  A non empty stack

    Test A non empty stack -> becomes deeper by retaining a pushed item as its top PASSED
    Test A non empty stack -> on popping reveals tops in reverse order of pushing PASSED

  An empty stack

    Test An empty stack -> throws when queried for its top item PASSED
    Test An empty stack -> acquires depth by retaining a pushed item as its top PASSED
    Test An empty stack -> throws when popped PASSED

SUCCESS: Executed 39 tests in 1s


BUILD SUCCESSFUL in 3s
5 actionable tasks: 5 executed
```
