/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaGUI;


import java.util.TimerTask;

/**
 *
 * @author evallejos
 */
public class Servicio extends TimerTask{
    
      

    @Override
    public void run() {
     LeerArchivos Larchivo = new LeerArchivos ();
             
     Larchivo.leer();
    }
        
    
}
