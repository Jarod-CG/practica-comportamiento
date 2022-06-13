package Caso16;

public interface IPuerto {
    public boolean puedeArribar(AbstractNave nave);
    public void notificarZarpar();
    public void preparar(AbstractNave nave);
}
