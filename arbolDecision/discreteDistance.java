package ArbolesDecision.arbolDecision;

public enum discreteDistance {
	CLOSE{
		@Override
        public String toString() {
            return "CLOSE";
	}
	},
	FAR{
		@Override
        public String toString() {
            return "FAR";
		
		}
	};
	public static int breakPoint = 20;
	public static discreteDistance discretizeInt(int aux) {
		if(aux < breakPoint)
			return CLOSE;
		return FAR;
		
		
	}
	

	
}
