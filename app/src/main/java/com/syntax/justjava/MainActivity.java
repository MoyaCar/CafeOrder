package com.syntax.justjava;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int CantidadDeCafe = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ingresarOrden(View view) {
        int precio = CantidadDeCafe * 5;
        displayPrice(precio);
    }

    private void mostrar(int numero) {

        TextView NumberView = findViewById(R.id.cantidad_text_view);
        NumberView.setText("" + numero);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.precio_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    //Metodo para sumar cantidad de café
    public void sumar(View view) {

        if (CantidadDeCafe < 50) {
            CantidadDeCafe = CantidadDeCafe + 1;
            mostrar(CantidadDeCafe);
        }
    }

    //Metodo para restar la cantidad de cafe
    public void restar(View view) {
        if (CantidadDeCafe > 1) {
            CantidadDeCafe = CantidadDeCafe - 1;
            mostrar(CantidadDeCafe);
        }

    }

}
