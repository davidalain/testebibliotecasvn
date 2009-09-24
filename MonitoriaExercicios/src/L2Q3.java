public class L2Q3 {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		Arquivo io = new Arquivo("L2Q3.in", "L2Q3.out");
		
		int contador = 1;
		while(!io.isEndOfFile()){
			AVLTree3<Monkey> tree = new AVLTree3<Monkey>();
			
			io.print("Conjunto #");
			io.print(contador);
			io.println();
			
			
			String command = io.readString();
			while(!command.equals("fim") && !io.isEndOfFile()){
				
				if(command.equals("entra")){
					String name = io.readString();
					int weight = io.readInt();
					Monkey newOne = new Monkey(name, weight);
					ReturnStatus3<Monkey> status = tree.insert(newOne);
					if(!status.exists){
						io.print(name);
						io.print(" inserido com sucesso no nivel ");
						io.print(status.level);
					}
					else
						io.print("ja existe macaco com esse nome");
				}
				else if(command.equals("verificar")){
					String verify = io.readString();
					if(!tree.isEmpty()){
						if(verify.equals("pre"))
							tree.preOrder(io);
						else if(verify.equals("in"))
							tree.inOrder(io);
						else
							tree.posOrder(io);
					}
					else
						io.print("arvore vazia");
				}
				else if(command.equals("peso")){
					String name = io.readString();
					MonkeyStatus<Monkey> query = tree.subtreeWeight(new Monkey(name,0));
					if(query.exists){
						io.print(name);
						io.print(" peso: ");
						io.print(query.data.getWeight());
						io.print("Kg peso total: ");
						io.print(query.weight);
						io.print("Kg");
					}
					else
						io.print("macaco inexistente");
				}
				else{
					String name = io.readString();
					int newWeight = io.readInt();
					ReturnStatus3<Monkey> query = tree.search(new Monkey(name,0));
					if(query.exists){
						query.data.setWeight(query.data.getWeight() + newWeight);
						io.print(name);
						io.print(" ganhou ");
						io.print(newWeight);
						io.print("Kg ficando com ");
						io.print(query.data.getWeight());
						io.print("Kg");
					}
					else
						io.print("macaco inexistente");
				}				
				
				if(!io.isEndOfFile())
					command = io.readString();
				io.println();
			}			
			io.println("acabou");
			io.println();
			contador++;
		}
		System.out.println(String.format("%.3fs",((double)(System.currentTimeMillis()-a))/1000));
	}
}

interface MonkeyWeight<E> extends Comparable<E>{
	public int getWeight();
	public void setWeight(int weight);
	public int compareTo(E o);
}

class Monkey implements MonkeyWeight<Monkey>{

	private String name;
	private int weight;
	
	public Monkey(String n, int w){
		this.name = n;
		this.weight = w;
	}
		
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int compareTo(Monkey o) {
		return this.name.compareTo(o.getName());
	}
	
	public String toString(){
		return this.name;
	}
}

class SubtreeStatus3<E>{
	public boolean changed;
	public AVLNode3<E> newRoot;
	public int level;
	public boolean exists;
	public E data;
	
	public SubtreeStatus3(AVLNode3<E> node, boolean c, int l, boolean e, E d){
		this.changed = c;
		this.newRoot = node;
		this.level = l;
		this.exists = e;
		this.data = d;
	}
}

class ReturnStatus3<E>{
	public int level;
	public boolean exists;
	public E data;
	
	public ReturnStatus3(int level, boolean exists, E data){
		this.level = level;
		this.exists = exists;
		this.data = data;
	}
}

class MonkeyStatus<E>{
	public E data;
	public int weight;
	public boolean exists;
	
	public MonkeyStatus(E data, int w, boolean e){
		this.data = data;
		this.weight = w;
		this.exists = e;
	}
}

class AVLNode3<E> {
	private E element;
	protected int balance;
	protected AVLNode3<E> left;
	protected AVLNode3<E> right;

	public AVLNode3(E element) {
		this.element = element;
		this.balance = 0;
		this.left = null;
		this.right = null;
	}

	public E getElement() {
		return element;
	}
}

class AVLTree3<E extends MonkeyWeight<E>> {
	private AVLNode3<E> root;
	
	public AVLTree3(){
		this.root = null;
	}
	
	public boolean isEmpty(){
		return (this.root == null);
	}	
	
	public ReturnStatus3<E> insert(E element){
		SubtreeStatus3<E> status = this.insert(new AVLNode3<E>(element), this.root, 0); 
		this.root = status.newRoot;
		return new ReturnStatus3<E>(status.level, status.exists, status.data);
	}
	
