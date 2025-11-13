
package modelo.dao;

/**
 *
 * @author l1ghtm4n
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Super Clase Generica que herdan todas las clases para crear la persistencia
 * Permite crear archivos de objetos y guardarlos en 1 capa de persistencia HD
 * @param <T> nombre genrico para cada archivo
 */
public class Persistencia<T> implements Serializable {

    protected List<T> lista;
    protected transient ObjectInputStream entrada;
    protected transient ObjectOutputStream salida;
    protected String archivo;

    @SuppressWarnings("unchecked")
    /**
     * Función para leer los archivos de la capa de persistencia
     * y guardar los datos contenidos en objetos en un arreglo dinamico List
     * @param archivo
     */
    public Persistencia(String archivo) {
        this.lista = new ArrayList<>();
        this.archivo = archivo;
        File file = new File(archivo);

        if (file.isFile()) {
            try {
                this.entrada = new ObjectInputStream(new FileInputStream(archivo));
                this.lista = (List<T>) this.entrada.readObject();
                this.entrada.close();
            } catch (Exception e) {
                System.out.println("Error al guardar: " + e.getMessage());
                guardar();
            }
        }
    }

    /**
     * Función para guardar archivos eb la capa de persistencia HD
     */
    public void guardar() {
        try {
            this.salida = new ObjectOutputStream(new FileOutputStream(archivo));
            this.salida.writeObject(lista);
            this.salida.close();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}