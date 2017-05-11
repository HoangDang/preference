package dnb.stackpreference;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ngodung on 5/11/17.
 */

public class ViewMain {

    private final Context context;

    private EditText txtRing;
    private EditText txtGreen;
    private EditText txtTotal;
    private Button btnNext;


    private void log(String msg) {
        Log.d("DNB", getClass().getName() + ">>" + msg);
    }

    public ViewMain(Context context) {
        this.context = context;
    }

    public View getView() {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main, null, false);


        txtRing = (EditText) view.findViewById(R.id.txt_main_ring);
        txtGreen = (EditText) view.findViewById(R.id.txt_main_green);
        txtTotal = (EditText) view.findViewById(R.id.txt_main_total);
        btnNext = (Button) view.findViewById(R.id.btn_main_next);

        addEvent();

        return view;
    }

    private void onChangeRing() {
        int ring = parserInt(txtRing);
        MyPreference.saveRing(ring);
    }

    private void onChangeGreen() {
        int green = parserInt(txtGreen);
        MyPreference.saveGreen(green);
    }

    private void onChangeTotal() {
        int total = parserInt(txtTotal);
        MyPreference.saveTotal(total);
    }

    private void onClickNext() {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }

    private int parserInt(EditText txt) {
        try {
            String input = txt.getText().toString().trim();
            if (input != null && !input.isEmpty()) {
                return Integer.parseInt(input);
            }
        } catch (Exception e) {
            log("err--" + e.toString());
        }
        return 0;
    }

    private void addEvent() {
        txtRing.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onChangeRing();
                log("ring change: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        txtGreen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onChangeGreen();
                log("green change: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtTotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onChangeTotal();
                log("total change: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNext();
            }
        });
    }


}
