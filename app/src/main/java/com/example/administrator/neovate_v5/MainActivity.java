package com.example.administrator.neovate_v5;

import android.app.Activity;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
//Array of options -> array adapter->ListView
//list views {views:patient.xml}


public class MainActivity extends Activity {
    private static Button button_sbm;
    private ListView listView1;
    MyReceiver myReceiver;
    private ArrayList<Infant> screenlist;


    //ListView listView;
     private InfantAdapter myadapter;

    //ArrayAdapter<String> adapter;

    @Override
    //sets up the listview
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Intent j = new Intent(this, InfantList.class);
        //startActivity(j);

        Intent i = new Intent(this, UsbServiceOp.class);
        startService(i);

        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UsbServiceOp.MY_ACTION);
        registerReceiver(myReceiver, intentFilter);


        Button arduino_advance = (Button) findViewById(R.id.arduino_connect);
        arduino_advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("ARD", "About to pass intent");
                Intent arduino = new Intent(MainActivity.this, UsbConnect.class);
                startActivity(arduino);
            }
        });





      /*  Infant startinfant1 = new Infant("Infant 1", "01/01/01", 2, HRpop, Restpop, Restpop, Restpop);


        Infant startinfant2 = new Infant("Infant 2", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant3 = new Infant("Infant 3", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant4 = new Infant("Infant 4", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant5 = new Infant("Infant 5", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant6 = new Infant("Infant 6", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant7 = new Infant("Infant 7", "01/01/01", 1, HRpop, Restpop, Restpop, Restpop);
        Infant startinfant8 = new Infant("Infant 8", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant9 = new Infant("Infant 9", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant10 = new Infant("Infant 10", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant11 = new Infant("Infant 11", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant12 = new Infant("Infant 12", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant13 = new Infant("Infant 13", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant14 = new Infant("Infant 14", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant15 = new Infant("Infant 15", "01/01/01", 1,  HRpop, Restpop, Restpop, Restpop);

        screenlist.add(startinfant0);
        screenlist.add(startinfant1);
        screenlist.add(startinfant2);
        screenlist.add(startinfant3);
        screenlist.add(startinfant4);
        screenlist.add(startinfant5);
        screenlist.add(startinfant6);
        screenlist.add(startinfant7);
        screenlist.add(startinfant8);
        screenlist.add(startinfant9);
        screenlist.add(startinfant10);
        screenlist.add(startinfant11);
        screenlist.add(startinfant12);
        screenlist.add(startinfant13);
        screenlist.add(startinfant14);
        screenlist.add(startinfant15);*/


//        ArrayList<String> ar = new ArrayList<String>();
//        String s1 ="Infant A";
//        String s2 ="Infant B";
//        String s3 ="Infant C";
//        ar.add(s1);
//        ar.add(s2);
//        ar.add(s3)
        ArrayList<Infant> screenlist = InfantList.getList();

        InfantAdapter myadapter = new InfantAdapter(this, screenlist);

        //  listView = (ListView) findViewById(android.R.id.list);
        ListView listView1 = (ListView) findViewById(R.id.listView1);
        // View header = (View) getLayoutInflater().inflate((R.layout.header_grid_main), null);
        //  View header = (View) getLayoutInflater().inflate((R.layout.header_grid_main), null);
        //listView1.addHeaderView(header);
        listView1.setAdapter(myadapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                 String rownumber = String.valueOf(position);
                                                 Intent infanthistory = new Intent(MainActivity.this, InfantHistory.class);
                                                 infanthistory.putExtra("position", position);
                                                 startActivity(infanthistory);

                                                 //Toast.makeText(MainActivity.this, rownumber, Toast.LENGTH_SHORT).show();
                                             }
                                         }

        );



    }

    public void updatelist() {
        runOnUiThread(new Runnable() {
            public void run() {
                listView1.invalidateViews();
                ((InfantAdapter) listView1.getAdapter()).notifyDataSetChanged();

            }
        });
    }


   /* private BroadcastReceiver ReceivefromService = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent)
        {
            //get the data using the keys you entered at the service
            String newData =intent.getStringExtra("incomingData");

        }
    };*/


    private class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context arg0, Intent arg1) {
            // TODO Auto-generated method stub
            TextView setter = (TextView) findViewById(R.id.datainc);
            //setter.setText(" ");
            final TextView ftv = setter;

            String newData = arg1.getStringExtra("DATAPASSED");
            final String newDatafinal = newData;
            /*runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //Toast.makeText(MainActivity.this, ftext, Toast.LENGTH_SHORT).show();

                    ftv.append(newDatafinal);
                }
            });*/
            int stringlength = newData.length();
            String stringlengthtext = ""+stringlength;
            Toast.makeText(MainActivity.this, stringlengthtext, Toast.LENGTH_SHORT).show();

          //  Toast.makeText(MainActivity.this, "Triggered by Service!\n" + "Data passed: " + newData, Toast.LENGTH_SHORT).show();
        if(newData.length()>=12) {
            double[] update = vitalsParser(newData);
            InfantList.updater(update);
            //setter.setText(" ");
            String parsing =  Arrays.toString(update);
            final String parsed = parsing;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Toast.makeText(MainActivity.this, parsed, Toast.LENGTH_SHORT).show();

                    ftv.append(parsed);


                    InfantAdapter myadapter = new InfantAdapter(MainActivity.this, InfantList.getList());

                    ListView listView1 = (ListView) findViewById(R.id.listView1);

                    listView1.setAdapter(myadapter);
                }
            });


        }



        }
    }

    public double[] vitalsParser(String myString) {
        final int NUMSTRINGELEMENTS = 5;
     //sensor number, hr, rr, temp, ox sat
        double[] parsedDoubles = new double[NUMSTRINGELEMENTS];
        String[] parsedString = myString.split(" ");
        for (int i = 0; i < NUMSTRINGELEMENTS; i++) {
            parsedDoubles[i] = Double.parseDouble(parsedString[i]);
        }

        return parsedDoubles;
    }


        //allows for interactions with different activities
    public void interact(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("Add Infant")) {
            Intent intent = new Intent(this, InfantAdd.class);
            startActivity(intent);
        } else if (button_text.equals("Infant History")) {
            Intent intent = new Intent(this, InfantHistory.class);
            startActivity(intent);

        }
    }

}







