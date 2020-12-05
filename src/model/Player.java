package model;
public class Player extends Employee implements Nivel,Precio{

	//Attributes
	private int dorsal;
	private int goals;
	private double rating;
	private double nivel;
	private double precio;




	//Relationships
	private Position position;
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes</b> 
	 * @param name player name
	 * @param id player id
	 * @param salary player salary
	 * @param dorsal player dorsal
	 * @param goals player goals
	 * @param rating player rating
	 * @param position player position
	 */
	public Player(String name, String id, double salary, int dorsal, int goals, double rating, String position){
	super(name,id,salary);
	this.dorsal=dorsal;
	this.goals=goals;
	this.position=Position.valueOf(position);
	this.precio=calcularMercado();
	this.nivel=calcularNivel();

	}
	

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	

	public void setGoals(int goals) {
		this.goals = goals;
	}

	

	public void setRating(double rating) {
		this.rating = rating;
	}

	

	public void setNivel(double nivel) {
		this.nivel = nivel;
	}

	

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

	public void setPosition(String position) {
		this.position = Position.valueOf(position);
	}

	/**
	 * calculate player msrket<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @return the nivel
	 */	
	public double calcularMercado(){
		double precio=0;
		switch(position){
		  	case GOALKEEPER:
		  		 precio=(getSalary()*12)+(rating*150);
		  	break;
		  	case DEFENDER:
		  		 precio=( getSalary()*13)+(rating*125)+(goals*100);
		  	break;
		 	case MIDFIELDER:
		  		 precio=( getSalary()*14)+(rating*135)+(goals*125);
		  	break;
		  	case FORWARD:
		  		 precio=( getSalary()*15)+(rating*145)+(goals*150);
		  	break;
		}
		return precio;
	}


	/**
	 * calculate player level<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @return the nivel
	 */	
	public double calcularNivel(){
		double nivel=0;
		switch(position){
	  		case GOALKEEPER:
	  			 nivel = (rating * 0.9);
	 		break;
	  		case DEFENDER:
	  			 nivel = (rating * 0.9)+ (goals/100);
	  		break;
	  		case MIDFIELDER:
	  			 nivel = (rating * 0.9)+ (goals/90);
	  		break;
	  		case FORWARD:
	  			 nivel = (rating * 0.9)+ (goals/80);
	  		break;
		}
		return nivel;

	}
	/**
	 * show player information<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @return the player information
	 */	
	@Override
	public String toString(){
	String message=super.toString();
	message+=
		"\n **********Player*********" +
		"\n dorsal: " + dorsal +
		"\n goals : " +goals+
		"\n nivel : " + calcularNivel()+
		"\n rating: " + rating+
		"\n market price: " + calcularMercado()+
		"\n *************************";
		return message;
	}

}