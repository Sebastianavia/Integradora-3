package model;
import java.util.ArrayList;
public class FootballClub{
	
	//Attribute
	private String name;
	private String nit;
	private String foundationDate;
	

	//obj//arraiz
	private ArrayList <Employee> employees;

	//relatinship
	private Team[] teams;
	private Lineup[][] lineup;

	//Constructor


	/**
	 * constructor method <br>
	 * <b> pre: we need the constants and relationships </b> 
	 */
	public FootballClub(String name, String nit, String foundationDate){
		this.name=name;
		this.nit=nit;
		this.foundationDate=foundationDate;
		this.employees = new ArrayList <Employee>(); 
		teams = new Team [2];
		teams[0]=new Team ("TeamA");
		teams[1]=new Team ("TeamB");
		int [][]lineup = new int [Lineup.ROWS_IN__LINEUP][Lineup.COLUMNS_IN_LINEUP];
	}

	
	/**
	 * find the name we write <br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @return the name the user is looking for
	 */
	
	// find method____________________________________
	public Employee findEmployee(String name){
		Employee objSearch=null;
		boolean findEm=false;
		for (int i=0;i<employees.size() && !findEm;i++){
			if (employees.get(i).getName().equalsIgnoreCase(name)){
				objSearch=employees.get(i);
				findEm=true;	
			}
		}
		return objSearch;
	}

	/**
	 * add a new Employee <br>
	 * <b> pre: we need the information about head coach </b> 
	 * @param name head coach name
	 * @param yearsExperience years of experience of head coach
	 * @param id head coach id
	 * @param salary head coach salary
	 * @param numbersTeams numbersTeams
	 * @param championships champions chip won
	 * @return a messag, if the head coach could be created or could not be created
	 */
	
	//________________________principal coach_____________________________________________________________
	public String addEmployee(int yearsExperience, String name, String id, double salary, int numbersTeams, int championships){
		String message="";
		boolean addPl=false;
		
		Employee objSearch=findEmployee(name);
		if(objSearch!=null)
			message="Error. the employee already exist";
		else{
		
			employees.add(new HeadCoach( yearsExperience,  name,  id,  salary,  numbersTeams,  championships));
			addPl=true;
			message="The employee has been registered";
				
			}

		return message;
	}

	/**
	 * add a new Employee <br>
	 * <b> pre: we need the information about aassistan coach </b> 
	 * @param name assistatnt coach name
	 * @param yearsExperience years of experience of assistatnt coach
	 * @param id assistatnt coach id
	 * @param salary assistatnt coach salary
	 * @param exPlayer if the assistatnt coach was soccer player
	 * @param expertise expertice
	 * @return a messag, if the assistatnt coach could be created or could not be created
	 */
	//________________________Asistent coach_____________________________________________________________
	public String addEmployee(int yearsExperience, String name, String id, double salary, String exPlayer, String expertise){
		String message="";
		boolean addPl=false;
		
		Employee objSearch=findEmployee(name);
		if(objSearch!=null)
			message="Error. the employee already exist";
		else{
			
			employees.add(new AssistantCoach( yearsExperience,  name,  id,  salary,  exPlayer,  expertise));
			addPl=true;
			message="The employee has been registered";
				
			}
		return message;
	}

	/**
	 * add a new Employee <br>
	 * <b> pre: we need the information about player </b> 
	 * @param name palyer name
	 * @param dorsal player dorsal
	 * @param id assistatnt coach id
	 * @param salary assistatnt coach salary
	 * @param goals goals of player
	 * @param rating player rating
	 * @param position player position
	 * @return a messag, if the assistatnt coach could be created or could not be created
	 */
	//________________________soccer player_____________________________________________________________
	public String addEmployee(String name, String id, double salary, int dorsal, int goals, double rating, String position){
		String message="";
		boolean addPl=false;
		
		Employee objSearch=findEmployee(name);
		if(objSearch!=null){
			message="Error. the employee already exist";
		}
		else{

			employees.add(new Player( name,  id,  salary,  dorsal,  goals,  rating,  position));				
			message="The employee has been registered";

			}
		return message;
	}


