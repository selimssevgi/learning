#include <stdio.h>

// STRUCT ISIMLERINI BUYUK HARFLERLE YAZIYORSUN!

// struct tanımı 1.yontem
// VITALSTAT adında bir struct yapımız var.
// Bu isimle tanımladıgımız degıskenler bu yapıya sahip olacaktır
// or: struct VITALSTAT vs; vs değişken ismi
struct VITALSTAT{
	char vsName[19], vsSnum[11];
	short vsMonth, vsDay, vsYear;
};

// struct tanımı 2.yontem
// Bu yontem ile direkt vs adındaki bir degiskeni struct yapısında tanımladık
// Bu yapıyı baska degiskenlere efektıf bır sekılde uygulayamaz.Tek degisken tanımı ıcın kullanıdır.
// Pek ideal değildir.
struct{
	char vsName[19], vsSnum[11];
	short vsMonth, vsDay, vsYear;
} vs;

// struct tanımı 3.yontem
// bu da sık kullanılır.
typedef struct{
		char vsName[19], vsSnum[11];
		short vsMonth, vsDay, vsYear;
} VITALSTAT2;

int main(){
	struct VITALSTAT vs; // struct yapımıza gore degıskenı tanımlarken de degısıklık oluyor
	VITALSTAT2 vs2; 	 // Burda ise görüldüğü gibi daha yalın bır sekılde tanımladık
	VITALSTAT2 *pStruct; // structure gosteren pointer kullanımı
	struct VITALSTAT vs3 = { "SElim", "131214", 2, 4, 1992 }; // initializing structure.
	
	pStruct = &vs2;
	
	// Struct yapısı icindeki degiskenlere ulasmak
	// Referencing Structure Members
	vs.vsMonth = 3;
	vs.vsDay = 15;
	vs.vsYear = 1994;
	printf("vs.vsMonth : %d, vs.vsDay : %d, vs.vsYear : %d \n", vs.vsMonth, vs.vsDay, vs.vsYear);
	
	
	// structure işaret eden pointerler kullanırsak referencing durumu biraz farklı oluyor.
	// pointer ile struct veri alanına ulastıgımız da -> işaretini kullanıyoruz.
	pStruct->vsDay = 18;
	pStruct->vsMonth = 3;
	pStruct->vsYear = 1992;
	
	printf("pStruct->vsDay : %d, pStruct->vsMonth : %d, pStruct->vsYear : %d \n", pStruct->vsDay, pStruct->vsMonth, pStruct->vsYear);
	
	(*pStruct).vsDay = 20;
	
	printf("pStruct->vsDay : %d, pStruct->vsMonth : %d, pStruct->vsYear : %d \n", pStruct->vsDay, pStruct->vsMonth, pStruct->vsYear);
	
	printf("Structure definetion");
	return 0;
}


















