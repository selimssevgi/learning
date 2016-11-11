# Unix: A oral history 
Unix was born at Bell Labs.

CTSS was fully functional system that could support up to 30 remote users
and was an integral part of Project MAC.

Yet by 165 Project MAC had overloaded CTSS, 
and MIT had begun looking for a 2nd generation time sharing system.
This was the Multics project, which was intended as a dynamic, modular system
capable of supporting hundreds of users.

Multics was not simply intended as a replacement for the overloaded CTSS,
it was menat to go beyond time sharing to create a community computing facility.
And integral part of this was to make the system modular, so as to support growth and change.

The system was designed to include fault-free continuous operation capabilities,
convenient remote terminal access and selective information sharing.

One of the most important features of Multics was to follow the trend towards
integrated multi-tasking and permit multiple programming environments
and different human interfaces under one operating system.

Multics allowed many people to share the cycles in the machine.

Multics was designed but lack of a compiler, causing falling behind the shcedule
and giving up on it. 

"It was really the combination of the disappearance of Multics and 
the fact that Ken had always wanted to write an OS of his own led fairly directly to Unit."

The integration of numerous aspects pf Multics design into Unix
maintained the power of Unix as a time-sharing system. 
In contrast, the simplicity of the Unix system avoided many of negative facets of Multics.

"If you order an OS of a group of programmers, you get Multics(complicated,over-engineered).
If you leave them to their own resources and imagination, things like Unix will grow out of their creativity."

## The Beginning

### Files to Share
A small group of computer scientists set out to create a file system,
that could be shared efficiently within their workgroup.

The OS was little more than an afterthought resulting from a need to test this file system.

It was created after observing the failing part of Project MAC and Multics file system.
"to have the activity locus of manipulation of data for user one and user two to be disjoined,
so that in fact, they wouldnt be locking common tables."

"If we were to make a file system, what would it look like?
How could we do this in a less massive way?"

A feature from Multics: "treating files and devices the same... having the same read calls."

Problems with hardware disk and tools, led to creation of other tools,
after some point it became more than a file system.

### Language from B to C
At first, Ken believed that Unix would have ti have a Fortran compiler 
in order to be considered a 'serious system.' Then they reliazed they didnt want that.

They wanted a high-level language. PL/1, which used in Multics, was too high-level.
So instead Ken create a new but very simle language, called B.

At the time there was BCPL from MIT, but it was too big to run on Unix machines.
Then KT made B, which was nearly exactly same, althought it was an interpreter, instead of a compiler.
B made two passes, one to turn code into an intermediate language and another to interpret it.
Ritche wrote a compiler for B. Some system tools were written in B, not the OS itself.
B semantically same language as BCPL, syntactically it look lke what became C, althought it lacked types.

KT had the idea that B would be very simple, very clean and very portable language.
"It was written in its on language. That's why its so portable."
KT was intent on having Unix be portable, and the creation of a portable langueage was intrinsic to this.

B was word-oriented. PDP-11 after PDP-7 was byte-oriented. 
The machine and the language didnt fit well together.
B was an interpreter, it was doomed to be slow.
They needed a better language as the systems language.
Ritchie developed C language.

KT undertook this project, but give up.
"It may have been because he got tired of it or whatnot, but there were sort of two things
that went wrong. One was his problem that he couldnt figure out how to..
switch control from one process to another. The second thing that 
he couldnt easily handlle - from my point of view the more important - was the difficutly of getting proper data structure."

Ritchie added structures to C and made the compiler somewhat better, with better code.
They rewrote the whole operating system in C in the winter of 73.
There were no really tough problems.

C took off. Part of its success was simply its association with Unix.

A number of interesting tools were being developed,
so there was an effort to make the tools available to other people.
"The best way to do that was to have a C compiler on other machines."
Then there was the problem not with tools or underlying architecture, 
but differences in operating systems.
"The solution: to not waste time trying to make individual programs portable
while fighting the OS, but to make the OS portable, too.""

MULTI- being many and UNI- being one.

The file system on the PDP-7 was created in assembly language.
KT realized that for an OS to be useful it needed to be created in a high-level language
by which it could be ported to any system. KT initially began programming a Fortran compiler,
but changed his mind and created a very simple language called B.
Ritchie improved upon B and renamed the language C.
Unit was written in C and could be ported to any computer."

### Pipe
It was clearly a beautiful mental model, this idea that
the output from one process would just feed in as input to another.

