package com.example.ejercicio_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Lista para guardar Números Primos
    static ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();

    //Variables Java
    static EditText posicion;
    TextView texto1,texto2,texto3;
    Button boton;
    static int contador = 0;
    static boolean encontrado = false;

    //FUNCIONES
    public static boolean esPrimo(int numero) {
        // El 0, 1 y 4 no son primos
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            if (numero % x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void numerosPrimos(){
        numerosPrimos.add(0);
        //Calculo de números primos
        for (int x = 2; !encontrado; x++) {
            if (esPrimo(x)) {
                numerosPrimos.add(x);
                contador++;
                if(Integer.parseInt(posicion.getText().toString())==contador){
                    encontrado = true;
                }
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RELACIONAMOS LAS VARIABLES DE JAVA CON XML
        boton = findViewById(R.id.boton);
        texto1 = findViewById(R.id.textView);
        texto2 = findViewById(R.id.textView2);
        texto3 = findViewById(R.id.textView3);
        posicion = findViewById(R.id.numPosicion);



        //Metodo ON CLICK
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Buscamos los números primos
                numerosPrimos();

                /*Especificamos que el Toast tendrá traducción y apuntamos a la String 'toast' en el
                fichero de Strings.xml*/
                String toastMessage = MainActivity.this.getResources().getString(R.string.toast);
                Toast toast = Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT);
                toast.show();

                //Mostramos el número primo de la posicion
                texto3.setText(numerosPrimos.get(Integer.parseInt(posicion.getText().toString())).toString());
            }
        });
    }
}