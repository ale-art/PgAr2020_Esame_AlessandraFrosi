package it.unibs.ing.arnaldo;
/**
 * <b>Classe</B> <br>
 * rapresents the accident cell
 * where the player lose his money
 * @author Alessandra
 *
 */
public class Accident extends Cell{
	
	
	private double moneyLost;
	private String message;
	
	
	public Accident(String name,String message,double moneyLost) {
		super(name);
		this.moneyLost=moneyLost;
		this.message=message;
	}

	public double getMoneyLost() {
		return moneyLost;
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	

}
