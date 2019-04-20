#include <stdio.h>

int main(){
		int A[6] = {5,8,46,57,97,35};
		int i,j,temp,N=6;
		
		for(i=0; i<N-1; i++){
				for(j=0; j<N-i; j++){
						if( A[j]>A[j+1] ){
								temp = A[j];
								A[j] = A[j+1];
								A[j+1] = temp;
						}
				}
		}
		
		for(i=0; i<N; i++){
				printf("%d ", A[i]);
		}
		
		return 0;
}
