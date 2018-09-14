package com.seu.LexianSystem.util;

import com.alibaba.fastjson.serializer.SerializerFeature;

// 通用操作常量
public class Constant {
	
	private Constant(){
		
	}

	public static final String LEXIANUSERKEY = "lexianKey";
	
	public static final  int success_code = 0;
	
	public static final  int failed_code = 1;
	
	// 序列化格式定�?
	public static final SerializerFeature[] serializerFeatures = {
		SerializerFeature.QuoteFieldNames,	
		SerializerFeature.WriteNullNumberAsZero,
		SerializerFeature.WriteDateUseDateFormat,
		SerializerFeature.WriteNullListAsEmpty,
		SerializerFeature.WriteNullStringAsEmpty,
		SerializerFeature.WriteNullBooleanAsFalse,
		SerializerFeature.SkipTransientField 
	};
	
}
