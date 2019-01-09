package com.syntax.justjava;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int lattePrice = 1;
    int chocoPrice = 2;
    int CantidadDeCafe = 1;
    String clientName;
    boolean isLatte;
    boolean hasChoco;
    int preciox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //construlle mensaje de orden y lo muestra

    public void ingresarOrden(View view) {

        if (hasChoco == true && isLatte == false) {
            preciox = (CantidadDeCafe * 5)+ (chocoPrice * CantidadDeCafe) ;
            Log.v("Precio Checker", "Preciox: " + preciox);
        }
        if (hasChoco == true && isLatte == true) {
            preciox = (CantidadDeCafe * 5) + (chocoPrice * CantidadDeCafe) + (lattePrice * CantidadDeCafe);
            Log.v("Precio Checker", "Preciox: " + preciox);
        }
        if (isLatte == true && hasChoco == false) {
            preciox = (CantidadDeCafe * 5) + (lattePrice * CantidadDeCafe);
            Log.v("Precio Checker", "Preciox: " + preciox);
        } if(isLatte == false && hasChoco == false) {
            preciox = CantidadDeCafe * 5;
            Log.v("Precio Checker", "Precioxx: " + preciox);
        }
        String precio = createOrderSumary(preciox);
        displayMessage(precio);
        Log.v("MainActivity", "Nombre del Cliente: " + clientName);
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
        Log.v("Activity", "Agregando Cafe, Total: " + CantidadDeCafe);
    }

    //Metodo para restar la cantidad de cafe
    public void restar(View view) {
        if (CantidadDeCafe > 1) {
            CantidadDeCafe = CantidadDeCafe - 1;
            displayQuantity(CantidadDeCafe);
        }
        Log.v("Activity", "Sustrayendo Cafe, Total: " + CantidadDeCafe);
    }



    public String createOrderSumary(int precio) {
        EditText et = findViewById(R.id.edit_name_view);
        clientName = et.getText().toString();
        return clientName + "\n" + "Cantidad: "
                + CantidadDeCafe + "\n Is Latte?"
                + isLatte + "\n Choco?" + hasChoco
                + "\n" + "Total: $" + precio + "\n"
                + "Muchas Graxiash";
    }

    public void latteCheck(View view) {
        CheckBox checkBox = findViewById(R.id.late_checkbox);
        if (checkBox.isChecked() == true) {
            isLatte = true;
        } else {
            isLatte = false;
        }
        Log.v("MainActivity", "Latte checker is " + isLatte);
    }

    public void chocolateCheck(View view) {
        CheckBox checkBox1 = findViewById(R.id.chocolate_checkbox);
        if (checkBox1.isChecked() == true) {
            hasChoco = true;
        } else {
            hasChoco = false;
        }
        Log.v("MainActivity", "Choco checker is " + hasChoco);
    }


}
