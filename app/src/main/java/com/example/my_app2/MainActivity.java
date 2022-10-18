package com.example.my_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private TextView tv;
    private RadioButton rbt_suma,rbt_resta,rbt_multiplicacion,rbt_division;
    private Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Pasar datos entre la parte grafica y la parte logica*/
        et1 = (EditText) findViewById(R.id.str_text_num1);
        et2 = (EditText) findViewById(R.id.str_text_num2);
        tv = (TextView) findViewById(R.id.out_str_resultado);
        rbt_suma = (RadioButton) findViewById(R.id.rbt_suma);
        rbt_resta = (RadioButton) findViewById(R.id.rbt_resta);
        rbt_multiplicacion = (RadioButton) findViewById(R.id.rbt_multiplicacion);
        rbt_division = (RadioButton) findViewById(R.id.rbt_division);
        calcular= (Button) findViewById(R.id.btn_calcular);
    }



    public double suma(){
        return Double.parseDouble(et1.getText().toString()) +  Double.parseDouble(et2.getText().toString());
    }
    public double resta(){
        return Double.parseDouble(et1.getText().toString()) -  Double.parseDouble(et2.getText().toString());
    }
    public double multiplicacion(){
        return Double.parseDouble(et1.getText().toString()) *  Double.parseDouble(et2.getText().toString());
    }
    public double division(){
        return Double.parseDouble(et1.getText().toString()) /  Double.parseDouble(et2.getText().toString());
    }

    public void calcular(View vista){
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        double resultado = 0;
        if ( rbt_suma.isChecked())
            resultado=suma();
        else if ( rbt_resta.isChecked())
            resultado=resta();
        else if ( rbt_multiplicacion.isChecked())
            resultado=multiplicacion();
        else if ( rbt_division.isChecked())
            if(num2!=0)
                resultado=division();
            else
                Toast.makeText(this,"No existe la division para cero",Toast.LENGTH_SHORT).show();
        tv.setText(String.valueOf(resultado));
    }

    public void juego(View vista){
        Intent in = new Intent(this,MainActivity2.class);
        startActivity(in);
    }
}