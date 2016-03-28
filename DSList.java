
public class DSList implements List {

	public Node head;
	//int size = 1;

	public DSList() {
		head = null;
	}

	public DSList(Node head_) {
		head = head_;
	}

	public DSList(DSList other) { // Copy constructor.

		for (Node n = other.head; n != null; n = n.next){
			add(n.getObject());
		}
		//size = other.size;
	}
	public Token remove(int index) {
		if (index < 0 || index > size()){
			return null;
		}
		Token tempToken = get(index);
		remove(tempToken);
		return tempToken;
	}

	public int indexOf(Token obj) {

		int count = 0;
		for (Node n = head; n != null; n = n.next){
			if (n.getObject().equals(obj)){
				return count;
			}
			count++;
		}
		return 0;
	}

	public Token get(int index) {

		Node currentNode = head;
		int count = 0;
		Token returnToken = null;

		while (currentNode != null)
		{
			if (count == index){
				returnToken = currentNode.getObject();
			}

			count++;
			currentNode = currentNode.next;
		}
		return returnToken;
	}

	public boolean isEmpty() {
		if (head == null){
			return true;
		}
		return false;
	}

	public int size() {

		int count = 1;
		Node tempNode = head;
		
		if (isEmpty() == true){
			return 0;
		}
		while (tempNode.next != null){
			count++;
			tempNode = tempNode.next;
		}
		return count;
	}

	@Override
	public String toString() {

		String result = "";
		Node current = head;
		while(current != null){
			result += current.getObject().toString() + " ";
			current = current.next;
		}
		return result.trim();
	}

	public boolean add(Token obj) {

		if (head == null){
			head = new Node(null, null, obj);
			return true;
		}

		Node currentNode = head;
		while (currentNode.next != null){
			currentNode = currentNode.next;
		}

		if (currentNode.next == null){
			currentNode.next = new Node(null, currentNode, obj);
			//size ++;
			return true;
		}
		return false;
	}

	public boolean add(int index, Token obj) {

		if (index == 0){
			Node tempNode = head;
			tempNode.previous = head = new Node(tempNode, null, obj);
			//size++;
			return true;
		}

		int count = 0;
		for (Node n = head; n != null; n = n.next){
			if (count == index-1){
				n.next = new Node(n.next, n.previous, obj);
				//size++;
				return true;
			}
			else if (n.next == null){
				add(obj);
				return true;
			}
			count++;
		}

		return false;
	}

	public boolean contains(Token obj) {


		for (Node n = head; n != null; n = n.next){
			if (n.getObject().equals(obj)){
				return true;
			}
		}
		return false;
	}

	public boolean remove(Token obj) {

		if (head.getObject().equals(obj)){
			head = head.next;
			//size--;
			return true;
		}

		for (Node n = head; n != null; n = n.next){
			if (n.getObject().equals(obj)){
				n.previous.next = n.next;
				if (n.next == null){
					n.next = null;
				}
				else {
					n.next.previous = n.previous;
				}
				//size --;
				return true;
			}
		}
		return false;
	}

	@Override

	public int hashCode() {

		// TODO: Replace this
		return (int) System.nanoTime();
	}

	@Override

	public boolean equals(Object other) {
		if(getClass() == other.getClass()){
			DSList objCast = (DSList)other;
			if (objCast.hashCode() == this.hashCode()){
				return true;
			}
		}
		return false;
	}	
}
