package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compra;
import modelo.Tarjeta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-03T00:48:24")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> correoCliente;
    public static volatile SingularAttribute<Cliente, Integer> tipo;
    public static volatile CollectionAttribute<Cliente, Tarjeta> tarjetaCollection;
    public static volatile SingularAttribute<Cliente, String> nombreCliente;
    public static volatile SingularAttribute<Cliente, String> passwordCliente;
    public static volatile CollectionAttribute<Cliente, Compra> compraCollection;
    public static volatile SingularAttribute<Cliente, String> direccionCliente;
    public static volatile SingularAttribute<Cliente, Integer> telefonoCliente;
    public static volatile SingularAttribute<Cliente, Integer> idcliente;

}