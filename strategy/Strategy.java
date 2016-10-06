package ArbolesDecision.strategy;

public interface Strategy {
	
	public void execute();
	public String toString();
	public static Strategy valueOf(String s){
		
		
		
		switch(s){
			case("Eat"):
				return new Eat();
				
				
			default:
				return new Run();
		}
	}
	
	

}
