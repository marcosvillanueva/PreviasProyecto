package aplicacion.android.stevemorbo.previasfinal;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ServicePersona {

    public static boolean iniciarsesion(String mail, String contrasena){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference buscarUsuario = database.getReference("Persona");

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
                DatabaseReference crearUsuario = database.getReference("Persona").push();
                crearUsuario.child("nombre").setValue(nombre);
                crearUsuario.child("apellido").setValue(apellido);
                crearUsuario.child("mail").setValue(mail);
                crearUsuario.child("contrasena").setValue(contrasena);


            return true;
        }
    }


}
