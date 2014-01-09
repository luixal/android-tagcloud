package es.luixal.android_tagcloud.filters;

/**
 * Accept all not null objects
 */
public class NotFilter<E> extends FilterBase<E> {

	private static final long serialVersionUID = 1L;
	
	private Filter<E> filter = null;
	
	public NotFilter(Filter<E> filter) {
		this.filter = filter;
	}
	
	@Override
	public boolean accept(E e) {
		if (filter != null) {
			return ! filter.accept(e);
		}
	
		return false;
	}

}
