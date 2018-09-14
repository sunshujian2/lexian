package com.seu.LexianSystem.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.seu.LexianSystem.service.BaseService;

@Service
public class SystemInfoServiceImpl extends BaseService {
	public Map<Object,Object> getSystemInfo(final String ...keys){
       if(keys==null||keys.length==0)
    	   return System.getProperties();
       return new HashMap<Object,Object>(){
    	   private static final long serialVersionUID = 1L;
    	   {
    		   for(String key:keys){
    			   put(key,System.getProperty(key));
    		   }
    	   }
       };
	};
}
