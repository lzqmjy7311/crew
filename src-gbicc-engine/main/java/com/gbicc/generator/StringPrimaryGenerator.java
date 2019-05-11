package com.gbicc.generator;

import java.util.UUID;

public class StringPrimaryGenerator implements IPrimaryGenerator<String>{
	private int length =0;
	
	public StringPrimaryGenerator(){
	}
	
	public StringPrimaryGenerator(int length){
		this.length =length;
	}
	
	@Override
	public String next() {
		String uuid =UUID.randomUUID().toString();
		if(length>0){
			return uuid.substring(0, length);
		}
		return uuid;
	}
}
