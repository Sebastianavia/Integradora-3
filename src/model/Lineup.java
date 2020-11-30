	package model;

	public class Lineup{
		
	public final static int ROWS_IN__LINEUP=10;
	public final static int COLUMNS_IN_LINEUP=7;

	private String chain;
	private String date;
	private int[][] matrix;

	public Lineup(String chain,String date){
		this.date=date;
		matrix=stringToMatrix(chain);
	}
	public int[][] stringToMatrix (String chain){
		int [][] message=new int [ROWS_IN__LINEUP][COLUMNS_IN_LINEUP];
		
		return message;
	}
	public String matrixToString(){
		return "todo matrixToString";
	}
	private String showMatrix(){
		String message="";
		
		for (int i=0;i<ROWS_IN__LINEUP;i++){
			for(int j=0;j<COLUMNS_IN_LINEUP;j++)
			message+=matrix[i][j]+"\n";
			
		}
		return message;
	}
	public String toString(){
		String message="";
		
		return message;
	}


}