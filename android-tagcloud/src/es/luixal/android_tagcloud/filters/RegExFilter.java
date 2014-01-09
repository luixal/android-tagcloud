package es.luixal.android_tagcloud.filters;

import es.luixal.android_tagcloud.Tag;

/**
 * Filters tags that don't match a given regular expression
 */
public class RegExFilter extends TagFilter {

	private static final long serialVersionUID = 1L;
	private String regEx = null;
	
	public RegExFilter(String regEx) {
		setRegEx(regEx);
	}

	@Override
	public boolean accept(Tag tag) {
		if (tag == null || tag.getName() == null)
			return false;

		if (tag.getName().matches(regEx))
			return true;
		else
			return false;
	}

	/**
	 * @return The regular expression
	 */
	public String getRegEx() {
		return regEx;
	}

	/**
	 * Sets the regular expression
	 * @param regEx The regular expression to set
	 */
	public void setRegEx(String regEx) {
		this.regEx = regEx;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regEx == null) ? 0 : regEx.hashCode());
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
		final RegExFilter other = (RegExFilter) obj;
		if (regEx == null) {
			if (other.regEx != null)
				return false;
		} else if (!regEx.equals(other.regEx))
			return false;
		return true;
	}

	
}
