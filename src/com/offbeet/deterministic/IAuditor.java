package com.offbeet.deterministic;

public interface IAuditor {

	public abstract void add(String datum);

	public abstract boolean isEmpty();

}