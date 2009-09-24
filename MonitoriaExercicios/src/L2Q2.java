public class L2Q2 {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		Arquivo io = new Arquivo("L2Q2.in", "L2Q2.out");
		
		int contador = 1;
		while(!io.isEndOfFile()){
			AVLTree<Room> tree = new AVLTree<Room>();
			
			io.print("Conjunto #");
			io.print(contador);
			io.println();			
			
			String command = io.readString();
			while(!command.equals("reset") && !io.isEndOfFile()){
				int roomNumber = io.readInt();
				
				if(command.equals("getReservas")){
					InsertionStatus<Room> query = tree.search(new Room(roomNumber, 0));
					if(!query.exists){
						io.print("nao existe quarto ");
						io.print(roomNumber);
					}
					else{
						io.print("Numero: ");
						io.print(roomNumber);
						io.print(", Reservas: ");
						io.print(query.data.getPointer());
						io.print(", Nivel: ");
						io.print(query.level);
					}						
				}
				else{
					int pointer = io.readInt();
					Room newRoom = new Room(roomNumber, pointer);
					InsertionStatus<Room> status = tree.insert(newRoom);
					int level = status.level;
					if(!status.exists){
						io.print("quarto ");
						io.print(roomNumber);
						io.print(" com repositorio ");
						io.print(pointer);
						io.print(" inserido no nivel ");
						io.print(level);
					}
					else{
						io.print("ja existe quarto ");
						io.print(roomNumber);
						io.print(" no nivel ");
						io.print(level);
						if(status.data.getPointer() == pointer)
							io.print(" com repositorio indicado");
						else
							io.print(" com outro repositorio");
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

class Room implements Comparable<Room>{

	private int number;
	private int pointer;
	
	public Room(int n, int p){
		this.number = n;
		this.pointer = p;
	}	
	
	public int getNumber() {
		return number;
	}

	public int getPointer() {
		return pointer;
	}
	
	public boolean equals(Room o){
		return this.number == o.getNumber();
	}

	public int compareTo(Room o) {
		int ret;		
		if(o == null)
			throw new NullPointerException();
		else if(this.getNumber() < o.getNumber())
			ret = -1;
		else if(this.getNumber() > o.getNumber())
			ret = 1;
		else
			ret = 0;
		return ret;
	}	
}

class SubtreeStatus<E>{
	public boolean changed;
	public AVLNode<E> newRoot;
	public int level;
	public boolean exists;
	public E data;
	
	public SubtreeStatus(AVLNode<E> node, boolean c, int l, boolean e, E d){
		this.changed = c;
		this.newRoot = node;
		this.level = l;
		this.exists = e;
		this.data = d;
	}
}

class InsertionStatus<E>{
	public int level;
	public boolean exists;
	public E data;
	
	public InsertionStatus(int level, boolean exists, E data){
		this.level = level;
		this.exists = exists;
		this.data = data;
	}
}

class AVLNode<E> {
	private E element;
	protected int balance;
	protected AVLNode<E> left;
	protected AVLNode<E> right;

	public AVLNode(E element) {
		this.element = element;
		this.balance = 0;
		this.left = null;
		this.right = null;
	}

	public E getElement() {
		return element;
	}
}

class AVLTree<E extends Comparable<E>> {
	private AVLNode<E> root;
	
	public AVLTree(){
		this.root = null;
	}
	
	public boolean isEmpty(){
		return (this.root == null);
	}	
	
	public InsertionStatus<E> insert(E element){
		SubtreeStatus<E> status = this.insert(new AVLNode<E>(element), this.root, 0); 
		this.root = status.newRoot;
		return new InsertionStatus<E>(status.level, status.exists, status.data);
	}
	
	private SubtreeStatus<E> insert(AVLNode<E> newNode, AVLNode<E> root, int rootLevel) {
		SubtreeStatus<E> status = null;
		if(root == null)
			status = new SubtreeStatus<E>(newNode, true, rootLevel, false, null);
		else {
			E rootValue = root.getElement();
			E newNodeValue = newNode.getElement();

			if (newNodeValue.compareTo(rootValue) > 0){
				status = this.insert(newNode, root.right, rootLevel+1);
				root.right = status.newRoot;
				if(status.changed)
					root.balance++;
			}
			else if(newNodeValue.compareTo(rootValue) < 0){
				status = this.insert(newNode, root.left, rootLevel+1);
				root.left = status.newRoot;
				if(status.changed)
					root.balance--;
			}
			else
				status = new SubtreeStatus<E>(root, false, rootLevel, true, rootValue);
			
			if(root.balance == 0)
				status = new SubtreeStatus<E>(root, false, status.level, status.exists, status.data);
			else if(root.balance == 1 || root.balance == -1){
				if(status.changed)
					status = new SubtreeStatus<E>(root, true, status.level, status.exists, status.data);
				else
					status = new SubtreeStatus<E>(root, false, status.level, status.exists, status.data);
			}
			else if(root.balance == 2){
				if(root.right.balance == 1){
					AVLNode<E> node = this.simpleRotateLeft(root);
					status = new SubtreeStatus<E>(node, false, status.level-1, status.exists, status.data);
				}
				else if(root.right.balance == -1){
					AVLNode<E> node = this.doubleRotateLeft(root);
					if(node.left.left == null)
						status = new SubtreeStatus<E>(node, false, status.level-2, status.exists, status.data);
					else
						status = new SubtreeStatus<E>(node, false, status.level-1, status.exists, status.data);
				}
			}
			else if(root.balance == -2){
				if(root.left.balance == -1){
					AVLNode<E> node = this.simpleRotateRight(root);
					status = new SubtreeStatus<E>(node, false, status.level-1, status.exists, status.data);
				}
				else if(root.left.balance == 1){
					AVLNode<E> node = this.doubleRotateRight(root);
					if(node.right.right == null)
						status = new SubtreeStatus<E>(node, false, status.level-2, status.exists, status.data);
					else
						status = new SubtreeStatus<E>(node, false, status.level-1, status.exists, status.data);
				}
			}			
		}		
		
		return status;
	}

	public int height(){
		return this.height(this.root);
	}
	
	private int height(AVLNode<E> root){
		int height = 0; // base case
		
		if(root != null){
			int leftHeight = this.height(root.left);
			int rightHeight = this.height(root.right);
			height = 1 + Math.max(leftHeight, rightHeight);
		}
		return height;
	}

	private AVLNode<E> doubleRotateRight(AVLNode<E> root) {
		AVLNode<E> B = root.left;
		AVLNode<E> C = B.right;
		AVLNode<E> temp1 = C.right;
		C.right = root;
		AVLNode<E> temp2 = C.left;
		C.left = B;
		root.left = temp1;
		root = C;
		B.right = temp2;
		// updating balance
		root.balance = 0;
		root.left.balance = this.height(root.left.right) - this.height(root.left.left);
		root.right.balance = this.height(root.right.right) - this.height(root.right.left);
		return root;
	}

	private AVLNode<E> doubleRotateLeft(AVLNode<E> root) {
		AVLNode<E> B = root.right;
		AVLNode<E> C = B.left;
		AVLNode<E> temp1 = C.left;
		C.left = root;
		AVLNode<E> temp2 = C.right;
		C.right = B;
		root.right = temp1;
		root = C;
		B.left = temp2;
		// updating balance
		root.balance = 0;
		root.left.balance = this.height(root.left.right) - this.height(root.left.left);
		root.right.balance = this.height(root.right.right) - this.height(root.right.left);
		return root;
	}

	private AVLNode<E> simpleRotateRight(AVLNode<E> root) {
		AVLNode<E> B = root.left;
		AVLNode<E> temp = B.right;
		B.right = root;
		root.left = temp;
		root = B;
		// updating balance
		B.balance = 0;
		B.right.balance = 0;
		return root;
	}

	private AVLNode<E> simpleRotateLeft(AVLNode<E> root) {
		AVLNode<E> B = root.right;
		AVLNode<E> temp = B.left;
		B.left = root;
		root.right = temp;
		root = B;
		// updating balance
		B.balance = 0;
		B.left.balance = 0;
		return root;
	}
	
	public InsertionStatus<E> search(E element) {
		return this.search(element, this.root, 0);
	}
	
	private InsertionStatus<E> search(E element, AVLNode<E> root, int rootLevel) {
		InsertionStatus<E> founded;
		
		if (root == null)
			founded = new InsertionStatus<E>(rootLevel, false, null);
		else {
			E current = root.getElement();
			if (element.compareTo(current) == 0)
				founded = new InsertionStatus<E>(rootLevel, true, current);
			else if (element.compareTo(current) > 0)
				founded = this.search(element, root.right, rootLevel+1);
			else
				founded = this.search(element, root.left, rootLevel+1);
		}
		return founded;
	}

	public int level(E element){
		return this.level(element, this.root);
	}
	
	private int level(E target, AVLNode<E> root){
		int level = 0;
		if(root != null){
			E current = root.getElement();
			if (target.compareTo(current) > 0)
				level = 1 + this.level(target, root.right);
			else if (target.compareTo(current) < 0)
				level = 1 + this.level(target, root.left);
		}			
		return level;	
	}
}