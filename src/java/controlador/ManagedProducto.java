/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EnterpriseJavaBean.ProductoFacadeLocal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Categoria;
import modelo.Producto;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class ManagedProducto {
    @EJB
    ProductoFacadeLocal productoFacadeLocal;
    private List<Producto> listaProducto;
    private List<Producto> listarCarrito = new ArrayList<>();
    private Producto producto;
    private Categoria categoria;
    String nombreArchivo;
    String ruta="C:\\Users\\Usuario\\Downloads\\PryDWI_4\\PryDWI\\web\\resources\\imagenes_pro";
    private double totalCompra;
 
    

    public List<Producto> getListaProducto() {
        listaProducto = productoFacadeLocal.findAll();
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
        public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
    @PostConstruct
    public void init(){
        this.categoria = new Categoria();
        this.producto = new Producto();
    }
    
    public void guardar(){
        producto.setImagenProducto("/resources/imagenes_pro/"+nombreArchivo);
        this.producto.setIdcategoria(categoria);
        this.productoFacadeLocal.create(producto);
    }
    public void eliminar(Producto p){ //Eliminamos un cliente en particular
        this.productoFacadeLocal.remove(p);
    }
    public void cargarProducto(Producto p){
        this.categoria.setIdcategoria(p.getIdcategoria().getIdcategoria()); // Obtenemos el idCategoria de Categoria, y lo seteamos en setIdCat;
        this.producto = p;
    }
    
    public void modificar(){
        this.producto.setIdcategoria(categoria);
        this.productoFacadeLocal.edit(producto);
    }
    
    public void copiarImagen(FileUploadEvent e){
        byte[] b =new byte[50000];
        int todo;
        
        
        
        try {
            UploadedFile uploadedFile=e.getFile();
            nombreArchivo = uploadedFile.getFileName();
            File file=new File(ruta, nombreArchivo);
            OutputStream out= new FileOutputStream(file);
            InputStream in = uploadedFile.getInputstream();
            while((todo=in.read(b))!=-1){
                out.write(b, 0, todo);
            
        }
            out.close();
            in.close();
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagedProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagedProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      


    public List<Producto> getListarCarrito() {
        return listarCarrito;
    }

    public void setListarCarrito(List<Producto> listarCarrito) {
        this.listarCarrito = listarCarrito;
    }
    
    
    
    
    
    
    public void agregarCarrito(Producto p){
    listarCarrito.add(p);
    totalCompra = calcularTotal();
}
    
    public List<Producto> eliminarProductoCarrito(int codigo){
        for(int i=0; i<listarCarrito.size(); i++){
            if(listarCarrito.get(i).getIdproducto()==codigo){
                listarCarrito.remove(i);
            }
        }       
        totalCompra = calcularTotal();
        return listarCarrito;
    }

  public double calcularTotal(){
        double suma=0;
        for(Producto p:listarCarrito){
            suma = suma + p.getPrecioUnitario();
        }
        return suma;
    }    
}
