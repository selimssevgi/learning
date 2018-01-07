# What is Docker?

- Docker is a tool that helps solve common problems like installing, removing,
  upgrading, distributin, trusting, and managing software

- It accomplishes this using a UNIX technology called containers

## Containers

- Historically, the term 'jail' is used, to describe a modified runtime
  environment for a program that prevents that program from accessing protected resources

- Since 2005, after Solaris Containers, 'container' has become the preferred term

- The goal expanded from preventing access to protected resources to isolating a
  process from all resources except where explicitly allowed

- Earlier building and using a container was not easy to use and hard to configure

- Docker solves this problem by using existing container engines to provide
  consistent containers built according to best practices

- As Docker evolves and improves, you can get that for free

## Containers are not virtualization

- hardware virtualization (virtual machines) provides isolation

- full operating system on a virtual machine takes time to create and load

- Docker containers don't use HW virtualization, programs interface directly
  with the host's Linux kernel

- In container's case, there is no additional OS, no resources are wasted by
  running redundant software or simulating virtual hardware (important distinction)

- Docker is not a virtualization technology, instead it helps you use the
  container technology already built into your OS.

* Getting Organized

Docker keeps things organized by isolating everything with containers and
images. Applications and their dependencies running inside a containers. Instead
of sharing dependencies (different version?)

* Improving Portability

Docker runs natively on Linux and comes with a single VM for OS X and Windows

Docker improves the portability of every program regardless of the language it
was written in, the operating system it was designed for, or the state of the
environment where it's running.

* Protecting your computer

Isolating (harmful) programs, jailing in a cell

## Why Docker is important?

- Docker provides what is called an 'abstraction'

- Shipping containers vs docker containers

- It has accomplished for the computer what app stores did for mobile devices


