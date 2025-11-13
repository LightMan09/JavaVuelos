
package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author l1ghtm4n
 */
public class Asiento implements Serializable{
    private int fila;
    private char asiento;
    private Pasajero pasajero;

    
    public int getFila(){return fila;}
    
    public void setFila(int fila){this.fila = fila;}
    
    public char getAsiento(){return asiento;}
    
    public void setAsiento(char asiento){this.asiento=asiento;}
    
    public Pasajero getPasajero(){return pasajero;}
    
    public void setPasajero(Pasajero pasajero){this.pasajero = pasajero;}


}
