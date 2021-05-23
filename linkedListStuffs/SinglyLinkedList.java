package linkedListStuffs;

public class SinglyLinkedList {
	
	//mr head and mr tail
	private Node head;
	private Node tail;
	
	//as one method wants to add node before tail, it would be useful to keep a reference
	//of the node before tail node
	private Node nodeBeforeTail;
	
	public SinglyLinkedList() {
		super();
		this.head = null;
		this.tail = null; 
		this.nodeBeforeTail = null;
	}
	
	//AddNode (int): Adds a new node at the end of the list.
	public void addNode(int data) {
		//if there is no element in the list
		Node newNode = new Node(data);
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
			this.nodeBeforeTail = newNode;
		} else {
			tail.setNextNode(newNode);
			this.nodeBeforeTail = tail; //as we are going to change referene of the tail...
			this.tail = newNode;
		}
	}
	
	//Traverse(): Prints the values stored in the list.
	public void traverse() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.getData());
			temp = temp.getNextNode();
		}
	}
	
	//void insertBeforeTail(int):Adds a new node before the last node.
	public void insertBeforeTail(int data) {
		Node newNode = new Node(data);
		nodeBeforeTail.setNextNode(newNode);
		nodeBeforeTail = newNode;
		newNode.setNextNode(tail);
	}
	
	//a main method to test all implementations
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.addNode(12);
		sll.addNode(32);
		sll.addNode(45);
		sll.addNode(87);
		sll.addNode(52);
		
		System.out.println("Before adding bewfore tail: ");
		sll.traverse();
		
		sll.insertBeforeTail(01);
		sll.insertBeforeTail(02);
		sll.insertBeforeTail(03);
		System.out.println("After adding bewfore tail: ");
		sll.traverse();
	}
	
}
