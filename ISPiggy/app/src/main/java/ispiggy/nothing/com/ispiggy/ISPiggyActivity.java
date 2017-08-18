package ispiggy.nothing.com.ispiggy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ISPiggyActivity extends AppCompatActivity {

    // Declare interactive elements
    Button btnStart;
    Button btnStop;
    Button RandomName;
    Button ToCom;
    Button GetIP;
    Button MinusRand;
    CheckBox ChkDebug;

    TextView lblName;
    EditText txtDomain;

    String sLblName = "Random Domain: "; // random domain label set

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
        ChkDebug=(CheckBox)findViewById(R.id.ChkDebug);

        lblName = (TextView) findViewById(R.id.lblName);
        txtDomain = (EditText) findViewById(R.id.txtDomain);

        // turn off debug buttons
        RandomName.setVisibility(View.GONE);
        ToCom.setVisibility(View.GONE);
        GetIP.setVisibility(View.GONE);
        MinusRand.setVisibility(View.GONE);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GetDomain
                RandomName.callOnClick();  // get a new domain name
                GetIP.callOnClick(); // getIP to see if it's valid

                // loop start 5 times here
          for (int i = 0; i < 5; i++){
                    String tmpLabel;
                    tmpLabel = String.valueOf(lblName.getText());

                    // check is valid domain is returned "not found!"
                    if (tmpLabel.contains("not found")) {
                        // check for dot com
                        tmpLabel = String.valueOf(txtDomain.getText());
                        if (tmpLabel.contains(".com")) {
                            MinusRand.callOnClick();    // remove a random char
                            GetIP.callOnClick();        // check IP
                        } else {
                            ToCom.callOnClick();        // change to dot com
                            GetIP.callOnClick();        // check IP
                        }
                    } else {
                        //btnStart.callOnClick();
                    }
                }
                // end loop here
                // check if STOP was pressed
                    // yes pressed, then end
                    // else Random Name and set i to 0 ????
               //  btnStart.callOnClick();
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
                String strWeb;
                strWeb = makeDomainName();
                lblName.setText(sLblName + strWeb);
                txtDomain.setText(strWeb);
            }
        });

        ToCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strDomain;
                strDomain = String.valueOf(txtDomain.getText());
                strDomain = String.valueOf(toDotCom(strDomain));
                txtDomain.setText(strDomain);
            }
        });

        GetIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String strDomain = String.valueOf(txtDomain.getText());
                String keepStrDomain = String.valueOf(txtDomain.getText());
                try
                {
                    strDomain = new NetTask().execute(strDomain).get();
                    lblName.setText(sLblName +  keepStrDomain + " is " + strDomain);
                 }
                catch(Exception e1)
                {
                    // exception is unrecoverable here and the program will crash :(
                }
            }
        });

        MinusRand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strDomain;
                strDomain = String.valueOf(txtDomain.getText());
                strDomain = String.valueOf(domainMinusRand(strDomain));
                txtDomain.setText(strDomain);
            }
        });


        ChkDebug.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ChkDebug.isChecked()) {
                    // unhide the buttons and disable START button
                    btnStart.setVisibility(View.GONE);
                    btnStop.setVisibility(View.GONE);
                    RandomName.setVisibility(View.VISIBLE);
                    ToCom.setVisibility(View.VISIBLE);
                    GetIP.setVisibility(View.VISIBLE);
                    MinusRand.setVisibility(View.VISIBLE);
                } else {
                    // hide the lower buttons and enable the START/START buttons
                    btnStart.setVisibility(View.VISIBLE);
                    btnStop.setVisibility(View.VISIBLE);
                    RandomName.setVisibility(View.GONE);
                    ToCom.setVisibility(View.GONE);
                    GetIP.setVisibility(View.GONE);
                    MinusRand.setVisibility(View.GONE);
                }
            }
        });
    }


