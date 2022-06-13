/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Caso8;

/**
 *
 * @author XPC
 */
public class Aplicacion {
    
    private boolean conectado;
    private String dispositivo;
    private static Aplicacion instance; 
    private SistemaAc Aire01;
    private Luces luces01;
    private Parlantes parlantes01;
    
    private Aplicacion(){}
    
    public static Aplicacion getInstance(){
        //System.out.println("Instancia: " + this.instance);
        if(instance == null){
            instance = new Aplicacion();
            //this.Aire01 = new SistemaAc();         
        }
        
        return instance;
       
    }
    
    public void crearUI(){
        
    }

    public void ejecutarCommando (Command c){
        
    }
    
    public void setDispositivo(String dispositivo){
        this.dispositivo = dispositivo;
    }
    
    public String getDispositivo() {
        return this.dispositivo;
    }
    
    public void setAire01(){
        this.Aire01 = new SistemaAc();
    }
    
    public SistemaAc getAire01(){
        return this.Aire01;
    }
    
    public void setLuces01(){
        this.luces01 = new Luces();
    }
    
    public Luces getLuces01(){
        return this.luces01;
    }
    
    public void setParlantes01(){
        this.parlantes01 = new Parlantes();
    }
    
    public Parlantes getParlantes01(){
        return this.parlantes01;
    }
}
