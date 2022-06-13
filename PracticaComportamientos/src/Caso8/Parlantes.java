/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Caso8;

/**
 *
 * @author XPC
 */
public class Parlantes {
    
    private int volumen;
    
    public Parlantes (){
    this.volumen = 75;}
    
    public void aumentarVolumen() {
        this.volumen = this.volumen +1;
        System.out.println("El volumen actual es: " + this.volumen + " decibeles.");
    }
    
    public void disminuirVolumen() {
        this.volumen = this.volumen -1;
        System.out.println("El volumen actual es: " + this.volumen + " decibeles.");
    }
    
    public int getVolumen(){
        return this.volumen;
    }
    
}
