package ArbolesDecision.arbolDecision;

import java.util.ArrayList;
import java.util.Hashtable;

import Arboles.atributos.Atribute;
import ArbolesDecision.customData.DataSet;

public class SeleccionAtributo {
	
	
	public static Atribute random(ArrayList<Atribute> atributes){
		
		
		return atributes.get(0);
	}
	public static double log2(double value){
		double sol;
		sol = Math.log10(value) / Math.log10(2);
		
		return sol;
		
	}
	public static String ID3( Hashtable <String,Integer> atributes){
		
		double info;
				
		
		return "";
	}
	public double getInfo(DataSet dataSet,int index){
		
		
		double info= 0;
		
		
		return info;
	}
/* 
 Class generateTree(){ 
  	DataSet dataset= new Dataset();
  	int numEat,numRun,tuplas;
  	numEat = dataset.countEat;
  	numRun = dataset.countRun;
 	tuplas= dataset.CountRawTuples;
 	public float infoD = - (numEat/tuplas) * sol(numEat/tuplas) - (numRun/tuplas) * sol(numRun/tuplas); 
 	 
 		 
 	 
 	 
 	public float sacarInfoDeAtributo(Atributo atributo){ 
 		float info; 
 		 int numVariantes;
		numVariantes= atributo.getNumVariantes;
 		//los numEat y numRun de aqui no son los totales, sino los que hay por cada variante de ese atributo 
 		// por ejemplo: de la variante Lejos, hay X numEat e Y numRun(0 en realidad porque el arbol es to pequeño y si esta lejos come) 
 		 for(int i=0; i< numVariantes; i++)
 		{
 		info += (atributo.variante[i]/tuplas) *(- (numEat/atributo.variante[i])*sol(numEat/atributo.variante[i])
 		 -(numRun/atributo.variante[i])*sol(numRun/atributo.variante[i])); 
 		}
		return info; 
 	} 
 	 
 	 
 	public string siguienteAtributo(){ 
 		float mayor=0; 
 		int aux=0; 
 		float info; 
 		for(int i=0; i<numAtri; i++) 
 		{ 
 			info = sacarInfoDeAtributo(atributo[i]); 
 			if ((infoD - info)> mayor) 
 			{ 
 				mayor = info; 
 				aux=i; 
 			} 
 		 
 		} 
 		return atributo[i]; 
 	} 
  
 } 
 */ 
}