	private SubtreeStatus3<E> insert(AVLNode3<E> newNode, AVLNode3<E> root, int rootLevel) {
		SubtreeStatus3<E> status = null;
		if(root == null)
			status = new SubtreeStatus3<E>(newNode, true, rootLevel, false, null);
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
				status = new SubtreeStatus3<E>(root, false, rootLevel, true, rootValue);
			
			if(root.balance == 0)
				status = new SubtreeStatus3<E>(root, false, status.level, status.exists, status.data);
			else if(root.balance == 1 || root.balance == -1){
				if(status.changed)
					status = new SubtreeStatus3<E>(root, true, status.level, status.exists, status.data);
				else
					status = new SubtreeStatus3<E>(root, false, status.level, status.exists, status.data);
			}
			else if(root.balance == 2){
				if(root.right.balance == 1){
					AVLNode3<E> node = this.simpleRotateLeft(root);
					status = new SubtreeStatus3<E>(node, false, status.level-1, status.exists, status.data);
				}
				else if(root.right.balance == -1){
					AVLNode3<E> node = this.doubleRotateLeft(root);
					if(node.left.left == null)
						status = new SubtreeStatus3<E>(node, false, status.level-2, status.exists, status.data);
					else
						status = new SubtreeStatus3<E>(node, false, status.level-1, status.exists, status.data);
				}
			}
			else if(root.balance == -2){
				if(root.left.balance == -1){
					AVLNode3<E> node = this.simpleRotateRight(root);
					status = new SubtreeStatus3<E>(node, false, status.level-1, status.exists, status.data);
				}
				else if(root.left.balance == 1){
					AVLNode3<E> node = this.doubleRotateRight(root);
					if(node.right.right == null)
						status = new SubtreeStatus3<E>(node, false, status.level-2, status.exists, status.data);
					else
						status = new SubtreeStatus3<E>(node, false, status.level-1, status.exists, status.data);
				}
			}			
		}			
		return status;
	}

	public int height(){
		return this.height(this.root);
	}
	
	private int height(AVLNode3<E> root){
		int height = 0; // base case
		
		if(root != null){
			int leftHeight = this.height(root.left);
			int rightHeight = this.height(root.right);
			height = 1 + Math.max(leftHeight, rightHeight);
		}
		return height;
	}

	private AVLNode3<E> doubleRotateRight(AVLNode3<E> root) {
		AVLNode3<E> B = root.left;
		AVLNode3<E> C = B.right;
		AVLNode3<E> temp1 = C.right;
		C.right = root;
		AVLNode3<E> temp2 = C.left;
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

	private AVLNode3<E> doubleRotateLeft(AVLNode3<E> root) {
		AVLNode3<E> B = root.right;
		AVLNode3<E> C = B.left;
		AVLNode3<E> temp1 = C.left;
		C.left = root;
		AVLNode3<E> temp2 = C.right;
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

	private AVLNode3<E> simpleRotateRight(AVLNode3<E> root) {
		AVLNode3<E> B = root.left;
		AVLNode3<E> temp = B.right;
		B.right = root;
		root.left = temp;
		root = B;
		// updating balance
		B.balance = 0;
		B.right.balance = 0;
		return root;
	}

	private AVLNode3<E> simpleRotateLeft(AVLNode3<E> root) {
		AVLNode3<E> B = root.right;
		AVLNode3<E> temp = B.left;
		B.left = root;
		root.right = temp;
		root = B;
		// updating balance
		B.balance = 0;
		B.left.balance = 0;
		return root;
	}
	
	public ReturnStatus3<E> search(E element) {
		return this.search(element, this.root, 0);
	}
	
	private ReturnStatus3<E> search(E element, AVLNode3<E> root, int rootLevel) {
		ReturnStatus3<E> founded;
		
		if (root == null)
			founded = new ReturnStatus3<E>(rootLevel, false, null);
		else {
			E current = root.getElement();
			if (element.compareTo(current) == 0)
				founded = new ReturnStatus3<E>(rootLevel, true, current);
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
	
	private int level(E target, AVLNode3<E> root){
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
	
	public void preOrder(Arquivo io) {
		this.preOrder(io, this.root);
	}

	private void preOrder(Arquivo io, AVLNode3<E> node) {
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

	private void inOrder(Arquivo io, AVLNode3<E> node) {
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

	private void posOrder(Arquivo io, AVLNode3<E> node) {
		if (node != null) {
			this.posOrder(io, node.left);
			this.posOrder(io, node.right);
			io.print(node.getElement().toString());
			io.print(" ");
		}
	}
	
	public MonkeyStatus<E> subtreeWeight(E element){
		return this.subtreeWeight(element, this.root);
	}
	
	private MonkeyStatus<E> subtreeWeight(E element, AVLNode3<E> node){
		MonkeyStatus<E> status = null;
		
		if(node == null)
			status = new MonkeyStatus<E>(null, 0, false);
		else{
			E current = node.getElement();
			if (element.compareTo(current) == 0)
				status = new MonkeyStatus<E>(current, this.subtreeWeight(node),true);
			else if (element.compareTo(current) > 0)
				status = this.subtreeWeight(element, node.right);
			else
				status = this.subtreeWeight(element, node.left);
		}
		return status;
	}
	
	private int subtreeWeight(AVLNode3<E> node) {
		int total = 0;
		if(node != null){
			total += this.subtreeWeight(node.left);
			total += this.subtreeWeight(node.right);
			total += node.getElement().getWeight();
		}		
		return total;
	}
}