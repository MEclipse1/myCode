#include<stdio.h>
#include<stdlib.h>
int main(){
	int i,sum;
	i=sum=0;
	while(i<=100){
		sum=sum+i;
		i++;
	}
	printf("%d",sum);
	system("pause");
	return 0;
}
