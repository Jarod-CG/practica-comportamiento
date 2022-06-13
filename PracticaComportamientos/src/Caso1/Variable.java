
package Caso1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*
    Variable que puede definir el usuario
*/
public class Variable {
    
    private String identifier;      //Identificador de la variable.         Ej: x,  y
    private String expression;      //Expresion que da valor a la variable. Ej: 2, 3+1
    private double value;           //Valor numerico (de eval expresion).   Ej: 2,  4
    
    /*
    OPEXPRESSION:   Una vez definido la expresion, mediante el engine de js, 
                    procede a calcular el valor float de la variable
    */
    public boolean opExpression(){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            value = Double.valueOf(engine.eval(expression).toString());
            return true;
        } catch (ScriptException ex) {
            value = 0.0;                    //Si algo sale mal, le pone un valor de cero
            return false;
        }
    }

    //CONSTRUCTORES
    public Variable() {
    }

    public Variable(String identifier, String expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public Variable(String identifier, double value) {
        this.identifier = identifier;
        this.value = value;
    }

    public Variable(String identifier, String expression, double value) {
        this.identifier = identifier;
        this.expression = expression;
        this.value = value;
    }

    //SETTERS & GETTERS
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        if (identifier == null){
            return "Variable " +"-"+ " = "+"-"+"  | Definido mediante la expresion "+"-";
        }else{
            return "Variable " + identifier + " = "+value+"  | Definido mediante la expresion "+expression;
        } 
    }
    
}
