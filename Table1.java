package com.vbh.hotel_billing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Table1 extends AppCompatActivity implements itemnolistener{
    Globalclass gb4=null;
    TextView itno4=null;
    TextView itena4=null;
    TextView itqua4=null;
    TextView itpr4=null;
    TextView tot4=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table1);
        Button serve=findViewById(R.id.button1);
        Button print=findViewById(R.id.prt1);
        Button edit=findViewById(R.id.edtt1);
        TextView tot=findViewById(R.id.tott1);
        Globalclass gb=(Globalclass) getApplicationContext();
        final Intent main=new Intent(Table1.this,MainActivity.class);


            TextView iteno=findViewById(R.id.i_no);
            TextView itena=findViewById(R.id.i_na);
            TextView quant=findViewById(R.id.i_qu);
            TextView pric=findViewById(R.id.i_pr);

            Intent intent=getIntent();
            String itno=intent.getStringExtra("item_no");
            String itna=intent.getStringExtra("item_name");
            String quanti=intent.getStringExtra("Q");
            String pri=intent.getStringExtra("price");

            gb.itnoset(itno);
            gb.itnaset(itna);
            gb.quaset(quanti);
            gb.priset(pri);

        int il=gb.it.size();
        String itnu="",ite_na="",itqu="",itpri="";
        int total=0;
        int i=0;
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



        serve.setOnClickListener(new View.OnClickListener() {
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
        gb4.edit1(ino);

        final int il=gb4.it.size();
        int total=0;
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        while(i<il)
        {
            itnu+=gb4.itenoget(i);
            itnu+="\n";
            ite_na+=gb4.itenaget(i);
            ite_na+="\n";
            itqu+=gb4.quaget(i);
            itqu+="\n";
            itpri+=gb4.priget(i);
            itpri+="\n";

            total+=Integer.parseInt(gb4.quaget(i))*Integer.parseInt(gb4.priget(i));

            i+=1;
        }
        itno4=findViewById(R.id.i_no);
        itena4=findViewById(R.id.i_na);
        itqua4=findViewById(R.id.i_qu);
        itpr4=findViewById(R.id.i_pr);
        tot4=findViewById(R.id.tott1);

        itno4.setText(itnu);
        itena4.setText(ite_na);
        itqua4.setText(itqu);
        itpr4.setText(itpri);
        tot4.setText("Total :"+String.valueOf(total));
    }
}
