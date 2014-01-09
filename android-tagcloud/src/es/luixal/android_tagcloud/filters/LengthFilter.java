package es.luixal.android_tagcloud.filters;

import es.luixal.android_tagcloud.Tag;

/**
 * Filters tags with length not contained between a minimum and a maximum value
 */
public class LengthFilter extends TagFilter {

	private static final long serialVersionUID = 1L;
	private int minLength = 0;
	private int maxLength = Integer.MAX_VALUE;
	
	public LengthFilter(int minLength, int maxLength) {
		setMinLength(minLength);
		setMaxLength(maxLength);
	}

	@Override
	public boolean accept(Tag tag) {
		if (tag == null || tag.getName() == null)
			return false;

		if (tag.getName().length() < getMinLength() || tag.getName().length() > getMaxLength())
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

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int minLength) {
		this.maxLength = minLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxLength;
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
		final LengthFilter other = (LengthFilter) obj;
		if (maxLength != other.maxLength)
			return false;
		if (minLength != other.minLength)
			return false;
		return true;
	}

	
}
