package packageForAccountList;

public class AccountList {
	private node head;

	public AccountList() {
		this.head = null;
	}

	public void addFront(int n, String s, double b) {
		node newNode = new node(n, s, b);
		newNode.next = head;
		head = newNode;
	}

	public void listAll() {
		node temp = head;

		while (temp != null) {
			System.out.println(temp.account_number + " " + temp.name + " " + temp.balance);
			temp = temp.next;
		}
	}

	public boolean updateBalance(int act, double newb) {
		node temp = head;

		while (temp != null) {
			if (temp.account_number == act) {
				temp.balance = newb;
				return true;
			} else
				temp = temp.next;
		}
		return false;
	}

	public void insert_in_order_balance(int n, String s, double b) {
		// insert in descending order of balance
		// compare the element with the existing element balance
		// if newNode balance is higher than the node under comparison, add new node in
		// front of it
		node newNode = new node(n, s, b);
		node previousNode = null;
		// if there is no element in the list
		if (this.head == null) {
			newNode.next = head;
			head = newNode;
			return;
		} else {

			node temp = head;

			while (temp != null) {
				// if we have to place new node at the first place
				if (temp == head && temp.balance <= newNode.balance) {
					this.addFront(n, s, b);
					return;
				} else if (temp.balance <= newNode.balance) {
					// when newNode balance is greater
					node preoviousNext = previousNode.next;
					previousNode.next = newNode;
					newNode.next = preoviousNext;
					return;
				}
				previousNode = temp;
				temp = temp.next;
			}
		}
		// in every other case add the element in the end of the list:
		previousNode.next = newNode;
	}

	public void remove(String name) {
		node previousNode = null;
		node temp = head;
		while (temp != null) {
			// if first element is supposed to be removed
			if (temp==head && temp.name.compareToIgnoreCase(name)==0) {
				head = temp.next;
			} else if(temp.name.compareToIgnoreCase(name)==0) {
				previousNode.next = temp.next; 
			}
			previousNode = temp;
			temp = temp.next;
		}
	}

//	public static void main(String[] args) {
//		AccountList AL = new AccountList();
//
//		AL.insert_in_order_balance(1001, "John Kelly", 2000);
//		AL.insert_in_order_balance(3003, "Jane Smith", 100);
//		AL.insert_in_order_balance(2002, "James Smith", 200);
//		AL.insert_in_order_balance(4004, "John Smith", 1300);
//
//		System.out.println("Before rempval operation");
//		AL.listAll();
//		
//		AL.remove("James Smith");
//		System.out.println("\nAfter removal operation");
//		AL.listAll();
//
//	}
}
