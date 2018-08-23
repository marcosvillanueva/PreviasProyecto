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

        /*private void writeNewUser(String userId, String nombre,String apellido, String mail, String contrasena) {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference Person = database.getReference("Persona");
            Persona user = new Persona(nombre, apellido, mail, contrasena, "","","");

            Person.child("users").child(userId).setValue(user);
        }*/





    }


