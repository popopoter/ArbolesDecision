package ArbolesDecision.arbolDecision;

import java.util.Dictionary;
import java.util.Hashtable;

import Arboles.atributos.Atribute;

public class Nodo {
	
	String solution;
	//int value;
	Atribute atribute;
	Dictionary <String,Nodo> children;
	
	
	
	public Nodo(){
		
		children = new Hashtable<String,Nodo>();
		
		
	}
	
	public Nodo next(String s){
		
		
		return children.get(s);
		
	}
	public void addChild(String s ,Nodo n){
		
		children.put(s, n);
		
		
		
		//children.get(s);
		
		
	}
	
	public boolean isLeaf(){
		if(children.isEmpty())
			return true;
		return false;
	}
	
	
	

}
