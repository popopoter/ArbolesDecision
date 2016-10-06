package customData;

import arbolDecision.discreteDistance;
import strategy.Strategy;

public class DataTuple {
	
	String[] valores;
	int maxAtributos = 2;
	
	public DataTuple(discreteDistance distance, Strategy s){
		
		
		valores = new String[maxAtributos];
		
		
		
	}
	
	public DataTuple(dataRecording.DataTuple data){
		System.out.println("Bug");
		
		System.out.println((String) data.closestGhost.toString());
		//valores[0]= data.strategy.toString();
		
		
		
	}
public DataTuple(){
		
		
		
		
		
	}

	
	

}
