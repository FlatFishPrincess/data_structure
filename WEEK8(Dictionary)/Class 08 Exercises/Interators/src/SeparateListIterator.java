import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 A class that represents an iterator for the ADT list.
 
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public class SeparateListIterator<T> implements Iterator<T>
{
   private ListInterface<T> list;
   private int              nextPosition;  // Position of entry last returned by next()
   private boolean          wasNextCalled; // Needed by remove
   
   public SeparateListIterator(ListInterface<T> myList)
   {
      list = myList;
      nextPosition = 0;
      wasNextCalled = false;
   } // end constructor

   public boolean hasNext()
   {
      return nextPosition < list.size();
   } // end hasNext
   
   public T next()
   {
      if (hasNext())
      {
         wasNextCalled = true;
         T result = list.getEntry(nextPosition);
         nextPosition++;
         return result;
      }
      else
         throw new NoSuchElementException("Illegal call to next(); " +
                                          "iterator is after end of list.");
   } // end next

   public void remove()
   {
      if (wasNextCalled)
      {
         // nextPosition was incremented by the call to next(), so
         // it is the position number of the entry to be removed
         list.remove(nextPosition - 1);
         nextPosition--;        // A subsequent call to next() must be
                                // unaffected by this removal
         wasNextCalled = false; // Reset flag
      }
      else
         throw new IllegalStateException("Illegal call to remove(); " +
                                         "next() was not called.");
   } // end remove
/*
   public void remove()
   {
      throw new UnsupportedOperationException("remove() is not " +
                                              "supported by this iterator");
   } // end remove
*/
} // end SeparateListIterator
