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

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.github.matthewjones2435.model.Keyword;
import io.github.matthewjones2435.viewmodel.KeywordViewModel;
import java.util.List;

/**
 * Keyword Fragment allow user to interact with the keywords entity {@link Keyword} and store
 *  the input material into the database {@link io.github.matthewjones2435.model.HaikuDatabase}
 */

public class KeywordFragment extends Fragment {

  private String userText;
  private int clickCount = 0;
  private int listClickCount = 0;
  private Context context;

  public KeywordFragment() {

  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.context = context;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {


    final View view = inflater.inflate(R.layout.fragment_keyword, container, false);
    final ListView keywordsList = view.findViewById(R.id.keyword_list);
    final KeywordViewModel viewModel = ViewModelProviders
        .of(getActivity()).get(KeywordViewModel.class);

    viewModel.getKeywordsLiveData().observe(this, new Observer<List<Keyword>>() {
      @Override
      public void onChanged(List<Keyword> keywords) {
        final ArrayAdapter<Keyword> adapter = new ArrayAdapter<Keyword>(context,
            R.layout.list_white_text,
            keywords);
        keywordsList.setAdapter(adapter);
      }
    });

    final TextView keywordOne = view.findViewById(R.id.user_input_one);
    final TextView keywordTwo = view.findViewById(R.id.user_input_two);
    final Button newKeyword = view.findViewById(R.id.input_keyword);
    final EditText enterKeyword = view.findViewById(R.id.enter_keyword);

    newKeyword.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        clickCount = clickCount + 1;
        String inputOne = enterKeyword.getText().toString();
        String inputTwo = enterKeyword.getText().toString();
        Keyword newKeyword = new Keyword();
        newKeyword.setUserInput(enterKeyword.getText().toString());
        viewModel.addKeyword(newKeyword);
        enterKeyword.setText("");
        if (clickCount <= 1) {
          keywordOne.setText(inputOne);
          keywordOne.setVisibility(View.VISIBLE);
          clickCount = clickCount + clickCount;
        } else {
          keywordTwo.setText(inputTwo);
          keywordTwo.setVisibility(View.VISIBLE);
          clickCount = 0;
        }
      }
    });

    final Button buildHaiku = view.findViewById(R.id.haiku_build_button);
    buildHaiku.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Fragment fragment = new HaikuFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
      }
    });

    final Button liveInThePast = view.findViewById(R.id.populate_list);
    liveInThePast.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        listClickCount = listClickCount + 1;
        if (listClickCount <= 1) {
          keywordsList.setVisibility(View.VISIBLE);
          listClickCount = listClickCount + 1;
        } else {
          keywordsList.setVisibility(View.INVISIBLE);
          listClickCount = 0;
        }
      }
    });

    return view;
  }
}
