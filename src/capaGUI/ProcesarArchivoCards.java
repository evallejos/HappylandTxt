/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaGUI;


import capaDTO.PosCards;
import capaNegocio.InsertarDatosPosCardsBaseDatos;
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
public class ProcesarArchivoCards {   
    
   private int totalLineas = 0;// VARIABLE PARA CONTAR LAS LINEAS DEL ARCHIVO   
   private String linea;//revisar linea separado por 
   
   
   
   
    
    public void procesarArchivoCards(String rutaDeDestino,String archivoPosCards)
    {             
            
       InsertarDatosPosCardsBaseDatos insertarDatosPos = new InsertarDatosPosCardsBaseDatos();
       
       PosCards pos = new PosCards();//objeto para llamar a los seteadores de la clase PostCards
        
        try{
            
            // concateno ruta y nombre del archivo y creo el objeto archivoFinal
               File archivoFinal = new File (rutaDeDestino,archivoPosCards);                             
                                             
              
               FileReader lector = new FileReader(archivoFinal);               
                       
               BufferedReader buff = new BufferedReader(lector);
               // leo el objeto buff y guardo los datos del archivo en la variable linea
               while( ( linea = buff.readLine() ) != null )
               {
                 StringTokenizer datos =new StringTokenizer (linea,";");
                 
                 totalLineas ++;// INCREMENTO LA VARIABLE totalLineas EN 1
              
                 pos.setIdTransaccion(Integer.parseInt(datos.nextToken().trim()));
                 pos.setCodigo(datos.nextToken().trim());  
                 pos.setTarjeta(datos.nextToken().trim());
                 pos.setEdinero(Double.parseDouble(datos.nextToken().trim()));
                 pos.setBonus(Double.parseDouble(datos.nextToken().trim()));                 
                                  
                                  
                 //llamo al metodo e INSERTO LOS DATOS DEL ARCHIVO EN LA DB
                insertarDatosPos.insertarDatosPos(pos);
                              
               }//fin while 
               buff.close();//cierro el archivo.txt
               
                LeerArchivos auxArchivos = new LeerArchivos ();
              
              auxArchivos.generarLog(archivoPosCards,rutaDeDestino,totalLineas);
               
           System.out.println("Total de Lineas Archivo "+archivoPosCards+" : ["+totalLineas+"]");
           Path original = Paths.get(rutaDeDestino+archivoPosCards);
           Path temporal = Paths.get(rutaDeDestino+"temporal");
           Files.move(original,temporal.resolve(original.getFileName()));
        }
           catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }//fin metodo procesar archivo
    
}
