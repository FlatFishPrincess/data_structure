package DictionaryPackage;

import java.util.ListIterator;
import java.util.NoSuchElementException;

enum Move {
	NEXT, PREVIOUS
}

public class ListIteratorForLists<T extends Comparable<? super T>> implements ListIterator<T> {
	private ListInterface<T> list;
	
	private int nextIndex; // Index of next entry in the iteration
	private boolean isRemoveOrSetLegal;
	private Move lastMove;

	public ListIteratorForLists(ListInterface<T> list) {
		this.list = list;
		nextIndex = 0; // Iteration begins at list's first entry
		isRemoveOrSetLegal = false;
		lastMove = null;
	} // end default constructor

	public boolean hasNext() {
		return nextIndex < list.size(); // up to the size of the list
	} // end hasNext

	public T next() {
		if (hasNext()) {
			lastMove = Move.NEXT;
			isRemoveOrSetLegal = true;

			T nextEntry = list.getEntry(nextIndex);
			nextIndex++; // Advance iterator

			return nextEntry;
		} else
			throw new NoSuchElementException("Illegal call to next(); " + "iterator is after end of list.");
	} // end next

	public boolean hasPrevious() {
		return (nextIndex > 0) && (nextIndex <= list.size());
	} // end hasPrevious

	public T previous() {
		if (hasPrevious()) {
			lastMove = Move.PREVIOUS;
			isRemoveOrSetLegal = true;

			T previousEntry = list.getEntry(nextIndex - 1);
			nextIndex--; // Move iterator back
			return previousEntry;
		} else
			throw new NoSuchElementException("Illegal call to previous(); " + "iterator is before beginning of list.");
	} // end previous

	public int nextIndex() {
		int result;

		if (hasNext())
			result = nextIndex; // Change to zero-based numbering of iterator
		else
			result = list.size(); // End-of-list flag

		return result;
	} // end nextIndex

	public int previousIndex() {
		int result;

		if (hasPrevious())
			result = nextIndex - 1; // Change to zero-based numbering of iterator
		else
			result = -1; // Beginning-of-list flag

		return result;
	} // end previousIndex

	@Override
	public void add(T newEntry) {
		isRemoveOrSetLegal = false;

		// Insert newEntry immediately before the the iterator's current position
		list.add(nextIndex, newEntry);
		nextIndex++;
	} // end add

	public void remove() {
		if (isRemoveOrSetLegal) {
			isRemoveOrSetLegal = false;

			if (lastMove.equals(Move.NEXT)) {
				// next() called, but neither add() nor remove() has been
				// called since.

				// Remove entry last returned by next().

				// nextIndex is 1 more than the index of the entry
				// returned by next()
				list.remove(nextIndex - 1);
				nextIndex--; // Move iterator back
			} else {
				// previous() called, but neither add() nor remove() has been
				// called since

				// Remove entry last returned by previous().

				// nextIndex is the index of the entry returned by previous().
				list.remove(nextIndex);
			} // end if
		} else
			throw new IllegalStateException("Illegal call to remove(); " + "next() or previous() not called, OR "
					+ "add() or remove() called since then.");
	} // end remove

	public void set(T newEntry) {
		if (isRemoveOrSetLegal) {
			if (lastMove.equals(Move.NEXT)) {

				list.replace(nextIndex - 1, newEntry); // Replace entry last returned by next()
			} else {
				// Assertion: lastMove.equals(Move.PREVIOUS)
				list.replace(nextIndex, newEntry); // Replace entry last returned by previous()
			} // end if
		} else
			throw new IllegalStateException("Illegal call to set(); " + "next() or previous() not called, OR "
					+ "add() or remove() called since then.");
	} // end set

} // end ListIteratorForArrayList
