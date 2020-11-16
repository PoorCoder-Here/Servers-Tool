package com.vbh.hotel_billing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Table4 extends AppCompatActivity implements itemnolistener{
    Globalclass gb4=null;
    TextView itno4=null;
    TextView itena4=null;
    TextView itqua4=null;
    TextView itpr4=null;
    TextView tot4=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table4);
        Button serve=findViewById(R.id.buttn4);
        Button edit=findViewById(R.id.edt4);
        TextView tot=findViewById(R.id.tott4);
        Button print=findViewById(R.id.pnt4);
        Globalclass gb=(Globalclass) getApplicationContext();
        final Intent main=new Intent(Table4.this,MainActivity.class);

        TextView iteno=findViewById(R.id.i_no);
        TextView itena=findViewById(R.id.i_na);
        TextView quant=findViewById(R.id.i_qu);
        TextView pric=findViewById(R.id.i_pr);

        Intent tab4=getIntent();
        String itno=tab4.getStringExtra("item_no");
        String itna=tab4.getStringExtra("item_name");
        String quanti=tab4.getStringExtra("Q");
        String pri=tab4.getStringExtra("price");

        gb.t4itnoset(itno);
        gb.t4itnaset(itna);
        gb.t4quaset(quanti);
        gb.t4priset(pri);

        int il=gb.t4it.size();
        String itnu="",ite_na="",itqu="",itpri="";
        int i=0;
        int total=0;
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
        itno4=findViewById(R.id.i_no);
        itena4=findViewById(R.id.i_na);
        itqua4=findViewById(R.id.i_qu);
        itpr4=findViewById(R.id.i_pr);
        tot4=findViewById(R.id.tott4);

        itno4.setText(itnu);
        itena4.setText(ite_na);
        itqua4.setText(itqu);
        itpr4.setText(itpri);
        tot4.setText("Total :"+String.valueOf(total));
    }
}
