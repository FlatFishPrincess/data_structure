/**
   An interface for the ADT stack.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface StackInterface<T>
{
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry);
  
   /**
    * Removes and returns the stack's top entry or a null if empty. Note this is DIFFERENT
    * from the textbook.
    * @return The object at the top of the stack or null if empty
    */
   public T pop();
  
   /**
    * Retrieves this stack's top entry or a null if empty. Note this is DIFFERENT
    * from the textbook.
    * @return The object at the top of the stack or null if empty
    */
   public T peek();
  
   /** Detects whether this stack is empty. 
       @return  True if the stack is empty. */
   public boolean isEmpty();
  
   /** Removes all entries from this stack. */
   public void clear();
   
   /**
    * Gets size of stack (not capacity)
    * @return current number of entries in the stack
    */
   public int size();
   
} // end StackInterface
