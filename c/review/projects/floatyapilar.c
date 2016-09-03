#include <stdio.h>

int main(){
		double x,y;
		double a,b,c,d,e;
		
		// Float sayilarin iki kısmını belirtmek zorunda değiliz.
		// Bir tanesini yazmamız yeterli.
		
		a = 4.7;
		b = 4.;
		c = 4; // İnteger yapısında ama compiler onu floata çevirecek.
		d = .7;
		e = 0.7;
		
		printf("a = %f, b = %f, c = %f, d= %f, e = %f\n", a,b,c,d,e);
		
		x = 5e2; // 5 * 10^2 yani = 500
		y = 5e-2;// 5 * 10'-2 yani = 0.05
		
		// Burdaki e 10 tabanındaki ve e den sonrası ile üs olarak alınıyor.
		// virgülden sonrayı 6 karaktere tamamlanıyor.
		
		printf("x= %f, y= %f\n", x, y);
		
		return 0;
}
