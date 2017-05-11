package dnb.stackpreference;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by ngodung on 5/11/17.
 */

public class SecondActivity extends Activity {
    private ViewSecond view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new ViewSecond(this);
        setContentView(view.getView());
    }

}
