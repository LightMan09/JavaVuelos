package modelo.dto;

import java.io.Serializable;
/**
 *
 * @author l1ghtm4n
 */
public class Pasajero implements Serializable {
    private String nombre;
    private String correoElectronico;
    
    public String getNombre(){return nombre;}
    
    public void setNombre(String nombre){this.nombre = nombre;}
    
    public String getCorreoElectronico(){return correoElectronico;}
    
    public void setCorreoElectronico(String correo){this.correoElectronico = correo;}
}
