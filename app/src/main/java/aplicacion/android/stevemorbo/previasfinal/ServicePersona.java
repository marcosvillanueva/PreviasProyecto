package aplicacion.android.stevemorbo.previasfinal;

public class ServicePersona {

    public static boolean iniciarsesion(String mail, String contrasena){

        if(mail.equals(contrasena)){
            return true;
        }else {
            return false;
        }
    }


}
