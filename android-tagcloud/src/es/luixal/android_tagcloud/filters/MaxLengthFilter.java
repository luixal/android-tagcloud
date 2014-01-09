package es.luixal.android_tagcloud.filters;

import es.luixal.android_tagcloud.Tag;

/**
 * Filters tags with length greater than a defined value
 */
public class MaxLengthFilter extends TagFilter {

	private static final long serialVersionUID = 1L;
	private int maxLength = Integer.MAX_VALUE;
	
	public MaxLengthFilter() {
	}
	
	public MaxLengthFilter(int maxLength) {
		setMaxLength(maxLength);
	}

	@Override
	public boolean accept(Tag tag) {
		if (tag == null || tag.getName() == null)
			return false;

		if (tag.getName().length() > getMaxLength())
			return false;
		else
			return true;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxLength;
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
		final MaxLengthFilter other = (MaxLengthFilter) obj;
		if (maxLength != other.maxLength)
			return false;
		return true;
	}

	
}
