import java.util.Arrays;

/**
 * A class of stacks whose entries are stored in an array.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 5.0
 */

public final class ArrayStack2<T> implements StackInterface<T> {
	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry, negative if empty
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	public ArrayStack2() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public ArrayStack2(int initialCapacity) {
		integrityOK = false;
		checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		// NOTE: The following won't work as we don't know what T is in order to create
		// an array
		// T[] tempStack = new T[initialCapacity];
		// must create array of objects, then cast to T
		T[] tempStack = (T[]) new Object[initialCapacity];

		stack = tempStack;
		topIndex = -1; // indicates stack is empty
		integrityOK = true;
	} // end constructor

	private void ensureCapacity() {
		if (topIndex >= stack.length - 1) // If array is full, double its size
		{
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		} // end if
	} // end ensureCapacity

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
	} // end checkCapacity

	// Throws an exception if receiving object is not initialized.
	private void checkIntegrity() {
		if (!integrityOK)
			throw new SecurityException("ArrayBag object is corrupt.");
	} // end checkintegrity

	// implementation of StackInterface methods go here.
	// make sure you checkIntegrity and ensureCapacity()

	@Override
	public void push(T newEntry) {
		ensureCapacity();
		checkIntegrity();
		 	stack[topIndex + 1] = newEntry;
		topIndex++;
	}

	@Override
	public T pop() {
		checkIntegrity();
		T pop = peek();
		stack[topIndex] = null;
		topIndex--;
		return pop;
	}

	@Override
	public T peek() {
		T top = null;
		if(!isEmpty())
			 top = stack[topIndex];
		return top;
	}

	@Override
	public boolean isEmpty() {
		 return topIndex < 0;
	}

	@Override
	public void clear() {
		  stack = null;
	}

} // end ArrayStack
