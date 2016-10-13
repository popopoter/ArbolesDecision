package ArbolesDecision.customData;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import Arboles.atributos.Atribute;
import Arboles.atributos.Solution;
import ArbolesDecision.dataRecording.DataSaverLoader;

public class DataSet {
	
	//int numberOfAtributes;
	public Solution sol= new Solution();
	public ArrayList <Atribute> atributes;
	public DataTuple[] tuples;
	
	
	public DataSet(){
		
		
		//numberOfAtributes= nAtri;
		atributes = new ArrayList<Atribute>();
		
		
		ArbolesDecision.dataRecording.DataTuple[] aux = DataSaverLoader.LoadPacManData();
		tuples = new DataTuple[aux.length];
		int i = 0;
		for(ArbolesDecision.dataRecording.DataTuple a : aux){
			
			tuples[i]= new DataTuple(a);
			i++;
			
		}
		
		
	}
	public DataSet(DataSet ogDataSet){
		atributes = new ArrayList<Atribute> (  ogDataSet.atributes);
		 int nTuples = ogDataSet.countRawTuples();
		 tuples = new DataTuple[nTuples];
		 int i = 0;
		 for(DataTuple tuple : ogDataSet.tuples){
			
			 tuples[i] = new DataTuple(tuple);
			 i++;
			} 
		
		
		
	}
	//Numero de tuplas
	public int countRawTuples(){
		
		return tuples.length;
	}
	public int countTuples(){
		int count = 0;
		for(DataTuple tuple : tuples){
			if(tuple.active)
			count++;
		} 
		return count;
	}
	public boolean isEmpty(){
		if(countTuples()==0)
			return true;
		else return false;
		
	}
	public void eliminarAtributo(Atribute atribute){
		
		System.out.println("Eliminando "+atribute.toString());
		atributes.remove(atribute);
		
	}
	
	/*public int count(int posicion){
		
		return posicion;
	}*/
	public int countConditional(int atributeIndex, String condition){
		int count = 0;
		for(DataTuple tuple : tuples){
			if(tuple.valores[atributeIndex].equals(condition)&& tuple.active)
				count++;
		}
		return count;
		
		
	}
	
	public void print( ){
		//La clase, solucion
		System.out.print(sol.toString());
		//Los atributos
		for(Atribute atribute: atributes){
			System.out.print(atribute.toString() + " ");
		}
		
		
		System.out.println("  ");
		
		
		//Las tuplas
		for(DataTuple d : tuples){
			//Si esta activada 
			if(d.active){
			//Imprimimos el valor de la solucion
			System.out.println(d.valores[sol.getIndx()]);
			for(Atribute atribute: atributes){
				//Imprimos el valor de cada tupla
				System.out.print(d.valores[atribute.getIndx()]+" ");
			}
			}
			
		}
		
	}
			public String sameClass( ){
				
			int indx = sol.getIndx();
			String s = "";
			for(DataTuple d : tuples){
				
				if(d.active && s.isEmpty()){
					
					s = d.valores[indx];
					
			
			}else if(d.active &&  !(s.equals(d.valores[indx]))){
				
				return "";
			}
			}
			
	
			return s;
		}
		public String claseMayoritaria(){
			int indx = sol.getIndx();
			String[] s = sol.getValues();
			System.out.println("Numero de cosas" + countTuples());
			int count[] = new int [s.length];
			
			for(int i = 0; i<s.length;i++){
				count[i] = 0;
					
			}
			for(DataTuple d : tuples){
				if(d.active){
					for(int i = 0;i<s.length;i++){
						if(d.valores[indx].equals(s[i])){
							count[i] = count[i]+1;
						}
								
					}
				}
					
			}
			int aux = 0;
			int newIndx = 0;
			for(int i = 0;i<count.length;i++){
				System.out.println(count[i]);
				if(count[i] > aux){
					newIndx =i; 
					aux = count[i];
			}
				}
			
			return s[newIndx];
			
			/*int countRun = 0;
			int countEat = 0;
			for(DataTuple d : tuples){
				if (d.valores[0].equals("Eat") && d.active)
					countEat++;	
				if( d.valores[0].equals("Run") && d.active)
					countRun++;
				 
				//System.out.println( d.valores[0] + "/" +"Eat" +"="+ d.valores[0].equals("Eat"));
				if(countRun> 100)
					break;
			}
			if(countEat > countRun)
				return "Eat";
			return "Run";*/
		}
		public void eliminar(Atribute atribute, String valor){
			int indx = atribute.getIndx();
			for(DataTuple d : tuples){
				
				if(d.valores[indx].equals(valor)){
					d.disactive();
				}
			}
		}
			
		
		
		public DataSet divide(Atribute atribute, String subClass){
			
			DataSet nuevoDataSet = new DataSet(this);
			int atributeIndex = atribute.getIndx();
			
			for(DataTuple tuple : nuevoDataSet.tuples){
				if(tuple.active){
				if(!(tuple.valores[atributeIndex].equals(subClass)))
					
					tuple.disactive();
				
				}
					
				}
			nuevoDataSet.eliminarAtributo(atribute);
			return nuevoDataSet;
}
			
		public int countEat(){
			int countEat = 0;
			for(DataTuple d : tuples){
				if (d.valores[0].equals("Eat") && d.active)
					countEat++;	
			}
				return countEat;
		}	
			public int countRun(){
				int countRun = 0;
				for(DataTuple d : tuples){
					if (d.valores[0].equals("Run") && d.active)
						countRun++;	
				}
					return countRun;
			}		
			
			
			
			
		 
} 
