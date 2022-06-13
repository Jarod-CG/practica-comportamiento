
package Caso1;

import java.util.Scanner;

/*
    Main -> Menu en consola para operar las funcionalidades de Calculator
*/
public class mainC1 {


    public static void main(String[] args) throws InterruptedException {
        
        Calculator laCalcu = new Calculator();
        
        Scanner entrada = new Scanner(System.in);
        
        while (true){
            System.out.println("------------\nCALCULADORA");
            System.out.println(laCalcu.getFuncs().getOperand1());
            System.out.println(laCalcu.getFuncs().getOperand2());
            System.out.println(laCalcu.getFuncs().getOperation());
            System.out.println(laCalcu.getFuncs().getResult());
            System.out.println(laCalcu.getFuncs().getVariables().toString());
            System.out.println("------------");
            
            Thread.sleep(2000);
            
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Elevar Potencia");
            System.out.println("6. Sacar Raiz");
            System.out.println("7. Menu Variables");
            System.out.println("8. Guardar Estado");
            System.out.println("9. Recuperar Estado");
            System.out.println("0. Salir");
            System.out.print("   Ingrese la opcion de su preferencia: ");
            
            int opcion = entrada.nextInt();     //Opcion del menu
            
            //0. Salir
            if (opcion==0){                                     
                System.out.println("... CERRANDO EL PROGRAMA ...");
                break;
            }
            //7. Menu Variables
            if (opcion==7){
                System.out.println("");
                int index = 0;
                for (Variable var : laCalcu.getFuncs().getVariables()){     //Imprime que tienen las variables actualmente
                    if (var.getExpression()!=null){
                        System.out.print(index+1+". ");
                        System.out.println(var.toString());
                    }else{
                        System.out.print(index+1+". ");
                        System.out.println("Variable disponible");
                    }
                    index++;
                }
                System.out.print("  Ingrese el espacio a asignar la variable o presione 0 para salir: ");
                int pos = entrada.nextInt();
                if (0<pos && pos<4){
                    //Pide los datos para actualizar la variable elegida
                    System.out.print(" Ingrese el identificador de la nueva variable: ");
                    String pId = entrada.next();
                    System.out.print(" Asigne el valor de "+pId+": ");
                    String pDef = entrada.next();

                    laCalcu.getFuncs().saveVariable(pos-1, pId, laCalcu.changeLiterals(pDef));
                }else{
                    System.out.println("  Regresando al menu principal");
                }
                System.out.println("");
            }
            // 8. Guardar Estado
            if (opcion==8){
                System.out.println("");
                laCalcu.makeSavepoint();
                System.out.println("Estado Salvado!");
                System.out.println("SAVEPOINT "+laCalcu.getHistory().get(laCalcu.getHistory().size()-1).getSavepointId()+"\n");
                //Indico el numero de savepoint que recien se creo
            }
            // 9. Recuperar Estado
            if (opcion==9){
                
                System.out.println(laCalcu.getHistory().toString());
                
                System.out.println("");
                System.out.println("1. Recuperar ultimo estado guardado");
                System.out.println("2. Recuperar estado especifico");
                System.out.println("3. Reiniciar al estado de inicio");
                int opcionEstado = entrada.nextInt();
                switch(opcionEstado){
                    case 1:
                        laCalcu.go2Savepoint(-1); break;    //El ultimo savepoint
                    case 2:
                        System.out.print(" Ingrese el numero de savepoint deseado para la recuperacion: ");
                        int elSavepoint = entrada.nextInt();            //El i-esimo savepoint
                        laCalcu.go2Savepoint(elSavepoint); break;
                    case 3:
                        laCalcu.reset();                    //Reinicia al estado inicial
                }
                System.out.println("");
            }
            
            // Opciones 1 a 6
            //MANDA A EJECUTAR LA OPERACION ARITMETICA CORRESPONDIENTE
            if (opcion>0&&opcion<7){
                System.out.println("");
                System.out.print("Ingrese el primer  operando: ");
                String primero = entrada.next();
                System.out.print("Ingrese el segundo operando: ");
                String segundo = entrada.next();
                
                primero = laCalcu.changeLiterals(primero);  //Si hay alguna variable, va a buscar su valor
                segundo = laCalcu.changeLiterals(segundo);
                
                switch (opcion){
                    case 1: laCalcu.operationsMenu(primero, segundo, TOperation.ADD); break;
                    case 2: laCalcu.operationsMenu(primero, segundo, TOperation.SUB); break;
                    case 3: laCalcu.operationsMenu(primero, segundo, TOperation.MUL); break;
                    case 4: laCalcu.operationsMenu(primero, segundo, TOperation.DIV); break;
                    case 5: laCalcu.operationsMenu(primero, segundo, TOperation.EXP); break;
                    case 6: laCalcu.operationsMenu(primero, segundo, TOperation.ROOT); break;
                }
                System.out.println("");
            }
            
            //OPCION NO VALIDA
            if (opcion>9){
                System.out.println("Opcion No Valida!!!");
            }
      
            }
            
        }
    
}
