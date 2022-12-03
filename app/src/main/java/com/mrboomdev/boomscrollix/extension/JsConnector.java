package com.mrboomdev.boomscrollix.extension;

import android.webkit.JavascriptInterface;
import com.mrboomdev.boomscrollix.extension.UpdateHandler;
import com.mrboomdev.boomscrollix.util.HttpUtil;
import java.io.IOException;

public class JsConnector {
	private HttpUtil http = new HttpUtil();
	private UpdateHandler handler;
	
	public JsConnector(UpdateHandler handler) {
		this.handler = handler;
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
		handler.update(result);
	}
	
	public static enum pathType {
		EXTERNAL,
		INTERNAL,
		ASSETS
	}
	
	@JavascriptInterface
	public String getFile(String path, pathType pathType) {
		return "";
	}
}