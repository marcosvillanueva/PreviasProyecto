package aplicacion.android.stevemorbo.previasfinal;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button inicio;
    private TextView registrarse;
    private EditText nombre;
    private EditText apellido;
    private EditText mail;
    private EditText contrasena;
    private Button registro;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        Toasts.toastmain(context);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        bindUI();

        inicio = (Button) findViewById(R.id.iniciarsesion);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail1 = mail.getText().toString();
                String contrasena1 = contrasena.getText().toString();
                boolean mensaje = ServicePersona.iniciarsesion(mail1, contrasena1);
                if (mensaje){
                    setContentView(R.layout.pantinicio);
                    Toast.makeText(context, mail1 + " " + contrasena1, Toast.LENGTH_LONG).show();
                    ServicePrevia.cargarprevia();
                }else {
                    Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });

        registrarse = (TextView) findViewById(R.id.buttonRegister);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.pantregistro);
                registro = (Button) findViewById(R.id.registrarse);
                registro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nombre1 = nombre.getText().toString();
                        String apellido1 = apellido.getText().toString();
                        String mail1 = mail.getText().toString();
                        String contrasena1 = contrasena.getText().toString();
                        Persona persona1 = new Persona(nombre1, apellido1, mail1, contrasena1, "", "", "");
                        Toast.makeText(context, "Nombre " + persona1.nombre, Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, "Apellido " + persona1.apellido, Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, "Mail " + persona1.mail, Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, "Contrasena " + persona1.contrasena, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    private void bindUI(){
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        mail = findViewById(R.id.mail);
        contrasena = findViewById(R.id.contrasena);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
