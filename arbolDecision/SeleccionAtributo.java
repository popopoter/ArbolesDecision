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
	public static Atribute ID3( ArrayList <Atribute> atributes,DataSet dataSet){
		System.out.println("Quedan "+ atributes.size()+" atributes");
		for(Atribute a: atributes )
			System.out.println(a);
		if(atributes.size()==1){
			
			System.out.println("Solo queda una atributo");
			for(Atribute atri: atributes){
				return atri;
				
			}
			
		}
		double infoT = getInfoT(dataSet);
		double maxInfo = 0;
		int indx = 0;
		double aux;
		
		for(int i = 0; i< atributes.size();i++){
			aux = infoT - getInfo(dataSet, atributes.get(i));
			System.out.println(aux);
			if(aux>maxInfo){
				maxInfo= aux;
				indx = i;
			}
			
		}
		System.out.println(indx);
		System.out.println("ID3 selecciona " + atributes.get(indx) + " con una Info de: "+maxInfo);
		return atributes.get(indx);
	}
	public static  double getInfoT(DataSet dataSet){
		
		int indx = dataSet.sol.getIndx();
		String[] valores = dataSet.sol.getValues();
		double total = (double) dataSet.countTuples();
		double info= 0.0;
		double aux;

		for(int i = 0; i< valores.length;i++){
			
			 aux = dataSet.countConditional(indx, valores[i]) /  total;
			 System.out.println(aux);
			 aux = (aux*log2(aux));
			
			info =info  - aux;
			
			//System.out.println(aux);
			
		}
		
		return info;
	}
public static double getInfo(DataSet dataSet,Atribute atribute){
		
		int indx = atribute.getIndx();
		String[] valores = atribute.getValues();
		String [] clases = dataSet.sol.getValues();
		double total = (double) dataSet.countTuples();
		double info= 0;
		double aux=0;
		double aux1;
		double acumulador=0;
		for(int i = 0; i< valores.length;i++){
			
			aux1= (double) dataSet.countConditional(indx, valores[i]);
			
			for(String string : clases){
				//System.out.println(aux1+" para "+valores[i] +"/" + dataSet.countDoubleConditional(indx, valores[i], dataSet.sol.getIndx(), string) );
				aux = dataSet.countDoubleConditional(indx, valores[i], dataSet.sol.getIndx(), string) ;
				if(aux != 0){
					aux /= (double) aux1;
					aux = aux*log2(aux);
					acumulador = acumulador - aux;
					
				}
				System.out.println(aux);
			}
			info += aux1/total * acumulador;
			 acumulador = 0;
			
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
