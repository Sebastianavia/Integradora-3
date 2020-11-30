package model;
public class AssistantCoach extends Coach{
//Attributes
	private String exPlayer;

	//Relationship
	private Expertise expertise;

	public AssistantCoach (int yearsExperience, String name, String id, double salary, String exPlayer, String expertise){
		super(name, id, salary, yearsExperience);
		this.exPlayer=exPlayer;
		this.expertise=Expertise.valueOf(expertise);
	}

	@Override
	public String toString(){
	String message=super.toString();
	message+=
		"\n *************Coach*************" +	
		"\n ex player: " +exPlayer+
		"\n expertise: " +expertise+
		"\n ******************************";
		return message;
	}
}

		