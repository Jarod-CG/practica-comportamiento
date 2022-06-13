package Caso16;

public class BuqueCarga extends AbstractNave {
    
    BuqueCarga (String nombre, IPuerto puerto) {
        super.puerto = puerto;
        this.nombre = nombre;
    }

    public String getNombre() {
        return "buque : " + this.nombre;
    }
}
