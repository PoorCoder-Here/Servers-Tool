package com.vbh.hotel_billing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activityt3 extends AppCompatActivity implements itemnolistener{
    Globalclass gb4=null;
    TextView itno4=null;
    TextView itena4=null;
    TextView itqua4=null;
    TextView itpr4=null;
    TextView tot4=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activityt3);
        Button tkodr=findViewById(R.id.btm3);
        Button edit=findViewById(R.id.edtt3);
        TextView tot=findViewById(R.id.tott3);
        Button print=findViewById(R.id.prtt3);
        Globalclass gb=(Globalclass) getApplicationContext();
        final Intent main=new Intent(Main3Activityt3.this,MainActivity.class);

        TextView iteno=findViewById(R.id.i_no);
        TextView itena=findViewById(R.id.i_na);
        TextView quant=findViewById(R.id.i_qu);
        TextView pric=findViewById(R.id.i_pr);

        int il=gb.t3it.size();
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        int total=0;
        while(i<il)
        {
            itnu+=gb.t3itenoget(i);
            itnu+="\n";
            ite_na+=gb.t3itenaget(i);
            ite_na+="\n";
            itqu+=gb.t3quaget(i);
            itqu+="\n";
            itpri+=gb.t3priget(i);
            itpri+="\n";
            total+=Integer.parseInt(gb.t3quaget(i))*Integer.parseInt(gb.t3priget(i));
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

        gb4=(Globalclass)getApplicationContext();
        gb4.edit3(ino);

        final int il=gb4.t3it.size();
        int total=0;
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        while(i<il)
        {
            itnu+=gb4.t3itenoget(i);
            itnu+="\n";
            ite_na+=gb4.t3itenaget(i);
            ite_na+="\n";
            itqu+=gb4.t3quaget(i);
            itqu+="\n";
            itpri+=gb4.t3priget(i);
            itpri+="\n";

            total+=Integer.parseInt(gb4.t3quaget(i))*Integer.parseInt(gb4.t3priget(i));

            i+=1;
        }
        itno4=findViewById(R.id.i_no);
        itena4=findViewById(R.id.i_na);
        itqua4=findViewById(R.id.i_qu);
        itpr4=findViewById(R.id.i_pr);
        tot4=findViewById(R.id.tott3);

        itno4.setText(itnu);
        itena4.setText(ite_na);
        itqua4.setText(itqu);
        itpr4.setText(itpri);
        tot4.setText("Total :"+String.valueOf(total));
    }
}
