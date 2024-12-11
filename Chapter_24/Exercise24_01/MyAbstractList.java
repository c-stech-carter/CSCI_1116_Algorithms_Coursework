/*
Author: Charles Carter
Date: 12/9/2024

Description:   MyAbstractList implements methods defined in MyList
For the assignment the three methods required to be added are

addAll(), removeAll(), and retainAll()

 */


public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the list

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	/** Return true if this list contains no elements */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else 
			return false;
	}


	//My changes to the assignment's source code are below this comment

	/** Adds the elements in otherList to this list.
	 * Returns true if this list changed as a result of the call */
	public boolean addAll(MyList<E> otherList) {
		boolean changed = false;
		for (E e: otherList) {  //iterates through otherList
			add(e);  //adds each element
			changed = true;
		}
		return changed;  //returns false if otherList is empty
	}

	/** Removes all the elements in otherList from this list
	 * Returns true if this list changed as a result of the call */
	public boolean removeAll(MyList<E> otherList) {
		boolean changed = false;
		for (E e: otherList) {
			while (contains(e)) {
				remove(e);
				changed = true;
			}
		}
		return changed; //returns false if otherList is empty
	}

	/** Retains the elements in this list that are also in otherList
	 * Returns true if this list changed as a result of the call */
	public boolean retainAll(MyList<E> otherList) {
		boolean changed = false;
		for (int i = 0; i < size(); i++) {
			if (!otherList.contains(get(i))) {  //check if element is NOT in otherList
				remove(i);
				i--; //adjust index after removal
				changed = true;
			}
		}
		return changed;  //returns true if the list is modified
	}
}
