
public class DSQueue extends Queue {
	
	DSList List;
	
	public DSQueue(Queue input) {
		List = new DSList((DSList)((List) input));
	}
	
	public DSQueue() {
		List = new DSList();
	}
	
	public boolean offer(Token t) {
		if (t == null){
			throw new NullPointerException();
		}
		return add(t);
	}
	
	public Token poll() {
		return List.remove(0);
	}
	
	public Token peek() {

		if (List.isEmpty() == true){
			return null;
		}
		else{
			return List.get(0);
		}
	}
	
	@Override
	public boolean add(Token obj) {
		List.add(obj);
		return true;
	}
	
	public boolean isEmpty() {
		return List.isEmpty();
	}
	
	public int size() {
		return List.size();
	}
	
	@Override
	public String toString() {
		return List.toString();
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int hashCode() {
		// TODO: Replace this
		return (int) System.nanoTime();
	}
}
