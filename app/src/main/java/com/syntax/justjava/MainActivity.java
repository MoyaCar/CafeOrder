package com.syntax.justjava;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int CantidadDeCafe = 1;
    String clientName = "Lulo Esperon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//construlle mensaje de orden y lo muestra
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void ingresarOrden(View view) {
        int price = calculatePrice();
        String precio = createOrderSumary(price);
        displayMessage(precio);
    }

//muestra mensaje de orden en pantalla
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void displayMessage(String string) {
        TextView priceTextView = (TextView) findViewById(R.id.orden_view);
        priceTextView.setText(string);
    }

    private void displayQuantity(int numero) {

        TextView NumberView = findViewById(R.id.cantidad_text_view);
        NumberView.setText("" + numero);

    }


    //Metodo para sumar cantidad de café
    public void sumar(View view) {

        if (CantidadDeCafe < 50) {
            CantidadDeCafe = CantidadDeCafe + 1;
            displayQuantity(CantidadDeCafe);
        }
    }

    //Metodo para restar la cantidad de cafe
    public void restar(View view) {
        if (CantidadDeCafe > 1) {
            CantidadDeCafe = CantidadDeCafe - 1;
            displayQuantity(CantidadDeCafe);
        }

    }

    private int calculatePrice() {
        return CantidadDeCafe * 5;

    }

    public String createOrderSumary(int precio) {
        return clientName + "\n" + "Cantidad: " + CantidadDeCafe + "\n" + "Total: $" + precio + "\n" + "Muchas Graxiash";
    }
}
