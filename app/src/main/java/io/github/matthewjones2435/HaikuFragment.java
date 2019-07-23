package io.github.matthewjones2435;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

// import io.github.matthewjones2435.viewmodel.HaikuViewModel;


public class HaikuFragment extends Fragment {

  //  private HaikuViewModel viewModel;
  private Context context;
  private ListView randomWordsList;

  public HaikuFragment() {

  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.context = context;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    final View view = inflater.inflate(R.layout.fragment_haiku, container, false);
    final ListView testResponse = view.findViewById(R.id.display_haiku);

//    viewModel = ViewModelProviders.of(this).get(HaikuViewModel.class);
//    getLifecycle().addObserver(viewModel);
//    viewModel.getRandomWords(null).observe(this, (randomWords) -> {
//      ArrayAdapter<ApiWords> adapter = new ArrayAdapter<>(context, R.layout.list_white_text, randomWords);
//      randomWordsList.setAdapter(adapter);

//    });
//

    final EditText testSearch = view.findViewById(R.id.testing_search);
    final Button testButton = view.findViewById(R.id.testing_api);

//  testButton.setOnClickListener((v) -> viewModel.getRandomWords(testSearch.getText().toString().trim()));

    return view;
  }

}
