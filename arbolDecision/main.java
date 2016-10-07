package ArbolesDecision.arbolDecision;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tree tree = new tree();
		
		Nodo nuevo = new Nodo();
		Nodo nuevo1 = new Nodo();
		Nodo nuevo2 = new Nodo();
		Nodo nuevo3 = new Nodo();
		Nodo nuevo4 = new Nodo();
		Nodo nuevo5 = new Nodo();
		
		tree.raiz.addChild("FAR", nuevo); 
		nuevo.addChild("RUN",nuevo2);
		nuevo.addChild("EAT",nuevo3);
		tree.raiz.addChild("CLOSE", nuevo1);
		nuevo1.addChild("RUN",nuevo4);
		nuevo1.addChild("EAT",nuevo5);
		
		
		nuevo = tree.raiz.next("FAR");
		for(int i = 0;i<10;i++){
		if(nuevo.isLeaf()){
			System.out.println();
			break;
		}
		else nuevo = nuevo.next("EAT");
		
		}
		/*while(!actual.isLeaf())
			actual.next(dataTuple[Atributo]);
		return actual.value;
		*/
		//If(isLeaf) return value;
		//tuple 
		//Lista Argu
		
		//anterior.next(tuple[1])
		
		
		//System.out.println(nuevo.value);
		
	}

}
