package it.unibs.ing.arnaldo;

import util.mylib.MyMath;

/**
 * a class representing the player
 * 
 * @author Alessandra Frosi
 *
 */
public class Player {
	
	
	private String name;
	private double money;
	/**
	 * <b>Attribute</b>
	 * The position
	 */
	private int position;
	private Cube cube;

	/**
	 * <b>Constructor</B> <br>
	 * managing money position and the cube
	 * 
	 * @param money
	 * @param position
	 * @param cube
	 */
	public Player(String name, int position,double money ,Cube cube) {
		super();
		this.name=name;
		this.position=position;
		this.money = money;
		this.cube = cube;

	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	
	public double getMoney() {
		return money;
	}

	public Cube getCube() {
		return cube;
	}
/**
 * <b>Method</B> <br>
 * to move thought the map 
 * @param mapSize
 */
	public void throwYourCube(int mapSize) {
		int path = 0;
		path = this.cube.thowrCube();
		if((this.position+path)>(mapSize)) {
			this.setPosition(0);
			path--;
			if(path!=0) {
				this.setPosition(this.position+path);
			}
		}
		else {
			int total=this.position+path;
			this.setPosition(total);
		}

	}


	// public void
	/**
	 * <b>Method</b> <br>
	 * Checking the status of the player
	 * 
	 * @return true if the player has got 0 money
	 */
	public boolean hasLost() {
		if (this.money<=0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <b>Method</b> <br>
	 * Checking the status of the player
	 * 
	 * @return true if the player has got the maximum amount of money
	 */
	public boolean hasWin() {
		if (this.money>=1000000) {
			return true;
		} else {
			return false;
		}
	}
	public void loseMoney(double moneyLost) {
		double temp=this.money-moneyLost;
		this.money=temp;
	}
	public void calculateNewPosition(int newPosition, int mapSize) {
		int path = 0;
		path = this.cube.thowrCube();
		if((this.position+path)>(mapSize)) {
			this.setPosition(0);
			path--;
			if(path!=0) {
				this.setPosition(this.position+path);
			}
		}
		else {
			this.setPosition(this.position+path);
		}
		
	}


}
