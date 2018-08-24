package aplicacion.android.stevemorbo.previasfinal;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServicePersona {

    public static boolean iniciarsesion(String mail, String contrasena){

        if(mail.equals(contrasena)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean registrarse(String nombre, String apellido, String mail, String contrasena){

        if(nombre.equals("") || contrasena.equals("") || contrasena.length()<4){
            return false;
        }else {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Person = database.getReference("Persona");

                Person.child("nombre").setValue(nombre);

                Person.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.

                        /*FIXIT
                        String value = dataSnapshot.getValue(String.class);
                        Log.d("nombre", value);
                        */
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Persona", "Failed to read value.", error.toException());
                    }
                });
            return true;
        }
    }


}
