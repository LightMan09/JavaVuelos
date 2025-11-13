
package modelo.dao;

/**
 *
 * @author l1ghtm4n
 */


import java.util.List;
import modelo.dto.Vuelo;

/**
 * Hereda de Persistencia
 * Implementa ICrud
 */
public class VueloDao extends Persistencia<Vuelo> implements ICrud {

    public VueloDao() {
        // Llama al constructor de la súper clase y le pasa el nombre del archivo de persistencia
        // El nombre del archivo será "vuelo" (como en EstudianteDao usaba "estudiante").
        super("vuelo"); 
    }

    @Override
    public boolean crear(Object object) { 
        // Primero, añade el objeto Vuelo a la lista protegida 'lista' de la súper clase Persistencia.
        boolean estado = lista.add((Vuelo) object);
        // Segundo, llama al método del padre para guardar la lista completa en el archivo.
        guardar(); 
        return estado;
    }

    @Override
    public Object leer(Object object) { 
        // Se busca el Vuelo por su identificador único (numero).
        int numeroABuscar = ((Vuelo) object).getNumero();
        for (Vuelo vuelo : lista) {
            if (vuelo.getNumero() == numeroABuscar) {
                return vuelo;
            }
        }
        return null;
    }

    @Override
    public Object actualizar(int index, Object object) { 
        // 1. Reemplaza el objeto Vuelo en la posición 'index'.
        Object estado = lista.set(index, (Vuelo) object);
        // 2. Guarda la lista actualizada.
        guardar(); 
        return estado;
    }

    @Override
    public boolean eliminar(Object object) { 
        // 1. Elimina el objeto Vuelo de la lista.
        boolean estado = lista.remove((Vuelo) object);
        // 2. Guarda la lista.
        guardar(); 
        return estado;
    }

    @Override
    public int buscarIndex(Object object) { 
        // Retorna el índice del objeto Vuelo.
        return lista.indexOf(object);
    }

    @Override
    public List leerTodos() { 
        // Retorna la lista completa de Vuelos cargada por Persistencia.
        return lista;
    }
}