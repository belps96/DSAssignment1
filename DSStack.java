import java.util.EmptyStackException;

/**
 * @author simont
 *
 */
public class DSStack extends Stack {
	
	DSList List;
	
	public DSStack() {
	List = new DSList();
	}
	
	public DSStack(Stack other) {
	
	}
	
	public Token push(Token obj) {
		List.add(obj);
		return obj;
	}

	public Token peek() {
		return List.get(size());
	}

	public Token pop() {
		return null;
	}
	
	public boolean empty() {
		return List.isEmpty();
	}

	public boolean add(Token obj) {
		return false;
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
	public boolean equals(Object other) {
		return false;
	}

	@Override
	public int hashCode() {
		// TODO: Replace this
		return (int) System.nanoTime();
	}

}