// Procedure : makeDomainName
    public static String makeDomainName() {
        String sRandWeb;
        int iDomain;
        int x;

        String[] astrVowels;
        String[] astrConsonants;
        String[] astrTLDsuffix;

        astrVowels = new String[]{"a", "e", "i", "o", "u", "y"};
        astrConsonants = new String[]{"c", "d", "f", "h", "l", "m", "n", "r", "s", "t"};
        astrTLDsuffix = new String[]{".com", ".com", ".net", ".org"};

        sRandWeb = "";
        x = 0;

        int iMinDomain = 5; // minimum word size for domain name
        int iMaxDomain = 8; // maximum word size for domain name

        while ((x < (Integer) myRandom(iMinDomain, iMaxDomain))) {
            if (((Integer) isOdd(x) == 1)) {
                //  even number generates random vowel
                sRandWeb = (sRandWeb + astrVowels[(Integer) myRandom(0, (astrVowels.length - 1))]);
            } else {
                //  odd number generates random consonant
                sRandWeb = (sRandWeb + astrConsonants[(Integer) myRandom(0, (astrConsonants.length - 1))]);
            }
            x = (x + 1);
        }

        iDomain = (Integer) myRandom(0, (astrTLDsuffix.length - 1));
        //  get random domain suffix
        return (sRandWeb + astrTLDsuffix[iDomain]);
    }

    // Procedure : myRandom
    public static Object myRandom(int iMinVal, int iMaxVal) {
        return (int) Math.floor((double) (((iMaxVal - iMinVal) + 1) * Math.random()) + iMinVal);
    }

    // Procedure : isOdd
    public static Object isOdd(int iNumber) {
        Object tempIsOdd;
        if ((int) Math.floor(iNumber) % 2 > 0) {
            tempIsOdd = 0; // Odd Number, return 0
        } else {
            tempIsOdd = 1; // Even Number, return 1
        }
        return tempIsOdd;
    }

    // Procedure : toDotCom
    public static Object toDotCom(String strToCom) {
        int iLength;
        int iDotLoc;
        int iDomOnly;

        iLength = strToCom == null ? 0 : strToCom.length(); // get overall domain length
        iDotLoc = strToCom.indexOf(".") + 1; // get dot location in domain
        iDomOnly = (iLength - (iLength - iDotLoc + 1)); // get size of domain

        if (iDomOnly >= 2) // domain has at least two chars
        {
            // save only domain into variable and add .com
            strToCom = strToCom.substring(0, iDomOnly) + ".com";
        }
        return strToCom;
    }

    // Procedure : domainMinusRand
    public static Object domainMinusRand(String strDomain) {
        int iLength;
        int iDotLoc;
        int iDomOnly;
        int iRndChar;
        String sExtOnly;
        String sRndChar;

        iLength = strDomain == null ? 0 : strDomain.length(); // get overall domain length
        iDotLoc = strDomain.indexOf(".") + 1; // get dot location in domain
        iDomOnly = (iLength - (iLength - iDotLoc + 1)); // get size of domain

        if (iDomOnly >= 3) // domain has at least two chars
        {
            // save extension into variable
            sExtOnly = strDomain.substring(iDotLoc - 1, iDotLoc - 1 + iLength - iDotLoc + 1);
            strDomain = strDomain.substring(0, iDomOnly); // save only domain into variable

            iRndChar = (Integer) myRandom(1, iDomOnly); // get random char int location from domain length
            sRndChar = strDomain.substring(iRndChar - 1, iRndChar - 1 + 1); // gets random char from domain

            strDomain = strDomain.replaceFirst(sRndChar, "") + sExtOnly; // removes random char
        }
        return strDomain;
    }

    // Class to handle async network thread : NetTask
    public class NetTask extends AsyncTask<String, Integer, String>
    {
        @Override
        protected String doInBackground(String... params)
        {
            InetAddress addr = null;
            try
            {
                addr = InetAddress.getByName(params[0]);
            }
            catch (UnknownHostException e)
            {
                String myMsg = "not found!";
                return myMsg;
            }
            return addr.getHostAddress();
        }
    }

}
