package com.gbicc.util;

import java.util.UUID;

public class StringUtil {
	public static String uuid(int length){
		return UUID.randomUUID().toString().substring(0, length-1);
	}
}
