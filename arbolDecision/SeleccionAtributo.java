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


		
	public float infoD = - (numEat/tuplas) * sol(numEat/tuplas) - (numRun/tuplas) * sol(numRun/tuplas);
	
		
	
	
	public float sacarInfoDeAtributo(Atributo atributo){
		float info;
		
		//los numEat y numRun de aqui no son los totales, sino los que hay por cada variante de ese atributo
		// por ejemplo: de la variante Lejos, hay X numEat e Y numRun(0 en realidad porque el arbol es to pequeño y si esta lejos come)
		
		info = (atributo.variante1/tuplas) *(- (numEat/atributo.variante1)*sol(numEat/atributo.variante1) - (numRun/atributo.variante1)*sol(numRun/atributo.variante1))+ (atributo.variante2/tuplas)*(-(numEat/atributo.variante2)*sol(numEat/atributo.variante2) - (numRun/atributo.variante2)*sol(numEat/atributo.variante2));
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
