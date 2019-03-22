/**
 * A class of stacks whose entries are stored in an array.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 5.0
 */


public class ArrayStack<T> implements StackInterface<T> {
	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry
	private static final int DEFAULT_CAPACITY = 100;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public ArrayStack(int initialCapacity) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
	} // end constructor

	@Override
	public void push(T newEntry) {
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}

	@Override
	public T pop() {
		T result = peek();
		stack[topIndex] = null;
		topIndex--;
		return result;
	}

	@Override
	public T peek() {
		T result = null;
		if(topIndex > -1){
			result = stack[topIndex];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public void clear() {
		stack = null;
	}

	@Override
	public int size() {
		int size = topIndex + 1;
		return size;
	}
	
	/**
	 * Display all elements in a stack.
	 * Begin with the title followed by the stack size.
	 * Then display each stack element using the toString() method 
	 * of the element.
	 * @param title title to display ahead of list of elements
	 */
	public void display(String title) {
		int stackSize = size();
		System.out.println("===================");
		System.out.println(title + " size " + stackSize);
		for (int i = 0; i < stackSize; i++) {
			System.out.println(stack[i]);
		}

		System.out.println("===================");
	}
	
	public T[] toArray(){
		T[] stackCopy = stack;
		// .. should use toArray not display
		return null;
	}
} // end ArrayStack