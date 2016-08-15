package com.lv.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;


public class HtttpUntil {
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	// 聚合数据key
	public static final String APPKEY = "3a018b45bd73145d4768e2f742d3f1da";
	//百度key
	public static final String Ak = "POyNOqE95AL4AENyabSxsLXB2cXuUSiU";

	// 影视搜索
	public static String  getRequest1(String name) {
		String result = null;
		String url = "http://op.juhe.cn/onebox/movie/video";//�ַ
		Map params = new HashMap();// �������
		params.put("key", APPKEY);
		params.put("dtype", "json");
		params.put("q", name);

		try {
			result = net(url, params, "GET");

			JSONObject object = new JSONObject(result);

	
			if (object.getInt("error_code") == 0) {
				
			} else {
				System.out.println(object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public static String getRequest2(String cityname) {
		String result = null;
		String url = "http://op.juhe.cn/onebox/movie/pmovie";// ����ӿڵ�ַ

		Map params = new HashMap();
		params.put("key", APPKEY);
		params.put("dtype", "json");
		params.put("city", cityname);

		try {
			result = net(url, params, "POST");
			JSONObject object = new JSONObject(result);

			// JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				//System.out.println(object.get("result"));
			} else {
				System.out.println(object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 调用placeapi
	public static String nettobaidu(String city, String q) throws Exception {
		Map params = new HashMap();
		params.put("q", q);
		params.put("scope", "2");
		params.put("region", city);
		params.put("output", "json");
		params.put("ak", Ak);
		String result = "";
		String ur = "http://api.map.baidu.com/place/v2/search";
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer();
		HttpURLConnection con = null;
		try {
			String s = "";
			String strurl=ur+"?"+urlencode(params);
			URL url = new URL(strurl);	
			con = (HttpURLConnection) url.openConnection();
			con.connect();
			System.out.println("99999999999999..............88888888888888");
			InputStream in = con.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in,DEF_CHATSET));
			while ((s= reader.readLine()) != null) {
				buffer.append(s);
			}
			result = buffer.toString();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();

			}
			if (con != null) {
				con.disconnect();
			}

		}

		return result;
	}

	/**
	 *
	 * @param strUrl
	 *            �����ַ
	 * @param params
	 *            �������
	 * @param method
	 *            ���󷽷�
	 * @return ���������ַ���
	 * @throws Exception
	 */
	public static String net(String strUrl, Map params, String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				// get��ʽֱ��д��url��
				strUrl = strUrl + "?" + urlencode(params);

			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals("POST")) {
				try {
					// post��ʽ�ڽ������Ӻ�
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception e) {

				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	// ��map��תΪ���������
	public static String urlencode(Map<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + 
						"", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
