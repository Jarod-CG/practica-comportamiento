
package Caso1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*
    Contiene la logicas de las operaciones aritmeticas y la gestion de variables
    Produce y se recupera de savepoints
*/
public class Aritmetic {
    
    private ArrayList<Variable> variables;  //Las variables que asigna el usuario
    private String operand1;                //Primer operando
    private String operand2;                //Segundo operando
    private TOperation operation;           //Operacion
    private double result;                  //Resultado de operar los operandos
    
    // =||=||=||=||==||=||==||=||==||=||==||=||==||=||==||=||==||=||==||=||==||=||=
    
    //  *** INICIA CLASE SAVEPOINT  ***
    
    /*
        Clase ANIDADA
        Corresponde a los savepoints, los mementos que se generan cuando el usuario asi lo desea
    */
    public static class Savepoint{
        private int savepointId;                    //Identificador del savepoint, para su busqueda
        private ArrayList<Variable> variables;      //Fue el estado de Aritmetic en algun momento del tiempo
        private String operand1;
        private String operand2;
        private TOperation operation;
        private double result;
        
        //Construye el savepoint
        public Savepoint(int savepointId, ArrayList<Variable> variables, String operand1, String operand2, TOperation operation, double result) {
            this.savepointId = savepointId;
            this.operand1 = operand1;
            this.operand2 = operand2;
            this.operation = operation;
            this.result = result;
            
            ArrayList<Variable> copia = new ArrayList<Variable>(3);     //Esto es para clonar las variables de ese estado, y no se alteren
            Iterator<Variable> iterator = variables.iterator();         //Note que siempre seran 3, las cuales se sobreescriben
            while(iterator.hasNext()){
                Variable copiando = iterator.next();
                copia.add(new Variable(copiando.getIdentifier(), copiando.getExpression(), copiando.getValue()));
            }
            this.variables = copia;
        }

        //Se deja publico para hacer la busqueda del savepoint deseado
        public int getSavepointId() {
            return savepointId;
        }

        //Solo Accesible por clases internas
        //Sirve la info para el recovery
        private ArrayList<Variable> getVariables() {
            return variables;
        }

        private String getOperand1() {
            return operand1;
        }

        private String getOperand2() {
            return operand2;
        }

        private TOperation getOperation() {
            return operation;
        }

        private double getResult() {
            return result;
        }
        
        //SOLO PARA DEPURAR
        @Override
        public String toString() {
            return "Savepoint{" + "savepointId=" + savepointId + ", variables=" + variables + ", operand1=" + operand1 + ", operand2=" + operand2 + ", operation=" + operation + ", result=" + result + '}';
        }
        
        
    }
    
    //  ***  FIN  CLASE SAVEPOINT  ***
    
    // =||=||=||=||==||=||==||=||==||=||==||=||==||=||==||=||==||=||==||=||==||=||=
    
    //SALVAR - Manda a crear un savepoint, pasandole su estado actual
    public Savepoint save(int id){
        return new Savepoint(id, this.variables, this.operand1, this.operand2, this.operation, this.result);
    }

    //RESTAURA - Vuelve a un savepoint anterior
    public void restore(Savepoint s){
        this.variables = s.getVariables();
        this.operand1 = s.getOperand1();
        this.operand2 = s.getOperand2();
        this.operation = s.getOperation();
        this.result = s.getResult();
    }
    
    //EXISTS AN EMPTY VAR? Verifica si hay variables libres o es necesario sobre-escribir
    public int availableVarField(){
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getIdentifier()==null){
                return i;
            }
        }
        return -1;
    }
    
    /*
        Salva una variable que fue definida por el usuario
    */
    public boolean saveVariable(int field, String id, String expression){
        Variable varUpdate = this.variables.get(field);
        varUpdate.setIdentifier(id);
        varUpdate.setExpression(expression);
        varUpdate.opExpression();
        return true;
    }
    
    /*
        Realiza la evaluacion de los operandos, en caso de que estos hayan sido
        dados mediante una expresion aritmetica.
    Ej: Operando1 es 2*8 ... entonces evalua y Operando1 ahora es 16
    */
    private void evaluateOperand(){
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            operand1 = engine.eval(operand1).toString();
            operand2 = engine.eval(operand2).toString();
        } catch (ScriptException ex) {
            operand1 = "0.0";
            operand2 = "0.0";
        }
    }

    //Operaciones aritmeticas de la calculadora
    
    //ADDITION
    public double add(){
        evaluateOperand();
        return Double.valueOf(operand1)+Double.valueOf(operand2);
    }
    
    //SUBSTRACTION
    public double sub(){
        evaluateOperand();
        return Double.valueOf(operand1)-Double.valueOf(operand2);
    }
    
    //MULTIPLICATION
    public double mul(){
        evaluateOperand();
        return Double.valueOf(operand1)*Double.valueOf(operand2);
    }
    
    //DIVISION
    public double div(){
        evaluateOperand();
        return Double.valueOf(operand1)/Double.valueOf(operand2);
    }
    
    //EXPONENTIAL
    public double exp(){
        evaluateOperand();
        return Math.pow(Double.valueOf(operand1), Double.valueOf(operand2));
    }
    
    //NTH ROOT
    public double root(){
        evaluateOperand();
        return Math.pow(Double.valueOf(operand1), 1/Double.valueOf(operand2));
    }
    
    //CONSTRUCTOR
    public Aritmetic() {
        this.variables = new ArrayList<Variable>();
        this.variables.add(new Variable());
        this.variables.add(new Variable());
        this.variables.add(new Variable());
    }

    //SETTERS & GETTERS
    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public TOperation getOperation() {
        return operation;
    }

    public void setOperation(TOperation operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

}