	/**
	 * fire employees<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @return the name the user is looking for
	 */
	//agragar un nuevo empleado en el puesto que despedimos
	public String dismiss(String name){
		String message="";
		boolean addPl=false;
		
		Employee objSearch=findEmployee(name);
		if(objSearch ==null){
			message = "dont exist";
		}else{
			objSearch.setStatus("INACTIVE");
		}
     return message;
	}

//___________________________________addemployee to team


	/**
	 * add a new employee to a team<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param election choose which team to add the employee to
	 * @return the name the employee is already
	 */
	
	public String addEmployetoteam(int election, String name){
		String message="";
		Team team=null;
		Employee employee=findEmployee(name);
        if (election==1){
          team=teams[0];
        }
        else if (election==2)
        {
        	team=teams[1];
        }

		if (employee !=null){
			if (employee instanceof HeadCoach){
				message=team.addHeadCoach((HeadCoach)employee);
			}
			else if (employee instanceof AssistantCoach){
				message=team.addAssistentCoach((AssistantCoach)employee);
			}
			else if (employee instanceof Player){
				message=team.addPlayer((Player)employee);
			}
		}
		else
		{
			message="The employee does not exist";
		}

		return message;
	}

//_________________________________________________modify name element__________

	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newname new name the employee
	 * @return if the element is modify or not
	 */
	public String modifyname(String name, int option, String newname) {
		String message = "";		
		Employee objSearch=findEmployee(name);
		if(objSearch ==null){
			message = "dont exist the employee";
		}else{
			if(option == 1) {
				
				objSearch.setName(newname);
				message = "The element is modifycate";
							
			}
		}
		return message;
	}
	
	//_________________________________________________modify id element__________
	
	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newid new id the employee
	 * @return if the element is modify or not
	 */
	public String modifyid(String name, int option, String newid) {
		String message = "";		
		Employee objSearch=findEmployee(name);
		if(objSearch ==null){
			message = "dont exist the employee";
		}else{
			if(option == 2) {
				
				objSearch.setId(newid);
				message = "The element is modifycate";
				
			}
		}
		return message;
	}
	
	//_________________________________________________modify salary element__________
		
	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newsalary new salary the employee
	 * @return if the element is modify or not
	 */
		public String modifysalary(String name, int option, double newsalary) {
			String message = "";		
			Employee objSearch=findEmployee(name);
			if(objSearch ==null){
				message = "dont exist the employee";
			}else{
				if(option == 3) {
							objSearch.setSalary(newsalary);
							message = "The element is modifycate";
				}
			}
			return message;
		}
		
		
		//_________________________________________________modify years experience element__________
	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newyears new years the employee
	 * @return if the element is modify or not
	 */
			public String modifyYears(String name, int option, int newyears) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 4 ) {
						
						((Coach)objSearch).setYearsExperience(newyears);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
			
			//_________________________________________________modify teams element__________
	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newyears new teams to charge 
	 * @return if the element is modify or not
	 */	
			public String modifyteams(String name, int option, int newteams) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 5) {
						
						((HeadCoach)objSearch).setNumbersTeams(newteams);
						message = "The element is modifycate";

					}
				}
				return message;
			}
//_________________________________________________modify champions element__________
			

	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newchampions new champions won 
	 * @return if the element is modify or not
	 */	
			public String modifychampions(String name, int option, int newchampions) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 6) {
						
						((HeadCoach)objSearch).setChampionships(newchampions);
						message = "The element is modifycate";

					}
				}
				return message;
			}
					
			
			
