package aplicacion.android.stevemorbo.previasfinal;

public class Previa {

    String titulo;
    String descripcion;
    String localidad;
    int edadmin;
    int edadmax;

    public Previa(){

    }

    public Previa(String titulo, String descripcion, String localidad, int edadmin, int edadmax){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.localidad = localidad;
        this.edadmin = edadmin;
        this.edadmax = edadmax;
    }
}
