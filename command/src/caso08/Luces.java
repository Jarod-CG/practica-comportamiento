/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso08;

/**
 *
 * @author XPC
 */
public class Luces {
    
    private int intensidad;
    
    public Luces(){
        this.intensidad = 50;
    }
    
    public void aumentarIntensidadLuz(){
        this.intensidad = this.intensidad +1;
        System.out.println("La intensidad de luces es: " + this.intensidad + " lumens.");
    }
    
    public void disminuirIntensidadLuz() {
        this.intensidad = this.intensidad -1;
        System.out.println("La intensidad de luces es: " + this.intensidad + " lumens.");
    }
    
    public int getIntensidad() {
        return this.intensidad;
    }
    
}
