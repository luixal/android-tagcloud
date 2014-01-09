//@MC
/**
 * 
 */
package es.luixal.android_tagcloud.filters;

import java.io.Serializable;
import java.util.Collection;

/**
 * Interface that defines a generic object filter.
 */
public interface Filter<E> extends Serializable {

	/**
	 * Tells whether the element is accepted or discarded by the filter.
	 * @param e Object to consider
	 * @return True if the object is accepted by the filter, false if it is discarded
	 */
	public boolean accept(E e);
	
	/**
	 * Remove from the collection the objects non accepted by the filter
	 * @param coll Collection of objects to filter
	 */
	public void filter(Collection<E> coll);

}
//@MC