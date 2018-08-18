package aplicacion.android.stevemorbo.previasfinal;

public class Persona {

    String nombre;
    String apellido;
    String mail;
    String contrasena;
    boolean sexo;
    int edad;

    public Persona(){

    }

    public Persona(String nombre, String apellido, String mail, String contrasena){

            this.nombre = nombre;
            this.apellido = apellido;
            this.mail = mail;
            this.contrasena = contrasena;

    }

    public void CrearPersona(String mail, String contrasena){
        if (mail==contrasena){

        }

    }
}
