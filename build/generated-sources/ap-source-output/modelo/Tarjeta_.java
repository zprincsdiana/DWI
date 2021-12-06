package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Boleta;
import modelo.Cliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-03T00:48:24")
@StaticMetamodel(Tarjeta.class)
public class Tarjeta_ { 

    public static volatile SingularAttribute<Tarjeta, Integer> codigo;
    public static volatile SingularAttribute<Tarjeta, String> entidad;
    public static volatile SingularAttribute<Tarjeta, Integer> idtarjeta;
    public static volatile SingularAttribute<Tarjeta, Date> fechaCad;
    public static volatile CollectionAttribute<Tarjeta, Boleta> boletaCollection;
    public static volatile SingularAttribute<Tarjeta, Cliente> idcliente;

}