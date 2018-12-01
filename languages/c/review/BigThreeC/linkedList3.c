#include <stdio.h>

struct Node{
    int data;
    struct Node *data;
};



int main(){
    struct Node *dummy;

    dummy = malloc(sizeof(struct Node));

    insertAtBeginning(&dummy, 5);

    return 0;
}
