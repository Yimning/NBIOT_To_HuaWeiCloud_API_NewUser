package com.yimning.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

import javax.net.ssl.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;


public class HttpUtils {
	public final static String HTTPGET = "GET";

	public final static String HTTPPUT = "PUT";

	public final static String HTTPPOST = "POST";

	public final static String HTTPDELETE = "DELETE";

	public final static String HTTPACCEPT = "Accept";

	public final static String CONTENT_LENGTH = "Content-Length";

	public final static String CHARSET_UTF8 = "UTF-8";

	private static CloseableHttpClient httpClient;

	/**
	 * Two-Way Authentication In the two-way authentication, the client needs: 
	 * 1 Import your own certificate for server verification; 
	 * 2 Import the CA certificate of the server, and use the CA certificate to verify the certificate sent by the server; 
	 * 3 Set the domain name to not verify (Non-commercial IoT platform, no use domain name access.)
	 * 
	 * */
	public void initSSLConfigForTwoWay() throws Exception {
		
		// 1 Import your own certificate
		String demo_base_Path = System.getProperty("user.dir");
		String selfcertpath = demo_base_Path + Constant.SELFCERTPATH;
		String trustcapath = demo_base_Path + Constant.TRUSTCAPATH;

		KeyStore selfCert = KeyStore.getInstance("pkcs12");
		selfCert.load(new FileInputStream(selfcertpath),
				Constant.SELFCERTPWD.toCharArray());
		KeyManagerFactory kmf = KeyManagerFactory.getInstance("sunx509");
		kmf.init(selfCert, Constant.SELFCERTPWD.toCharArray());

		// 2 Import the CA certificate of the server,
		KeyStore caCert = KeyStore.getInstance("jks");
		caCert.load(new FileInputStream(trustcapath), Constant.TRUSTCAPWD.toCharArray());
		TrustManagerFactory tmf = TrustManagerFactory.getInstance("sunx509");
		tmf.init(caCert);

		SSLContext sc = SSLContext.getInstance("TLS");
		sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

		// 3 Set the domain name to not verify
		// (Non-commercial IoT platform, no use domain name access generally.)
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sc, new DefaultHostnameVerifier());

		httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
				.build();
	}

	/**
	 * One-Way Authentication In the One-way authentication, the client needs: 
	 * 1 Import the CA certificate of the server, and use the CA certificate to verify the certificate sent by the server; 
	 * 2 Set the domain name to not verify (Non-commercial IoT platform, no use domain name access.)
	 *
	 * */
	/*
	 * public void initSSLConfigForOneWay() throws Exception {
	 * 
	 * // 1 Import the CA certificate of the server, 
	 * KeyStore caCert = KeyStore.getInstance("jks"); 
	 * caCert.load(new FileInputStream(TRUSTCAPATH), TRUSTCAPWD.toCharArray());
	 * TrustManagerFactory tmf = TrustManagerFactory.getInstance("sunx509");
	 * tmf.init(caCert);
	 * 
	 * SSLContext sc = SSLContext.getInstance("TLS"); 
	 * sc.init(null, tmf.getTrustManagers(), null);
	 * 
	 * // 2 Set the domain name to not verify // (Non-commercial IoT platform,
	 * no use domain name access generally.) 
	 * SSLSocketFactory ssf = new SSLSocketFactory(sc, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	 * 
	 * //If the platform has already applied for a domain name which matches the
	 * domain name in the certificate information, the certificate 
	 * //domain name check can be enabled (open by default) 
	 * // SSLSocketFactory ssf = new SSLSocketFactory(sc);
	 * 
	 * ClientConnectionManager ccm = this.getConnectionManager();
	 * SchemeRegistry sr = ccm.getSchemeRegistry(); 
	 * sr.register(new Scheme("https", 8743, ssf));
	 * 
	 * httpClient = new DefaultHttpClient(ccm); }
	 */

	public HttpResponse doPostJson(String url, Map<String, String> headerMap,
			String content) {
		HttpPost request = new HttpPost(url);
		addRequestHeader(request, headerMap);

		request.setEntity(new StringEntity(content,
				ContentType.APPLICATION_JSON));

		return executeHttpRequest(request);
	}
	
	   public StreamClosedHttpResponse doPostMultipartFile(String url, Map<String, String> headerMap,
	           File file) {
	        HttpPost request = new HttpPost(url);
	        addRequestHeader(request, headerMap);
	        
	        FileBody fileBody = new FileBody(file);
	        // Content-Type:multipart/form-data; boundary=----WebKitFormBoundarypJTQXMOZ3dLEzJ4b
	        HttpEntity reqEntity = (HttpEntity) MultipartEntityBuilder.create().addPart("file", fileBody).build();
	        request.setEntity(reqEntity);
	        
	        return (StreamClosedHttpResponse) executeHttpRequest(request);
	    }

	public StreamClosedHttpResponse doPostJsonGetStatusLine(
			String url, Map<String, String> headerMap, String content) {
		HttpPost request = new HttpPost(url);
		addRequestHeader(request, headerMap);

		request.setEntity(new StringEntity(content,
				ContentType.APPLICATION_JSON));

		HttpResponse response = executeHttpRequest(request);
		if (null == response) {
			System.out.println("The response body is null.");
		}

		return (StreamClosedHttpResponse) response;
	}

	public StreamClosedHttpResponse doPostJsonGetStatusLine(String url, String content) {
		HttpPost request = new HttpPost(url);

		request.setEntity(new StringEntity(content,
				ContentType.APPLICATION_JSON));

		HttpResponse response = executeHttpRequest(request);
		if (null == response) {
			System.out.println("The response body is null.");
		}

		return (StreamClosedHttpResponse) response;
	}
	
	private List<NameValuePair> paramsConverter(Map<String, String> params) {
		List<NameValuePair> nvps = new LinkedList<NameValuePair>();
		Set<Map.Entry<String, String>> paramsSet = params.entrySet();
		for (Map.Entry<String, String> paramEntry : paramsSet) {
			nvps.add(new BasicNameValuePair(paramEntry.getKey(), paramEntry
					.getValue()));
		}

		return nvps;
	}


	public StreamClosedHttpResponse doPostFormUrlEncodedGetStatusLine(
			String url, Map<String, String> formParams) throws Exception {
		HttpPost request = new HttpPost(url);

		request.setEntity(new UrlEncodedFormEntity(paramsConverter(formParams)));

		HttpResponse response = executeHttpRequest(request);
		if (null == response) {
			System.out.println("The response body is null.");
			throw new Exception();
		}

		return (StreamClosedHttpResponse) response;
	}

	public HttpResponse doPutJson(String url, Map<String, String> headerMap,
			String content) {
		HttpPut request = new HttpPut(url);
		addRequestHeader(request, headerMap);

		request.setEntity(new StringEntity(content,
				ContentType.APPLICATION_JSON));

		return executeHttpRequest(request);
	}
    
	public HttpResponse doPut(String url, Map<String, String> headerMap) {
		HttpPut request = new HttpPut(url);
		addRequestHeader(request, headerMap);
		
		return executeHttpRequest(request);
	}
	
	public StreamClosedHttpResponse doPutJsonGetStatusLine(String url, Map<String, String> headerMap,
			String content) {
		HttpResponse response = doPutJson(url, headerMap, content);
		if (null == response) {
			System.out.println("The response body is null.");
		}

		return (StreamClosedHttpResponse) response;
	}
	
	public StreamClosedHttpResponse doPutGetStatusLine(String url, Map<String, String> headerMap) {
		HttpResponse response = doPut(url, headerMap);
		if (null == response) {
			System.out.println("The response body is null.");
		}

		return (StreamClosedHttpResponse) response;
	}

	public HttpResponse doGetWithParas(String url,
			Map<String, String> queryParams, Map<String, String> headerMap)
			throws Exception {
		HttpGet request = new HttpGet();
		addRequestHeader(request, headerMap);

		URIBuilder builder;
		try {
			builder = new URIBuilder(url);
		} catch (URISyntaxException e) {
			System.out.printf("URISyntaxException: {}", e);
			throw new Exception(e);

		}

		if (queryParams != null && !queryParams.isEmpty()) {
			builder.setParameters(paramsConverter(queryParams));
		}
		request.setURI(builder.build());

		return executeHttpRequest(request);
	}

	public StreamClosedHttpResponse doGetWithParasGetStatusLine(String url,
			Map<String, String> queryParams, Map<String, String> headerMap)
			throws Exception {
		HttpResponse response = doGetWithParas(url, queryParams, headerMap);
		if (null == response) {
			System.out.println("The response body is null.");
		}

		return (StreamClosedHttpResponse) response;
	}

	public HttpResponse doDeleteWithParas(String url, 
			Map<String, String> queryParams, Map<String, String> headerMap)
			throws Exception {
		HttpDelete request = new HttpDelete(url);
		addRequestHeader(request, headerMap);
		
		URIBuilder builder;
		try {
			builder = new URIBuilder(url);
		} catch (URISyntaxException e) {
			System.out.printf("URISyntaxException: {}", e);
			throw new Exception(e);
		}
		
		if (queryParams != null && !queryParams.isEmpty()) {
			builder.setParameters(paramsConverter(queryParams));
		}
		request.setURI(builder.build());

		return executeHttpRequest(request);
	}

	public StreamClosedHttpResponse doDeleteWithParasGetStatusLine(String url,
			Map<String, String> queryParams, Map<String, String> headerMap)
			throws Exception {
		HttpResponse response = doDeleteWithParas(url, queryParams, headerMap);
		if (null == response) {
			System.out.println("The response body is null.");
		}

		return (StreamClosedHttpResponse) response;
	}

	private static void addRequestHeader(HttpUriRequest request,
			Map<String, String> headerMap) {
		if (headerMap == null) {
			return;
		}

		for (String headerName : headerMap.keySet()) {
			if (CONTENT_LENGTH.equalsIgnoreCase(headerName)) {
				continue;
			}

			String headerValue = headerMap.get(headerName);
			request.addHeader(headerName, headerValue);
		}
	}

	private HttpResponse executeHttpRequest(HttpUriRequest request) {
		HttpResponse response = null;

		try {
			response = httpClient.execute(request);
		} catch (Exception e) {
			System.out.println("executeHttpRequest failed.");
		} finally {
			try {
				response = new StreamClosedHttpResponse(response);
			} catch (IOException e) {
				System.out.println("IOException: " + e.getMessage());
			}
		}

		return response;
	}

	public String getHttpResponseBody(HttpResponse response)
			throws UnsupportedOperationException, IOException {
		if (response == null) {
			return null;
		}

		String body = null;

		if (response instanceof StreamClosedHttpResponse) {
			body = ((StreamClosedHttpResponse) response).getContent();
		} else {
			HttpEntity entity = response.getEntity();
			if (entity != null && entity.isStreaming()) {
				String encoding = entity.getContentEncoding() != null ? entity
						.getContentEncoding().getValue() : null;
				body = StreamUtils.inputStream2String(entity.getContent(),
						encoding);
			}
		}

		return body;
	}




	public void initClient() throws KeyManagementException, NoSuchAlgorithmException {
		SSLContext sslcontext = getSSLContent();
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE))
				.build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		RequestConfig.Builder builder = RequestConfig.custom();
		RequestConfig requestConfig = builder.build();
		httpClient = HttpClients.custom().setConnectionManager(connManager).setDefaultRequestConfig(requestConfig).build();
	}

	public SSLContext getSSLContent() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("TLSv1.2");

		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		sc.init(null, new TrustManager[]{trustManager}, null);
		return sc;
	}

	public StreamClosedHttpResponse doPost(String url, Map<String, String> headerMap, String body) {
		HttpPost httpPost = new HttpPost(url);
		addHeader(headerMap, httpPost);
		httpPost.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));
		return (StreamClosedHttpResponse)execute(httpPost);

	}

	public StreamClosedHttpResponse doGet(String url, Map<String, String> headerMap, Map<String, String> params) throws URISyntaxException {
		HttpGet httpGet = new HttpGet(url);
		addHeader(headerMap, httpGet);
		URIBuilder uriBuilder = null;
		try {
			uriBuilder = new URIBuilder(url);
		} catch (URISyntaxException e) {
			System.out.println(e);
		}
		if (params != null && !params.isEmpty()) {
			uriBuilder.setParameters(convertParams(params));
		}
		httpGet.setURI(uriBuilder.build());
		return (StreamClosedHttpResponse)execute(httpGet);

	}

	public String constructUri(String url, Map<String, String> params) throws URISyntaxException {
		URIBuilder uriBuilder = null;
		try {
			uriBuilder = new URIBuilder(url);
		} catch (URISyntaxException e) {
			System.out.println(e);
		}
		if (params != null && !params.isEmpty()) {
			uriBuilder.setParameters(convertParams(params));
		}
		return uriBuilder.build().toString();

	}

	public List<NameValuePair> convertParams(Map<String, String> params) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		for (String paramKey : params.keySet()) {
			list.add(new BasicNameValuePair(paramKey, params.get(paramKey)));
		}
		return list;
	}


	private void addHeader(Map<String, String> headerMap, HttpUriRequest request) {
		if (headerMap == null) {
			return;
		}

		for (String headerName : headerMap.keySet()) {
			if (CONTENT_LENGTH.equalsIgnoreCase(headerName)) {
				continue;
			}
			String headValue = headerMap.get(headerName);
			request.addHeader(headerName, headValue);
		}
	}

	public HttpResponse execute(HttpUriRequest request) {

		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				return new StreamClosedHttpResponse(response);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		return null;
	}


}
