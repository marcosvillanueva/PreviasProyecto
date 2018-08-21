package aplicacion.android.stevemorbo.previasfinal;

import android.content.Context;

public class ServicePersona {

    public static boolean iniciarsesion(String mail, String contrasena, Context context){

        if(mail.equals(contrasena)){
            return true;
        }else {
            return false;
        }
    }
}
