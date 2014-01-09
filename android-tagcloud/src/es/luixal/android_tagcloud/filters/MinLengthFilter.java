package es.luixal.android_tagcloud.filters;

import es.luixal.android_tagcloud.Tag;

/**
 * Filters tags with length lower than a defined value
 */
public class MinLengthFilter extends TagFilter {

	private static final long serialVersionUID = 1L;
	private int minLength = 0;
	
	public MinLengthFilter() {
	}
	
	public MinLengthFilter(int minLength) {
		setMinLength(minLength);
	}

	@Override
	public boolean accept(Tag tag) {
		if (tag == null || tag.getName() == null)
			return false;

		if (tag.getName().length() < getMinLength())
			return false;
		else
			return true;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + minLength;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MinLengthFilter other = (MinLengthFilter) obj;
		if (minLength != other.minLength)
			return false;
		return true;
	}

	
}
