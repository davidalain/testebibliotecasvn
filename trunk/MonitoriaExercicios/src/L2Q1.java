public class L2Q1 {
	
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		Arquivo io = new Arquivo("L2Q1.in", "L2Q1.out");
		String command = io.readString();
		
		int contador = 1;
		while(!io.isEndOfFile()){
			BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
			
			io.print("Conjunto #");
			io.print(contador);
			io.println();
			
			command = io.readString();
			while(!command.equals("n") && !io.isEndOfFile()){
				if(command.equals("m")){
					int molecule = io.readInt();
					ReturnStatus1<Integer> status = tree.insert(new Integer(molecule));
					if(!status.exists){
						io.print("novo, nivel ");
						io.print(status.level);
					}
					else{
						io.print("absorvida no nivel ");
						io.print(status.level);
					}	
				}
				else if(command.equals("d")){
					int molecule = io.readInt();
					ReturnStatus1<Integer> status = tree.remove(new Integer(molecule));
					if(!status.exists){
						io.print("nao existe ");
						io.print(molecule);
					}
					else{
						io.print("destruido ");
						io.print(molecule);
						io.print(" ");
						io.print(status.level);
						io.print(" ");
						if(status.data != null)
							io.print(status.data);
						else
							io.print("x");
					}
				}
				else if(command.equals("a")){
					String type = io.readString();
					if(type.equals("pre") && !tree.isEmpty()){
						tree.preOrder(io);
					}
					else if(type.equals("pos") && !tree.isEmpty()){
						tree.posOrder(io);
					}
					else if(type.equals("in") && !tree.isEmpty()){
						tree.inOrder(io);
					}
					else if(type.equals("cam")){
						int molecule = io.readInt();
						boolean exists = tree.printPath(io, new Integer(molecule));
						if(!exists){
							io.print("nao existe ");
							io.print(molecule);
						}	
					}
				}
				else if(command.equals("e")){
					int molecule = io.readInt();
					ReturnStatus1<Integer> status = tree.search(new Integer(molecule));
					if(!status.exists)
						io.print("nao");
					else{
						io.print("sim, no nivel ");
						io.print(status.level);
					}						
 				}
				
				if(!io.isEndOfFile())
					command = io.readString();
				io.println();
			}			
			io.println();
			contador++;
		}
		io.close();
		System.out.println(String.format("%.3fs",((double)(System.currentTimeMillis()-a))/1000));
	}
}

class BSTNode<E> {
	private E element;
	protected BSTNode<E> left;
	protected BSTNode<E> right;

	public BSTNode(E element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}

	public E getElement() {
		return element;
	}
	
	public void setElement(E newE){
		this.element = newE;
	}
}

class ReturnStatus1<E>{
	public int level;
	public boolean exists;
	public E data;
	
	public ReturnStatus1(int level, boolean exists, E data){
		this.level = level;
		this.exists = exists;
		this.data = data;
	}
}

class SubtreeStatus1<E>{
	public BSTNode<E> newRoot;
	public int level;
	public boolean exists;
	public E data;
	
	public SubtreeStatus1(BSTNode<E> node, int l, boolean e, E d){
		this.newRoot = node;
		this.level = l;
		this.exists = e;
		this.data = d;
	}
}

class BinarySearchTree<E extends Comparable<E>> {
	private BSTNode<E> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public boolean isEmpty(){
		return (this.root == null);
	}
	
	public ReturnStatus1<E> insert(E element) {
		SubtreeStatus1<E> status = this.insert(new BSTNode<E>(element), this.root, 0);
		this.root = status.newRoot;
		return new ReturnStatus1<E>(status.level, status.exists, status.data);
	}

	private SubtreeStatus1<E> insert(BSTNode<E> newNode, BSTNode<E> root, int rootLevel) {
		SubtreeStatus1<E> status = null;
		boolean check = false;
		if (root == null)
			status = new SubtreeStatus1<E>(newNode, rootLevel, false, null);
		else {
			E rootValue = root.getElement();
			E newNodeValeu = newNode.getElement();

			if (newNodeValeu.compareTo(rootValue) > 0){
				status = this.insert(newNode, root.right, rootLevel+1);
				root.right = status.newRoot;
				check = true;
			}
			else if(newNodeValeu.compareTo(rootValue) < 0){
				status = this.insert(newNode, root.left, rootLevel+1);
				root.left = status.newRoot;
				check = true;
			}
			else
				status = new SubtreeStatus1<E>(root, rootLevel, true, rootValue);
		}
		
		if (check)
			status = new SubtreeStatus1<E>(root, status.level, status.exists, status.data);

		return status;
	}

