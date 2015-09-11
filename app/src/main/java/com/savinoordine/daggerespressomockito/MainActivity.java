package com.savinoordine.daggerespressomockito;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject
    Alphabet alphabet;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DemoApplication) getApplication()).component().inject(this);

        textView = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(alphabet.getStringA());
            }
        });
    }
}
