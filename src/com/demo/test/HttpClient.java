package com.demo.test;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clientTest("https://www.baidu.com/","");

	}
	public static String  clientTest(String url, String json){
		   json="";
		   // ����Httpclient����
	       CloseableHttpClient httpClient = HttpClients.createDefault();
	       CloseableHttpResponse response = null;
	       String resultString = "";
	       try {
	           // ����Http Post����
	           HttpPost httpPost = new HttpPost(url);
	           // ������������
	           StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
	           System.out.println("������"+json);
	           httpPost.setEntity(entity);
	           // ִ��http����
	           response = httpClient.execute(httpPost);
	           resultString = EntityUtils.toString(response.getEntity(), "utf-8");
	           System.out.println("�����"+resultString);
	       } catch (Exception e) {
	           e.printStackTrace();
	           System.out.println(e.getMessage());
	       } finally {
	           try {
	               response.close();
	           } catch (IOException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	               System.out.println(e.getMessage());
	           }
	       }

	       return resultString;
	   }
}
