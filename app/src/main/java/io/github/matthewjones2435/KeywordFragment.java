package io.github.matthewjones2435;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.github.matthewjones2435.model.Keyword;
import io.github.matthewjones2435.viewmodel.KeywordViewModel;
import java.security.Key;
import java.util.List;

public class KeywordFragment extends Fragment {

  private Context context;

  public KeywordFragment() {

  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.context = context;
  }


  @Override
  public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){

    final View view = inflater.inflate(R.layout.fragment_keyword, container, false);
    final ListView keywordsList = view.findViewById(R.id.keyword_list);
    final KeywordViewModel viewModel = ViewModelProviders
        .of(getActivity()).get(KeywordViewModel.class);

    viewModel.getKeywordsLiveData().observe(this, new Observer<List<Keyword>>() {
      @Override
      public void onChanged(List<Keyword> keywords) {
        final ArrayAdapter<Keyword> adapter =  new ArrayAdapter<Keyword>(context,R.layout.list_white_text ,
            keywords);
      }
    });


   // Button goAllRandom = view.findViewById(R.id.go_all_random);
    Button newHaiku = view.findViewById(R.id.haiku_build_button);
    EditText enterKeyword = view.findViewById(R.id.enter_keyword);

    final Button newKeyword = view.findViewById(R.id.input_keyword);
    newKeyword.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        EditText keywordEditText = view.findViewById(R.id.enter_keyword);
        Keyword newKeyword = new Keyword();
        newKeyword.setUserInput(keywordEditText.getText().toString());
        viewModel.addKeyword(newKeyword);
        keywordEditText.setText("");
      }
    });

    return view;
  }
}
