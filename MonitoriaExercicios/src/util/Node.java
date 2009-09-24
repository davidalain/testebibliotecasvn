package util;

public class Node {
    private Object info;
    private Node next = null;
    
    public Node(Object el){
        if (el == null)
            throw new RuntimeException("Node data cannot be null");
        this.info = el;
    }
    public Node(Object el, Node next){
        if (el == null)
            throw new RuntimeException("Node data cannot be null");
        this.info = el;
        this.next = next;
    }
    
    public Object getInfo() { 
        return info;
    }
    
    public void setInfo(Object info) {
        this.info = info;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }

}
