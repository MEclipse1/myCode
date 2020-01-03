#include<stdio.h>
#include<stdlib.h>
int f(){
	int i=0,x,y,mobile;
   scanf("%d",&y);
   while(i<9){
   	scanf("%d",&x);
   	if(x<y) {
   		mobile=x;
   		x=y;
   		y=mobile;
	   }   
   	i++;
   }
   printf("%d",y);
}
int main(){
	f();
	return 0;
}
