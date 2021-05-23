package linkedListStuffs;

public class Node {
	private int data;
	private Node next;
	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}
	
	public int getData() {
		return data;
	}
	
	public Node getNextNode() {
		return next;
	}
	
	public void setNextNode(Node node) {
		this.next = node;
	}
	
	public void setData(int data) {
		this.data = data;
	}
}
