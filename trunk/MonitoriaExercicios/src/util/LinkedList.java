package util;

public class LinkedList {
    private Node last;
    private Node first;
    public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}
	public LinkedList(Object firstInfo) {
        this.first = new Node(firstInfo);
        this.last = this.first;
    }
    public void printList(){
        if (first != null) {
            Node elem = null;
            Node next = first;
            while (next != null) {                
                elem = next;
                next = elem.getNext();
                System.out.println(elem.getInfo().toString());
            }  
        } else {
            System.out.println("EMPTY LIST!!");
        }        
    }
    public Object find(Object x){
        Object ret = null;
        if (first != null) {
            Node elem = null;
            Node next = first;
            while(next != null) {
                elem = next;
                next = elem.getNext();                
                if (elem.getInfo().equals(x)) {
                    ret =  elem.getInfo();
                    break;
                }
            }            
        }
        return ret;
    }
    public Object findKth(int pos){
        Object ret = null;
        if (first != null) {
            Node elem = null;
            Node next = first;
            int i = 0;
            while(next != null) {
                i++;
                elem = next;
                next = elem.getNext();                                
                if (i == pos) {
                    ret = elem.getInfo();
                    break; 
                }
            }
        }
        return ret;
    }
    public void insert(Object x){
        Node newNode = new Node(x);
        if (last == null) {
            first = newNode;   
        } else { 
            last.setNext(newNode);   
        }   
        last = newNode;
    }    
    public void remove(Object x){
        if (first != null) {
            Node previous = null;
            Node elem = null;
            Node next = first;            
            while(next != null) {
                previous = elem;
                elem = next;
                next = elem.getNext();                
                if (elem.getInfo().equals(x)) {
                    if (elem == first) {
                        first = first.getNext();
                        elem.setNext(null);  
                    } else {
                        if (previous != null) {
                            previous.setNext(next);
                        }
                        elem.setNext(null);
                    } 
                }                
            }
        }
    }
    private Node findLast() {
        Node ret = null;
        if (first != null) {
            Node last = null;
            Node next = first;
            while(next != null) {
                last = next;
                next = last.getNext();
            }
            ret =  last;        
        }
        return ret;
    }
    public ListIterator getIterator() {
        return new ListIterator(first);        
    }    
}
