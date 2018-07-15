package com.koujiang.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koujiang.framework.util.validation.VNETookit;



/**
 * <br>(c) Copyright 2017 koujiang901123@sina.com
 * <br>@description	:基于 httpclient 4.3.1版本的 http工具类
 * <br>@file_name	:HttpTookit.java
 * <br>@author		:koujiang 
 * <br>@create_time	:2017年11月21日 下午10:19:55
 * <br>@mender		:(Please add the modifier name)
 * <br>@Modified	:(Please add modification date)
 * <br>@varsion		:v1.0.0
 */
public class HttpTookit {

	private static final CloseableHttpClient httpClient;
	public static final String CHARSET = "UTF-8";
	private static final Logger logger = LoggerFactory.getLogger(HttpTookit.class);

	static {
		String MaxTotal = null;// PropertyUtil.getPropertyByKey("httpclient.MaxTotal");
		String MaxPerRoute = null;//PropertyUtil.getPropertyByKey("httpclient.MaxPerRoute");
		if (VNETookit.isNull(MaxTotal)) {
			MaxTotal = "100";
		}
		if (VNETookit.isNull(MaxPerRoute)) { //Blank
			MaxPerRoute = "100";
		}
		RequestConfig config = RequestConfig.custom().setConnectTimeout(6 * 60 * 1000)
				.setSocketTimeout(6 * 60 * 1000).build();
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(Integer.valueOf(MaxTotal));//连接池最大并发连接数
		cm.setDefaultMaxPerRoute(Integer.valueOf(MaxPerRoute));//单路由最大并发数
		httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).setConnectionManager(cm).build();
	}

	public static String doGet(String url, Map<String, String> params) throws Exception {
		return doGet(url, params, null, CHARSET);
	}

	public static String doPost(String url, Map<String, String> params) throws Exception {
		return doPost(url, params, null, CHARSET);
	}

	public static String doDelete(String url, Map<String, String> params) throws Exception {
		return doDelete(url, params, null, CHARSET);
	}

	public static String doPut(String url, Map<String, String> params) throws Exception {
		return doPut(url, params, null, CHARSET);
	}

	public static String doGet(String url, Map<String, String> params, Map<String, String> headers) throws Exception {
		return doGet(url, params, headers, CHARSET);
	}

	public static String doPost(String url, Map<String, String> params, Map<String, String> headers) throws Exception {
		return doPost(url, params, headers, CHARSET);
	}

	public static String doDelete(String url, Map<String, String> params, Map<String, String> headers) throws Exception {
		return doDelete(url, params, headers, CHARSET);
	}

	public static String doPostWithJson(String url, String json, Map<String, String> headers) throws Exception {
		return doPostWithJson(url, json, headers, CHARSET);
	}

	public static String doPut(String url, Map<String, String> params, Map<String, String> headers) throws Exception {
		return doPut(url, params, headers, CHARSET);
	}

	public static String doPutWithJson(String url, String json, Map<String, String> headers) throws Exception {
		return doPutWithJson(url, json, headers, CHARSET);
	}

	/**
	 * HTTP Get 获取内容
	 *
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 * @throws Exception 
	 */
	public static String doGet(String url, Map<String, String> params, Map<String, String> headers, String charset) throws Exception {
		if (VNETookit.isNull(url)) {
			return null;
		}
		try {
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
				url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
			}
			HttpGet httpGet = new HttpGet(url);
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					httpGet.addHeader(entry.getKey(), entry.getValue());
				}
			}
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6 * 60 * 1000)
					.setConnectTimeout(6 * 60 * 1000).build();// 设置请求和传输超时时间
			httpGet.setConfig(requestConfig);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpGet.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			httpGet.releaseConnection();
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		//return null;
	}

	/**
	 * HTTP Post 获取内容
	 *
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 * @throws Exception 
	 */
	public static String doPost(String url, Map<String, String> params, Map<String, String> headers, String charset) throws Exception {
		if (VNETookit.isNull(url)) {
			return null;
		}
		try {
			List<NameValuePair> pairs = null;
			if (params != null && !params.isEmpty()) {
				pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
			}
			HttpPost httpPost = new HttpPost(url);
			if (pairs != null && pairs.size() > 0) {
				httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
			}
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					httpPost.addHeader(entry.getKey(), entry.getValue());
				}
			}
			CloseableHttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			httpPost.releaseConnection();
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
//		return null;
	}

	/**
	 * HTTP Post 获取内容
	 *
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 * @throws Exception 
	 */
	public static String doPostWithJson(String url, String json, Map<String, String> headers, String charset) throws Exception {
		if (VNETookit.isNull(url)) {
			return null;
		}
		try {
			HttpPost httpPost = new HttpPost(url);
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					httpPost.addHeader(entry.getKey(), entry.getValue());
				}
			}
			StringEntity s = new StringEntity(json, "UTF-8");
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");//发送json数据需要设置contentType
			httpPost.setEntity(s);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			httpPost.releaseConnection();
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
//		return null;
	}

	/**
	 * HTTP Delete 获取内容
	 *
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 * @throws Exception 
	 */
	public static String doDelete(String url, Map<String, String> params, Map<String, String> headers, String charset) throws Exception {
		if (VNETookit.isNull(url)) {
			return null;
		}
		try {
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
				url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
			}
			HttpDelete httpDelete = new HttpDelete(url);
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					httpDelete.addHeader(entry.getKey(), entry.getValue());
				}
			}
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6 * 60 * 1000)
					.setConnectTimeout(6 * 60 * 1000).build();// 设置请求和传输超时时间
			httpDelete.setConfig(requestConfig);
			CloseableHttpResponse response = httpClient.execute(httpDelete);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpDelete.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			httpDelete.releaseConnection();
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
//		return null;
	}

	/**
	 * HTTP Post 获取内容
	 *
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 * @throws Exception 
	 */
	public static String doPut(String url, Map<String, String> params, Map<String, String> headers, String charset) throws Exception {
		if (VNETookit.isNull(url)) {
			return null;
		}
		try {
			List<NameValuePair> pairs = null;
			if (params != null && !params.isEmpty()) {
				pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
			}
			HttpPut httpPut = new HttpPut(url);
			if (pairs != null && pairs.size() > 0) {
				httpPut.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
			}
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					httpPut.addHeader(entry.getKey(), entry.getValue());
				}
			}
			CloseableHttpResponse response = httpClient.execute(httpPut);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPut.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			httpPut.releaseConnection();
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
//		return null;
	}

	public static String doPutWithJson(String url, String json, Map<String, String> headers, String charset) throws Exception {
		if (VNETookit.isNull(url)) {
			return null;
		}
		try {
			HttpPut httpPut = new HttpPut(url);
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					httpPut.addHeader(entry.getKey(), entry.getValue());
				}
			}
			StringEntity s = new StringEntity(json, "UTF-8");
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");//发送json数据需要设置contentType
			httpPut.setEntity(s);
			CloseableHttpResponse response = httpClient.execute(httpPut);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPut.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			httpPut.releaseConnection();
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);;
			//throw new RuntimeException(e);
			throw e;
		}
		//return null;
	}

}