package aplicacion.android.stevemorbo.previasfinal;

import android.content.Context;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    private Button inicio;
    private TextView registrarse;
    private EditText mail;
    private EditText contrasena;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();




        inicio = (Button) findViewById(R.id.iniciarsesion);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail = findViewById(R.id.mail);
                contrasena = findViewById(R.id.contrasena);
                String mail1 = mail.getText().toString();
                String contrasena1 = contrasena.getText().toString();
                if (ServicePersona.iniciarsesion(mail1, contrasena1)){
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
                goToRegister();
            }
        });
    }


    public void goToRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }






    /*----------------------------------------------------------------------------------------------------------------*/
    //NO SE QUE VERGA ES
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
