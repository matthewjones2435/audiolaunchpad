package io.github.matthewjones2435.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.github.matthewjones2435.model.ApiWords;
import io.github.matthewjones2435.service.WordsApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class HaikuViewModel extends AndroidViewModel {

  private MutableLiveData<List<String>> randomWords;
  private CompositeDisposable pending = new CompositeDisposable();

  public HaikuViewModel(@NonNull Application application) {
    super(application);
  }

  public MutableLiveData<List<String>> getRandomWords(String query) {
    if (randomWords == null) {
      randomWords = new MutableLiveData<>();
    }
     pending.add (
         WordsApiService.getInstance().randomWords(query)
         .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
         .subscribe((words)-> randomWords.setValue(words))
     );
    return randomWords;
  }

}
