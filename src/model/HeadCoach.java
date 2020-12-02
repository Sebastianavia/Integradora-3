package model;
public class HeadCoach extends Coach implements Nivel,Precio{
//Attributes
	private int numbersTeams;
	private int championships;
	private double precio;
	private double  nivel;

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



public double calcularMercado(){
	double precio=( getSalary()*10)+(getYearsExperience()*100)+(championships*50);
	return precio;
}

public double calcularNivel(){
	double nivel=5+(championships/10);
	return nivel;
}

	@Override
	public String toString(){
	String message=super.toString();
	message+=
		"\n **********Head Coach*********" +
		"\n numbers of team: " + numbersTeams +
		"\n championships won: " +championships+
		//"\n years of experience: " +yearsExperience+
		"\n market price: "+calcularMercado()+
		"\n nivel: "+calcularNivel()+
		"\n ******************************";
		return message;
	}

}

