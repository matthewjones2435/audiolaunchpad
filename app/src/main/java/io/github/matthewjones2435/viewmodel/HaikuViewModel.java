package io.github.matthewjones2435.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.github.matthewjones2435.model.ApiWords;
import io.github.matthewjones2435.service.WordsApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class HaikuViewModel extends AndroidViewModel {

  private MutableLiveData<List<ApiWords>> randomWords;
  private CompositeDisposable pending = new CompositeDisposable();

  public HaikuViewModel(@NonNull Application application) {
    super(application);
  }

  public MutableLiveData<List<ApiWords>> getRandomWords() {
    if (randomWords == null) {
      randomWords = new MutableLiveData<>();
    }
     pending.add (
         WordsApiService.getInstance().randomWords()
         .subscribeOn(AndroidSchedulers.mainThread())
         .subscribe((words)-> randomWords.setValue(words))
     );
    return randomWords;
  }

}
