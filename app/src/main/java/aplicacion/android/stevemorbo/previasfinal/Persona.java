package aplicacion.android.stevemorbo.previasfinal;

public class Persona {

        public String nombre;
        public String apellido;
        public String mail;
        public String contrasena;
        public boolean sexo;
        public int edad;
        public Ubicacion ubicacion;



        public Persona(String nombre, String apellido, String mail, String contrasena, String pais, String provincia, String departamento){

            this.nombre = nombre;
            this.apellido = apellido;
            this.mail = mail;
            this.contrasena = contrasena;
            this.ubicacion.pais = pais;
            this.ubicacion.provincia = provincia;
            this.ubicacion.departamento = departamento;

        }



    }

}
