package model;
public class Coach extends Employee{

	//Attributes
	private int yearsExperience;

	public Coach (String name, String id, double salary, int yearsExperience){
	super(name,id,salary);
	this.yearsExperience=yearsExperience;
	}

	@Override
	public String toString(){
	String message=super.toString();
	message+=
		"\n *************Coach*************" +	
		"\n years of experience: " +yearsExperience+
		"\n ******************************";
		return message;
	}

	public int getYearsExperience(){
		return yearsExperience;
	}

}