/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaGUI;

import capaDTO.LogArchivos;
import capaDTO.Pos;
import capaNegocio.InsertarDatosLogArchivos;
import capaNegocio.InsertarDatosPosBaseDatos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 *
 * @author evallejos
 */
public class ProcesarArchivoPos {
    
   private int totalLineas = 0;// VARIABLE PARA CONTAR LAS LINEAS DEL ARCHIVO   
   private String linea;//revisar linea separado por 
    
    public void procesarArchivoPos(String rutaDeDestino,String archivos)
    {
          
       
            
       InsertarDatosPosBaseDatos insertarDatosPos = new InsertarDatosPosBaseDatos();
       
       Pos pos = new Pos();
        
        try{
            
            // concateno ruta y nombre del archivo y creo el objeto archivoFinal
               File archivoFinal = new File (rutaDeDestino,archivos);                             
                                             
              
               FileReader lector = new FileReader(archivoFinal);               
                       
               BufferedReader buff = new BufferedReader(lector);
               // leo el objeto buff y guardo los datos del archivo en la variable linea
               while( ( linea = buff.readLine() ) != null )
               {
                 StringTokenizer datos =new StringTokenizer (linea,";");
                 
                 totalLineas ++;// INCREMENTO LA VARIABLE totalLineas EN 1
              
                 pos.setIdTransaccion(Integer.parseInt(datos.nextToken().trim()));
                 pos.setHora(datos.nextToken().trim());  
                 pos.setNumeroTerminal(Integer.parseInt(datos.nextToken().trim()));
                 pos.setTipo(Integer.parseInt(datos.nextToken().trim()));
                 pos.setNumeroComprobante(Integer.parseInt(datos.nextToken().trim()));
                 pos.setImporte(Double.parseDouble(datos.nextToken().trim()));
                                  
                                  
                 //llamo al metodo e INSERTO LOS DATOS DEL ARCHIVO EN LA DB
                insertarDatosPos.insertarDatosPos(pos);                             
                              
               }//fin while 
               buff.close();//cierro el archivo.txt
               
              LeerArchivos auxArchivos = new LeerArchivos ();
              
              auxArchivos.generarLog(archivos,rutaDeDestino,totalLineas);//metodo para generar log
               
               
               
          System.out.println("Total de Lineas Archivo "+archivos+" : ["+totalLineas+"]");
          Path original = Paths.get(rutaDeDestino+archivos);
          Path temporal = Paths.get(rutaDeDestino+"temporal");//mover archivos a la carpeta temporal
          Files.move(original,temporal.resolve(original.getFileName()));
          
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }//fin metodo procesar archivo
    
}
