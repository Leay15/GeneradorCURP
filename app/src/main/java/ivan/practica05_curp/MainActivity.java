package ivan.practica05_curp;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText txNombre,txApat,txAmat,txFechaNaci;
    RadioButton radHombre,radMujer;
    Spinner spEstados;
    Button btnGenerar;
    ListView listCURP;
    String[] Estados={"Aguascalientes","Baja California","Baja California Sur","Campeche","Coahuila","Colima","Chiapas","Chihuahua","Distrito Federal","Durango","Guanajuato","Guerrero","Hidalgo",
    "Jalisco","Mexico","Michoacan","Morelos","Nayarit","Nuevo Leon","Oaxaca","Puebla","Queretaro","Quintana Roo","San Luis Potosi","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz",
    "Yucatan","Zacatecas","Nacido En El Extranjero"};
    String[] Abreviaturas={"AS","BC","BS","CC","CL","CM","CS","CH","DF","DG","GT","GR","HG","JC","MC","MN","MS","NT","NL","OC","PL","QT","QR","SP","SL","SR","TC","TS","TL","VZ","YN","ZS","NE"};
    int anio=0,mes=0,dia=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txNombre=(EditText)findViewById(R.id.txNombre);
        txApat=(EditText)findViewById(R.id.txApat);
        txAmat=(EditText)findViewById(R.id.txAmat);
        txFechaNaci=(EditText)findViewById(R.id.txFecha);
        radHombre=(RadioButton)findViewById(R.id.radHombre);
        radMujer=(RadioButton)findViewById(R.id.radMujer);
        spEstados=(Spinner)findViewById(R.id.spEstados);
        btnGenerar=(Button)findViewById(R.id.btnGenerar);
        listCURP=(ListView)findViewById(R.id.listCURP);

        txFechaNaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDatePicker();
            }
        });
    }

    private void mostrarDatePicker() {
        DatePickerFragment newFrag = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 Enero es mes 0
                final String fecha = day + " - " + (month+1) + " - " + year;
                if(year>1917 && year<=2017){
                dia=day;
                mes=(month+1);
                anio=year;
                txFechaNaci.setText(fecha);
                }else{
                    if(year>2017){
                        Toast.makeText(getBaseContext(),"Debe seleccionarse un año igual o menor a 2017",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getBaseContext(),"Debe seleccionarse un año mayor a 1917",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        newFrag.show(getFragmentManager(), "datePicker");
    }
}
