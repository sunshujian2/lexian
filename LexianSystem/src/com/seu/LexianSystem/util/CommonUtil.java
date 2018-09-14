package com.seu.LexianSystem.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.web.multipart.MultipartFile;

public class CommonUtil { 
	
	private CommonUtil(){
		
	};
	/**
	 * @param request �?要获取ip的请�?
	 * @return ip地址
	 */
    public static String getClientIp(HttpServletRequest request){
    	
    		String ip = request.getHeader("x-forwarded-for");
    		if (StringUtils.isNullOrEmpty(ip)|| "unknown".equalsIgnoreCase(ip)) {
    			ip = request.getHeader("Proxy-Client-IP");
    		}
    		if (StringUtils.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
    			ip = request.getHeader("WL-Proxy-Client-IP");
    		}
    		if (StringUtils.isNullOrEmpty(ip)|| "unknown".equalsIgnoreCase(ip)) {
    			ip = request.getRemoteAddr();
    		}
    		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    	}
    
    /**
     * 
     * @param request 
     * @return 返回请求是否为异步请�?
     */
    public static boolean isAjaxAction(HttpServletRequest request){
      return "XMLHttpRequest".equals(request.getHeader("x-requested-with"))|| "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
   
    
    
   
    /**
     * 删除文件
     * @param  path
     * @return true删除成功   false删除失败
     */
    public static boolean delFile(String webFilePath,String url){
    	File file =  new File(webFilePath,url.substring(url.lastIndexOf('/')));
    	if(null!=file&&file.exists()&&file.isFile()){
    		return file.delete();
    	}
    	return false;
    	
    }

	/**
     * 
     * @param str  �?要escape的字符串
     * @return  返回替代后的字符�? 防止js注入工具
     */
    public static String escapeHtmltoString(String str){
    	if(str==null)
    		return null;
    	StringBuilder sbBuilder = new StringBuilder();
    	for(int index=0;index<str.length();index++){
    		char ch = str.charAt(index);
    		switch (ch) {
			case '<':
				sbBuilder.append("&lt;");
				break;
			case '>':
				sbBuilder.append("&gt;");
				break;
			default:
				sbBuilder.append(ch);
			    break;
			}
    	}
    	return sbBuilder.toString();
    }
    
  
    
    /**
     * @param str �?要计算长度的字符�?
     * @return 字符串实际长�? 
     */
    public static int getLengthOfStr(String str){
    	int count = 0;
    	char []chs = str.toCharArray();
    	for(char ch:chs){
    		//通过Unicode判断是中�?
    	  if(ch>='\u0391' && ch<='\uFFE5'){
    		 count+= 2; 
    	  }
    	  else{
    		  count+= 1; 
    	  }
    	}
    	return count;
    }
    
    /**
     * 
     * @param str �?要校验的字符�?
     * @return  是否包含汉子 不包含返回true
     */
    public static boolean hasNoZhWord(String str){
    	return !hasZhWord(str);
    }
    
    
    public static boolean hasZhWord(String str){
    	char []chs = str.toCharArray();
    	for(char ch:chs){
    		//通过Unicode判断是中�?
    	  if(ch>='\u0391' && ch<='\uFFE5'){
    		 return  true;
    	  }
    	}
    	return false;
    }
    
   /**
    *
    * @param joinChar 间隔�?
    * @param objects �?要拼接的字符串数�?
    * @return
    */
    public static String joinList(String joinChar,String ...objects){
    	if(objects==null)
    		return "";
    	StringBuffer sbBuffer = new StringBuffer();
    	int index  = 0;
    	for(Object object:objects){
    		if(index++>0)
    			sbBuffer.append(joinChar);
    		sbBuffer.append(String.valueOf(object));
    	}
    	return sbBuffer.toString();
    	
    }
    
    /**
     * 
     * @param object 
     * @param str  
     * @return 缓存key
     * @throws IllegalAccessException
     */
    public  static String getSingleCacheKey(Object object,String ...str) throws  IllegalAccessException{
    	StringBuilder stringBuilder = new StringBuilder(); 
        Class<?>clazz = object.getClass();
    	if(str==null||str.length==0)
    		return String.valueOf(object.hashCode());
    	for(String tmp:str){
    	    Field field = FieldUtils.getDeclaredField(clazz, tmp, true);
    	    if(field!=null){
    	    	 Object value = field.get(object);
    	    	 if(value!=null){
    	    		 stringBuilder.append(field.getName().toLowerCase()).append(String.valueOf(value));
    	    	 }
    	    }
    	}
    	return stringBuilder.toString();
    }
    
	/**
	 * 验证客户端上传的文件是否是图�?
	 * @param file
	 * @return 
	 */

	public static boolean isImage(MultipartFile file)
	{ 
		if(file==null||file.isEmpty()){
			return false;
		}
		return StringUtils.isImage(file.getOriginalFilename());
	}


	/**
	 * 验证某个文件是否是图片文�?
	 * @param file
	 * @return
	 */
	public static boolean isImage(File file)
	{ 
		if(file==null||!file.exists()){
			return false;
		}
		return StringUtils.isImage(file.getName());
	}

	/**
	 *  深度克隆
	 * @param oldObj �?要克隆的对象
	 * @return 返回克隆后的对象
	 */
	public final static Object clone(Serializable oldObj) {
		Object newObj = null;
		ByteArrayOutputStream byteoutput = null;
		try {
			byteoutput = new ByteArrayOutputStream();
			ObjectOutputStream objouput = new ObjectOutputStream(byteoutput);
			objouput.writeObject(oldObj);
			objouput.flush();
			ByteArrayInputStream byteinput = new ByteArrayInputStream(
					byteoutput.toByteArray());
			ObjectInputStream objinput = new ObjectInputStream(byteinput);
			newObj = objinput.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newObj;
	}
	
	public static boolean startWithIgnoreCace(String origin,String prefix){
		String or = origin.toLowerCase();
		if(StringUtils.isNullOrEmpty(or))
			return false;
		if(StringUtils.isNullOrEmpty(prefix))
			return false;
		if(or.length()<prefix.length())
			return false;
		for(int i=0;i<prefix.length();i++){
			if(or.charAt(i)!=prefix.charAt(i))
				return false;
		}
		return true;
	}

	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列�?
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {

		}
		finally {
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				oos =null;
			}
			if(baos!=null){
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				baos=null;
			}
		}
		return null;
	}
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		if(bytes==null||bytes.length==0)
			return null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
	
		return null;
	}

}
