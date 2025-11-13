
package modelo.dto;


import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author l1ghtm4n
 */
public class Vuelo implements Serializable{
    private int numero;
    private String origen;
    private String destino;
    private Date fechaHoraSalida;
    private String aerolinea;
    private Asiento[][] asientos;
    
    public void generarAsientos(int filas, int asientosPorFila) {
        this.asientos = new Asiento[filas][asientosPorFila];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < asientosPorFila; j++) {
                // Crea una nueva instancia de Asiento
                this.asientos[i][j] = new Asiento();
                // Asigna la fila y la letra del asiento (ej. 1A, 2B)
                this.asientos[i][j].setFila(i + 1); // Fila empieza en 1
                this.asientos[i][j].setAsiento((char) ('A' + j)); // Letra del asiento 0='A', 1='B', etc.
                // El pasajero es null por defecto, indicando que el asiento está libre
            }
        }
    }
    public void setAsiento(Asiento[][] asiento){this.asientos = asiento;}
    
    public Asiento[][] getAsiento(){return asientos;}
    
    public void setNumero(int numero){this.numero = numero;}
    
    public int getNumero(){return numero;}
    
    public void setOrigen(String origen){this.origen = origen;}
    
    public String getOrigen(){return origen;}
    
    public void setDestino(String destino){this.destino = destino;}
    
    public String getDestino(){return destino;}
    
    public Date getFechaHoraSalida(){return fechaHoraSalida;}
    
    public void setFechaHoraSalida(Date fechaHS){this.fechaHoraSalida= fechaHS;}
    
    public void setAereolinea(String aereolinea){this.aerolinea = aereolinea;}
    
    public String getAereolinea(){return aerolinea;}
}
