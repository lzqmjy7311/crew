package com.gbicc.generator;

import java.util.ArrayList;
import java.util.List;

public class CompositeVariableGenerator{
	private List<IVariableGenerator<?>> generators =new ArrayList<IVariableGenerator<?>>();
	private Counter counter;
	
	public CompositeVariableGenerator add(IVariableGenerator<?> generator) {
		generators.add(generator);
		initCounter();
		return this;
	}
	
	public CompositeVariableGenerator add(List<IVariableGenerator<?>> generators) {
		for(IVariableGenerator<?> generator : generators){
			this.generators.add(generator);
		}
		initCounter();
		return this;
	}

	public boolean hasNext() {
		return counter.hasNext();
	}

	public List<Object> next() {
		List<Object> result =new ArrayList<Object>();
		int[] indexs =counter.next();
		for(int i=0;i<indexs.length;i++){
			result.add(generators.get(i).getValues().get(indexs[i]));
		}
		return result;
	}
	private void initCounter(){
		int[] max =new int[generators.size()];
		for(int i=0;i<generators.size();i++){
			max[i] =generators.get(i).getValues().size()-1;
		}
		counter =new Counter(max);
	}
	
	static class Counter {
		private int[] pointer;
		private int[] max;
		
		public Counter(int[] max){
			this.max =max;
			this.pointer =new int[max.length];
			this.pointer[max.length-1] =-1;
		}
		
		public boolean hasNext(){
			for(int i=0;i<pointer.length; i++){
				if(pointer[i]!=max[i]){
					return true;
				}
			}
			return false;
		}
		
		public int[] next(){
			int p =pointer.length-1;
			while(p>=0){
				pointer[p]++;
				if(pointer[p]>max[p]){
					pointer[p]=0;
					p--;
				}else{
					break;
				}
			}
			
			return pointer;
		}
	}
}


