package customData;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import dataRecording.DataSaverLoader;

public class DataSet {
	
	//int numberOfAtributes;
	public Hashtable <Integer,String> atributes;
	DataTuple[] tuples;
	
	
	public DataSet(){
		
		//numberOfAtributes= nAtri;
		atributes = new Hashtable<Integer,String>();
		
		
		dataRecording.DataTuple[] aux = DataSaverLoader.LoadPacManData();
		tuples = new DataTuple[aux.length];
		int i = 0;
		for(dataRecording.DataTuple a : aux){
			
			tuples[i]= new DataTuple(a);
			
			
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
		
		
		for(int i = 0; i < atributes.size();i++ ){
			System.out.println(atributes.get(i));
			
		}
		System.out.println("  ");
		
		for(DataTuple d : tuples){
			int i = 0;
			if(atributes.get(0) != null){
				
				System.out.println(d.valores[0]);
			}
			if(atributes.get(1) != null){
				
				System.out.println(d.valores[1]);
			}
			
			if(i > 100)
				break;
			i++;
		}
			
	
		}
		
		
} 