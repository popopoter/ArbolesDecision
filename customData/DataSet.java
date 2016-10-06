package ArbolesDecision.customData;

import java.util.Enumeration;
import java.util.Hashtable;

import ArbolesDecision.dataRecording.DataSaverLoader;

public class DataSet {
	
	//int numberOfAtributes;
	public Hashtable <Integer,String> atributes;
	DataTuple[] tuples;
	
	
	public DataSet(){
		
		//numberOfAtributes= nAtri;
		atributes = new Hashtable<Integer,String>();
		
		
		ArbolesDecision.dataRecording.DataTuple[] aux = DataSaverLoader.LoadPacManData();
		tuples = new DataTuple[aux.length];
		int i = 0;
		for(ArbolesDecision.dataRecording.DataTuple a : aux){
			
			tuples[i]= new DataTuple(a);
			i++;
			
		}
		
		
	}
	
	public void eliminarAtributo(int posicion){
		
		System.out.println("Eliminando "+atributes.get(posicion));
		atributes.remove(posicion);
		
		
		
		
		
	}
	
	public int count(int posicion){
		
		return posicion;
	}

	public void print( ){
		Enumeration <String>  enumeration =atributes.elements();
		while(enumeration.hasMoreElements()){
			System.out.print(enumeration.nextElement()+" ");
			
			
		}
		
		System.out.println("  ");
		
		int i = 0;
		for(DataTuple d : tuples){
			if(atributes.get(0) != null){
				
				System.out.print(d.valores[0]+" ");
			}
			if(atributes.get(1) != null){
				
				System.out.print(d.valores[1]);
			}
			System.out.println("  ");
			
			if(i > 10)
				break;
			i++;
		}
			
	
		}
		
		
} 