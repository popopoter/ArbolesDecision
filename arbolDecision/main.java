package ArbolesDecision.arbolDecision;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tree tree = new tree();
		
		Nodo nuevo = new Nodo(1);
		Nodo nuevo1 = new Nodo(2);
		Nodo nuevo2 = new Nodo(3);
		Nodo nuevo3 = new Nodo(4);
		Nodo nuevo4 = new Nodo(5);
		Nodo nuevo5 = new Nodo(6);
		
		tree.raiz.addChild("FAR", nuevo); 
		nuevo.addChild("RUN",nuevo2);
		nuevo.addChild("EAT",nuevo3);
		tree.raiz.addChild("CLOSE", nuevo1);
		nuevo1.addChild("RUN",nuevo4);
		nuevo1.addChild("EAT",nuevo5);
		
		
		nuevo = tree.raiz.next("FAR");
		for(int i = 0;i<10;i++){
		if(nuevo.isLeaf()){
			System.out.println(nuevo.value);
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
