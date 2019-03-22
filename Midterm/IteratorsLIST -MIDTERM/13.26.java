// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T next()
{
   if (hasNext())
   {
      lastMove = Move.NEXT;
      isRemoveOrSetLegal = true;

      T nextEntry = list[nextIndex];
      nextIndex++; // Advance iterator

      return nextEntry;
   }
   else
      throw new NoSuchElementException("Illegal call to next(); " +
                                       "iterator is after end of list.");
} // end next
