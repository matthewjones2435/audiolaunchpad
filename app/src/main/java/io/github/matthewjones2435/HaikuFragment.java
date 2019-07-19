package io.github.matthewjones2435;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.github.matthewjones2435.model.ApiWords;
import io.github.matthewjones2435.viewmodel.HaikuViewModel;
import java.util.List;


public class HaikuFragment extends Fragment{

  private Context context;
  private ListView randomWordsList;

  public HaikuFragment()  {

  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.context = context;
  }

  @Override
  public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){

    final View view = inflater.inflate(R.layout.fragment_haiku, container, false);
    final HaikuViewModel viewModel = ViewModelProviders.of(getActivity()).get(HaikuViewModel.class);

    final EditText testSearch =  view.findViewById(R.id.testing_search);
    final Button testButton = view.findViewById(R.id.testing_api);

  testButton.setOnClickListener((v) -> viewModel.getRandomWords(testSearch.getText().toString().trim()));


    return view;
  }

}
