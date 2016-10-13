package ArbolesDecision.arbolDecision;

import java.util.ArrayList;
import java.util.Hashtable;

import Arboles.atributos.Atribute;
import ArbolesDecision.customData.DataSet;

public class SeleccionAtributo {
	
	public   SeleccionAtributo() {
		// TODO Auto-generated constructor stub
		
	}
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
	public double getInfoT(DataSet dataSet){
		
		int indx = dataSet.sol.getIndx();
		String[] valores = dataSet.sol.getValues();
		int total = dataSet.countTuples();
		double info= 0;
		double aux;

		for(int i = 0; i< valores.length;i++){
			
			 aux = dataSet.countConditional(indx, valores[i]) / (double) total;
			 aux = (aux*log2(aux));
			
			info =info  - aux;
			System.out.println(info);
			//System.out.println(aux);
			
		}
		
		return info;
	}
public double getInfo(DataSet dataSet,Atribute atribute){
		
		int indx = atribute.getIndx();
		String[] valores = atribute.getValues();
		String [] clases = dataSet.sol.getValues();
		int total = dataSet.countTuples();
		double info= 0;
		double aux;
		int aux1;
		for(int i = 0; i< valores.length;i++){
			
			aux1= dataSet.countConditional(indx, valores[i]);
			
			for(String string : clases){
				aux = dataSet.countConditional(indx, valores[i]) / (double) total;
				
				
			}
			
			 
			 aux = (aux*log2(aux));
			
			info =info - aux;
			System.out.println(info);
			//System.out.println(aux);
			
		}
		
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
