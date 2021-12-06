package controlador;

import EnterpriseJavaBean.ClienteFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;

@ManagedBean
@SessionScoped

public class ManagedCliente {
    @EJB
    ClienteFacadeLocal clienteFacadeLocal;
    List<Cliente> listaCliente;
    Cliente cliente;

    public List<Cliente> getListaCliente() {
        listaCliente = clienteFacadeLocal.findAll();
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
     //Constructor 
    @PostConstruct
    public void init(){
        this.cliente = new Cliente();
    }
    
    public void guardar(){
        this.clienteFacadeLocal.create(cliente);
    }
    
    public void eliminar(Cliente cli){ //Eliminamos un cliente en particular
        this.clienteFacadeLocal.remove(cli);
    }
    
    //1ro obtenemos los datos
    public void cargarClientes(Cliente cli){
        this.cliente = cli;
    }
    //2do modificamos
    public void modificar(){
        this.clienteFacadeLocal.edit(cliente);
    }
    
    
    
}
