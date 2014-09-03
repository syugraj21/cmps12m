/*Yugraj Singh
 *FileRevers.c
 *
 *This program reads a word(s) from the file and prints out the word(s) in
 *reverse
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* stringReverse*/
/* Pre: takes a char array*/
/* Pos: reverses the array*/
void stringReverse(char* s){
	int i;
	int j=strlen(s)-1;
	char temp;
	for(i=0; i<=j; i++){
		temp = s[j];
		s[j] = s[i];
		s[i]=temp;
		j--;
	}
}


int main ( int argc, char* argv[]){
	FILE* in;
	FILE* out;
	char word[256];
	/*throws an error that depends on the command line args*/
	if( argc != 3){
		printf("Usage: %s inputFile outputFile\n", argv[0]);
		exit(EXIT_FAILURE);
	}
	/*throws an error that depends on the input file*/
	in = fopen(argv[1], "r");
	if( in==NULL){
		printf("Unable to read from file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}
	/*throws an error that depends on the output file*/
	out = fopen(argv[2], "w");
	if( out==NULL){
		printf("Unable to write to file %s\n",argv[2]);
		exit(EXIT_FAILURE);
	}
	/*reads the input file and reverses the array*/ 
	while( fscanf(in, " %s",word) != EOF){
		stringReverse(word);
		fprintf(out,"%s\n",word );/*prints to the output file*/
	
	}
	/*closes the input and output file*/
	fclose(in);
	fclose(out);


	return(EXIT_SUCCESS);

}

