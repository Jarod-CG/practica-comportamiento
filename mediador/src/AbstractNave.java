public abstract class AbstractNave {
    protected IPuerto puerto;
    protected String nombre;

    public void arribar() {
       if (puerto.puedeArribar(this)) {
            System.out.println(getNombre() + " puede arribar");
            return;
       }
       System.out.println(getNombre() + " arribo bloqueado");
        
    }

    public void zarpar() {
        System.out.println(getNombre() + " zarpando");
        puerto.notificarZarpar();
        
    }

    public void solicitarArribo() {
        System.out.println(getNombre() + " solicita arribo");
        puerto.preparar(this);
    }

    public void permitirArribo() {
        System.out.println(getNombre() + " arribo permitido");
        arribar();
    }

    public IPuerto getPuerto() {
        return this.puerto;
    }

    public void setPuerto(IPuerto puerto) {
        this.puerto = puerto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
