/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EnterpriseJavaBean.TarjetaFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import modelo.Tarjeta;

@ManagedBean
@SessionScoped
public class ManagedTarjeta {
    @EJB
    TarjetaFacadeLocal tarjetaFacadeLocal;
    private List<Tarjeta> listaTarjeta;
    private Tarjeta tarjeta;
    private Cliente cliente;

    public List<Tarjeta> getListaTarjeta() {
        listaTarjeta = tarjetaFacadeLocal.findAll();
        return listaTarjeta;
    }

    public void setListaTarjeta(List<Tarjeta> listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    @PostConstruct
    public void init(){
        this.cliente = new Cliente();
        this.tarjeta = new Tarjeta();
    }
    
    public void guardar(){
        this.tarjeta.setIdcliente(cliente);
        this.tarjetaFacadeLocal.create(tarjeta);
    }
    public void eliminar(Tarjeta t){ //Eliminamos una tarjeta en particular
        this.tarjetaFacadeLocal.remove(t);
    }
    public void cargarTarjeta(Tarjeta t){
        this.cliente.setIdcliente(t.getIdcliente().getIdcliente()); 
        this.tarjeta = t;
    }
    
    public void modificar(){
        this.tarjeta.setIdcliente(cliente);
        this.tarjetaFacadeLocal.edit(tarjeta);
    }

    
}
