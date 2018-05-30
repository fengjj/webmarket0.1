package com.sitech.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;



import org.apache.log4j.Logger;

import com.sitech.hsf.common.logger.LoggerFactory;
import com.sitech.market.busiobject.basicclass.BaseClass;

/**
 * 用HttpClient3 实现get、post及 ssl get、ssl post
 * 
 * @author Administrator
 * 
 */
public class HttpUtils extends BaseClass{


    private static Logger logger = Logger.getLogger(HttpUtils.class);

	public static String executeGet(String url) throws Exception {
		String content = null;
		byte[] responseBody = executeGetAsByte(url);
		// 处理内容
		content = new String(responseBody, "UTF-8");
		return content;
	}

	public static byte[] executeGetAsByte(String url) throws Exception {
		byte[] responseBody;
		// 定义HttpClient
		HttpClient client = new HttpClient();

		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

		// 实例化HTTP方法
		GetMethod getMethod = new GetMethod(url);
		getMethod.setRequestHeader("Content-Type", "text/html;charset=utf-8");

		// 使用系统提供的默认的恢复策略,此处HttpClient的恢复策略可以自定义（通过实现接口HttpMethodRetryHandler来实现）。
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

		// 设置读数据超时时间(单位毫秒)
		client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		// 设置连接超时时间(单位毫秒)
		client.getHttpConnectionManager().getParams().setSoTimeout(5000);

		try {
			// 执行getMethod
			int statusCode = client.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				throw new Exception(getMethod.getStatusText());
			}
			// 读取内容
			responseBody = getMethod.getResponseBody();
			// 处理内容

		} catch (Exception e) {
			throw e;
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}
		return responseBody;
	}

	public static String executePost(String url, String requestBody) throws Exception {

		String responseBody = "";
		PostMethod method = null;
		try {

			HttpClient client = new HttpClient();
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			client.getHttpConnectionManager().getParams()
			.setConnectionTimeout(5000);
			
			method = new PostMethod(url);
			method.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
			method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

			InputStream input = new ByteArrayInputStream(requestBody.getBytes("UTF-8"));
			method.setRequestEntity(new InputStreamRequestEntity(input));

			int statusCode = client.executeMethod(method);
			logger.info("http status = {}");
			if (HttpStatus.SC_OK == statusCode) {
				byte[] bys = method.getResponseBody();
				responseBody = new String(bys, "UTF-8");
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (method != null)
				method.releaseConnection();
		}
		return responseBody;
	}
	
	public static String executePostHttpConn(String url, String requestBody) throws Exception {
		HttpURLConnection connection = null;
		String response = "";
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			connection.getOutputStream().write(requestBody.getBytes("UTF-8"));
			connection.getOutputStream().flush();
			connection.getOutputStream().close();

			int code = connection.getResponseCode();
			logger.info( code);

			if (200 == code) {
				InputStream in = connection.getInputStream();
				StringBuffer out = new StringBuffer();
				byte[] b = new byte[4096];
				for (int n; (n = in.read(b)) != -1;) {
					out.append(new String(b, 0, n, "UTF-8"));
				}
				response = out.toString();
			}

		} catch (Exception e) {
			logger.error("http请求异常", e);
			throw e;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return response;
	}

	public static String executeSSLGet(String url) throws Exception {

		HttpsURLConnection connection = null;
		String response = "";
		try {

			connection = (HttpsURLConnection) new URL(url).openConnection();
			connection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setConnectTimeout(5000);

			int code = connection.getResponseCode();
			logger.info(code);

			if (200 == code) {
				InputStream in = connection.getInputStream();
				StringBuffer out = new StringBuffer();
				byte[] b = new byte[4096];
				for (int n; (n = in.read(b)) != -1;) {
					out.append(new String(b, 0, n, "UTF-8"));
				}
				response = out.toString();
			}

		} catch (Exception e) {
			logger.error("http请求异常", e);
			throw e;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

		logger.info(response);

		return response;
	}

	public static String executeSSLPost(String url, String request) throws Exception {
		logger.info("请求报文：\n{}"+request);

		HttpURLConnection connection = null;
		String response = "";
		try {

			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setConnectTimeout(5000);

			connection.getOutputStream().write(request.getBytes("UTF-8"));
			connection.getOutputStream().flush();
			connection.getOutputStream().close();

			int code = connection.getResponseCode();
			logger.info("http code : {}"+code);

			if (200 == code) {

				InputStreamReader ins = new InputStreamReader(connection.getInputStream(), "UTF-8");

				StringWriter output = new StringWriter();
				int n = 0;
				char[] buffer = new char[1024 * 4];
				while (-1 != (n = ins.read(buffer))) {
					output.write(buffer, 0, n);
				}
				response = output.toString();
			}

		} catch (Exception e) {
			logger.error("http请求异常", e);
			throw e;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

		logger.info("响应报文：{}"+ response);

		return response;
	}

	private static class MyTrustManager implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

	}

	private static class MyHostnameVerifier implements HostnameVerifier {
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	static {
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, new TrustManager[] { new MyTrustManager() }, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(new MyHostnameVerifier());
		} catch (Exception e) {

		}
	}

}
