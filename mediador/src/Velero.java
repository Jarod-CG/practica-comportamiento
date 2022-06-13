public class Velero extends AbstractNave{

    Velero (String nombre, IPuerto puerto) {
        super.puerto = puerto;
        this.nombre = nombre;
    }

    public String getNombre() {
        return "velero : " + this.nombre;
    }

}
