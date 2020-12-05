package model;
public class HeadCoach extends Coach implements Nivel,Precio{
//Attributes
	private int numbersTeams;
	private int championships;
	private double precio;
	private double  nivel;


	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name employee name
	 * @param id Head Coach id
	 * @param salary Head Coach salary
	 * @param yearsExperience Head Coach years experience 
	 * @param numbersTeams Head Coach numbersTeams to charge. 
	 * @param championships Head Coach championships won
	 */
	public HeadCoach (int yearsExperience, String name, String id, double salary, int numbersTeams, int championships){
		super(name, id, salary, yearsExperience);
		this.numbersTeams=numbersTeams;
		this.championships=championships;
		this.precio=calcularMercado();
		this.nivel=calcularNivel();
	}
	public int getChampionships() {
		return championships;
	}


	public void setChampionships(int championships) {
		this.championships = championships;
	}


	public int getNumbersTeams() {
		return numbersTeams;
	}


	public void setNumbersTeams(int numbersTeams) {
		this.numbersTeams = numbersTeams;
	}


	/**
	 * calculate head coach msrket<br>
	 * <b> pre: we need the head coach to have already been created </b> 
	 * @return the nivel
	 */	
public double calcularMercado(){
	double precio=( getSalary()*10)+(getYearsExperience()*100)+(championships*50);
	return precio;
}
	/**
	 * calculate head coach level<br>
	 * <b> pre: we need the head coach to have already been created </b> 
	 * @return the nivel
	 */	
public double calcularNivel(){
	double nivel=5+(championships/10);
	return nivel;
}
	/**
	 * show head coach information<br>
	 * <b> pre: we need the head coach  to have already been created </b> 
	 * @return the head coach information
	 */	
	@Override
	public String toString(){
	String message=super.toString();
	message+=
		"\n **********Head Coach*********" +
		"\n numbers of team: " + numbersTeams +
		"\n championships won: " +championships+
		"\n market price: "+calcularMercado()+
		"\n nivel: "+calcularNivel()+
		"\n ******************************";
		return message;
	}

}

