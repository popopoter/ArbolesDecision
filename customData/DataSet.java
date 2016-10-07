package ArbolesDecision.customData;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import ArbolesDecision.dataRecording.DataSaverLoader;

public class DataSet {
	
	//int numberOfAtributes;
	public Hashtable <String,Integer> atributes;
	DataTuple[] tuples;
	
	
	public DataSet(){
		
		//numberOfAtributes= nAtri;
		atributes = new Hashtable<String,Integer>();
		
		
		ArbolesDecision.dataRecording.DataTuple[] aux = DataSaverLoader.LoadPacManData();
		tuples = new DataTuple[aux.length];
		int i = 0;
		for(ArbolesDecision.dataRecording.DataTuple a : aux){
			
			tuples[i]= new DataTuple(a);
			i++;
			
		}
		
		
	}
	
	public void eliminarAtributo(String atribute){
		
		System.out.println("Eliminando "+atribute);
		atributes.remove(atribute);
		
	}
	
	public int count(int posicion){
		
		return posicion;
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
			
			if(i > 10)
				break;
			i++;
			}
		}
	}
			public Boolean sameClass(String clas){
			int indx = atributes.get(clas);
			String tmp = tuples[0].valores[indx];
			for(DataTuple d : tuples){
				if(d.valores[indx] != tmp && d.active){
					
					return false;
				
				}
			}
			return true;
		}
		public void eliminar(String atributo, String valor){
			int indx = atributes.get(atributo);
			for(DataTuple d : tuples){
				System.out.println(d.valores[indx]+" / "+valor );
				if(d.valores[indx].equals(valor)){
					d.disactive();
				}
			}
		}
		
} 