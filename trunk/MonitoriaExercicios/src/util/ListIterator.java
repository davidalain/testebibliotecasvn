package util;

public class ListIterator {
    Node current;    
    public ListIterator(Node n){
      current= n;
    }
    public boolean isPastEnd() {
      return (current == null);
    }
    public Object retrieve() {
      if (isPastEnd())
        return null;
      else  
        return current.getInfo();
    }
    public void advance(){
      if(!isPastEnd())
         current = current.getNext();
    }
}

