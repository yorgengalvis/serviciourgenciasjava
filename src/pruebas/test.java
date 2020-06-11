/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Medico;
import modelo.Paciente;
import modelo.Urgencias;

/**
 *
 * @author YorgenGalvis
 */
public class test {

    public static void main(String[] args) {
        Paciente p1 = new Paciente(2, "Jesus Gonzales", "Mario Rodriguez");
        Paciente p2 = new Paciente(1, "Yorgen Galvis", "Hector de la cruz");
        Paciente p3 = new Paciente(8, "Lilia Romero", "Mario Rodriguez");
        Paciente p4 = new Paciente(7, "Andrey Rivera", "Maria Manosalva");
        Paciente p5 = new Paciente(3, "Ronald Benitez", "Hector de la cruz");
        Paciente p6 = new Paciente(4, "Diego Galvis", "Mario Rodriguez");
        Paciente p7 = new Paciente(6, "Angelly Basto", "Mario Rodriguez");
        Paciente p8 = new Paciente(5, "Natalia Remolina", "Maria Manosalva");
        Paciente p9 = new Paciente(10, "Miguel Fernandez", "Ronald Jesus");
        Paciente p10 = new Paciente(9, "Josue Garcia", "Hector de la cruz");

        Medico m1 = new Medico("Hector de la cruz");
        Medico m2 = new Medico("Mario Rodrgiuez");

        LinkedList<Paciente> aseguradosTurno = new LinkedList<Paciente>();
        aseguradosTurno.add(p1);
        aseguradosTurno.add(p4);
        aseguradosTurno.add(p6);
        aseguradosTurno.add(p2);
        aseguradosTurno.add(p3);
        aseguradosTurno.add(p5);
        aseguradosTurno.add(p7);
        aseguradosTurno.add(p8);
        aseguradosTurno.add(p9);
        LinkedList<Medico> medicosTurno = new LinkedList<Medico>();
        medicosTurno.add(m1);
        medicosTurno.add(m2);

        Urgencias ur = new Urgencias();

        try {
            ur.crearTurno(medicosTurno, aseguradosTurno);

            //Se crea un nuevo paciente
            Paciente pnuevo = new Paciente(10, "Miguel Fernandez");
            Paciente pnuevo2 = new Paciente(5, "Natalia Remolina");
            Paciente pnuevo3 = new Paciente(4, "Diego Galvis");
            Paciente pnuevo4 = new Paciente(1, "Yorgen Galvis");
            //se inserta paciente
           //ur.insertPaciente(pnuevo, "Hemorragia masiva incontrolable");
           
            ur.insertPaciente(pnuevo2,"Dolor intenso");
            ur.insertPaciente(pnuevo3,"Fiebre");
            ur.insertPaciente(pnuevo,"Hemorragia masiva incontrolable");
            ur.insertPaciente(pnuevo4,"Hemorragia masiva incontrolable");
            //Se atiende un paciente
             /*while(!ur.salaDeEspera.isEmpty()) {
       System.out.println("Dqueue" + "-->" + ur.salaDeEspera.remove());
        }*/
             
             //Atiende un paciente.
            System.out.println(ur.atenderPaciente());
            System.out.println(ur.atenderPaciente());
            System.out.println(ur.atenderPaciente());
            System.out.println("==========================");
            /*PriorityQueue<Paciente> aux=ur.salaDeEspera;
             while(!aux.isEmpty()) {
       System.out.println("Dqueue" + "-->" + ur.salaDeEspera.remove());
        }*/
             Paciente pnuevo5 = new Paciente(7, "Andrey Rivera");
             ur.insertPaciente(pnuevo5,"Hemorragia masiva incontrolable");
             Paciente pnuevo6 = new Paciente(8, "Andrey Rivera");
             ur.insertPaciente(pnuevo6,"Hemorragia masiva incontrolable");
             PriorityQueue<Paciente> aux2=ur.salaDeEspera;
             while(!aux2.isEmpty()) {
       System.out.println("Dqueue" + "-->" + ur.salaDeEspera.remove());
        }
             System.out.println(ur.listarTurno());
          
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
