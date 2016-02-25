package com.example.administrator.neovate_v5;

import android.app.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Administrator on 12/26/2015.
 */
public class InfantList extends Activity {

    public static ArrayList<Infant> infantlist = new ArrayList<Infant>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*    ArrayList<Double> HRpop = new ArrayList<Double>();
        ArrayList<Double> Restpop = new ArrayList<Double>();
        HRpop.add(90.);
        Restpop.add(-1.);
        Infant startinfant1 = new Infant("Infant 0", "01/01/01", 1, HRpop, Restpop, Restpop, Restpop);
        Infant startinfant2 = new Infant("Infant 2", "01/01/01", 2,  HRpop, Restpop, Restpop, Restpop);
        Infant startinfant3 = new Infant("Infant 3", "01/01/01", 3,  HRpop, Restpop, Restpop, Restpop);
        infantlist.add(startinfant1);
        infantlist.add(startinfant2);
        infantlist.add(startinfant3);

        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent)*/;

        // if(getIntent().getExtras()!=null) {
        // Bundle data = getIntent().getExtras();
        // Intent intent2 = getIntent();

        // }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Infant infanttemp = getIntent().getParcelableExtra("infant1");
        Log.v("Parcel", " got parcel in InfantList.java");

        infantlist.add(infanttemp);
        Log.v("ADD", " added to list in infantlist");
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

public static void updater(double[] parsedDoubles) {
    //sensor number, hr, rr, temp, ox sat
  for(int counter =0; counter<(InfantList.getList().size());counter++){
       if(infantlist.get(counter).sensornum== parsedDoubles[0])
       {
           infantlist.get(counter).heartrate.add(parsedDoubles[1]);
           infantlist.get(counter).resprate.add(parsedDoubles[2]);
           infantlist.get(counter).temp.add(parsedDoubles[3]);
           infantlist.get(counter).oxsat.add(parsedDoubles[4]);
       }
   }
    return;
}

    public static void adder(Infant infant) {
        infantlist.add(infant);

        return;
    }

    public static ArrayList<Infant> getList() {
        return infantlist;
    }

}




/*public class infant implements Parcelable{
   private String name;
    private String datebirth;
    private int sensornum;
    private double heartrate; //bpm
    private double resprate; //breaths per minute
    private double temp;
    private double oxsat;

    public infant(String name, String datebirth, int sensornum, double heartrate, double resprate, double temp, double oxsat){
        this.name=name;
        this.datebirth=datebirth;
        this.sensornum=sensornum;
        this.heartrate=heartrate;
        this.resprate=resprate;
        this.temp=temp;
        this.oxsat=oxsat;
    }

    public infant(Parcel input){
        name = input.readString();
        datebirth=input.readString();
        sensornum=input.readInt();
        heartrate = input.readDouble();
        resprate = input.readDouble();
        temp = input.readDouble();
        oxsat = input.readDouble();

    }
    @Override
    public int describeContents(){
        Log.v("TAG","describe infant vitals");
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    Log.v("TAG","writeToParcle infant");
    dest.writeString(name);
    dest.writeString(datebirth);
    dest.writeInt(sensornum);
    dest.writeDouble(heartrate);
    dest.writeDouble(resprate);
    dest.writeDouble(temp);
    dest.writeDouble(oxsat);
}

    public static final Parcelable.Creator<infant> CREATOR
            = new Parcelable.Creator<infant>(){
        public infant createFromParcel(Parcel in) {
            Log.w("TAG", "Parcel: being made");
            return new infant(in);
        }
    };
}*/




