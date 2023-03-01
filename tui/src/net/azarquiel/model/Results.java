package net.azarquiel.model;

public class Results {
	public String name;
	
	public int points;
    public int played;
    public int won;
    public int tied;
    public int lost;
    public int scoreF;
    public int scoreC;
    public int scoreDiff;
    
    public Results(String name) {
    	this.name = name;
    }
}
