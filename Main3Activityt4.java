package com.vbh.hotel_billing_system;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activityt4 extends AppCompatActivity implements itemnolistener{

    Globalclass gb=null;
    Globalclass gb4=null;
    TextView itno4=null;
    TextView itena4=null;
    TextView itqua4=null;
    TextView itpr4=null;
    TextView tot4=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activityt4);
        Button tkodr=findViewById(R.id.butntkord4);
        final TextView tot=findViewById(R.id.tot4);
        Button print=findViewById(R.id.prnt4);
        Button edit=findViewById(R.id.edit4);
        gb=(Globalclass)getApplicationContext();

        final Intent main=new Intent(Main3Activityt4.this,MainActivity.class);
        final TextView iteno=findViewById(R.id.itnoip4);
        final TextView itena=findViewById(R.id.itnaip4);
        final TextView quant=findViewById(R.id.itquip4);
        final TextView pric=findViewById(R.id.itprip4);

        final int il=gb.t4it.size();
        int total=0;
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        while(i<il)
        {
            itnu+=gb.t4itenoget(i);
            itnu+="\n";
            ite_na+=gb.t4itenaget(i);
            ite_na+="\n";
            itqu+=gb.t4quaget(i);
            itqu+="\n";
            itpri+=gb.t4priget(i);
            itpri+="\n";

            total+=Integer.parseInt(gb.t4quaget(i))*Integer.parseInt(gb.t4priget(i));

            i+=1;
        }
        iteno.setText(itnu);
        itena.setText(ite_na);
        quant.setText(itqu);
        pric.setText(itpri);
        tot.setText("Total :"+String.valueOf(total));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        tkodr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(main);
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

        gb4=(Globalclass)getApplicationContext();
        gb4.edit(ino);

        final int il=gb4.t4it.size();
        int total=0;
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        while(i<il)
        {
            itnu+=gb4.t4itenoget(i);
            itnu+="\n";
            ite_na+=gb4.t4itenaget(i);
            ite_na+="\n";
            itqu+=gb4.t4quaget(i);
            itqu+="\n";
            itpri+=gb4.t4priget(i);
            itpri+="\n";

            total+=Integer.parseInt(gb4.t4quaget(i))*Integer.parseInt(gb4.t4priget(i));

            i+=1;
        }
        itno4=findViewById(R.id.itnoip4);
        itena4=findViewById(R.id.itnaip4);
        itqua4=findViewById(R.id.itquip4);
        itpr4=findViewById(R.id.itprip4);
        tot4=findViewById(R.id.tot4);

        itno4.setText(itnu);
        itena4.setText(ite_na);
        itqua4.setText(itqu);
        itpr4.setText(itpri);
        tot4.setText("Total :"+String.valueOf(total));
    }
}

