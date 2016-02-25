package com.example.administrator.neovate_v5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 12/26/2015.
 */
public class InfantHistory extends Activity{
    private TextView textName;
    private TextView textDOB;
    private TextView textPosition;
    private TextView textSensorNumber;
    private TextView textHeartRate;
    private TextView textRespRate;
    private TextView textTemp;
    private TextView textOxSat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infant_history);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        textPosition = (TextView) findViewById(R.id.InfantHistoryPosition);
        textName = (TextView) findViewById(R.id.InfantHistoryName);
        textDOB = (TextView) findViewById(R.id.InfantHistoryDOB);
        textPosition = (TextView) findViewById(R.id.InfantHistoryPosition);
        textSensorNumber = (TextView) findViewById(R.id.InfantHistorySensorNumber);
        textHeartRate = (TextView) findViewById(R.id.InfantHistoryHeartRate);
        textRespRate = (TextView) findViewById(R.id.InfantHistoryRespRate);
        textTemp = (TextView) findViewById(R.id.InfantHistoryTemp);
        textOxSat = (TextView) findViewById(R.id.InfantHistoryOxSat);



        if(b!=null)
        {
            int pos = (int) b.get("position");
            textPosition.setText("Array Position" + String.valueOf(pos));
            ArrayList<Infant> specInfantList = InfantList.getList();
            //Infant specInfant = new Infant("Specific Infant", "010101", 1, 90, -1, -1, -1);
           Infant specInfant = specInfantList.get(pos);
/*
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateInString = specInfant.datebirth;

            try {

                Date date = formatter.parse(dateInString);
                System.out.println(date);
                System.out.println(formatter.format(date));

            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            String stringName = "Infant Name: " + specInfant.name;
            String stringDOB = "Date of Birth: " + specInfant.datebirth;
            String stringSensorNumber = "Sensor Number: " + (String.valueOf(specInfant.sensornum));
            String stringHeartRate = "Heart Rate (BPM): " + (String.valueOf(specInfant.heartrate.get(specInfant.heartrate.size()-1)));
            String stringRespRate = "Respiratory Rate : " + (String.valueOf(specInfant.resprate.get(specInfant.resprate.size()-1)));
            String stringTemp = "Temperature: " + (String.valueOf(specInfant.temp.get(specInfant.temp.size()-1)));
            String stringOxSat = "Oxygen Saturation " + (String.valueOf(specInfant.oxsat.get(specInfant.oxsat.size()-1)));

            textName.setText(stringName);
            textDOB.setText(stringDOB);
            textSensorNumber.setText(stringSensorNumber);
            textHeartRate.setText(stringHeartRate);
            textRespRate.setText(stringRespRate);
            textTemp.setText(stringTemp);
            textOxSat.setText(stringOxSat);


        }



    }
}
