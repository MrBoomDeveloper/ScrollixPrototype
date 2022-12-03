package com.mrboomdev.boomscrollix;

import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.elevation.SurfaceColors;
import com.mrboomdev.boomscrollix.databinding.ActivityMainBinding;
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

    setSupportActionBar(findViewById(R.id.appbar));
    BottomNavigationView navView = findViewById(R.id.nav_view);
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
    NavigationUI.setupWithNavController(binding.navView, navController);
  }

  private void applyTheme() {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    int color = SurfaceColors.SURFACE_2.getColor(this);
    getWindow().setStatusBarColor(color);
    getWindow().setNavigationBarColor(color);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
	  getMenuInflater().inflate(R.menu.main_topbar, menu);
    return super.onCreateOptionsMenu(menu);
  }
}
