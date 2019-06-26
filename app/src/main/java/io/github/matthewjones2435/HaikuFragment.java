package io.github.matthewjones2435;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;


public class HaikuFragment extends Fragment{

  private Context context;

  public HaikuFragment() {

  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.context = context;
  }

  @Override
  public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){

    final View view = inflater.inflate(R.layout.fragment_haiku, container, false);
    TextView textView = view.findViewById(R.id.display_haiku);

    return view;
  }
}
