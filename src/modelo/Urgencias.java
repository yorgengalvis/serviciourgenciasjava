/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;


/**
 *
 * @author YorgenGalvis
 */
public class Urgencias {
    public PriorityQueue<Paciente> salaDeEspera;
    public LinkedList<Medico> medicosEnTurno;
    public LinkedList<Paciente>  pacientesTurnoAsegurados;
    
    public Urgencias(){
        this.salaDeEspera=new PriorityQueue<Paciente>();
    }
    
    public void crearTurno(LinkedList<Medico> medicos,LinkedList<Paciente> listAsegurados) throws Exception{
        if(medicos.size()<1)throw new Exception("Error: No hay almenos un medico en turno.");
        this.medicosEnTurno=new LinkedList<Medico>();
        this.pacientesTurnoAsegurados=new LinkedList<Paciente>();
        this.medicosEnTurno=ordenarListaMedicos(medicos);
        this.pacientesTurnoAsegurados=ordenarListaCodigAsegurado(listAsegurados);
    }
    
    
    public void insertPaciente(Paciente p,String urgencias) throws Exception{
        int gradodolencia=this.establecerGradoDolencia(urgencias);  
        this.insertarPaciente(urgencias, p, gradodolencia);
    }
    
    private  int establecerGradoDolencia(String urgencia){  
     if(urgencia.equals("Hemorragia masiva incontrolable") || urgencia.equals("Paro Cardiaco") || urgencia.equals("Paro Respiratorio") || urgencia.equals("Quemadura Grave") || urgencia.equals("Obstruccion via respiratoria")){
        return 1;
     }else if(urgencia.equals("Infarto agudo de miocardio") || urgencia.equals("Siniestro de transito grave") || urgencia.equals("Dificultad respiratoria severa") || urgencia.equals("Ataque Cerebrovascular(ACV)")){
         return 2;
     }else if(urgencia.equals("Dolor intenso") || urgencia.equals("Dificultad respiratoria moderada")){
         return 3;
     }else if(urgencia.equals("Fiebre") || urgencia.equals("Dolor de Cabeza") || urgencia.equals("Malestar General") || urgencia.equals("Curacion de heridas") || urgencia.equals("Lesion en piel") ){
         return 4;
     }
       return 5;
    }
    protected void insertarPaciente(String urgencias,Paciente paciente,int gradoDolencia) throws Exception{
        Paciente aux=null;
        String medico="nada";
        for (Paciente paci:this.pacientesTurnoAsegurados) {
            if(paci.getNombre().equals(paciente.getNombre())){
                medico=paci.getMedicoQA();
                paciente.setNumAsegurado(paci.getNumAsegurado());
                paciente.setGradoDolencia(gradoDolencia);
                paciente.setMedicoQA(medico);
                aux=paciente;
                this.salaDeEspera.add(aux);
                break;}
        }
        if(aux==null)throw new Exception("El paciente "+paciente.getNombre()+" no se encuentra asegurado en el turno actual.");
    }
    
    protected LinkedList<Paciente> ordenarListaCodigAsegurado(LinkedList<Paciente> lista){
    Collections.sort(lista,new Comparator<Paciente>(){
        @Override
        public int compare(Paciente t, Paciente t1) {
            return t.getNumAsegurado() - t1.getNumAsegurado();
        }
    });
    return lista;
    }
    protected LinkedList<Medico> ordenarListaMedicos(LinkedList<Medico> lista){
        Collections.sort(lista,new Comparator<Medico>(){
            @Override
            public int compare(Medico t, Medico t1) {
                return t.getNombre().compareTo(t1.getNombre());
            }
    });
        return lista;
    }
    
    public PriorityQueue<Paciente> getSalaEspera(){
        return this.salaDeEspera;
    }
    
    public Paciente atenderPaciente(){
        if(salaDeEspera.isEmpty())return null;
        Paciente pacienteAtender=this.salaDeEspera.remove();
        for(Medico medicoTurno:this.medicosEnTurno){
            if(pacienteAtender.getMedicoQA().equals(medicoTurno.getNombre()) && !medicoTurno.isTurnoAtendiendo()){
               int numAtendidos=medicoTurno.getNumPacientes();
               medicoTurno.setTurnoAtendiendo(true);
               medicoTurno.setNumPacientes(numAtendidos+1);
               pacienteAtender.setMedicoQA(medicoTurno.getNombre());
               break;
            }else if(!medicoTurno.isTurnoAtendiendo() || !this.buscarMedicoEnTurno(pacienteAtender.getMedicoQA())){
               int numAtendidos=medicoTurno.getNumPacientes();
               medicoTurno.setTurnoAtendiendo(true);
               medicoTurno.setNumPacientes(numAtendidos+1);
               pacienteAtender.setMedicoQA(medicoTurno.getNombre());
               break;
            }
        }
        return pacienteAtender;
    }
    
    public boolean buscarMedicoEnTurno(String name){
       for(Medico med:this.medicosEnTurno){
           if(med.getNombre().equals(name))return true;
       }
       return false;
    }
    
    public String listarTurno(){
        String msg="";
        for(Medico medico:this.medicosEnTurno){
            msg+=medico.getNombre()+" Atendido: "+medico.getNumPacientes()+" Esta en atención: "+medico.isTurnoAtendiendo()+"\n";
        }
        return msg;
    }
    
    
    
    
    
    
}
