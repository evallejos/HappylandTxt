/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaNegocio;

import capaConexion.Conexion;
import capaDTO.*;

/**
 *
 * @author evallejos
 */
public class InsertarDatosPosCardsBaseDatos {
    
     private Conexion con1=new Conexion();

    
    public void configurarConexion()
    {
        this.setCon1(new Conexion());
        this.getCon1().setNombreBaseDeDatos("jdbc:mysql://10.100.70.42/python");
        this.getCon1().setNombreTabla("PosCards");
        this.getCon1().setCadenaConexion("com.mysql.jdbc.Driver");
        this.getCon1().setUsuario("root");
        this.getCon1().setPass("dfe530tx1");
    }
    
    
    public void insertarDatosPos(PosCards pos)
    {
      
        this.configurarConexion();
        this.getCon1().setCadenaSQL("INSERT INTO "+this.getCon1().getNombreTabla()+" (id_transaccion,codigo,tarjeta,edinero,bonus)VALUES ('"+pos.getIdTransaccion()+"','"+pos.getCodigo()+"','"+pos.getTarjeta()+"','"+pos.getEdinero()+"','"+pos.getBonus()+"')");
        this.getCon1().setEsSelect(false);
        this.getCon1().conectar();
        this.getCon1().cerrar();
        
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
