package com.mrboomdev.boomscrollix.extension;

import android.webkit.JavascriptInterface;
import com.mrboomdev.boomscrollix.util.HttpUtil;
import java.io.IOException;

public class Interface {
	private HttpUtil http = new HttpUtil();
	
	public Interface(Fragment a) {
		
	}
	
	@JavascriptInterface
	public String fetch(String url) {
		try {
			return http.fetch(url);
		} catch(IOException e) {
			e.printStackTrace();
			StringBuilder bobTheBuilder = new StringBuilder();
			bobTheBuilder.append("<BoomScrollixException>");
			bobTheBuilder.append(e);
			bobTheBuilder.append("</BoomScrollixException>");
			return bobTheBuilder.toString();
		}
	}
	
	@JavascriptInterface
	public void addHome(String result) {
		//TODO: Complete the lenta
	}
	
	public static enum pathType {
		EXTERNAL,
		INTERNAL,
		ASSETS
	}
	
	@JavascriptInterface
	public void getFile(String path, pathType pathType) {
		//TODO: Complete file method
	}
}