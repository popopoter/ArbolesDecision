package ArbolesDecision.arbolDecision;

public class Condition {
	
	int breakPoint;
	public boolean evaluate(int valor){
		if(valor < breakPoint){
			
			return true;
			
		}
		return false;
		
		
		
	}
	
	
	

}
