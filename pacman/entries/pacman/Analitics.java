package ArbolesDecision.pacman.entries.pacman;

public class Analitics {
	int total;
	int errors;
	void report(){
		
		System.out.println(total+" acciones. "+errors+" errores. "+errors/(float)total*100+"%");
		
	}
	void normal(){
		
		total++;
	}
	void erro(){
		errors++;
		
	}

}
