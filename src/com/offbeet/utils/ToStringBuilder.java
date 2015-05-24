package com.offbeet.utils;

public class ToStringBuilder {
	
	private static char start = '[';
	private static char end = ']';
	private static char classDelim = ':';
	private static char nameValueDelim = '=';
	private static char delim = ',';
	
	private StringBuilder builder = new StringBuilder();
	
	public ToStringBuilder(Object o) {
		builder.append(start);
		builder.append(o.getClass());
		builder.append(classDelim);
	}

	public static ToStringBuilder forObject(Object o){
		return new ToStringBuilder(o);
	}

	public ToStringBuilder add(String name, Object value){
		builder.append(start);
		builder.append(name);
		builder.append(nameValueDelim);
		builder.append(value);
		builder.append(end);
		builder.append(delim);
		
		return this;
	}
	
	@Override
	public String toString(){
		int endIndex = builder.length() - 1;
		builder.deleteCharAt(endIndex);
		builder.append(end);
		return builder.toString();
	}
}
