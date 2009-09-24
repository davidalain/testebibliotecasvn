package util;

public class DoubleNode extends Node {
	
	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	private Node previous;
	
    public DoubleNode(Object el){
    	super(el);
    }
}
