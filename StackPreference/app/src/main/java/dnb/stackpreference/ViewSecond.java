package dnb.stackpreference;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ngodung on 5/11/17.
 */

public class ViewSecond {

    private final Context context;

    private TextView lblRing;
    private TextView lblGreen;
    private TextView lblTotal;
    private Button btnBack;


    private void log(String msg) {
        Log.d("DNB", getClass().getName() + ">>" + msg);
    }

    public ViewSecond(Context context) {
        this.context = context;
    }

    public View getView() {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_second, null, false);


        lblRing = (TextView) view.findViewById(R.id.lbl_second_ring);
        lblGreen = (TextView) view.findViewById(R.id.lbl_second_green);
        lblTotal = (TextView) view.findViewById(R.id.lbl_second_total);
        btnBack = (Button) view.findViewById(R.id.btn_second_back);


        initValueDefault();
        addEvent();

        return view;
    }

    private void initValueDefault() {
        lblRing.setText(String.valueOf(MyPreference.getRing()));
        lblGreen.setText(String.valueOf(MyPreference.getGreen()));
        lblTotal.setText(String.valueOf(MyPreference.getTotal()));
    }

    private void addEvent() {


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNext();
            }
        });
    }

    private void onClickNext() {
        ((Activity) context).finish();
    }

}
