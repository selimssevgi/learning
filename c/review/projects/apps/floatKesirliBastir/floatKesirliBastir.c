#include <stdio.h>

void kesirliYaz(int pay, int payda){
	int devam=0;
	int bolen=2;
	
	while( devam == 0 ){
		if( pay % bolen == 0 && payda % bolen == 0 ){
		pay = pay % bolen;
			payda = payda % bolen;
		}else {
			devam = 1;
		}
	}
	
	bolen = 5;
	while( devam == 0 ){
		if( pay % bolen == 0 && payda % bolen == 0 ){
			pay = pay % bolen;
			payda = payda % bolen;
		}else {
			devam = 1;
		}
	}
	
	printf("%d\n", pay);
	printf("----\n");
	printf("%d", payda);
	
}

int main(){
	float sayilar[] = { 1.352, 1.35, 1.05, 1.052, 0.051, 0.252 };
	float alinanSayi,cpyAlinanSayi;
	int pay,payda=1,i;
	
	// disardan float sayiyi al
	//printf("Sayi gir > ");
	//scanf("%f", &alinanSayi);
	//cpyAlinanSayi = alinanSayi;
	
	for(i=0; i<6; i++){
		cpyAlinanSayi = sayilar[i];
		payda=1;
		while( ((int)cpyAlinanSayi) != cpyAlinanSayi ){
			cpyAlinanSayi *= 10;
			payda *= 10;
		}
		
		printf("Alinan SAyi : %f", sayilar[i]);
		printf("\ncpyAlinanSAyi : %d", (int)cpyAlinanSayi);
		printf("\nPayda : %d\n", payda);
		
		pay = (int)cpyAlinanSayi;
		kesirliYaz(pay,payda);
		
		printf("\n\n\n");
	}
	
	return 0;
}
