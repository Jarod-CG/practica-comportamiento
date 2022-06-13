
package Caso1;

import Caso1.Aritmetic.Savepoint;
import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*
    Clase Caretaker
    Coordina las funcionalidades de Aritmetic
    Resguarda los savepoints que se han generado
        - Gestiona la creacion y recuperacion

*/
public class Calculator {
    
    private Aritmetic funcs = new Aritmetic();                              //Objeto experto en operaciones matematicas
    private ArrayList<Savepoint> history = new ArrayList<Savepoint>();      //Contendra el historial de SAVEPOINTS
    
    //Deshacer, restablece a un estado almacenado en el memento
    public void go2Savepoint(int i){
        if (i==-1){
            i = this.getHistory().size()-1;
            this.getFuncs().restore(history.get(i));
        }else{
            for (int j = 0; j < this.getHistory().size(); j++) {
                System.out.println("for");
               if (this.getHistory().get(j).getSavepointId()==i){
                   System.out.println("Esta es j "+this.getHistory().get(j).getSavepointId()+" y esta es i "+i);
                   this.getFuncs().restore(history.get(j));
                   break;
               }
            }
        }
    }
    
    //Deshacer, que borra todo: estados y variables
    public void reset(){
        this.funcs = new Aritmetic();
        history.clear();
    }
    
    //Genera un Savepoint
    public void makeSavepoint(){
        this.getHistory().add(this.getFuncs().save(this.getHistory().size()+1));
    }
    
    //Revisa si hay literales en la expresion (letras)
    //Busca si estas corresponden a variables -> Remplaza el valor
    //ej: 2*x+1, donde x = 26 ... entonces la expresion quedara 2*26+1
    public String changeLiterals(String expression){
         
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        
        try {
            //Aqui, verifica si la expresion tiene solo numeros, no se hace nada
            Double.valueOf(engine.eval(expression).toString());
            return expression;
        } catch (ScriptException ex) {
            String[] arr = expression.split("");
            
            for (int i = 0; i < arr.length; i++) {
                if(Character.isDigit(arr[i].charAt(0))){
                    continue;
                }
                if(Character.isAlphabetic(arr[i].charAt(0))){
                    //Lo buscaria si esta dentro de las variables definidas
                    for (Variable var : this.getFuncs().getVariables()){
                        if (var.getIdentifier()!=null && var.getIdentifier().charAt(0)==arr[i].charAt(0)){
                            arr[i] = String.valueOf(var.getValue());
                            break;
                        }
                    }
                }
            }
            expression = String.join("", arr);  //Forma la nueva expresion
            return expression;
        }
    }
    
    //Menu que manda a llamar la operacion aritmetica correspondientes
    public void operationsMenu(String operando1, String operando2, TOperation op){
        
        this.getFuncs().setOperand1(operando1);
        this.getFuncs().setOperand2(operando2);
        this.getFuncs().setOperation(op);
        switch(op){
            case ADD:     
                this.getFuncs().setResult(this.getFuncs().add()); break;
            case SUB:
                this.getFuncs().setResult(this.getFuncs().sub()); break;
            case MUL:
                this.getFuncs().setResult(this.getFuncs().mul()); break;
            case DIV: 
                this.getFuncs().setResult(this.getFuncs().div()); break;
            case EXP:
                this.getFuncs().setResult(this.getFuncs().exp()); break;
            case ROOT: 
                this.getFuncs().setResult(this.getFuncs().root()); break;        }
    }

    public Aritmetic getFuncs() {
        return funcs;
    }

    public ArrayList<Savepoint> getHistory() {
        return history;
    }
}
    

