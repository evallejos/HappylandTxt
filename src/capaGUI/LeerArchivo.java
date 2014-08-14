/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaGUI;

import capaDTO.Usuario;
import capaNegocio.NegocioUsuario;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;
import java.util.StringTokenizer;


/**
 *
 * @author evallejos
 */
public class LeerArchivo {
    
   private String archivo;  //variable que guarda nombre del archivo 
   private int totalLineas = 0;// VARIABLE PARA CONTAR LAS LINEAS DEL ARCHIVO   
   private String linea;//revisar linea separado por ,
   
   
    public void leer() 
    {  
       
       NegocioUsuario Nusuario = new NegocioUsuario();//creo el objeto De la clase NegocioUsuario 
       
       Usuario usuario = new Usuario (); //creo el objeto de la clase usuario
       
       File ruta =  new File ("/home/pruebatxt");//creo el objeto ruta para mapear el directorio      
      
       
       
       
         
  try{ 
      
      String [] listafichero= ruta.list();// guardo todo los archivos que estan dentro del objeto ruta
       
       
       if(listafichero.length == 0)
       { 
                      System.out.println("No hay archivos para insertar");     
       }
        else
        { 
           for(int i=0; i < listafichero.length; i++)
           {
                archivo = listafichero[i];   //guardo el arcvhivo encontrado en la variable archvio    
            }     
                                        
               File archivoFinal = new File (ruta,archivo); // concateno ruta y nombre del archivo y creo el objeto archivoFinal                            
                                             
              
               FileReader lector = new FileReader(archivoFinal);               
                       
               BufferedReader buff = new BufferedReader(lector);
        
               while( ( linea = buff.readLine() ) != null )// leo el objeto buff y guardo los datos del archivo en la variable linea
               {
                 StringTokenizer datos =new StringTokenizer (linea,",");
                 
                 totalLineas ++;// INCREMENTO LA VARIABLE totalLineas EN 1
              
                 usuario.setNombre(datos.nextToken().trim());
                 usuario.setEdad(Integer.parseInt(datos.nextToken().trim()));  
                 usuario.setId(Integer.parseInt(datos.nextToken().trim()));
                 System.out.println("nombre :"+ usuario.getNombre());
                 System.out.println("EDAD :" + usuario.getEdad());
                 System.out.println("id :" + usuario.getId());
                 
                Nusuario.insertarUsuario(usuario);//llamo al metodo e INSERTO LOS DATOS DEL ARCHIVO EN LA DB                             
                              
              }//fin while  
              
           System.out.println("Total de Lineas ["+totalLineas+"]");
           Path original = Paths.get("/home/pruebatxt/"+archivo);
           Path temporal = Paths.get("/home/temporaltxt");
           Files.move(original,temporal.resolve(original.getFileName()),REPLACE_EXISTING);
                                                           
          } //fin else         
                   
          
           
            
     }catch(Exception ex)
     {
         System.out.println(ex.getMessage());
     }
          
       
       
  }   //fin del metodo    

    
    
    
}//fin clase
