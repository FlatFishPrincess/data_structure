/**
   An interface for the ADT deque.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface DequeInterface<T>
{
   /** Adds a new entry to the front/back of this deque.
       @param newEntry  An object to be added. */
   public void addToFront(T newEntry);
   public void addToBack(T newEntry);
   
   /** Removes and returns the front/back entry of this deque.
       @return  The object at the front/back of the deque or null if empty 
    */
   public T removeFront();
   public T removeBack();
   
   /**
    * Retrieves the front entry or null if empty.
    * @return front entry or null
    */
   public T getFront();
   
   /**
    * Retrieves last entry or null if empty
    * @return last entry or null
    */
   public T getBack();
   
   /** Detects whether this deque is empty.
       @return  True if the deque is empty, or false otherwise. */
   public boolean isEmpty();
   
   /*  Removes all entries from this deque. */
   public void clear();
   
   /**
    * return the number of elements in the queue.
    * @return number of elements in the queue
    */
   public int size();
   
} // end DequeInterface
