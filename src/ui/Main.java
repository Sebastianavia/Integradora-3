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
		

	public int showMenu() {
		
		int option=0;

		System.out.println(
			"Selec one option to start\n"+
			"(1) to register employees\n"+
			"(2) to dismiss employee\n"+
			"(3) to add player to team\n"+
			"(4) to \n" + 
			"(5) to \n" +  
			"(6) to show de the employee inforamtions about one person\n" +  
			"(7) to show the all information about employees\n" +  
			"(8) to show the all information about the team\n" +
			"(0) Exit"
					);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

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
			
			break;
		case 5:
			
			break;
		case 6:
			showEmployee();
			break;
		case 7:
			message=club.showEmployees();
			System.out.println(message);
			break;	
		case 8:
			 //message = club.showTeam();
			 //System.out.println(message);
			
			break;

		default:
			System.out.println("Invalid option");
		}
	}




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

	public void dismissEmployee(){

		System.out.println("write the name of the person you are going to fire ");
		String name = sc.nextLine();
		String message = club.dismiss(name);
		System.out.println(message);

	}
	public void createTeam(){
		System.out.println("create team");
		System.out.println("Write the name team");
		String namepteam=sc.nextLine();

	}

	public void addplayertoteam(){

		System.out.println("add player to team");
		System.out.println("Write the employee name");
		String name=sc.nextLine();
		System.out.println("Write the name team");
		System.out.println("write 1 if it is the teamA, or 2 if it is the teamB ");
		int number=sc.nextInt();
		System.out.println(club.addEmployetoteam(number, name));
		
	}

	/*public void chooseFormaion(){

		System.out.println("Choose the formation")
		System.out.println("4,3,3  |  4,4,2   |   4,5,1   |   5,3,2   |    4,3,1,2    |    4,2,2,2")

	}*/
	public void showEmployee(){
		System.out.println("write the employee name ");
		String name=sc.nextLine();
		String message = club.showEmployee(name);
		System.out.println(message);

	}





	
}
