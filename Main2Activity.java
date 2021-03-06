package com.vbh.hotel_billing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements itemnolistener{


    Globalclass gb1=null;
    TextView itno4=null;
    TextView itena4=null;
    TextView itqua4=null;
    TextView itpr4=null;
    TextView tot4=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button tkodr=findViewById(R.id.btm);
        Button print=findViewById(R.id.prtt1);
        Button edit=findViewById(R.id.edt1);
        TextView tot=findViewById(R.id.tot1);
        Globalclass gb=(Globalclass) getApplicationContext();
        final Intent main=new Intent(Main2Activity.this,MainActivity.class);

        TextView iteno=findViewById(R.id.i_no);
        TextView itena=findViewById(R.id.i_na);
        TextView quant=findViewById(R.id.i_qu);
        TextView pric=findViewById(R.id.i_pr);

        int il=gb.it.size();
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        int total=0;
        while(i<il)
        {
            itnu+=gb.itenoget(i);
            itnu+="\n";
            ite_na+=gb.itenaget(i);
            ite_na+="\n";
            itqu+=gb.quaget(i);
            itqu+="\n";
            itpri+=gb.priget(i);
            itpri+="\n";

            total+=Integer.parseInt(gb.quaget(i))*Integer.parseInt(gb.priget(i));

            i+=1;
        }
        iteno.setText(itnu);
        itena.setText(ite_na);
        quant.setText(itqu);
        pric.setText(itpri);

        tot.setText("Total :"+String.valueOf(total));

        tkodr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(main);
            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    void openDialog()
    {
        Dialog dig=new Dialog();
        dig.show(getSupportFragmentManager(),"Delete Item from list");

    }

    @Override
    public void senditemno(String ino) {

        gb1=(Globalclass)getApplicationContext();
        gb1.edit1(ino);

        final int il=gb1.it.size();
        int total=0;
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        while(i<il)
        {
            itnu+=gb1.itenoget(i);
            itnu+="\n";
            ite_na+=gb1.itenaget(i);
            ite_na+="\n";
            itqu+=gb1.quaget(i);
            itqu+="\n";
            itpri+=gb1.priget(i);
            itpri+="\n";

            total+=Integer.parseInt(gb1.quaget(i))*Integer.parseInt(gb1.priget(i));

            i+=1;
        }
        itno4=findViewById(R.id.i_no);
        itena4=findViewById(R.id.i_na);
        itqua4=findViewById(R.id.i_qu);
        itpr4=findViewById(R.id.i_pr);
        tot4=findViewById(R.id.tot1);

        itno4.setText(itnu);
        itena4.setText(ite_na);
        itqua4.setText(itqu);
        itpr4.setText(itpri);
        tot4.setText("Total :"+String.valueOf(total));
    }

}
