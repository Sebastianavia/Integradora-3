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

	//gets method
	public String getName() {
	return name;
	}
	public String getNit() {
	return nit;
	}
	public String getFoundationDate() {
	return foundationDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public void setFoundationDate(String foundationDate) {
		this.foundationDate = foundationDate;
	}

	
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
	
	
}