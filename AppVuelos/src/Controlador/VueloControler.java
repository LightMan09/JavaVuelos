package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.VueloDao;
import modelo.dto.Vuelo;
import Vista.VueloView;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;


public class VueloControler implements ActionListener {

    private VueloDao modelo;
    private VueloView view;
    private Vuelo vuelo;
    private int index;

    public VueloControler(VueloView view) {
        this.view = view;
        this.modelo = new VueloDao();

        this.view.btnCrear.addActionListener(this);
        this.view.btnLeer.addActionListener(this);
        this.view.btnActualizar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnLeerTodos.addActionListener(this);
        this.view.btnMostrarAsientosDisponibles.addActionListener(this);

        this.view.setVisible(true);
    }

public void crear() {
    Vuelo nuevoVuelo = new Vuelo();
    try {
        nuevoVuelo.setNumero(Integer.parseInt(view.txtNumero.getText()));
        nuevoVuelo.setOrigen(view.txtOrigen.getText());
        nuevoVuelo.setDestino(view.txtDestino.getText());

        // conversión de texto a Date
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fecha = formato.parse(view.txtFecha.getText());
        nuevoVuelo.setFechaHoraSalida(fecha);

        boolean creado = modelo.crear(nuevoVuelo);
        if (creado) {
            JOptionPane.showMessageDialog(view, "Vuelo creado correctamente.");
        } else {
            JOptionPane.showMessageDialog(view, "Error al crear el vuelo.");
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(view, "El número de vuelo debe ser un entero válido.");
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(view, "Formato de fecha incorrecto. Usa: dd/MM/yyyy HH:mm");
    }
}


    public void leer() {
        try {
            int numero = Integer.parseInt(view.txtNumero.getText());
            Vuelo vueloBuscado = new Vuelo();
            vueloBuscado.setNumero(numero);

            Vuelo encontrado = (Vuelo) modelo.leer(vueloBuscado);
            if (encontrado != null) {
                view.txtOrigen.setText(encontrado.getOrigen());
                view.txtDestino.setText(encontrado.getDestino());
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                view.txtFecha.setText(formato.format(encontrado.getFechaHoraSalida()));

                JOptionPane.showMessageDialog(view, "Vuelo encontrado.");
            } else {
                JOptionPane.showMessageDialog(view, "No se encontró el vuelo.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ingrese un número de vuelo válido.");
        }
    }

    public void actualizar() {
        try {
            int numero = Integer.parseInt(view.txtNumero.getText());
            Vuelo vueloBuscado = new Vuelo();
            vueloBuscado.setNumero(numero);

            index = modelo.buscarIndex(vueloBuscado);
            if (index >= 0) {
                Vuelo vueloActualizado = new Vuelo();
                vueloActualizado.setNumero(numero);
                vueloActualizado.setOrigen(view.txtOrigen.getText());
                vueloActualizado.setDestino(view.txtDestino.getText());
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date fecha = formato.parse(view.txtFecha.getText());
                    vueloActualizado.setFechaHoraSalida(fecha);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(view, "Formato de fecha incorrecto. Usa: dd/MM/yyyy HH:mm");
                }



                modelo.actualizar(index, vueloActualizado);
                JOptionPane.showMessageDialog(view, "Vuelo actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(view, "Vuelo no encontrado para actualizar.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Número de vuelo inválido.");
        }
    }

    public void eliminar() {
        try {
            int numero = Integer.parseInt(view.txtNumero.getText());
            Vuelo vueloEliminar = new Vuelo();
            vueloEliminar.setNumero(numero);

            boolean eliminado = modelo.eliminar(vueloEliminar);
            if (eliminado) {
                JOptionPane.showMessageDialog(view, "Vuelo eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo eliminar el vuelo (no encontrado).");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Número de vuelo inválido.");
        }
    }

    public void leerTodos() {
        StringBuilder sb = new StringBuilder("Lista de vuelos:\n");
        for (Object obj : modelo.leerTodos()) {
            Vuelo v = (Vuelo) obj;
            sb.append("Número: ").append(v.getNumero())
              .append(", Origen: ").append(v.getOrigen())
              .append(", Destino: ").append(v.getDestino())
              .append(", Fecha: ").append(v.getFechaHoraSalida());
        }
        JOptionPane.showMessageDialog(view, sb.toString());
    }

    public void mostrarAsientosDisponibles() {
        JOptionPane.showMessageDialog(view, "Función pendiente: mostrar asientos disponibles.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(view.btnCrear)) {
            crear();
        } else if (source.equals(view.btnLeer)) {
            leer();
        } else if (source.equals(view.btnActualizar)) {
            actualizar();
        } else if (source.equals(view.btnEliminar)) {
            eliminar();
        } else if (source.equals(view.btnLeerTodos)) {
            leerTodos();
        } else if (source.equals(view.btnMostrarAsientosDisponibles)) {
            mostrarAsientosDisponibles();
        }
    }
}
