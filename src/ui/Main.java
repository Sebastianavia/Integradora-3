package ui;
import java.util.Scanner;
import model.*;

public class Main{

	private  Scanner sc;
	private FootballClub club;

	public Main(){
		sc = new Scanner(System.in);
			
	}

	public static void main(String[] args) {

		Main ppal= new Main();
		int option=0;
		ppal.addFootballClub();
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
	}
		
	/**
	 * prints on screen the options to use the application <br>
	 * <b> pre: we need the user to choose what action to perform </b> 
	 * @return the number chosen by the user
	 */
	public int showMenu() {
		
		int option=0;

		System.out.println(
			"Selec one option to start\n"+
			"(1) to register employees\n"+
			"(2) to dismiss employee\n"+
			"(3) to add employee to team\n"+
			"(4) to create a line up\n" + 
			"(5) to modify employees\n" +  
			"(6) to show de the employee inforamtions about one person\n" +  
			"(7) to show the all information about employees\n" +  
			"(8) to show the all information about the team\n" +
			"(9) to show line up\n" +
			"(10) to create to office\n"+// organizar los jugadores en los vestidores
			"(11) to show office\n"+//mostrar como quedaron los vestidores
			
			
			"(0) Exit"
					);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}


	/**
	 * depending on the option chosen, the program performs an option <br>
	 * <b> pre: we need the value of the option variable </b> 
	 * @param operation menu option
	 * 
	 */
	public void executeOperation(int operation) {
		String message="";
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			registerEmployee();
			break;
		case 2:
			dismissEmployee();
			break;
		case 3:
			addplayertoteam();
			break;
		case 4:
			createlineup();
			break;
		case 5:
			modifyElemnt();
			break;
		case 6:
			showEmployee();
			break;
		case 7:
			message=club.showEmployees();
			System.out.println(message);
			break;	
		case 8:
			 showTeam();
			
			break;
		case 9:
			showLineup();
			break;
		case 10:
			club.locateInTheOffices();
			break;
		case 11:
			System.out.println(club.showOffice());
			break;
		default:
			System.out.println("Invalid option");
		}
	}



	/**
	 * asks the user for the information of the Footboll club to be registered <br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
	public void addFootballClub(){
		String name, nit, foundationDate;

		System.out.println("");
		System.out.println("");	
		System.out.println("**************************");
		System.out.println("Write the name of the club");
		System.out.println("**************************");
		name = sc.nextLine();
		System.out.println("Enter the club's NIT");
		nit = sc.nextLine();
		System.out.println("Enter foundation date");
		foundationDate = sc.nextLine();
		club=new FootballClub(name, nit, foundationDate);

		
	}

	/**
	 * ask the user about the information of the employee to be registered <br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
	public void registerEmployee(){
		System.out.println("********************");
		System.out.println("Register information");
		System.out.println("********************");
		
		System.out.println("write the name");
		String name = sc.nextLine();
		System.out.println("Write the id");
		String id = sc.nextLine();
		System.out.println("Write the salary");
		double salary = sc.nextDouble();sc.nextLine();

		System.out.println("write (1) for  coachs, (2) for players");
		int	numplay = sc.nextInt();sc.nextLine();
		switch(numplay){

			case 1:
				System.out.println("write the years of experience");
				int yearsExperience = sc.nextInt();sc.nextLine();
				System.out.println("Write (1) to head coach or (2) to assitant coach");
				int	num = sc.nextInt();sc.nextLine();
				switch(num){

					case 1:
						System.out.println("teams in charge");
						int numbersTeams=sc.nextInt();sc.nextLine();
						System.out.println("championships won");
						int championships = sc.nextInt();sc.nextLine();
						System.out.print(club.addEmployee( yearsExperience,  name,  id,  salary,  numbersTeams,  championships));

					break;
					case 2:
						System.out.println("he is a former football player, yes / no");
						String exPlayer = sc.nextLine();
						//if(exPlayer.equalsIgnoreCase("yes"))
						System.out.println("what is your expertise?(OFFENSIVE, DEFENSIVE, POSSESSION,LAB_PLAY)");
						String expertise = sc.nextLine().toUpperCase();
						System.out.println(club.addEmployee( yearsExperience,  name,  id,  salary,  exPlayer,  expertise));

					break;
					default:
					System.out.println("Invalid option");
				}
			break;
			case 2:
				System.out.println("write "+ name + "'s number");
				int dorsal = sc.nextInt();sc.nextLine();
				System.out.println("write "+ name +"'s position, (GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD)");
				String position = sc.nextLine().toUpperCase();
				System.out.println("write the number of goals that " + name + " scored");
				int goals = sc.nextInt();sc.nextLine();
				System.out.println("soccer player rating");
				double rating = sc.nextDouble();sc.nextLine();
				System.out.println(club.addEmployee( name,  id,  salary,  dorsal,  goals,  rating,  position));

			break;
			default:
			System.out.println("Invalid option");
		}
	}

	/**
	 * ask the name of the person you want to fire<br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
	public void dismissEmployee(){

		System.out.println("write the name of the person you are going to fire ");
		String name = sc.nextLine();
		String message = club.dismiss(name);
		System.out.println(message);

	}
	/*public void createTeam(){
		System.out.println("create team");
		System.out.println("Write the name team");
		String namepteam=sc.nextLine();

	}*/

	/**
	 * add an employee to a team<br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
	public void addplayertoteam(){

		System.out.println("add player to team");
		System.out.println("Write the employee name");
		String name=sc.nextLine();
		System.out.println("Write the name team");
		System.out.println("write 1 if it is the teamA, or 2 if it is the teamB ");
		int number=sc.nextInt();
		System.out.println(club.addEmployetoteam(number, name));
		
	}


	/**
	 * show only one employee<br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
	public void showEmployee(){
		System.out.println("write the employee name ");
		String name=sc.nextLine();
		String message = club.showEmployee(name);
		System.out.println(message);
	}


	/**
	 * show a team<br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
	public void showTeam() {
		System.out.println("To teamA choose 1, or 2 for teamB");
		int number = sc.nextInt();
		String message = club.showTeam(number);
		System.out.println(message);

	}
	
	/*public void ingresalineup() {
		System.out.println("");
		
	}*/

	/**
	 * crear una alineacion <br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
	public void createlineup() {
        System.out.println("choose 1 to TeamA or 2 for TeamB");
        int team =sc.nextInt();sc.nextLine();
        System.out.println("Line up");
        System.out.println("Write the line up date");
        String date =sc.nextLine();
        System.out.println("tatic (POSSESSION, COUNT_ATTACK, HIGH_PRESSURE,DEFAULT)");
        String tactic = sc.nextLine().toUpperCase();
        System.out.println("Write the line up separate with -, for esxample 4-4-2");
        String alineup = sc.nextLine();
        String[] lineups = alineup.split("-");
        int deffender = Integer.parseInt(lineups[0]);
        int midfielder = Integer.parseInt(lineups[1]);
        int forward = Integer.parseInt(lineups[2]);
        System.out.println(club.createlineups(team,date,deffender,midfielder,forward,tactic));

    }

    /**
	 * show a line up<br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
    public void showLineup(){
    	System.out.println("choose team 1 to A or 2 to B");
        int team =sc.nextInt();sc.nextLine();
        System.out.println(club.showLineup(team));
	}


	/**
	 * modificar los datos del empleado  <br>
	 * <b> pre: we need the value of the option variable </b> 
	 */
	public void modifyElemnt() {
		
		int option;
		
		
		System.out.println("modify element");
		System.out.println("write the name of the employee you want to modify");
		String name = sc.nextLine();
		System.out.println("What information, do you want to modify?");
		System.out.println("\n Choose 1 to modify the name, 2 for the id, 3 for the salary."+
							"\n if is a coach write 4 to modify years experience. "+
							"\n if is a head coach, choose 5 to modify teams in charge or 6 to modify championship won"+
							"\n if is a assistant coach, choose 7 to modify the former football player (yes/no) or 8 is you want modifythe expertice"+
							"\n if is  a player, choose 9 to modify player number, 10 to modify de position, 11 to modify goals or 12 to modify rating"+
							"\n choose 0 to leave");
		
		option = sc.nextInt();sc.nextLine();
		
		switch(option) {
		case 1:
		System.out.println("Write the new name");	
		String newname = sc.nextLine();
		System.out.println(club.modifyname( name, option,  newname));
			break;
		case 2:
		System.out.println("Write the new id");
		String newid= sc.nextLine();
		System.out.println(club.modifyid(name, option, newid));
			break;
		case 3:
		System.out.println("Write the new salary");
		double newsalary = sc.nextDouble();
		System.out.println(club. modifysalary( name,option, newsalary));
			break;
		case 4:
		System.out.println("Write the new years experience");
		int newyears = sc.nextInt();sc.nextLine();
		System.out.println(club. modifyYears( name,  option,  newyears));
			break;
		case 5:
		System.out.println("Write the new teams in charge");
		int newteams = sc.nextInt();sc.nextLine();
		System.out.println(club.modifyteams(name,  option, newteams));
			break;
		case 6:
		System.out.println("Write the new championschip won");
		int newchampions = sc.nextInt();sc.nextLine();
		System.out.println(club.modifychampions(name, option,  newchampions));
			break;
		case 7:
		System.out.println("Write the new former player (yes/no)");
		String newcformer = sc.nextLine();
		System.out.println(club.modifyformer( name,  option,  newcformer));			
			break;
		case 8:
		System.out.println("Write the new expertice(OFFENSIVE, DEFENSIVE, POSSESSION,LAB_PLAY)");
		String newexpertice = sc.nextLine();
		System.out.println(club.modifyfexpertice(name, option, newexpertice));
			break;
		case 9:
		System.out.println("Write the new player number");
		int newnumber = sc.nextInt();sc.nextLine();
		System.out.println(club.modifynumber( name, option, newnumber));
			break;
		case 10:
		System.out.println("Write the new position (GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD)");
		String newposition = sc.nextLine().toUpperCase();
		System.out.println(club.modifyposition( name,  option,  newposition));
			break;
		case 11:
		System.out.println("Write the new goals");
		int newgoals = sc.nextInt();sc.nextLine();
		System.out.println(club.modifygoals( name,  option, newgoals));
			break;
		case 12:
		System.out.println("Write the new rating");
		double newrating = sc.nextDouble();sc.nextLine();
		System.out.println(club.modifyRating( name, option, newrating));
			break;	
		}	
	}//cierra el metodo modificar


	
}
