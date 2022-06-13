
package caso08;

public class Caso08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Aplicacion app;
        app = Aplicacion.getInstance();
        
        app.setDispositivo("AC");
        app.setAire01();
        app.setLuces01();
        app.setParlantes01();
        
        AumentarButton botonAumento = new AumentarButton();
        DisminuirButton botonDecremento = new DisminuirButton();
        
        System.out.println("La temperatura actual es: " + app.getAire01().getTemperatura() + " grados");
        
        System.out.println("Aumento de temperatura");
        
        botonAumento.click();
        botonAumento.click();
        botonAumento.click();
        botonAumento.click();
        
        System.out.println("Decremento de temperatura");
        
        botonDecremento.click();
        botonDecremento.click();
        botonDecremento.click();
        botonDecremento.click();
        
        System.out.println("La temperatura actual es: " + app.getAire01().getTemperatura() + " grados");
        
        System.out.println("");
        app.setDispositivo("Luces");
        
        System.out.println("La intensidad actual de las luces es: " + app.getLuces01().getIntensidad() + " lumens");
        
        System.out.println("Aumento de intensidad de luz");
        
        botonAumento.click();
        botonAumento.click();
        botonAumento.click();
        botonAumento.click();
        
        System.out.println("Decremento de intensidad de luz");
        
        botonDecremento.click();
        botonDecremento.click();
        botonDecremento.click();
        botonDecremento.click();
        
        System.out.println("");
        app.setDispositivo("Parlantes");
        
        System.out.println("La intensidad actual del volumen de los parlantes es: " + app.getParlantes01().getVolumen() + " decibeles");
        
        System.out.println("Aumento de intensidad de Volumen");
        
        botonAumento.click();
        botonAumento.click();
        botonAumento.click();
        botonAumento.click();
        
        System.out.println("Decremento de intensidad de Volumen");
        
        botonDecremento.click();
        botonDecremento.click();
        botonDecremento.click();
        botonDecremento.click();
    }
    
}