	public ReturnStatus1<E> remove(E element) {
		SubtreeStatus1<E> status = this.remove(element, this.root, 0);
		this.root = status.newRoot;
		return new ReturnStatus1<E>(status.level, status.exists, status.data);
	}

	private SubtreeStatus1<E> remove(E target, BSTNode<E> root, int rootLevel) {
		SubtreeStatus1<E> status = null;
		boolean check = false;
		if (root != null) {
			if(target.compareTo(root.getElement()) == 0){
				if(root.left == null && root.right == null)
					status = new SubtreeStatus1<E>(null, rootLevel, true, null);
				else if(root.left == null)
					status = new SubtreeStatus1<E>(root.right, rootLevel, true, root.right.getElement());
				else if (root.right == null)
					status = new SubtreeStatus1<E>(root.left, rootLevel, true, root.left.getElement());	
				else{
					E min = this.findMinimum(root.right).getElement();
					root.setElement(min);
					root.right = this.removeMinimum(root.right);
					status = new SubtreeStatus1<E>(root, rootLevel, true, min);
				}									
			}
			else if(target.compareTo(root.getElement()) > 0){
				status = this.remove(target, root.right, rootLevel+1);
				root.right = status.newRoot;
				check = true;
			}
			else if(target.compareTo(root.getElement()) < 0){
				status = this.remove(target, root.left, rootLevel+1);
				root.left = status.newRoot;
				check = true;
			}
		}
		else
			status = new SubtreeStatus1<E>(root, rootLevel, false, null);
		
		if(check)
			status = new SubtreeStatus1<E>(root, status.level, status.exists, status.data);
		return status;
	}
	
	private BSTNode<E> findMinimum(BSTNode<E> root){
		if(root != null){
			while(root.left != null)
				root = root.left;
		}
		return root;
	}
	
	private BSTNode<E> removeMinimum(BSTNode<E> root){
		if(root != null){
			if(root.left != null)
				root.left = removeMinimum(root.left);
			else
				root = root.right;
		}
		return root;
	}

	public ReturnStatus1<E> search(E element) {
		return this.search(element, this.root, 0);
	}

	private ReturnStatus1<E> search(E element, BSTNode<E> root, int rootLevel) {
		ReturnStatus1<E> founded;
		
		if (root == null)
			founded = new ReturnStatus1<E>(rootLevel, false, null);
		else {
			E current = root.getElement();
			if (element.compareTo(current) == 0)
				founded = new ReturnStatus1<E>(rootLevel, true, current);
			else if (element.compareTo(current) > 0)
				founded = this.search(element, root.right, rootLevel+1);
			else
				founded = this.search(element, root.left, rootLevel+1);
		}
		return founded;
	}

	public void preOrder(Arquivo io) {
		this.preOrder(io, this.root);
	}

	private void preOrder(Arquivo io, BSTNode<E> node) {
		if (node != null) {
			io.print(node.getElement().toString());
			io.print(" ");
			this.preOrder(io, node.left);
			this.preOrder(io, node.right);
		}
	}
	
	public void inOrder(Arquivo io) {
		this.inOrder(io, this.root);
	}

	private void inOrder(Arquivo io, BSTNode<E> node) {
		if (node != null) {
			this.inOrder(io, node.left);
			io.print(node.getElement().toString());
			io.print(" ");
			this.inOrder(io, node.right);
		}
	}
	
	public void posOrder(Arquivo io) {
		this.posOrder(io, this.root);
	}

	private void posOrder(Arquivo io, BSTNode<E> node) {
		if (node != null) {
			this.posOrder(io, node.left);
			this.posOrder(io, node.right);
			io.print(node.getElement().toString());
			io.print(" ");
		}
	}
	
	public boolean printPath(Arquivo io, E element){
		return this.printPath(io, element, this.root);
	}

	private boolean printPath(Arquivo io, E element, BSTNode<E> node) {		
		boolean exists = false;
		if(node != null){
			E current = node.getElement();
			if (element.compareTo(current) == 0)
				exists = true;
			else if (element.compareTo(current) > 0)
				exists = this.printPath(io, element, node.right);
			else
				exists = this.printPath(io, element, node.left);
			
			if(exists){
				io.print(current.toString());
				io.print(" ");
			}			
		}
		return exists;
	}
}