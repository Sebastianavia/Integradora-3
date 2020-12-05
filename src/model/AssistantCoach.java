package model;
public class AssistantCoach extends Coach{
//Attributes
	private String exPlayer;

	//Relationship
	private Expertise expertise;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name Assistant Coach name
	 * @param id Assistant Coach id
	 * @param salary Assistant Coach salary
	 * @param yearsExperience Assistant Coach years experience
	 * @param exPlayer Assistant Coach was exPlayer
	 * @param expertise Assistant Coach expertise
	 */
	public AssistantCoach (int yearsExperience, String name, String id, double salary, String exPlayer, String expertise){
		super(name, id, salary, yearsExperience);
		this.exPlayer=exPlayer;
		this.expertise=Expertise.valueOf(expertise);
	}
	

	public void setExPlayer(String exPlayer) {
		this.exPlayer = exPlayer;
	}

	

	public void setExpertise(String expertise) {
		this.expertise = Expertise.valueOf(expertise);
	}


	/**
	 * show Assistant coachinformation<br>
	 * <b> pre: we need the assistant coach  to have already been created </b> 
	 * @return the assistant coach information
	 */	
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

		