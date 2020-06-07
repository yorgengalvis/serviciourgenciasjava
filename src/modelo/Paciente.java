/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Comparator;
/**
 *
 * @author YorgenGalvis
 */
public class Paciente implements Comparable<Paciente>{
    
    private String nombre;
    private int  gradoDolencia;
    private String medicoQA;
    private int numAsegurado;        

    public Paciente() {
    }

    public Paciente(int numAsegurado,String nombre) {
        this.nombre = nombre;
        this.numAsegurado = numAsegurado;
    }

    
    
    public Paciente(int numAsegurado,String nombre, String medicoQA) {
        this.nombre = nombre;
        this.medicoQA = medicoQA;
        this.numAsegurado = numAsegurado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGradoDolencia() {
        return gradoDolencia;
    }

    public void setGradoDolencia(int gradoDolencia) {
        this.gradoDolencia = gradoDolencia;
    }

    public String getMedicoQA() {
        return medicoQA;
    }

    public void setMedicoQA(String medicoQA) {
        this.medicoQA = medicoQA;
    }

    public int getNumAsegurado() {
        return numAsegurado;
    }

    public void setNumAsegurado(int numAsegurado) {
        this.numAsegurado = numAsegurado;
    }
    
   
    public String toString() {
        return "nombre=" + nombre + ", gradoDolencia=" + gradoDolencia + ", medicoQA=" + medicoQA + ", numAsegurado=" + numAsegurado;
    }

    public int compareTo(Paciente otro){
       if (this.getGradoDolencia() < otro.getGradoDolencia())
                return -1;
            else if(this.getGradoDolencia() > otro.getGradoDolencia())
                return 1;
            else
                return 0;
    }
    
    
    
}
