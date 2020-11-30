package model;
public class Team {

	//Constant

	private final int MAX_ASSISTANTCOACH=3;
	private final int MAX_PLAYERS=25;

	//Attributes

	private String name;
	private Lineup line;

	//Relationship
	private Player [] players;
	private AssistantCoach [] assistents;
	private HeadCoach coach;

	public Team (String name){
	this.name=name;
	this.players = new Player [MAX_PLAYERS];
	this.assistents= new AssistantCoach [MAX_ASSISTANTCOACH];
	this.coach=null;
	}

	public String addHeadCoach(HeadCoach coach){
		String message="add head coach to team";
		this.coach=coach;
		return message;
	}

	public String addAssistentCoach(AssistantCoach assistent){
		String message="";
		boolean empty=false;
		for(int i=0;i<MAX_ASSISTANTCOACH && !empty;i++){
			if(assistents[i]==null){
				empty=true;
				assistents[i]=assistent;
				message="Assistant coach has been added";
			}
		}
		if(empty==false){
			message="the limit of assistant coaches has been exceeded";
		}
      return message;
	}

	public String addPlayer(Player player){
		String message="";
		boolean empty=false;
		for(int i=0;(i<MAX_PLAYERS) && !empty;i++){
			if(players[i]==null){
				empty=true;
				players[i]=player;
				message="player has been added";
			}
		}
		if(empty==false){
			message="the limit of Player has been exceeded";
		}
      	return message;		
		}


		public String toString(){
			String message;
			message=
			"\n **********Team***********" +
			
			return message;
	}


}