package ArbolesDecision.arbolDecision;

import java.util.ArrayList;
import java.util.Hashtable;

import Arboles.atributos.Atribute;
import Arboles.atributos.ClosestAgresiveGhost;
import Arboles.atributos.Eatable;
import Arboles.atributos.Solution;
import ArbolesDecision.customData.DataSet;
import ArbolesDecision.customData.DataTuple;

public class Tree {
	
	Nodo raiz;
	public ArrayList<Atribute> atributes;
	
	public Tree(){
		
		DataSet dataSet = new DataSet();
		dataSet.sol = new Solution();
		dataSet.atributes.add(new ClosestAgresiveGhost());
		dataSet.atributes.add(new Eatable());
		atributes = new ArrayList<Atribute>(dataSet.atributes);
		//aasd
		raiz = Generar_Arbol(dataSet);
		
	}
	public Nodo Generar_Arbol(DataSet dataSet){
				Nodo nuevoNodo = new Nodo();
				System.out.println("Nuevo nodo "+dataSet.countTuples()+" tuplas");
				String clas=dataSet.sameClass();
				if(!(clas.isEmpty())){
					System.out.println("Nunca");
					nuevoNodo.solution = clas;
					return nuevoNodo;
				}
				System.out.println("No tienen misma clase");
					
				//Si atributos vacia devuelve la mayoritaria
				if(dataSet.atributes.size()==0){
				
				nuevoNodo.solution = dataSet.claseMayoritaria();
				System.out.println(nuevoNodo.solution);
				return nuevoNodo;
				}
				System.out.println("No quedan atributos");
				//Aplicar metodo de seleccion de atributo
				Atribute atri = SeleccionAtributo.random(dataSet.atributes);
				//Etiquetar nodo como atributo y eliminar el atributo de la lista
				nuevoNodo.atribute = atri;
				//Por cada valor creamos un nodo con este metodo excepto si esta vacio, 
				//Si esta vacio se etiqueta con la clase mayoritaria
				
				//Array list con los valores del atributo(Deberia ser diferente por si no hubiera)
				int index = dataSet.atributes.indexOf(atri);
				 String [] valuesOfAtri = (dataSet.atributes.get(index)).getValues();
				//dataSet.eliminarAtributo(atri);
				
				for(String value: valuesOfAtri){
					System.out.print("Nuevo Hijo : ");
					System.out.println(value);
					//Aqui se elimina  atri
					DataSet aux = dataSet.divide(atri, value);
					nuevoNodo.addChild(value, Generar_Arbol(aux));
					
				}
				
				
				//dataSet.eliminar(atributo, valor);
				
		
				return nuevoNodo;
	}

	public String recorrer(DataTuple tuple,ArrayList <Atribute> atributes){
		
		
		Nodo actual = raiz;
		int index;
		while(!(actual.isLeaf())){
			System.out.println(actual.atribute);
			index = atributes.lastIndexOf(actual.atribute);
			index = atributes.get(index).getIndx();
			System.out.println(tuple.valores[index]);
			actual = actual.next(tuple.valores[index]);
		}
		return (actual.solution);
	}
	
	
	

}
