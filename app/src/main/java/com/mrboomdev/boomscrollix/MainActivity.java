package com.mrboomdev.boomscrollix;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.elevation.SurfaceColors;
import com.mrboomdev.boomscrollix.databinding.ActivityMainBinding;
import com.mrboomdev.boomscrollix.extension.Loader;
import com.itsaky.androidide.logsender.LogSender;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
	private ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("activity", "MainActivity.onCreate");
		this.applyTheme();
		LogSender.startLogging(this);

		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_browse, R.id.navigation_settings, R.id.navigation_profile)
            .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
    
    private void applyTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
		int color = SurfaceColors.SURFACE_2.getColor(this);
		getWindow().setStatusBarColor(color);
		getWindow().setNavigationBarColor(color);
    }
}