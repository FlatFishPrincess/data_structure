import java.util.ArrayList;

/**
 * This implements the ListInterface using the Java library ArrayList.
 * @author Jiweon Park
 *
 * @param <T>
 */
public class ArrayListUsingListInterface<T> implements ListInterface<T>{

	private ArrayList<T> coinList = new ArrayList<>();
	
	@Override
	public void add(T newEntry) {
		coinList.add(newEntry);
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// add(newPosition -1 , newEntry) 
		coinList.add(newPosition, newEntry);
	}

	@Override
	public T remove(int givenPosition) {
		// remove(givenPosition - 1)
		T result = coinList.remove(givenPosition);
		return result;
	}

	@Override
	public void clear() {
		coinList.clear();
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		T result = coinList.set(givenPosition, newEntry);
		return result;
	}

	@Override
	public T getEntry(int givenPosition) {
		return coinList.get(givenPosition);
	}

	@Override
	public T[] toArray() {
//		T[] newArr1 = (T[]) coinList.toArray(); // answer
		T[] newArr = (T[]) new Object();
		for(int i = 0; i< coinList.size(); i++){
			newArr[i] = coinList.get(i);
		}
		return newArr;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean result = false;;
		for(int i = 0; i< coinList.size(); i++){
			if(coinList.get(i).equals(anEntry)){
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public int getLength() {
		return coinList.size();
	}

	@Override
	public boolean isEmpty() {
		return coinList.isEmpty();
	}


}
