package io.github.matthewjones2435.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import io.github.matthewjones2435.model.HaikuDatabase;
import io.github.matthewjones2435.model.Keyword;
import java.util.List;

public class KeywordViewModel extends AndroidViewModel {

  private LiveData<List<Keyword>> keywords;

  public KeywordViewModel(@NonNull Application application) {
    super(application);
    HaikuDatabase db = HaikuDatabase.getInstance(application);
    keywords = db.keywordDao().getAll();
  }

  public LiveData<List<Keyword>> getKeywordsLiveData() {
    return keywords;
  }

  public void addKeyword (final Keyword keyword) {
    new Thread(new Runnable()  {
      @Override
          public void run() {
        HaikuDatabase db = HaikuDatabase.getInstance(getApplication());
        db.keywordDao().insert(keyword);
      }
    }).start();
  }
}
