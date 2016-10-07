package ArbolesDecision.customData;

import ArbolesDecision.arbolDecision.discreteDistance;
import ArbolesDecision.strategy.Strategy;

public class DataTuple {
	
	String[] valores;
	int maxAtributos = 2;
	Boolean active = true;
	public DataTuple(discreteDistance distance, Strategy s){
		
		
		valores = new String[maxAtributos];
		
		
		
	}
	public void disactive(){
		active = false;
		
	}
	public void active(){
		
		active = true;
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
