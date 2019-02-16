package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.PowerLink;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-16T15:20:42")
@StaticMetamodel(Power.class)
public class Power_ { 

    public static volatile SingularAttribute<Power, Long> powerId;
    public static volatile CollectionAttribute<Power, PowerLink> powerLinkCollection;
    public static volatile SingularAttribute<Power, BigDecimal> datapoint;
    public static volatile SingularAttribute<Power, BigInteger> secondstamp;

}