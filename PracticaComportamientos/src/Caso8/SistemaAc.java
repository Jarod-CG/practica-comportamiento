/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Caso8;

/**
 *
 * @author XPC
 */
public class SistemaAc {
    
    private int temperatura;
    
    public SistemaAc(){
        this.temperatura = 20;
    }
    
    public void aumentarTemp(){
        this.temperatura = this.temperatura +1;
        System.out.println("La temperatura actual es: " + this.temperatura + " grados.");
    }
    
    public void disminuirTemp() {
        this.temperatura = this.temperatura -1;
        System.out.println("La temperatura actual es: " + this.temperatura + " grados.");
    }
    
    public int getTemperatura(){
        return this.temperatura;
    }
    
    
}
