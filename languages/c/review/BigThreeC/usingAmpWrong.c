#include <stdio.h>

int* TAB() {
    int temp=5;
    printf("temp pointer : %p\n", &temp);
    return(&temp); // return a pointer to the local int
}
void main() {
    int* ptr;
    ptr = TAB();
    //*ptr = 42; // Runtime error! The pointee was local to TAB

    printf("ptr pointer : %p\n", &ptr);
    printf("Sayi : %d\n", *ptr);
}
