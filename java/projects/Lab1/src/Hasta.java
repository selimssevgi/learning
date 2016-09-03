
public class Hasta {
	private String TC,ad;
	private int kilo,age;
	private float boy,KBI;
	
	public Hasta(String TC, String ad){
		this.TC = TC;
		this.ad = ad;
	}
	
	public void setBoy(float boy){
		this.boy = boy;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setKilo(int kilo){
		this.kilo = kilo;
	}
	
	public float getKBI(){
		KBI = age*age / kilo;
		return KBI;
	}
}
