/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaGUI;


import capaDTO.LogArchivos;
import capaNegocio.InsertarDatosLogArchivos;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;



/**
 *
 * @author evallejos
 */
public class LeerArchivos {
    
    
   private String archivo;  //variable que guarda nombre del archivo 
   private String archivoPosCards;
   private String archivoPosDetalle;
   private String archivoPosPayments;
  
   
   
   
    public void leer() 
    {  
        
       RutaLocales rLocales = new RutaLocales (); 
        
       for(String s: rLocales.getRutas())
       {    
              String rutaDeDestino = s;  
           
                      File ruta =  new File (s);//creo el objeto ruta para mapear el directorio   
       
                       ProcesarArchivoPos archivoPos = new ProcesarArchivoPos ();
       
                       ProcesarArchivoCards archivosCards = new ProcesarArchivoCards ();
       
                      ProcesarArchivoPosDetalle auxArchivoPosDetalle = new ProcesarArchivoPosDetalle ();
       
                      ProcesarArchivoPosPayments auxArchivoPosPayments = new ProcesarArchivoPosPayments();
                   
      
                String [] listafichero= ruta.list();// guardo todo los archivos que estan dentro del objeto ruta       
       
                if(listafichero.length == 0){ 
                
                    System.out.println("No hay archivos para insertar");     
                }
                else{ 
                
                       for(int i=0; i < listafichero.length; i++)
                       {
               
                             if(listafichero [i].equals("pos-"+fecha()+".txt"))
                            {             
                                
                              archivo = listafichero [i];
                      
                              archivoPos.procesarArchivoPos(rutaDeDestino,archivo);                      
                                       
                            } 

                           if(listafichero[i].equals("pos_cards-"+fecha()+".txt"))
                           {
                      
                             archivoPosCards = listafichero [i];                      
                      
                             archivosCards.procesarArchivoCards(rutaDeDestino,archivoPosCards);                                       
                           }
                    
                          if(listafichero[i].equals("pos_detalle-"+fecha()+".txt"))
                          {
                      
                             archivoPosDetalle = listafichero [i];                      
                      
                              auxArchivoPosDetalle.procesarArchivoPosDetalle(rutaDeDestino,archivoPosDetalle);                                       
                          }
                  
                          if(listafichero[i].equals("pos_payments-"+fecha()+".txt"))
                          {
                      
                             archivoPosPayments = listafichero [i];                      
                      
                            auxArchivoPosPayments.procesarArchivoPosPayments(rutaDeDestino,archivoPosPayments);                                      
                         }                                        
                                  
                                             
                                                                   
                          
                      }  
                                                           
                 } //fin else       
                   
     
        }    
       
       
              
    }  //fin del metodo leer      
 
      
    
    public String fecha()
    {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String cadenaFecha = formato.format(fechaActual);
        
        return cadenaFecha;
    }
    
    public void generarLog(String archivo,String rutaDeDestino,int totalLineas)
    {
         LogArchivos log = new LogArchivos();
               
               
               InsertarDatosLogArchivos insertarDatosLog = new InsertarDatosLogArchivos();
               
                StringTokenizer archivoNombre =new StringTokenizer (archivo,".");
               
               log.setNombreArchivo(archivoNombre.nextToken().trim());
               log.setNombreLocal(rutaDeDestino.substring(15,18));
               log.setLineasInsertadas(totalLineas);
               //log.setFecha(leerArchivos.fecha());
               
               insertarDatosLog.insertarLogs(log);
    }
  
         
    
}//fin clase
