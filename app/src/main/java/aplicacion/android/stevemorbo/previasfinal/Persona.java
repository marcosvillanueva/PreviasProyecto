package aplicacion.android.stevemorbo.previasfinal;

import lombok.Getter;
import lombok.Setter;

public class Persona {


    @Getter @Setter
    public String nombre;
    @Getter @Setter
    public String apellido;
    @Getter @Setter
    public String mail;
    @Getter @Setter
    public String contrasena;
    @Getter @Setter
    public boolean sexo;
    @Getter @Setter
    public int edad;



    public Persona(String nombre, String apellido, String mail, String contrasena){

            this.nombre = nombre;
            this.apellido = apellido;
            this.mail = mail;
            this.contrasena = contrasena;

    }

}
