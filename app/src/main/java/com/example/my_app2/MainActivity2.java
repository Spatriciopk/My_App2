package com.example.my_app2;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;



public class MainActivity2 extends AppCompatActivity {
    private TextView et1,et2,et3,et5,et6,et7;
    private EditText et4;
    private TextView tv;
    private double int_num1,int_num2;
    private int int_num3;
    private String operacion []={"+","-","*","/"};
    private String url [] = {"suma.jpg","resta.jpg","multi.jpg","division.png"};
    private Button calcular;
    private  DecimalFormat df;
    private ImageView image,imggan;
    int time = 59;
    int correctos=0;
    int incorrectos=0;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1 = (TextView) findViewById(R.id.double_num1);
        et2 = (TextView) findViewById(R.id.double_num2);
        et3 = (TextView) findViewById(R.id.time);
        et6 = (TextView) findViewById(R.id.correcto);
        et7 = (TextView) findViewById(R.id.incorrecto);
        image = (ImageView) findViewById(R.id.imageView3);
        imggan = (ImageView) findViewById(R.id.gano);
        tv = (TextView) findViewById(R.id.str_resultado_juego);
        et4 = (EditText) findViewById(R.id.double_respuesta);
        et5 = (TextView) findViewById(R.id.str_resultado_juego);
        et6.setText("Correctos:" + String.valueOf(correctos));
        et7.setText("Incorrectos: " + String.valueOf(incorrectos));
        reload();
        calcular= (Button) findViewById(R.id.btn_resultadoJuego);
    }

    public void reload(){
        df = new DecimalFormat("#.00");
        int_num1 =  Double.parseDouble(df.format((Math.random()*10+1)));
        int_num2 =  Double.parseDouble(df.format((Math.random()*10+1)));
        int_num3 = (int) (Math.random()*4);
        et1.setText(String.valueOf(int_num1));
        et2.setText(String.valueOf(int_num2));
        imagen();

        //thread=null;

        et3.setText("1:00");
        if ( thread ==null){
            thread = new Thread(new Runnable()  {
                @Override
                public void run() {

                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while(!thread.isInterrupted()){

                        try {
                            if(time >9)
                                et3.setText("0:" + String.valueOf(time));
                            else
                                et3.setText("0:0" + String.valueOf(time));
                            time = time - 1;
                            sleep(1000);
                            if(time == 0){ runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sumincorrectos();
                                    reload();
                                }
                            });

                                et3.setText("0:0" + String.valueOf(time));
                                time=59;

                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            });
            thread.start();
        }


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

    public void sumcorrectos(){
        correctos = correctos+1;
        et6.setText("Correctos:" + String.valueOf(correctos));
    }

    public void sumincorrectos(){
        incorrectos = incorrectos+1;
        et7.setText("Incorrectos:" + String.valueOf(incorrectos));
    }

    public void verificar(View vista){

        double result = Double.parseDouble(et4.getText().toString());
        double resultado_num = 0;
        if( operacion[int_num3].equals("+")){
            resultado_num = Double.parseDouble(df.format(int_num1+int_num2));
            if(result == resultado_num){
                et5.setText("Felicitaciones");
                imggan.setImageResource(R.drawable.correcto);
                thread.interrupt();
                time=59;
                sumcorrectos();
                reload();
            }

            else{
                imggan.setImageResource(R.drawable.error);
                et5.setText("Vuelva a Intentarlo");
                sumincorrectos();
            }

        }
        else if ( operacion[int_num3].equals("-")){
            resultado_num = Double.parseDouble(df.format(int_num1-int_num2));
            if(result == resultado_num){
                et5.setText("Felicitaciones");
                imggan.setImageResource(R.drawable.correcto);
                thread.interrupt();
                time=59;
                sumcorrectos();
                reload();
            }
            else
            {
                imggan.setImageResource(R.drawable.error);
                et5.setText("Vuelva a Intentarlo");
                sumincorrectos();
            }
        }
        else if ( operacion[int_num3].equals("*")){
            resultado_num = Double.parseDouble(df.format(int_num1*int_num2));
            if(result == resultado_num){
                et5.setText("Felicitaciones");
                imggan.setImageResource(R.drawable.correcto);
                thread.interrupt();
                time=59;
                sumcorrectos();
                reload();
            }
            else
            {
                imggan.setImageResource(R.drawable.error);
                et5.setText("Vuelva a Intentarlo");
                sumincorrectos();
            }
        }
        else if ( operacion[int_num3].equals("/")){
            resultado_num = Double.parseDouble(df.format(int_num1/int_num2));
            if(result == resultado_num){
                et5.setText("Felicitaciones");
                imggan.setImageResource(R.drawable.correcto);
                thread.interrupt();
                time=59;
                sumcorrectos();
                reload();
            }

            else
            {
                imggan.setImageResource(R.drawable.error);
                et5.setText("Vuelva a Intentarlo");
                sumincorrectos();
            }
        }
    }

}