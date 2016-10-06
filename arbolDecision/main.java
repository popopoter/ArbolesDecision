package ArbolesDecision.arbolDecision;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tree tree = new tree();
		
		Nodo nuevo = new Nodo(1);
		Nodo nuevo1 = new Nodo(2);

		
		tree.raiz.addChild("FAR", nuevo);
		tree.raiz.addChild("CLOSE", nuevo1);
		
		
		
		nuevo = tree.raiz.next("CLOSE");
		
		if(nuevo.isLeaf())
			System.out.println(nuevo.value);
		else System.out.println("Come, manzana");
		Nodo actual = tree.raiz;
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
