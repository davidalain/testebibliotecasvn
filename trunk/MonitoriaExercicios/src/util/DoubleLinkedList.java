package util;

import sun.security.action.GetLongAction;


public class DoubleLinkedList extends LinkedList {
	public DoubleLinkedList(Object firstElement) {
		super(new DoubleNode(firstElement));
	}
    public void insert(Object x){
        DoubleNode newNode = new DoubleNode(x);
        DoubleNode last = (DoubleNode)getLast();
        if (last == null) {
            setFirst(newNode);   
        } else { 
            last.setNext(newNode);
            newNode.setPrevious(last);
        }   
        last = newNode;
    }    
    public void remove(Object x){
    	DoubleNode first = (DoubleNode)getFirst();
        if (first != null) {
            DoubleNode previous = null;
            DoubleNode elem = null;
            DoubleNode next = first;            
            while(next != null) {
                previous = elem;
                elem = next;
                next = (DoubleNode)elem.getNext();                
                if (elem.getInfo().equals(x)) {
                    if (elem == first) {
                        setFirst((DoubleNode)first.getNext());
                        elem.setNext(null);  
                        first.setPrevious(null);
                    } else {
                        previous.setNext(next);
                        if (next != null) {
                        	next.setPrevious((DoubleNode)previous);
                        }
                        elem.setNext(null);
                        elem.setPrevious(null);
                    } 
                }                
            }
        }
    }	
}