package io.github.matthewjones2435;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  private ActionBar toolbar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toolbar = getSupportActionBar();
    toolbar.setTitle("Haiku[GA]   Enter Keywords");
    loadFragment(new KeywordFragment());

    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
  }

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      Fragment fragment;
      switch (item.getItemId()) {
        case R.id.fragment_keyword:
          toolbar.setTitle("Haiku[GA]   Enter Keywords");
          fragment = new KeywordFragment();
          loadFragment (fragment);
          return true;
        case R.id.fragment_haiku:
          toolbar.setTitle("Haiku[GA]   Your Haiku");
          fragment = new HaikuFragment();
          loadFragment(fragment);
          return true;
        case R.id.results:
          // mTextMessage.setText(R.string.title_results);
          return true;
        
      }
      return false;
    }
  };

  private void loadFragment(Fragment fragment){
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.container, fragment);
    transaction.addToBackStack(null);
    transaction.commit();
  }

}
