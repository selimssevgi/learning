#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct Node{
    int data;
    struct Node* next;
};

int length(struct Node* head){
    struct Node* current = head;
    int count = 0;

    while( current != NULL ){
        count++;
        current = current->next;
    }

    return count;
}

void printList(struct Node* head){

    while( head != NULL ){
        printf("%d\n", head->data);
        head = head->next; // head->next = NULL olacak
    }
}

// verilen degerin listede kac kere tekrarlandigini hesaplar
int count(struct Node* head, int searchFor){
    int count = 0;
    struct Node* current = head;

    while( current != NULL ){
        if( current->data == searchFor ){
            count++;
        }
        current = current->next;
    }

    return count;
}

// Given a list and an index, return the data
// in the nth node of the list. The nodes are numbered from 0.
// Assert fails if the index is invalid (outside 0..lengh-1).
int getNth(struct Node* head, int index){
    struct Node* current = head;
    int i = 0;

    // sinir kontrolü
    if( index < 0 || index > (length(head)-1) ){
        printf("Out of boundry!");
        exit(1);
    }

    while( i != index ){
        i++;
        current = current->next;
    }

    return current->data;
}

void insertBeginning(struct Node** headRef, int data){
    struct Node* newNode = malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = *headRef;
    *headRef = newNode;
}

void deleteList(struct Node** headRef){
    struct Node* current = (*headRef)->next;
    struct Node* before;

    while( current != NULL ){
        before = current;
        current = current->next;
        printf("%d degeri silindi\n", before->data);
        free(before);
    }

    (*headRef)->next = NULL;
}

int pop(struct Node **headRef){
    struct Node* current = *headRef;
    int data;

    if( current->next != NULL ){
        data = current->data;
        *headRef = current->next;
        free(current);
        return data;
    }

    return -1; // there is no data to return
}

int main(){
    struct Node* head;
    int i;
    int num;

    head = malloc(sizeof(struct Node));
    assert(head);

    head->data = 15;
    head->next = NULL;

    for( i=5; i<100; i += 5 ){
        num = rand() % 10 + 1;
        insertBeginning(&head, num);
    }

    printf("Uzunluk : %d\n", length(head));

    printList(head);

    printf("\n3 sayisi, %d kere gecmis.\n", count(head, 3));

    printf("\n5.indisteki eleman : %d\n", getNth(head, 5));

    printf("%d degeri pop edildi.\n", pop(&head));

    printf("Uzunluk : %d\n", length(head));

    deleteList(&head);

    printf("Uzunluk : %d\n", length(head));



    return 0;
}
