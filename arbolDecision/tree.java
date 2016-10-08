package ArbolesDecision.arbolDecision;

import java.util.ArrayList;
import java.util.Hashtable;

import ArbolesDecision.customData.DataSet;
import ArbolesDecision.customData.DataTuple;

public class tree {
	
	Nodo raiz;
	
	public tree(){
		
		DataSet dataSet = new DataSet();
		
		dataSet.atributes.put("Strategy",0);
		dataSet.atributes.put("Distance",1);
		//aasd
		raiz = Generar_Arbol(dataSet);
		
	}
	public Nodo Generar_Arbol(DataSet dataSet){
		
				Nodo nuevoNodo = new Nodo();
				String clas=dataSet.sameClass("Strategy");
				if(!(clas.isEmpty())){
					nuevoNodo.solution = clas;
					System.out.println("Bien");
					return nuevoNodo;
				}
					
				//Si atributos vacia devuelve la mayoritaria
				if(dataSet.atributes.size()==1){
				
				nuevoNodo.solution = "Super Solucion: "+dataSet.claseMayoritaria();
				return nuevoNodo;
				}
				//Aplicar metodo de seleccion de atributo
				String atri = SeleccionAtributo.random();
				//Etiquetar nodo como atributo y eliminar el atributo de la lista
				nuevoNodo.atribute = atri;
				//Por cada valor creamos un nodo con este metodo excepto si esta vacio, 
				//Si esta vacio se etiqueta con la clase mayoritaria
				
				//Array list con los valores del atributo(Deberia ser diferente por si no hubiera)
				ArrayList <String> valuesOfAtri = dataSet.atributeValues(atri);
				//dataSet.eliminarAtributo(atri);
				
				for(String value: valuesOfAtri){
					System.out.println("Nuevo Hijo");
					System.out.println(value);
					//Aqui se elimina  atri
					nuevoNodo.addChild(value, Generar_Arbol(dataSet.divide(atri, value)));
					
				}
				
				
				//dataSet.eliminar(atributo, valor);
				
		
				return nuevoNodo;
	}

	public void recorrer(DataTuple tuple,Hashtable <String,Integer> atributes){
		
		
		Nodo actual = raiz;
		int index;
		while(!(actual.isLeaf())){
			index = atributes.get(actual.atribute);
			
			actual = actual.next(tuple.valores[index]);
		}
		System.out.println(actual.solution);
	}
	

}
