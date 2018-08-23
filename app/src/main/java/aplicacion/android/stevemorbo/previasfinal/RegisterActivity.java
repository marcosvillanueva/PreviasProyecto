package aplicacion.android.stevemorbo.previasfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText mail;
    private EditText contrasena;
    private Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantregistro);

        final Context context = this;

        setContentView(R.layout.pantregistro);
        registro = (Button) findViewById(R.id.registrarse);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        mail = findViewById(R.id.mail);
        contrasena = findViewById(R.id.contrasena);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre1 = nombre.getText().toString();
                String apellido1 = apellido.getText().toString();
                String mail1 = mail.getText().toString();
                String contrasena1 = contrasena.getText().toString();

                if (ServicePersona.registrarse(nombre1, apellido1, mail1, contrasena1)){
                    goToMain();
                }else {
                    Toast.makeText(context, "Ingresa bien los datos tarado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void goToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}