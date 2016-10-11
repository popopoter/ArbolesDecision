package ArbolesDecision.customData;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import Arboles.atributos.Atributes;
import ArbolesDecision.dataRecording.DataSaverLoader;

public class DataSet {
	
	//int numberOfAtributes;
	public Hashtable <Atributes,Integer> atributes;
	public DataTuple[] tuples;
	
	
	public DataSet(){
		
		//numberOfAtributes= nAtri;
		atributes = new Hashtable<Atribute ,Integer>();
		
		
		ArbolesDecision.dataRecording.DataTuple[] aux = DataSaverLoader.LoadPacManData();
		tuples = new DataTuple[aux.length];
		int i = 0;
		for(ArbolesDecision.dataRecording.DataTuple a : aux){
			
			tuples[i]= new DataTuple(a);
			i++;
			
		}
		
		
	}
	public DataSet(DataSet ogDataSet){
		atributes = new Hashtable <String, Integer> (ogDataSet.atributes);
		 int nTuples = ogDataSet.countRawTuples();
		 tuples = new DataTuple[nTuples];
		 int i = 0;
		 for(DataTuple tuple : ogDataSet.tuples){
			
			 tuples[i] = new DataTuple(ogDataSet.tuples[i]);
			 i++;
			} 
		
		
		
	}
	//Numero de tuplas
	public int countRawTuples(){
		int count = 0;
		for(DataTuple tuple : tuples){
			count++;
		} 
		return count;
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
	public void eliminarAtributo(String atribute){
		
		System.out.println("Eliminando "+atribute);
		atributes.remove(atribute);
		
	}
	
	/*public int count(int posicion){
		
		return posicion;
	}*/
	public int countConditional(int atributeIndex, String condition){
		int count = 0;
		for(DataTuple tuple : tuples){
			if(tuple.valores[atributeIndex].equals(condition))
				count++;
		}
		return count;
		
		
	}
	public ArrayList <String>  getAtributes(){
		Enumeration <String>  enumeration = atributes.keys();
		ArrayList<String> atributes = new ArrayList<String>();
				while(enumeration.hasMoreElements()){
					atributes.add((enumeration.nextElement()));	
				}
		return atributes;
	}
	public void print( ){
		ArrayList<String> atributesString = getAtributes();
		for(String atribute: atributesString){
			System.out.print(atribute + " ");
		}
		
		
		System.out.println("  ");
		
		int i = 0;
		for(DataTuple d : tuples){
			if(d.active){
			if(atributes.get("Strategy") != null){
				
				System.out.print(d.valores[0]+" ");
			}
			if(atributes.get("Distance") != null){
				
				System.out.print(d.valores[1]);
			}
			System.out.println("  ");
			
			if(i > 100)
				break;
			i++;
			}
		}
	}
			public String sameClass(String clas){
				
			int indx = atributes.get(clas);
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
			int countRun = 0;
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
			return "Run";
		}
		public void eliminar(String atribute, String valor){
			int indx = atributes.get(atribute);
			for(DataTuple d : tuples){
				
				if(d.valores[indx].equals(valor)){
					d.disactive();
				}
			}
		}
			
		
		public ArrayList <String> atributeValues(String atribute){
			ArrayList<String> values = new ArrayList<String>();
			int atributeIndex = atributes.get(atribute);
			for(DataTuple tuple : tuples)
				if(!values.contains(tuple.valores[atributeIndex])){
					
					values.add(tuple.valores[atributeIndex]);
					
				}
			
			return values;
			
			
		}
		public DataSet divide(String atribute, String subClass){
			
			DataSet nuevoDataSet = new DataSet(this);
			int atributeIndex = atributes.get(atribute);
			
			for(DataTuple tuple : nuevoDataSet.tuples){
				
				if((tuple.valores[atributeIndex].compareTo(subClass)!=0))
					tuple.disactive();
				
					
				}
			nuevoDataSet.eliminarAtributo(atribute);
			return nuevoDataSet;
}
			
			
			
			
			
			
		 
} 