//_________________________________________________modify former element__________
			

	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newcformer new former
	 * @return if the element is modify or not
	 */	
			public String modifyformer(String name, int option, String newcformer) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 7) {
						
						((AssistantCoach)objSearch).setExPlayer(newcformer);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
//_________________________________________________modify former element__________
			

	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newexpertice new expertice
	 * @return if the element is modify or not
	 */	
			public String modifyfexpertice(String name, int option, String newexpertice) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 8) {
						
						((AssistantCoach)objSearch).setExpertise(newexpertice);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
//________________________________________________modify former element__________
			

	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newnumber new number player
	 * @return if the element is modify or not
	 */	
			public String modifynumber(String name, int option, int newnumber) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 9) {
						
						((Player)objSearch).setDorsal(newnumber);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
			
//____________________________________modify position__________________________

	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newposition new position 
	 * @return if the element is modify or not
	 */	
			public String modifyposition(String name, int option, String newposition) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 10) {
						
						((Player)objSearch).setPosition(newposition);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
			
			
//____________________________________modify position__________________________

	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newgoals new many goals
	 * @return if the element is modify or not
	 */	
			public String modifygoals(String name, int option, int newgoals) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 11) {
						
						((Player)objSearch).setGoals(newgoals);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
	//____________________________________modify position__________________________

	/**
	 * modify de element<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newrating new rating
	 * @return if the element is modify or not
	 */	
			public String modifyRating(String name, int option, double newrating) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 12) {
						
						((Player)objSearch).setRating(newrating);
						message = "The element is modifycate";

					}
				}
				return message;
			}
	/**
	 * shows a single employee<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @return if the element is modify or not
	 */	
	public String showEmployee(String name){
		String message="";
		Employee objemployee = findEmployee(name);
		if(objemployee != null){
			message = objemployee.toString();
		}else{
			message = "The employeee dont exist";
		}

		
		
		return message;

	}
	//____________________________Show all employees


	/**
	 * shows all employees<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @param name Employee name
	 * @return if the element is modify or not
	 */	
	public String showEmployees(){
			String message="";
		if(!employees.isEmpty()){
		message = "list of elements";
		for(int i= 0; i<employees.size();i++){
			message +=(employees.get(i));
		}
	 	}else{
	 		message = "dont exist  elements";
	 	}
		return message;
	}

	public String showTeam(int number){
		Team team = null;
		String message="";
	if(number == 1) {
		 
		 message+=teams[0].toString();
		 
	}else {
		message+=teams[1].toString();
	}
	
	return message;
	}

	public String createlineups(int option, String date,  int deffender, int midfielder, int forward,String tactic) {
		
			String message = "";
			Team team=null;
			        if (option==1){
			          team=teams[0];
			        }
			        else if (option==2)
			        {
			        	team=teams[1];
			        }

			int lineup [][]=new int [10][7];
			
			
			    switch(deffender) {
			    case 3:
			    	lineup[8][3]=1;
			    	lineup[8][1]=1;
			    	lineup[8][5]=1;	
			    	break;
			    case 4:
			    	lineup[8][0]=1;
			    	lineup[8][2]=1;
			    	lineup[8][4]=1;
			    	lineup[8][6]=1;
			    	break;
			    case 5:
			    	lineup[8][0]=1;
			    	lineup[8][1]=1;
			    	lineup[8][3]=1;
			    	lineup[8][5]=1;
			    	lineup[8][6]=1;
			    	break;
			    }
			
			    switch(midfielder) {
			    case 3:
			    	lineup[5][3]=1;
			    	lineup[5][1]=1;
			    	lineup[5][5]=1;	
			    	break;
			    case 4:
			    	lineup[5][0]=1;
			    	lineup[5][2]=1;
			    	lineup[5][4]=1;
			    	lineup[5][6]=1;
			    	break;
			    case 2:
			    	lineup[5][2]=1;
			    	lineup[5][4]=1;
			    	
			    	break;
			    }
			    
			    switch(forward) {
			    case 3:
			    	lineup[2][3]=1;
			    	lineup[2][1]=1;
			    	lineup[2][5]=1;	
			    	break;
			    case 4:
			    	lineup[5][0]=1;
			    	lineup[5][2]=1;
			    	lineup[5][4]=1;
			    	lineup[5][6]=1;
			    	break;
			    case 2:
			    	lineup[2][2]=1;
			    	lineup[2][4]=1;
			    	
			    	break;
			    case 1:
			    	lineup[2][3]=1;
			    	
			    	break;
			    }
			message=team.addLineup(date,lineup,tactic);
			return message;
	}
	public String showLineup(int option){
	          String message = "";
				Team team=null;
				        if (option==1){
				          team=teams[0];
				        }
				        else if (option==2)
				        {
				        	team=teams[1];
				        }
				        message=team.showLineups();
	return message;
	}
	
	
}