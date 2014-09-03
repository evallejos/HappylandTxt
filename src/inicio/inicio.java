/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inicio;

import capaGUI.Servicio;
import java.util.Timer;

/**
 *
 * @author evallejos
 */
public class inicio {
    
     public static void main(String[] args)
    {
        Timer timer = new Timer ();
        
        Servicio servicio = new Servicio();       
        
        timer.schedule(servicio,0,60000);
    }
    
    
}
