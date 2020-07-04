package it.unibs.ing.arnaldo;
/**
 * <b>Class</b>
 * extends {@code Cell} 
 * if the player arrive in this Cell you will earn money <br>
 */
public class Probability extends Cell{

	private double earnedMoney;
	private String message;
	
	public Probability(String name,String message,double earnedMoney) {
		super(name);
		this.earnedMoney=earnedMoney;
		this.message=message;
	}

	public double getEarnedMoney() {
		return earnedMoney;
	}

	public String getMessage() {
		return message;
	}
	

}
