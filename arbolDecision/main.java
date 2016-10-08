package ArbolesDecision.arbolDecision;

import java.util.Hashtable;

import ArbolesDecision.customData.DataTuple;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree tree = new Tree();
		
		DataTuple test = new DataTuple("as","FAR");
		 Hashtable <String,Integer> atributes;
		 atributes =  new Hashtable<String,Integer>();
		atributes.put("Strategy",0);
		atributes.put("Distance",1);
		System.out.println("Aqui");
		tree.recorrer(test, atributes);
		
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
