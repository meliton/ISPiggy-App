package ispiggy.nothing.com.ispiggy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class ISPiggyActivity extends AppCompatActivity {

// Declare interactive elements
    Button btnStart;
    Button btnStop;
    Button RandomName;
    Button ToCom;
    Button GetIP;
    Button MinusRand;
    Button Rnd01;
    Button MinusOne;

    TextView lblName;
    EditText txtDomain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ispiggy);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        RandomName = (Button) findViewById(R.id.RandomName);
        ToCom = (Button) findViewById(R.id.ToCom);
        GetIP = (Button) findViewById(R.id.GetIP);
        MinusRand = (Button) findViewById(R.id.MinusRand);
        Rnd01 = (Button) findViewById(R.id.Rnd01);
        MinusOne = (Button) findViewById(R.id.MinusOne);

        lblName = (TextView) findViewById(R.id.lblName);
        txtDomain = (EditText) findViewById(R.id.txtDomain);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.lblName);
                tv.setText("START was pressed");
                EditText rv = (EditText) findViewById(R.id.txtDomain);
                rv.setText("START");
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.lblName);
                tv.setText("STOP was pressed");
                EditText rv = (EditText) findViewById(R.id.txtDomain);
                rv.setText("STOP");
            }
        });

        RandomName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.lblName);
                tv.setText("RandomName was pressed");
                // EditText rv = (EditText)findViewById(R.id.txtDomain);
                // rv.setText("RandomName");


            }
        });

        ToCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.lblName);
                tv.setText("ToCom was pressed");
                EditText rv = (EditText) findViewById(R.id.txtDomain);
                rv.setText("ToCom");
            }
        });

        GetIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.lblName);
                tv.setText("GetIP was pressed");
                EditText rv = (EditText) findViewById(R.id.txtDomain);
                rv.setText("GetIP");
            }
        });

        MinusRand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.lblName);
                tv.setText("MinusRand was pressed");
                EditText rv = (EditText) findViewById(R.id.txtDomain);
                rv.setText("MinusRand");
            }
        });

        Rnd01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.lblName);
                tv.setText("Rnd01 was pressed");
                EditText rv = (EditText) findViewById(R.id.txtDomain);
                rv.setText("Rnd01");
            }
        });

        MinusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.lblName);
                tv.setText("MinusOne was pressed");
                EditText rv = (EditText) findViewById(R.id.txtDomain);
                rv.setText("MinusOne");
            }
        });







    }}


