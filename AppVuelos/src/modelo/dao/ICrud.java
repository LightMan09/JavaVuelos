
package modelo.dao;

import java.util.List;

/**
 *
 * @author l1ghtm4n
 */
public interface ICrud {
    public abstract boolean crear(Object objeto);
    
    public abstract Object leer(Object objeto);
    
    public abstract Object actualizar(int e, Object objeto);
    
    public abstract boolean eliminar(Object objeto);
    
    public int buscarIndex(Object objecto);
    
    public List leerTodos();
}
