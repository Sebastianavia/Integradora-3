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

	public Player(String name, String id, double salary, int dorsal, int goals, double rating, String position){
	super(name,id,salary);
	this.dorsal=dorsal;
	this.goals=goals;
	this.position=Position.valueOf(position);
	this.precio=calcularMercado();
	this.nivel=calcularNivel();

	}
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getNivel() {
		return nivel;
	}

	public void setNivel(double nivel) {
		this.nivel = nivel;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = Position.valueOf(position);
	}

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