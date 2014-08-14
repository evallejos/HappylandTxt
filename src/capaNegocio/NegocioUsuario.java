/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaNegocio;

import capaConexion.Conexion;
import capaDTO.Usuario;

/**
 *
 * @author evallejos
 */
public class NegocioUsuario {
    
    
    private Conexion con1=new Conexion();

    
    public void configurarConexion()
    {
        this.setCon1(new Conexion());
        this.getCon1().setNombreBaseDeDatos("jdbc:mysql://10.100.70.42/python");
        this.getCon1().setNombreTabla("usuarios");
        this.getCon1().setCadenaConexion("com.mysql.jdbc.Driver");
        this.getCon1().setUsuario("root");
        this.getCon1().setPass("dfe530tx1");
    }

    
    
    
    public void insertarUsuario(Usuario usuario)
    {
        this.configurarConexion();
        this.getCon1().setCadenaSQL("INSERT INTO "+this.getCon1().getNombreTabla()+" (nombre,edad,id) VALUES ('"+usuario.getNombre()+"','"+usuario.getEdad()+"','"+usuario.getId()+"')");
        this.getCon1().setEsSelect(false);
        this.getCon1().conectar();
        this.getCon1().cerrar();
    } 
    
    public boolean validarDatos(int id)
    {
        boolean estado = false;       
        this.configurarConexion();
        this.getCon1().setCadenaSQL("SELECT * FROM "+this.getCon1().getNombreTabla()+ " WHERE id='"+id+"';");
        this.getCon1().setEsSelect(true);
        this.getCon1().conectar();
        
        try
        {
          if(this.getCon1().getDbResultSet().first())
          {
                        
             estado = true;
             
             return estado;
          }     
          
                    
          
        }   
          catch (Exception ex)
          {
                    
              System.out.println(ex.getMessage());
              
          }       
        this.getCon1().cerrar();
        
        return estado;
        
    }
    
    
    /**
     * @return the con1
     */
    public Conexion getCon1() {
        return con1;
    }

    /**
     * @param con1 the con1 to set
     */
    public void setCon1(Conexion con1) {
        this.con1 = con1;
    }
    
}
