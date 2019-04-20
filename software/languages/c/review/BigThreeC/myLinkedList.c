#include <stdio.h>
#include <stdlib.h>

struct Node{
    int     data;
    struct Node*   next;
};

void append(struct Node** headRef, int data){
    struct Node* newNode = malloc(sizeof(struct Node));
    struct Node* current = *headRef;

    newNode->data = data;
    newNode->next = NULL;

    if( current == NULL ){ // list bos ise
        *headRef = newNode;
    }else{
        // listenin sonunu bul
        while( current->next != NULL ){
            current = current->next;
        }
        current->next = newNode;
    }
}

void addAtHead(struct Node** headRef, int data){
    struct Node* node1 = malloc(sizeof(struct Node)); // heap te yeni node olustur

    node1->data = data; // data fielde deger ata
    node1->next = *headRef; // onceki head point etsin.
    *headRef = node1; // listenin basi olsun.
}

int length(struct Node* head){
    struct Node *current = head; // head ile yapsak da olur. anlasilir olmasi icin current diyelim
    int count = 0;

    // with while loop
    while( current != NULL ){
        count++;
        current = current->next;
    }

    count = 0;
    // with for loop
    for( current=head; current!=NULL; current=current->next ){
        count++;
    }

    return count;
}

void printList(struct Node* head){

    printf("List elements : \n");
    while( head != NULL ){
        printf("%d\n", head->data);
        head = head->next;
    }
}

int main(){
    struct Node* head = NULL;
    //struct Node* head2 = NULL;
    int i;

    for( i=0; i<5; i++ ){
        append(&head,i);
    }

    for( i=0; i<5; i++ ){
        addAtHead(&head,i);
    }



    printf("the length of the linkedlist : %d\n", length(head));
    printList(head);3

    printf("the length of the linkedlist : %d\n", length(head));
    printList(head);

    return 0;
}
