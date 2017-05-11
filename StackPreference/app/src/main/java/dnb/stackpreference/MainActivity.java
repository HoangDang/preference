package dnb.stackpreference;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {


    private ViewMain view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyPreference.getInstance(getApplicationContext());

        view = new ViewMain(this);
        setContentView(view.getView());
    }
}
