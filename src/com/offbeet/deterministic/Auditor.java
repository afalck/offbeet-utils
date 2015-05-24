package com.offbeet.deterministic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * A simplified Auditor for demo.
 * 
 * @author arturofalck
 */
public class Auditor implements IAuditor {
	
	private final Collection<String> data = new ArrayList<String>();

	/* (non-Javadoc)
	 * @see com.offbeet.deterministic.IAuditor#add(java.lang.String)
	 */
	@Override
	public void add(String datum) {
		data.add(datum);
	}

	public List<String> getData(){
		return new ArrayList<String>(data);
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append('{');
		for (String string : data) {
			builder.append('"').append(string).append('"').append(',');
		}
		
		if(!data.isEmpty()){
			builder.deleteCharAt(builder.length()-1);
		}

		builder.append('}');
		return builder.toString();
	}
}
