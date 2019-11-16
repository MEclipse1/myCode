#include<stdio.h>
#include<stdlib.h>
void f(int n){
	int i,g;
   for(i=1;i<=n;i++){
   	for(g=1;g<=n-i;g++) printf(" ");
	for(g=1;g<=2*i-1;g++)  printf("*");
	printf("\n");
   }
} 
int main(){
	int n,x;	
	for(x=1;x<=10;x++){
	scanf("%d",&n);
	 f(n);
	 }
	system("pause");
	return 0;
}
