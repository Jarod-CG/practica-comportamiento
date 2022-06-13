package Caso16;

import java.util.LinkedList;
import java.util.Queue;

public class Puerto implements IPuerto {

    private boolean disponible;
    private Queue<AbstractNave> colaNaves;

    public Puerto() {
        this.disponible = true;
        this.colaNaves = new LinkedList<AbstractNave>();
    }

    @Override
    public boolean puedeArribar(AbstractNave nave) {
        if (disponible) {
            disponible = false;
            return true;
        }
        colaNaves.add(nave);
        return false;
    }
    @Override
    public void notificarZarpar() {
        if (!disponible) {
            System.out.println("puerto : siguiente nave ...");
            disponible = true;
        } 
        if (colaNaves.size() > 0) {
            AbstractNave primera = colaNaves.poll();
            primera.solicitarArribo();
        }
    }

    @Override
    public void preparar(AbstractNave nave) {
        System.out.println("puerto : Preparando puerto para nave " + nave.getNombre() + " ...");
        System.out.println("puerto : Puerto listo!");
        nave.permitirArribo();
    }
}
