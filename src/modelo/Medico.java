/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author YorgenGalvis
 */
public class Medico {
    
    String nombre;
    int numPacientes;
    boolean turnoAtendiendo;
    
    public Medico(){
        
    }
    
    public Medico(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPacientes() {
        return numPacientes;
    }

    public void setNumPacientes(int numPacientes) {
        this.numPacientes = numPacientes;
    }

    public boolean isTurnoAtendiendo() {
        return turnoAtendiendo;
    }

    public void setTurnoAtendiendo(boolean turnoAtendiendo) {
        this.turnoAtendiendo = turnoAtendiendo;
    }

    @Override
    public String toString() {
        return "Medico{" + "nombre=" + nombre + ", numPacientes=" + numPacientes + ", turnoAtendiendo=" + turnoAtendiendo + '}';
    }
    
    public String toString2(){
        return nombre+" numPaciente: "+numPacientes+" En atencion: "+turnoAtendiendo;
    }
    
    
    
}
