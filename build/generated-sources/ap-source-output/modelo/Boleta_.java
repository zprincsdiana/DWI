package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compra;
import modelo.Tarjeta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-03T00:48:24")
@StaticMetamodel(Boleta.class)
public class Boleta_ { 

    public static volatile SingularAttribute<Boleta, Compra> idcompra;
    public static volatile SingularAttribute<Boleta, Date> fechaCompra;
    public static volatile SingularAttribute<Boleta, Integer> estado;
    public static volatile SingularAttribute<Boleta, Float> pagoTotal;
    public static volatile SingularAttribute<Boleta, Integer> idboleta;
    public static volatile SingularAttribute<Boleta, Tarjeta> idtarjeta;

}