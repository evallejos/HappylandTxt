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
public class LogArchivos {
    
    private String fecha;
    private String nombreArchivo;
    private String nombreLocal;
    private int lineasInsertadas;

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the nombreLocal
     */
    public String getNombreLocal() {
        return nombreLocal;
    }

    /**
     * @param nombreLocal the nombreLocal to set
     */
    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    /**
     * @return the lineasInsertadas
     */
    public int getLineasInsertadas() {
        return lineasInsertadas;
    }

    /**
     * @param lineasInsertadas the lineasInsertadas to set
     */
    public void setLineasInsertadas(int lineasInsertadas) {
        this.lineasInsertadas = lineasInsertadas;
    }
    
}
