# Unix System Overview

- All OSs provide services for programs they run

- Typical services:
  - executing a new program
  - opening a file
  - reading a file
  - allocating a region of memory
  - getting the current time of day

## Unix Architecture

- OS, the software that controls the HW resources and provides an environment for programs
- And this small piece of software is called 'Kernel'

- The interface to the kernel is a layer of software called the 'system calls'
- Most of the system functions return -1 when an error occurs

- Libraries of common functions are built on top of the syscalls

- The shell is a special application that provides an interface for running other applications
