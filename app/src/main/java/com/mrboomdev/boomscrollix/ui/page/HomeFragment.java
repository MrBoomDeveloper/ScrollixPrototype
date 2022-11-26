package com.mrboomdev.boomscrollix.ui.page;

import android.R;
import android.os.Bundle;
import android.os.StrictMode;
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
import com.mrboomdev.boomscrollix.util.HttpUtil;
import com.mrboomdev.boomscrollix.extension.Interface;

public class HomeFragment extends Fragment {
	private FragmentHomeBinding binding;
	private HttpUtil http = new HttpUtil();
	private String result = "";

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	Log.i("fragment", "HomeFragment.onCreateView");
    	binding = FragmentHomeBinding.inflate(inflater, container, false);
    	View root = binding.getRoot();

    	TextView textView = binding.textHome;
		WebView webview = binding.webview;
		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webview.addJavascriptInterface(new Interface(), "boomScrollix");
		webview.loadData("<script>boomScrollix.log();</script>", "text/html", "UTF-8");
    	textView.setText(result);
    	return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}