package io.github.matthewjones2435;

/*
Copyright [2019] [Matthew Jones]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 *  Main Activity class, in context of the app only controls the bottom bar navigation
 * via a switch statement, to switch between {@link KeywordFragment}, {@link HaikuFragment}, and
 * {@link ResultsFragment}
 */

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
           toolbar.setTitle("Haiku[GA]   Results");
           fragment = new ResultsFragment();
           loadFragment(fragment);
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
