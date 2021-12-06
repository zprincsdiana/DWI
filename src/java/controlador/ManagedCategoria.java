package controlador;

import EnterpriseJavaBean.CategoriaFacade;
import EnterpriseJavaBean.CategoriaFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Categoria;

/**
 *
 * @Clase va a ser convertido en un BEAN
 */

@ManagedBean
@SessionScoped

public class ManagedCategoria {
    @EJB
    CategoriaFacadeLocal categoriaFacadeLocal; //No se genera get and set xq es una interfaz
    //Por cada facadeLocal se importa EJB
    private List<Categoria> listarCategoria;
    private Categoria categoria;

    public List<Categoria> getListarCategoria() { //Selecciona todos los datos de categoría
        listarCategoria = categoriaFacadeLocal.findAll(); //Es Listar Todo - Select * from 
        return listarCategoria;
    }

    public void setListarCategoria(List<Categoria> listarCategoria) {
        this.listarCategoria = listarCategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    //Constructor 
    @PostConstruct
    public void init(){
        this.categoria = new Categoria();
    }
    
    public void guardar(){
        this.categoriaFacadeLocal.create(categoria);
    }
    
    public void eliminar(Categoria c){ //Eliminamos una categoría en particular
        this.categoriaFacadeLocal.remove(c);
    }
    
    //1ro obtenemos los datos
    public void cargarCategorias(Categoria c){
        this.categoria = c;
    }
    
    public void modificar(){
        this.categoriaFacadeLocal.edit(categoria);
    }
    
    
}
