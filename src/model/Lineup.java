package model;

	public class Lineup{
		
	public final static int ROWS_IN__LINEUP=10;
	public final static int COLUMNS_IN_LINEUP=7;

	private String date;
	private int[][] lineup;

	//Relationship 
	private Tactic tactic;

	private Position position;
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes</b> 
	 * @param date pdate of lineup created
	 * @param lineup matrix
	 * @param tactic tactic of lineup
	 */
	public Lineup (String date,int [][] lineup, String tactic){
    this.date=date;
    this.lineup=lineup;
    this.tactic=Tactic.valueOf(tactic);
	}


	/**
	 * show line up<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @return the lineup
	 */	
	public String toString (){
    String message = "";
	message = "\n ********** lineup ***********" +
	"\n Date: " + date +
	"\n Tatic: " + tactic +  
	"\n Lineup: \n" + showMatrix() +
	"\n *************************";
	return message;
	}

	/**
	 * show matrix information<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @return the matrix information
	 */	
	private String showMatrix(){
		String message="";
		
		for (int i=0;i<ROWS_IN__LINEUP;i++){
			for(int j=0;j<COLUMNS_IN_LINEUP;j++){
				message+=lineup[i][j]+"     ";
			}
			
			message+="\n";
		}

		return message;
	}



}