package ArbolesDecision.customData;

import ArbolesDecision.arbolDecision.discreteDistance;
import ArbolesDecision.strategy.Strategy;

public class DataTuple {
	
	String[] valores;
	int maxAtributos = 2;
	
	public DataTuple(discreteDistance distance, Strategy s){
		
		
		valores = new String[maxAtributos];
		
		
		
	}
	
	public DataTuple(ArbolesDecision.dataRecording.DataTuple data){
		
		valores = new String[maxAtributos];
		
		valores[0]= data.strategy.toString();
		valores[1]= data.closestGhost.toString();
		
		//System.out.println(data.strategy);
		
	}
public DataTuple(){
		
		
		
		
		
	}

	
	

}
