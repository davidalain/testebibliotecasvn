package Exercicio4ListaEncadeada;

import util.LinkedList;
import util.ListIterator;

public class ToStringLinkedList extends LinkedList{

	private int size ;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ToStringLinkedList(Object firstInfo) {
		super(firstInfo);
		this.size = 1;
		// TODO Auto-generated constructor stub
	}
	
	public void insert (Object x){
		super.insert(x);
		this.size ++;
		}
	
	public void remove (Object x){
		super.remove(x);
		this.size --;
	}
	
	public void printInverted () {
		if (this.size == 0){
			System.out.println("Lista Vazia");
		}
		else {
			Object[] arraytemp = new Object[this.size];
			ListIterator it = getIterator();
			int i = 0;
			while (it.isPastEnd() == false){
				arraytemp[i] = it.retrieve();
				it.advance();
				i++;
		}
			for (int j = this.size - 1; j >= 0 ; j-- ){
				System.out.println(arraytemp[j].toString());
			}	
		}
	}

	
}
