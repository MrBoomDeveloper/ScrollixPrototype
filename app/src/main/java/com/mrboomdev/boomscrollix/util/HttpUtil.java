package com.mrboomdev.boomscrollix.util;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
	private OkHttpClient http = new OkHttpClient();
	public String userAgent;
	
	public HttpUtil(String userAgent) {
		this.userAgent = userAgent;
	}
	
	public HttpUtil() {
		this.userAgent = "Mozilla/5.0 (Linux; Android 11; SM-A105F Build/RP1A.200720.012) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/106.0.5245.0 Mobile Safari/537.36";
	}
	
	public String fetch(String url) throws IOException { 
		 Request request = new Request.Builder()
		 	.url(url)
			 .header("User-Agent", this.userAgent)
			 .build();
		 try(Response response = http.newCall(request).execute()) {
			 return response.body().string();
		 }
	}
}