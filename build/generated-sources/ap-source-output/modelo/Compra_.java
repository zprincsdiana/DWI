package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Boleta;
import modelo.Cliente;
import modelo.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-03T00:48:24")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Integer> idcompra;
    public static volatile CollectionAttribute<Compra, Boleta> boletaCollection;
    public static volatile SingularAttribute<Compra, Float> precioTotal;
    public static volatile SingularAttribute<Compra, Integer> cantidadProducto;
    public static volatile SingularAttribute<Compra, Cliente> idcliente;
    public static volatile SingularAttribute<Compra, Producto> idproducto;

}