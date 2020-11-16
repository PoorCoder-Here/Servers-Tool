package com.vbh.hotel_billing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;
    String[] table={"Table","Table - 1","Table - 2","Table - 3","Table - 4"};
    String[] table1={"Nav_Table","Table - 1","Table - 2","Table - 3","Table - 4"};
    String[] price={"Price","120","80","150","200","60","110","35"};
    String[] itname={"Choose_Item_name","Non_veg_meals","Veg_meals","Chicken_Briyani","Chilly_chicken","Chicken_65",
    "Pepper_chicken","Gobi_65"};
    String[] itemno={"Choose_Item_No","I1","I2","I3","I4","I5","I6","I7"};
    String tableno;
    String itena;
    String ino,navtable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner itemname=findViewById(R.id.itna);
        final TextView pri=findViewById(R.id.tvpr);
        final Intent intent=new Intent(MainActivity.this,Table1.class);
        final Spinner imno=findViewById(R.id.itno);
        final  EditText qua=findViewById(R.id.etqua);
        final Spinner tabno=findViewById(R.id.tabno);
        final Button btn=findViewById(R.id.btnadd);
        final Spinner navtab=findViewById(R.id.nav);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,itname);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,itemno);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,table);
        ArrayAdapter<String> adapter4=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,table1);
        itemname.setAdapter(adapter);
        imno.setAdapter(adapter1);
        tabno.setAdapter(adapter3);
        navtab.setAdapter(adapter4);

        AdapterView.OnItemSelectedListener io=new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ino=String.valueOf(imno.getSelectedItem());
            if(ino.equals("I1"))
            {
                itemname.setSelection(1);
                pri.setText(price[1]);
            }
            if(ino.equals("I2"))
            {
                itemname.setSelection(2);
                pri.setText(price[2]);
            }
            if(ino.equals("I3"))
            {
                itemname.setSelection(3);
                pri.setText(price[3]);
            }
            if(ino.equals("I4"))
            {
                itemname.setSelection(4);
                pri.setText(price[4]);
            }
                if(ino.equals("I5"))
                {
                    itemname.setSelection(5);
                    pri.setText(price[5]);
                }
                if(ino.equals("I6"))
                {
                    itemname.setSelection(6);
                    pri.setText(price[6]);
                }
                if(ino.equals("I7"))
                {
                    itemname.setSelection(7);
                    pri.setText(price[7]);
                }
                if(ino.equals("Choose_Item_No"))
                {
                    itemname.setSelection(0);
                    pri.setText(price[0]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        imno.setOnItemSelectedListener(io);

        AdapterView.OnItemSelectedListener ina=new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itena=String.valueOf(itemname.getSelectedItem());
                if(itena.equals("Non_veg_meals"))
                {
                    imno.setSelection(1);
                    pri.setText(price[1]);
                }
                if(itena.equals("Veg_meals"))
                {
                    imno.setSelection(2);
                    pri.setText(price[2]);
                }
                if(itena.equals("Chicken_Briyani"))
                {
                    imno.setSelection(3);
                    pri.setText(price[3]);
                }
                if(itena.equals("Chilly_chicken"))
                {
                    imno.setSelection(4);
                    pri.setText(price[4]);
                }
                if(itena.equals("Chicken_65"))
                {
                    imno.setSelection(5);
                    pri.setText(price[5]);
                }
                if(itena.equals("Pepper_chicken"))
                {
                    imno.setSelection(6);
                    pri.setText(price[6]);
                }
                if(itena.equals("Gobi_65"))
                {
                    imno.setSelection(7);
                    pri.setText(price[7]);
                }
                if(itena.equals("Choose_Item_name"))
                {
                    imno.setSelection(0);
                    pri.setText(price[0]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        itemname.setOnItemSelectedListener(ina);

        AdapterView.OnItemSelectedListener natab=new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                navtable=String.valueOf(navtab.getSelectedItem());
                if(navtable.equals("Table - 1"))
                {
                    Intent navt1=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(navt1);
                }
                if(navtable.equals("Table - 2"))
                {
                    Intent navt2=new Intent(MainActivity.this,Main3Activityt2.class);
                    startActivity(navt2);
                }
                if(navtable.equals("Table - 4"))
                {
                    Intent navt4=new Intent(MainActivity.this,Main3Activityt4.class);
                    startActivity(navt4);
                }
                if(navtable.equals("Table - 3"))
                {
                    Intent navt3=new Intent(MainActivity.this,Main3Activityt3.class);
                    startActivity(navt3);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        navtab.setOnItemSelectedListener(natab);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableno=String.valueOf(tabno.getSelectedItem());
                if(tableno.equals("Table - 1"))
                {
                    intent.putExtra("item_no",String.valueOf(imno.getSelectedItem()));
                    intent.putExtra("item_name",String.valueOf(itemname.getSelectedItem()));
                    intent.putExtra("Q",qua.getText().toString());
                    intent.putExtra("price",pri.getText());
                    startActivity(intent);
                }
                if(tableno.equals("Table - 2"))
                {
                    Intent tab2=new Intent(MainActivity.this,Table2.class);
                    tab2.putExtra("item_no",String.valueOf(imno.getSelectedItem()));
                    tab2.putExtra("item_name",String.valueOf(itemname.getSelectedItem()));
                    tab2.putExtra("Q",qua.getText().toString());
                    tab2.putExtra("price",pri.getText());
                    startActivity(tab2);
                }
                if(tableno.equals("Table - 3"))
                {
                    Intent tab3=new Intent(MainActivity.this,Table3.class);
                    tab3.putExtra("item_no",String.valueOf(imno.getSelectedItem()));
                    tab3.putExtra("item_name",String.valueOf(itemname.getSelectedItem()));
                    tab3.putExtra("Q",qua.getText().toString());
                    tab3.putExtra("price",pri.getText());
                    startActivity(tab3);
                }
                if(tableno.equals("Table - 4"))
                {
                    Intent tab4=new Intent(MainActivity.this,Table4.class);
                    tab4.putExtra("item_no",String.valueOf(imno.getSelectedItem()));
                    tab4.putExtra("item_name",String.valueOf(itemname.getSelectedItem()));
                    tab4.putExtra("Q",qua.getText().toString());
                    tab4.putExtra("price",pri.getText());
                    startActivity(tab4);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Click two times to close an activity",    Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();
    }
}