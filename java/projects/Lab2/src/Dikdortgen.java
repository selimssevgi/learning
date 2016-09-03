
public class Dikdortgen {
	private int en,boy;
	private int alan,cevre;
	// Constructor's name is same to class' name.
	public Dikdortgen(int en,int boy){
		this.en = en;
		this.boy = boy;
	}
	
	public int alanHesapla(){
		alan = en * boy;
		return alan;
	}
	
	public int cevreHesapla(){
		cevre = 2*(en+boy);
		return cevre;
	}
	
}
