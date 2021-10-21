/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.ProductosDao;
import modelo.entidad.Productos;


/**
 *
 * @author elcon
 */
@ManagedBean
@ViewScoped
public class ProductosControl {

    /**
     * Creates a new instance of productoControl
     */
    private List<Productos> listaProductos;
    private Productos producto;

    public ProductosControl() {
        producto = new Productos();
    }

    public List<Productos> getListaProductos() {
        ProductosDao ad = new ProductosDao();
        listaProductos = ad.listarProductos();
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Productos getProductos() {
        return producto;
    }

    public void setProductos(Productos producto) {
        this.producto = producto;
    }

    public void limpiarProductos() {
        producto = new Productos();
    }

    public void agregarProductos() {
        ProductosDao ad = new ProductosDao();
        ad.agregar(producto);
    }

    public void modificarProductos() {
        ProductosDao ad = new ProductosDao();
        ad.modificar(producto);
        limpiarProductos();
    }

    public void eliminarProductos() {
        ProductosDao ad = new ProductosDao();
        ad.eliminar(producto);
        limpiarProductos();
    }
}
