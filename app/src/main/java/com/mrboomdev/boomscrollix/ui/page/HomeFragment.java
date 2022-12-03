package com.mrboomdev.boomscrollix.ui.page;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.mrboomdev.boomscrollix.databinding.FragmentHomeBinding;
import com.mrboomdev.boomscrollix.extension.JsConnector;

public class HomeFragment extends Fragment {
	private FragmentHomeBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	Log.i("fragment", "HomeFragment.onCreateView");
    	binding = FragmentHomeBinding.inflate(inflater, container, false);
    	View root = binding.getRoot();
		
    	TextView textView = binding.textHome;
		textView.setText("test");
		WebView webview = binding.jsEngine;
		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webview.addJavascriptInterface(new JsConnector((String data) -> {
			getActivity().runOnUiThread(() -> {
				textView.setText(data);
			});
		}), "boomScrollix");
		webview.loadData("<script>const a = boomScrollix.fetch('https://habr.com'); boomScrollix.addHome('Данный текст пришел прям из JS! ' + a);</script>", "text/html", "UTF-8");
		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}