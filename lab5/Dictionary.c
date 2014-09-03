#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

#include "Dictionary.h"

/********************* Private Functions **********************/
/* creates the node data type*/
typedef struct Node{
	int key;
	int value;
	struct Node* next;
} Node;
/*exports reference size*/
typedef Node* NodeRef;
/* 
 *creates the Dictionary ADT
 */
struct Dictionary{
	NodeRef front;
	int numItems;
}Dictionary;
/*constructor for the node data type*/
NodeRef newNode(int x, int y){
	NodeRef N = malloc(sizeof(Node));
	assert(N!=NULL);
	N->key = x;
	N->value = y;
	N->next = NULL;
	return(N);
}
/*free's the heap memory for the node data type*/
void freeNode(NodeRef* pN){
	if(pN!=NULL && *pN!=NULL){
		free(*pN);
		*pN = NULL;
	}
}
/********************** Public Funtions **********************/
/*Constructor for the Dictionary ADT */
DictionaryRef newDictionary(void){
	DictionaryRef D = malloc(sizeof(Dictionary));
	assert(D!=NULL);
	D->front = NULL;
	D->numItems = 0;
	return D;	
}
/*free's heap memory for the Dicitonary ADT*/
void freeDictionary(DictionaryRef* pD){
		free(*pD);
		*pD = NULL;
}
/*isEmpty
 *Pre:none
 *Pos:returns true or false if the stack is empty
 */ 
int isEmpty(DictionaryRef D){
	if( D == NULL){
		fprintf(stderr,"Stack Error: calling isEmpty() on NULL StackRef\n");
		exit(EXIT_FAILURE);
	}
	return(D->numItems==0);
}
/*size
 *Pre:none
 *Pos:returns the size of the stack
 */
int size(DictionaryRef D){
	return(D->numItems);
}
/*lookup
 *Pre:takes an int
 *Pos:returns the value or UNDEF if the values isn't there
 */
int lookup(DictionaryRef D, int k){
	NodeRef N=D->front;
	while(N != NULL){
		if(N->key == k){
			return N->value;
		}
		N = N->next;
	}
	return UNDEF;
}
/*insert
 *Pre:must not have a the same key that is alread in the list
 *Pos:inserts a key into the Stack
 */
void insert(DictionaryRef D, int x, int y){
	NodeRef N=D->front;
	if(D==NULL){
		fprintf(stderr, "Stack Error: calling insert() on NULL StackRef\n");
		exit(EXIT_FAILURE);
	}
	else if(lookup(D,y)!=UNDEF){
		fprintf(stderr, "Stack Error: inserting dublicate key\n");
		exit(EXIT_FAILURE);
	}
	else{
		if(D->front == NULL){
			N = newNode(x,y);
			D->front = N;
			D->numItems++;
		}
		else{
			while(N!= NULL){
				if(N->next==NULL){
					break;
				}
			        N = N->next;
			}
			N->next = newNode(x,y);
			D->numItems++;
		}
	}
}
/*delete
 *Pre:the key must be in the Stack
 *Pos:deletes the key from the stack
 */
void delete(DictionaryRef D, int k){
	NodeRef N = D->front;
	if(D==NULL){
		fprintf(stderr, "Stack Error: calling delete() on NULL StackRef\n");
		exit(EXIT_FAILURE);
	}
	else if(lookup(D,k)==UNDEF){
		fprintf(stderr, "Stack Error: deleting non-existant key\n");
		exit(EXIT_FAILURE);
	}
	else{
		if(D->numItems<=1){;
			freeNode(&N);
		}
		else{
			if(N->key==k){
				NodeRef temp = D->front; 
			        D->front = N->next;
				D->numItems--;
				freeNode(&temp);
			}
			else{
				while(N->next->key!=k){
					N = N->next;
				}
				NodeRef temp =  N->next;
				N->next = N->next->next;
				freeNode(&temp);
				D->numItems--;
			}	
		}
	}
}
/*makeEmpty
 *Pre:none
 *Pos: frees the Dictionary ADT heap memory
 */
void makeEmpty(DictionaryRef D){
	/*freeDictionary(&D);*/
	D->numItems=0;
	freeNode(&D->front);
}
/*printDictionary
 *Pre: none
 *Pos: prints the dictionary on an output file
 */
void printDictionary(DictionaryRef D, FILE* out){	
	NodeRef N = D->front;
	while( N != NULL){
		fprintf(out,"%d %d \n",N->key,N->value);
		N = N->next;
	}
}


