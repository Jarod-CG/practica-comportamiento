package Caso16;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Empieza ejecución!");
        Puerto puerto = new Puerto();
        System.out.println("puerto listo para recibir naves");

        String[] nombresVeleros = {"Swan", "Arrecife"};
        String[] nombresBuques = {"Frost"};

        ArrayList<AbstractNave> naves = new ArrayList<>();

        for (String nombre : nombresVeleros) {
            naves.add(new Velero(nombre, puerto));
        }

        for (String nombre : nombresBuques) {
            naves.add(new BuqueCarga(nombre, puerto));
        }

        for (AbstractNave nave : naves) {
            nave.arribar();
        }

        for (AbstractNave nave : naves) {
            nave.zarpar();
        }

    }
}
