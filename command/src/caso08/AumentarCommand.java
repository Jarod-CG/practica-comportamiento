/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso08;

/**
 *
 * @author XPC
 */
public class AumentarCommand implements Command {
    
    private String dispositivo;
    
    public AumentarCommand () {
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
            AC.aumentarTemp();
        }  else if (this.dispositivo == "Luces") {
            Luces luces = app.getLuces01();
            luces.aumentarIntensidadLuz();
        }  else if (this.dispositivo == "Parlantes") {
            Parlantes parlantes = app.getParlantes01();
            parlantes.aumentarVolumen();
        }
    
    }
    
}
