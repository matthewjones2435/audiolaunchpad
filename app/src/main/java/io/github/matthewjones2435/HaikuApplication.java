package io.github.matthewjones2435;

import android.app.Application;
import com.facebook.stetho.Stetho;
import io.github.matthewjones2435.model.HaikuDatabase;
import io.github.matthewjones2435.model.Keyword;

public class HaikuApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
