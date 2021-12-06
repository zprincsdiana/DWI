package controlador;

import javax.annotation.PostConstruct;
import EnterpriseJavaBean.UsuariosFacadeLocal;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Usuarios;

@ManagedBean
@SessionScoped

public class ManagedUsuarios {

    @EJB
    UsuariosFacadeLocal usuariosFacadeLocal;
    private List<Usuarios> listarUsuarios;
    private Usuarios usuarios;
    String verPagina = null;

    public List<Usuarios> getListarUsuarios() {
        return listarUsuarios;
    }

    public void setListarUsuarios(List<Usuarios> listarUsuarios) {
        this.listarUsuarios = listarUsuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @PostConstruct
    public void init() {
        this.usuarios = new Usuarios();
    }

    public String validarUsuario() {
        listarUsuarios = usuariosFacadeLocal.buscarUsuarios(usuarios);
        if (!listarUsuarios.isEmpty()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuarios);
            verPagina = "/paginas/admindex.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage("Usuario o contraseña invalida");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        return verPagina;
    }

    
    public void obtenerSesion(){
          usuarios = (Usuarios)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
          if(usuarios == null){
              try {
                  FacesContext.getCurrentInstance().getExternalContext().redirect("/IniciarSesion.xhtml");
              } catch (IOException ex) {
                  Logger.getLogger(ManagedUsuarios.class.getName()).log(Level.SEVERE, null, ex);
              }
        }       
        
    }

    public void cerrarSesion(){
        
        try {
            //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ManagedUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
       // verPagina = "index.xhtml";
    }


}
