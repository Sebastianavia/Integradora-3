package model;
import java.util.*;
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
	private ArrayList <Lineup> lineups;

	public Team (String name){
	this.name=name;
	this.players = new Player [MAX_PLAYERS];
	this.assistents= new AssistantCoach [MAX_ASSISTANTCOACH];
	this.coach=null;
	this.lineups= new ArrayList<Lineup>();
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


		public String showTeam() {
		String message ="\n *************"+
						"\n **Employess**"+
						"\n *************";
		if(coach != null){			
			message += "head coach: " + coach.toString();
		}
		for(int i=0; i <MAX_ASSISTANTCOACH; i++ ) {
			if(assistents[i] != null) {
			message +="\n Asistans coach: "+assistents[i].toString();
			}
		}
		for(int i=0; i <MAX_PLAYERS; i++ ) {
			if(players[i] !=null) {
			message +="\n player: "+players[i].toString();
			}
		}
		
		return message;
	}


	public String addLineup (String date,int [][] lineup, String tactic){
String message="the lineup was added";	
lineups.add(new Lineup(date,lineup,tactic));
return message;
}

public String showLineups(){
String message = "";
for(int i = 0; i<lineups.size(); i++){
message += lineups.get(i).toString();
}
return message;

}

}