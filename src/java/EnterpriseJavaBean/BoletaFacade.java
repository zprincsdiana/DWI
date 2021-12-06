/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseJavaBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Boleta;

/**
 *
 * @author Administrador
 */
@Stateless
public class BoletaFacade extends AbstractFacade<Boleta> implements BoletaFacadeLocal {

    @PersistenceContext(unitName = "PryDWIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoletaFacade() {
        super(Boleta.class);
    }
    
}
