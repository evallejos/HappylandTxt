/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaDTO;

/**
 *
 * @author evallejos
 */
public class PosCards {
    private int idTransaccion;
    private String codigo;
    private String tarjeta;
    private double edinero;
    private double bonus;

    /**
     * @return the idTransaccion
     */
    public int getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * @param idTransaccion the idTransaccion to set
     */
    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the tarjeta
     */
    public String getTarjeta() {
        return tarjeta;
    }

    /**
     * @param tarjeta the tarjeta to set
     */
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * @return the edinero
     */
    public double getEdinero() {
        return edinero;
    }

    /**
     * @param edinero the edinero to set
     */
    public void setEdinero(double edinero) {
        this.edinero = edinero;
    }

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
}
