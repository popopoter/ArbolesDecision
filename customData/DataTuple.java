package ArbolesDecision.customData;

import ArbolesDecision.arbolDecision.discreteDistance;
import ArbolesDecision.strategy.Strategy;

public class DataTuple {
	
	public String[] valores;
	int maxAtributos =3 ;
	Boolean active = true;
	public DataTuple(discreteDistance distance, Strategy s){
		
		
		valores = new String[maxAtributos];
		
		
		
	}
	public DataTuple(String s,String d, String string){
		valores = new String[maxAtributos];
		valores[0]=s;
		valores[1]=d;
		valores[2]= string;
	}
	public DataTuple(DataTuple tupleOg){
		
		if(!tupleOg.active)
			this.disactive();
		int i = 0;
		
		valores = new String[maxAtributos];
		i = 0;
		for(String valor: tupleOg.valores ){
			
			valores[i]=tupleOg.valores[i];
			
			i++;
			
		}
		
	}
	public DataTuple(ArbolesDecision.dataRecording.DataTuple data){
		
		valores = new String[maxAtributos];
		
		valores[0]= data.strategy;
		valores[1]= data.closestGhost.toString();
		valores[2]= String.valueOf(data.eatableGhost);
		//System.out.println(data.strategy);
		
	}
	public void disactive(){
		active = false;
		
	}
	public void active(){
		
		active = true;
	}
	
	
	

}
