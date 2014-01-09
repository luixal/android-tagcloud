package es.luixal.android_tagcloud.filters;

/**
 * Logical AND of two or more filters
 */
public class AndFilter<E> extends FilterBase<E> {

	private static final long serialVersionUID = 1L;
	private Filter<E>[] filters = null;
	
	public AndFilter(Filter<E>... filters) {
		this.filters = filters;
	}
	
	@Override
	public boolean accept(E e) {
		if (filters != null && filters.length > 0) {
			for (int i=0; i<filters.length; i++) {
				if (! filters[i].accept(e)) {
					return false;
				}
			}
			return true;
		}
	
		return false;
	}

}
