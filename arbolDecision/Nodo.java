package arbolDecision;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Nodo {
	
	int value;
	atribute atribute;
	Dictionary <String,Nodo> children;
	
	
	
	public Nodo(){
		
		children = new Hashtable<String,Nodo>();
		
		
	}
	public Nodo next(String s){
		
		
		return children.get(s);
		
	}
	public Nodo(int value){
	
		this.value = value;
		children = new Hashtable<String,Nodo>();
		
		
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
