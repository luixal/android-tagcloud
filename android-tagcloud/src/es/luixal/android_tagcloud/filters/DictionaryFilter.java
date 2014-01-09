package es.luixal.android_tagcloud.filters;


import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import es.luixal.android_tagcloud.Tag;

/**
 * Filters tags with names contained in a given list of terms.
 */
public class DictionaryFilter extends TagFilter {

	private static final long serialVersionUID = 1L;

	/** List of term to filter  */
	private Set<String> blackList = new HashSet<String>();
	
	/** Name of default resource bundle */
	final static public String defaultPropertyFile = "dictionary_blacklist";
	
	/**
	 * Default constructor.
	 * Use the default resource bundle.
	 */
	public DictionaryFilter() {
		update();
	}
	
	/**
	 * Default constructor.
	 * Use the default resource bundle.
	 */
	public DictionaryFilter(Locale locale) {
		update(locale);
	}

	/**
	 * Use the file corresponding to the given locale form the default resource bundle. 
	 */
	public DictionaryFilter(ResourceBundle bundle) {
		update(bundle);
	}
	
	/**
	 * Use the terms in the provided collection.
	 * @param coll Collection of strings to filter.
	 */
	public DictionaryFilter(Collection<? extends String> coll) {
		blackList.addAll(coll);
	}
	
	/**
	 * Use the terms in the provided array.
	 * @param entries Array of strings to filter
	 */
	public DictionaryFilter(String[] entries) {
		update(entries);
	}
	
	/**
	 * Use the terms read from the provided InputStrem.
	 * Each line corresponds to one term. 
	 * @param is The InputStrem object to read.
	 */
	public DictionaryFilter(InputStream is) {
		Scanner scanner = new Scanner(is);
		update(scanner);
	}
	
	/**
	 * Use the terms read from the provided Reader.
	 * Each line corresponds to one term. 
	 * @param reader The Reader object.
	 */
	public DictionaryFilter(Reader reader) {
		Scanner scanner = new Scanner(reader);
		update(scanner);
	}
	
	/**
	 * Use the terms read from the provided Scanner object.
	 * Each line corresponds to one term. 
	 * @param scanner The Scanner object to read.
	 */
	public DictionaryFilter(Scanner scanner) {
		update(scanner);
	}

	/**
	 * Reads terms from the default ResourceBundle using the default locale.
	 * Each line corresponds to one term. 
	 */
	public void update() {
		ResourceBundle bundle = ResourceBundle.getBundle(defaultPropertyFile);
		update(bundle);
	}
	
	/**
	 * Reads terms from the default ResourceBundle using the given locale.
	 * Each line corresponds to one term. 
	 * @param locale Locale of the ResourceBundle to read.
	 */
	public void update(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle(defaultPropertyFile, locale);
		update(bundle);
	}
	
	/**
	 * Reads terms from an InputStream object.
	 * Each line corresponds to one term. 
	 * @param is The InputStrem object to read.
	 */
	public void update(InputStream is) {
		Scanner scanner = new Scanner(is);
		update(scanner);
	}
	
	/**
	 * Reads terms from a Reader object.
	 * Each line corresponds to one term. 
	 * @param reader The Reader object to read.
	 */
	public void update(Reader reader) {
		Scanner scanner = new Scanner(reader);
		update(scanner);
	}

	/**
	 * Reads terms from a Scanner object.
	 * Each line corresponds to one term.
	 * @param scanner The Scanner object to read
	 */
	public void update(Scanner scanner) {
		blackList.clear();
		while (scanner.hasNextLine()) {
			String entry = scanner.nextLine();
			if (entry.length() != 0) {
				blackList.add(entry);
			}
		}
	}
	
	/**
	 * Reads terms from a ResourceBundle.
	 * Each line corresponds to one term.
	 * @param bundle The ResourceBundle object to read.
	 */
	public void update(ResourceBundle bundle) {
		Enumeration<String> enumeration = bundle.getKeys();
	
		blackList.clear();
		while (enumeration.hasMoreElements()) {
			String entry = enumeration.nextElement();
			if (entry.length() != 0) {
				blackList.add(entry);
			}
		}
	}

	/**
	 * Reads terms from an array of strings.
	 * @param entries Array of terms
	 */
	public void update(String[] entries) {
		blackList.clear();
		for (int i=0; i<entries.length; i++) {
			String entry = entries[i];
			if (entry != null && entry.length() != 0) {
				blackList.add(entry);
			}
		}
	}
	
	@Override
	public boolean accept(Tag tag) {
		if (tag == null)
			return true;
		
		if (blackList.contains(tag.getName()))
			return false;
		else
			return true;
	}

	/**
	 * @return The list of terms to filter 
	 */
	public Set<String> getDictionary() {
		return blackList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((blackList == null) ? 0 : blackList.hashCode());
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
		final DictionaryFilter other = (DictionaryFilter) obj;
		if (blackList == null) {
			if (other.blackList != null)
				return false;
		} else if (!blackList.equals(other.blackList))
			return false;
		return true;
	}
	
	
}
