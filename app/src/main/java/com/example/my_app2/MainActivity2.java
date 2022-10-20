package com.example.my_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    private TextView et1,et2,et3,et5;
    private EditText et4;
    private TextView tv;
    private double int_num1,int_num2;
    private int int_num3;
    private String operacion []={"+","-","*","/"};
    private String url [] = {"suma.jpg","resta.jpg","multi.jpg","division.png"};
    private Button calcular;
    private  DecimalFormat df;
    private ImageView image,imggan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        df = new DecimalFormat("#.00");
        et1 = (TextView) findViewById(R.id.double_num1);
        et2 = (TextView) findViewById(R.id.double_num2);
        //et3 = (TextView) findViewById(R.id.str_operacion);
        reload();
        calcular= (Button) findViewById(R.id.btn_resultadoJuego);
    }

    public void reload(){
        int_num1 =  Double.parseDouble(df.format((Math.random()*10+1)));
        int_num2 =  Double.parseDouble(df.format((Math.random()*10+1)));
        int_num3 = (int) (Math.random()*4);
        image = (ImageView) findViewById(R.id.imageView3);
        imggan = (ImageView) findViewById(R.id.gano);
        imagen();
        et1.setText(String.valueOf(int_num1));
        et2.setText(String.valueOf(int_num2));
    }
    public void imagen(){
        if(int_num3 == 0)
            image.setImageResource(R.drawable.suma);
        else if(int_num3==1)
            image.setImageResource(R.drawable.resta);
        else if (int_num3==2)
            image.setImageResource(R.drawable.multi);
        else if (int_num3 ==3)
            image.setImageResource(R.drawable.division);
    }
    public void verificar(View vista){
        tv = (TextView) findViewById(R.id.str_resultado_juego);
        et4 = (EditText) findViewById(R.id.double_respuesta);
        et5 = (TextView) findViewById(R.id.str_resultado_juego);
        double result = Double.parseDouble(et4.getText().toString());
        double resultado_num = 0;
        if( operacion[int_num3].equals("+")){
            resultado_num = Double.parseDouble(df.format(int_num1+int_num2));
            if(result == resultado_num){
                et5.setText("Felicitaciones");
                imggan.setImageResource(R.drawable.correcto);
                reload();
            }

            else{
                imggan.setImageResource(R.drawable.error);
                et5.setText("Vuelva a Intentarlo");
            }

        }
        else if ( operacion[int_num3].equals("-")){
            resultado_num = Double.parseDouble(df.format(int_num1-int_num2));
            if(result == resultado_num){
                et5.setText("Felicitaciones");
                imggan.setImageResource(R.drawable.correcto);
                reload();
            }
            else
            {
                imggan.setImageResource(R.drawable.error);
                et5.setText("Vuelva a Intentarlo");
            }
        }
        else if ( operacion[int_num3].equals("*")){
            resultado_num = Double.parseDouble(df.format(int_num1*int_num2));
            if(result == resultado_num){
                et5.setText("Felicitaciones");
                imggan.setImageResource(R.drawable.correcto);
                reload();
            }
            else
            {
                imggan.setImageResource(R.drawable.error);
                et5.setText("Vuelva a Intentarlo");
            }
        }
        else if ( operacion[int_num3].equals("/")){
            resultado_num = Double.parseDouble(df.format(int_num1/int_num2));
            if(result == resultado_num){
                et5.setText("Felicitaciones");
                imggan.setImageResource(R.drawable.correcto);
                reload();
            }

            else
            {
                imggan.setImageResource(R.drawable.error);
                et5.setText("Vuelva a Intentarlo");
            }
        }
    }

}