package com.offcn.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 请求工具类
 * @author Administrator
 *
 */
public class RequestUtil {
	  /**
	   * @作用 使用urlconnection
	   * @param url
	   * @param Params
	   * @return
	   * @throws IOException
	   */
	  public static Map<String, Object> sendPost(String url,String Params, HashMap<String, String> headers)throws IOException{
			OutputStreamWriter out = null;
			BufferedReader reader = null;
			String response="";
			try {
				URL httpUrl = null; //HTTP URL类 用这个类来创建连接
				//创建URL
				httpUrl = new URL(url);
				//建立连接
				HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("connection", "keep-alive");
				//处理头
				Set<String> keySet = headers.keySet();
				for (String key : keySet) {
					conn.setRequestProperty(key, headers.get(key));
				}
				conn.setUseCaches(false);//设置不要缓存
				conn.setInstanceFollowRedirects(true);
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.connect();
				//POST请求
				out = new OutputStreamWriter(
				      conn.getOutputStream());
				out.write(Params);
				out.flush();
				//读取响应
				reader = new BufferedReader(new InputStreamReader(
				      conn.getInputStream()));
				String lines;
				while ((lines = reader.readLine()) != null) {
					  lines = new String(lines.getBytes(), "utf-8");
					  response+=lines;
				}
				reader.close();
				// 断开连接
				conn.disconnect();
			} catch (Exception e) {
				System.out.println("发送 POST 请求出现异常！"+e);
				e.printStackTrace();
			}
		    //使用finally块来关闭输出流、输入流
		    finally {
			    try{
			    	if(out!=null){
			    		out.close();
			    	}
			    	if(reader!=null){
			    		reader.close();
			    	}
			    }
			    catch(IOException ex){
			      ex.printStackTrace();
			    }
		    }
				
			//转换一下
			
			ObjectMapper mapper = new ObjectMapper();
	
			Map<String, Object> map = new HashMap<String, Object>();
	
			// convert JSON string to Map
			map = mapper.readValue(response, new TypeReference<Map<String, Object>>(){});
			
		    return map;
	  }
}
