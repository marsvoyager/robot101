package com.example.listviews99;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Segundo ejemplo con arraylist
    public class miOyenteListview_Nombres implements
            AdapterView.OnItemClickListener{

        ListView thislv_ValoresLista;
        AppCompatActivity thisActivity;
        ArrayList<String> nombres = new ArrayList<String>();

        miOyenteListview_Nombres(AppCompatActivity pthisActivity, ListView pthislv_ValoresLista)
        {
            thisActivity=pthisActivity;
            thislv_ValoresLista=pthislv_ValoresLista;
            nombres.add("Sergio");
            nombres.add("Laura");
            nombres.add("Lara");

            ArrayAdapter<String>  adlvnombrs =
                    new ArrayAdapter<String>(thisActivity,
                            android.R.layout.simple_list_item_1,
                            android.R.id.text1,
                            nombres
                    );


            //Por defecto Un long click sobre el item Evita la ejecución del listener del item!!!
            thislv_ValoresLista.setAdapter(adlvnombrs);
            thislv_ValoresLista.setOnItemLongClickListener(
                    new AdapterView.OnItemLongClickListener()
                               {
                                   @Override
                                   public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                                       return true;
                                       //return false;
                                   }
                               }
            );
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            int itemPosition = i;
            //Agafa el valor del text:

            String itemValue =
                    (String) thislv_ValoresLista.getItemAtPosition(i);

            Toast.makeText(thisActivity,
                    "Borrado Posicion: " + i
                            + "Valor:" + itemValue, Toast.LENGTH_LONG ).show();

            nombres.remove(i);

            ((ArrayAdapter<String> )thislv_ValoresLista.getAdapter())
                    .notifyDataSetChanged();

        }
    };

        //Primer ejemplo de list views
    public class miOyenteListview implements
    AdapterView.OnItemClickListener{

        ListView thislv_ValoresLista;
        AppCompatActivity thisActivity;
        /*
         Gestión del oyente para items de list views
        * */
        miOyenteListview(AppCompatActivity pthisActivity, ListView pthislv_ValoresLista)
        {
            thisActivity=pthisActivity;
            thislv_ValoresLista=pthislv_ValoresLista;

            //Por defecto Un long click sobre el item Evita la ejecución del listener del item!!!
            thislv_ValoresLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
               {
                   @Override
                   public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                       return true;
                       //return false;
                   }
               }
            );
        }
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            int itemPosition = i;
            //Agafa el valor del text:

            String itemValue =
                    (String) thislv_ValoresLista.getItemAtPosition(i);

            Toast.makeText(thisActivity,
                    "Posicion: " + i
                    + "Valor:" + itemValue, Toast.LENGTH_LONG ).show();

        }
    }
    /*
    * */

    ListView lv_ValoresLista;
    miOyenteListview llv_ValoresListalistener;// = new miOyenteListview(this, lv_ValoresLista);

    ListView lv_ValoresListaNombre;
    miOyenteListview_Nombres llv_ValoresListaNombreslistener;// = new miOyenteListview(this, lv_ValoresLista);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] frutlst= new String[] { "Manzana",
                "Plátano",
                "Sandia",
                "Melón",
                "Fresas"
        };

        lv_ValoresLista = findViewById(R.id.milista99id);
        llv_ValoresListalistener = new miOyenteListview(this, lv_ValoresLista);

        ArrayAdapter<String>  adlvfrutlst =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        frutlst
                );
        lv_ValoresLista.setAdapter(adlvfrutlst);
        lv_ValoresLista.setOnItemClickListener(llv_ValoresListalistener);


        //Ejemplo 2
        lv_ValoresListaNombre= findViewById(R.id.milista98nomsid);
        llv_ValoresListaNombreslistener = new miOyenteListview_Nombres(
                this, lv_ValoresListaNombre);
        lv_ValoresListaNombre.setOnItemClickListener(llv_ValoresListaNombreslistener);

    }
}
