/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Caso8;

/**
 *
 * @author XPC
 */
public class DisminuirCommand implements Command {
    
    private String dispositivo;
    
    public DisminuirCommand () {
        Aplicacion app;
        app = Aplicacion.getInstance();
        this.dispositivo = app.getDispositivo();
    }
    
    @Override
    public void execute(){
        
        Aplicacion app;
        app = Aplicacion.getInstance();
        
        if(this.dispositivo == "AC"){
            SistemaAc AC = app.getAire01();
            AC.disminuirTemp();
        }  else if (this.dispositivo == "Luces") {
            Luces luces = app.getLuces01();
            luces.disminuirIntensidadLuz();
        }  else if (this.dispositivo == "Parlantes") {
            Parlantes parlantes = app.getParlantes01();
            parlantes.disminuirVolumen();
        }
    
    }
    
}

