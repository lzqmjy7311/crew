package com.gbicc.generator;

import java.util.ArrayList;
import java.util.List;

public class VariableGenerator<T> implements IVariableGenerator<T>{
	private List<T> values =new ArrayList<T>();
	private int nextIndex;
	
	@Override
	public IVariableGenerator<T> addNull() {
		values.add(null);
		return this;
	}

	@Override
	public VariableGenerator<T> add(T value){
		values.add(value);
		return this;
	}
	
	@Override
	public VariableGenerator<T> add(List<T> values){
		for(T value : values){
			this.values.add(value);
		}
		return this;
	}
	
	@Override
	public List<T> getValues() {
		return values;
	}

	@Override
	public boolean hasNext(){
		return nextIndex<values.size();
	}
	
	@Override
	public T next(){
		return values.get(nextIndex++);
	}
	
	public static void main(String[] args) {
		IVariableGenerator<String> g =new VariableGenerator<String>();
		g.add("a").add("b");
		while(g.hasNext()){
			System.out.println(g.next());
		}
	}
}
