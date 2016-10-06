package dataRecording;

public class DataSet {
	
	public String [] atributos;
	public DataTuple[] tuples;
	
	public DataSet(){
		
		
		tuples = DataSaverLoader.LoadPacManData();
		
		
	}
	
	

}
