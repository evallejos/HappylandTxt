/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


 
public class Conexion 
{ 
    //variables de instancia
    private String     nombreBaseDeDatos;
    private String     nombreTabla;
    private String     cadenaConexion;
    private String     cadenaSQL;
    private boolean    esSelect;
    private ResultSet  dbResultSet;
    private Connection dbConnection;
    private String     usuario;
    private String     pass;

    /**
     * @return the nombreBaseDeDatos
     */
    public String getNombreBaseDeDatos() {
        return nombreBaseDeDatos;
    }

    /**
     * @param nombreBaseDeDatos the nombreBaseDeDatos to set
     */
    public void setNombreBaseDeDatos(String nombreBaseDeDatos) {
        this.nombreBaseDeDatos = nombreBaseDeDatos;
    }

    /**
     * @return the nombreTabla
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * @param nombreTabla the nombreTabla to set
     */
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @return the cadenaConexion
     */
    public String getCadenaConexion() {
        return cadenaConexion;
    }

    /**
     * @param cadenaConexion the cadenaConexion to set
     */
    public void setCadenaConexion(String cadenaConexion) {
        this.cadenaConexion = cadenaConexion;
    }

    /**
     * @return the cadenaSQL
     */
    public String getCadenaSQL() {
        return cadenaSQL;
    }

    /**
     * @param cadenaSQL the cadenaSQL to set
     */
    public void setCadenaSQL(String cadenaSQL) {
        this.cadenaSQL = cadenaSQL;
    }

    /**
     * @return the esSelect
     */
    public boolean isEsSelect() {
        return esSelect;
    }

    /**
     * @param esSelect the esSelect to set
     */
    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }

    /**
     * @return the dbResultSet
     */
    public ResultSet getDbResultSet() {
        return dbResultSet;
    }

    /**
     * @param dbResultSet the dbResultSet to set
     */
    public void setDbResultSet(ResultSet dbResultSet) {
        this.dbResultSet = dbResultSet;
    }

     /**
     * @return the dbConnection
     */
    public Connection getDbConnection() {
        return dbConnection;
    }

    /**
     * @param dbConnection the dbConnection to set
     */
    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
    

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    //Metodos personales
    
    public void cerrar()
    {
       try
       {
          this.getDbConnection().close();
       }
       catch(Exception ex)
       {
           System.out.println("Error al cerrar coneccion " + ex.getMessage());
       }
    } //fin cerrar

    public void conectar()
    {
        //Validar las variables de instancia
        if (this.getNombreBaseDeDatos().isEmpty())
        {
            System.out.println("Base de datos en blanco");
           return;
        }

        if (this.getNombreTabla().isEmpty())
        {
            System.out.println("Nombre tabla en blanco en blanco");
           return;
        }
        if (this.getCadenaConexion().isEmpty())
        {
            System.out.println("Cadena conexion en blanco");
           return;
        }
        if (this.getCadenaSQL().isEmpty())
        {
            System.out.println("SQL en blanco");
           return;
        }
        if (this.getUsuario().isEmpty())
        {
            System.out.println("Usuario en blanco");
           return;
        }

        Statement st = null;
        try
        {
          //Se carga el Driver
            Class.forName(this.getCadenaConexion());
            this.setDbConnection(DriverManager.getConnection(this.getNombreBaseDeDatos(), this.getUsuario(), this.getPass()));
            st = this.getDbConnection().createStatement();
        }
        catch(Exception ex)
        {
             System.out.println("Error conexion "+ex.getMessage());
        } //Fin conexion
        
        if(this.isEsSelect())
        {
            try
            {
                //Se carga el ResultSet
                this.setDbResultSet(st.executeQuery(this.getCadenaSQL()));
            } catch (Exception ex) {
                 System.out.println("Error de carga de datos "+ex.getMessage());;
            }
            
        }
        else
        {
            try {
                int insertFila = st.executeUpdate(this.getCadenaSQL());
            } catch (Exception ex) {
                System.out.println("Error SQL "+ex.getMessage());
            }
            
        }        
        
    } //fin conectar   
} //Fin clase

    

