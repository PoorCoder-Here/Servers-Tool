package com.vbh.hotel_billing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Table2 extends AppCompatActivity implements itemnolistener{
    Globalclass gb4=null;
    TextView itno4=null;
    TextView itena4=null;
    TextView itqua4=null;
    TextView itpr4=null;
    TextView tot4=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table2);
        Button serve=findViewById(R.id.btn2);
        Button print=findViewById(R.id.prt2);
        Button edit=findViewById(R.id.edt2);
        TextView tot=findViewById(R.id.tot2);
        Globalclass gb=(Globalclass) getApplicationContext();
        final Intent main=new Intent(Table2.this,MainActivity.class);


        TextView iteno=findViewById(R.id.i_no);
        TextView itena=findViewById(R.id.i_na);
        TextView quant=findViewById(R.id.i_qu);
        TextView pric=findViewById(R.id.i_pr);

        Intent tab2=getIntent();
        String itno=tab2.getStringExtra("item_no");
        String itna=tab2.getStringExtra("item_name");
        String quanti=tab2.getStringExtra("Q");
        String pri=tab2.getStringExtra("price");

        gb.t2itnoset(itno);
        gb.t2itnaset(itna);
        gb.t2quaset(quanti);
        gb.t2priset(pri);

        int il=gb.t2it.size();
        String itnu="",ite_na="",itqu="",itpri="";
        int total=0;
        int i=0;
        while(i<il)
        {
            itnu+=gb.t2itenoget(i);
            itnu+="\n";
            ite_na+=gb.t2itenaget(i);
            ite_na+="\n";
            itqu+=gb.t2quaget(i);
            itqu+="\n";
            itpri+=gb.t2priget(i);
            itpri+="\n";
            total+=Integer.parseInt(gb.t2quaget(i))*Integer.parseInt(gb.t2priget(i));
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

        serve.setOnClickListener(new View.OnClickListener() {
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
        gb4.edit2(ino);

        final int il=gb4.t2it.size();
        int total=0;
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        while(i<il)
        {
            itnu+=gb4.t2itenoget(i);
            itnu+="\n";
            ite_na+=gb4.t2itenaget(i);
            ite_na+="\n";
            itqu+=gb4.t2quaget(i);
            itqu+="\n";
            itpri+=gb4.t2priget(i);
            itpri+="\n";

            total+=Integer.parseInt(gb4.t2quaget(i))*Integer.parseInt(gb4.t2priget(i));

            i+=1;
        }
        itno4=findViewById(R.id.i_no);
        itena4=findViewById(R.id.i_na);
        itqua4=findViewById(R.id.i_qu);
        itpr4=findViewById(R.id.i_pr);
        tot4=findViewById(R.id.tot2);

        itno4.setText(itnu);
        itena4.setText(ite_na);
        itqua4.setText(itqu);
        itpr4.setText(itpri);
        tot4.setText("Total :"+String.valueOf(total));
    }
}
