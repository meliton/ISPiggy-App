package ispiggy.nothing.com.ispiggy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.SocketException;
import java.text.MessageFormat;
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
                //TextView tv = (TextView) findViewById(R.id.lblName);
                //tv.setText("RandomName was pressed");
                // EditText rv = (EditText)findViewById(R.id.txtDomain);
                // rv.setText("RandomName");
                String strWeb;
                strWeb = makeDomainName();
                lblName.setText(sLblName + strWeb);
                txtDomain.setText(strWeb);

            }
        });

        ToCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // TextView tv = (TextView) findViewById(R.id.lblName);
               // tv.setText("ToCom was pressed");
               // EditText rv = (EditText) findViewById(R.id.txtDomain);
               // rv.setText("ToCom");
                String strDomain;
                strDomain = String.valueOf(txtDomain.getText());
                strDomain = String.valueOf(toDotCom(strDomain));
                txtDomain.setText(strDomain);

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
                //TextView tv = (TextView) findViewById(R.id.lblName);
                //tv.setText("MinusRand was pressed");
                //EditText rv = (EditText) findViewById(R.id.txtDomain);
                //rv.setText("MinusRand");
                String strDomain;
                strDomain = String.valueOf(txtDomain.getText());
                strDomain = String.valueOf(domainMinusRand(strDomain));
                txtDomain.setText(strDomain);

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
                // TextView tv = (TextView) findViewById(R.id.lblName);
                // tv.setText("MinusOne was pressed");
                // EditText rv = (EditText) findViewById(R.id.txtDomain);
                // rv.setText("MinusOne");
                String strDomain;
                strDomain = String.valueOf(txtDomain.getText());
                strDomain = String.valueOf(domainMinusOne(strDomain));
                txtDomain.setText(strDomain);

            }
        });
}
//////
// Procedure : makeDomainName
    public static String makeDomainName()
    {
        String sRandWeb;
        int iDomain;
        int x;

        String[] astrVowels;
        String[] astrConsonants;
        String[] astrTLDsuffix;

        astrVowels = new String[] {"a", "e", "i", "o", "u", "y"};
        astrConsonants = new String[] {"c", "d", "f", "h", "l", "m", "n", "r", "s", "t"};
        astrTLDsuffix = new String[] {".com", ".com", ".net", ".org"};

        sRandWeb = "";
        x = 0;

        int iMinDomain = 5; // minimum word size for domain name
        int iMaxDomain = 8; // maximum word size for domain name

        while ((x < (Integer) myRandom(iMinDomain, iMaxDomain))) {
            if (((Integer) isOdd(x) == 1)) {
                //  even number generates random vowel
                sRandWeb = (sRandWeb + astrVowels[(Integer) myRandom(0, (astrVowels.length-1))]);
            }
            else {
                //  odd number generates random consonant
                sRandWeb = (sRandWeb + astrConsonants[(Integer) myRandom(0, (astrConsonants.length-1))]);
            }

            x = (x + 1);
        }

        iDomain = (Integer) myRandom(0, (astrTLDsuffix.length - 1));
        //  get random domain suffix
        return (sRandWeb + astrTLDsuffix[iDomain]);
    }

    // Procedure : myRandom
    public static Object myRandom(int iMinVal, int iMaxVal)
    {
        return (int)Math.floor((double) (((iMaxVal - iMinVal) + 1) * Math.random()) + iMinVal);
    }

    // Procedure : isOdd
    public static Object isOdd(int iNumber)
    {
        Object tempisOdd;
        if ((int)Math.floor(iNumber) % 2 > 0)
        {
            tempisOdd = 0; // Odd Number, return 0
        }
        else
        {
            tempisOdd = 1; // Even Number, return 1
        }
        return tempisOdd;
    }

    // Procedure : toDotCom
    public static Object toDotCom(String strToCom)
    {
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
    public static Object domainMinusRand(String strDomain)
    {
        Object tempdomainMinusRand = null;  // remove null once this object is fixed below
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

    // Procedure : domainMinusOne
    public static Object domainMinusOne(String strDomain)
    {
        Object tempdomainMinusOne;
        int iLength;
        int iDotLoc;
        int iDomOnly;
        String sExtOnly;

        iLength = strDomain == null ? 0 : strDomain.length(); // get overall domain length
        iDotLoc = strDomain.indexOf(".") + 1; // get dot location in domain
        iDomOnly = (iLength - (iLength - iDotLoc + 1)); // get size of domain

        if (iDomOnly >= 3) // domain has at least two chars
        {
            // save extension into variable
            sExtOnly = strDomain.substring(iDotLoc - 1, iDotLoc - 1 + iLength - iDotLoc + 1);
            strDomain = strDomain.substring(0, iDomOnly); // save only domain into variable

            // remove last char in domain name and reassemble domain name
            tempdomainMinusOne = strDomain.substring(0, iDotLoc - 2) + sExtOnly;
            strDomain = (String) tempdomainMinusOne; // puts new domain in passed domain variable
        }
        return strDomain;
    }


}



