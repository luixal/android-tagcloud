package es.luixal.android_tagcloud.filters;

import java.util.Collection;
import java.util.Iterator;

/**
 * Base class for object filters.
 */
public abstract class FilterBase<E> implements Filter<E> {

	private static final long serialVersionUID = 1L;

	/**
	 * Tells whether the element is accepted or discarded by the filter.
	 * @param e Object to consider
	 * @return True if the object is accepted by the filter, false if it is discarded
	 */
	abstract public boolean accept(E e);

	/**
	 * Remove from the collection the objects non accepted by the filter
	 * @param coll Collection of objects to filter
	 */
	public void filter(Collection<E> coll) {
		Iterator<E> it = coll.iterator();
		
		while (it.hasNext()) {
			if (! accept(it.next())) {
				it.remove();
			}
		}
	}

}
