package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CadenceLink;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-24T15:00:00")
@StaticMetamodel(Cadence.class)
public class Cadence_ { 

    public static volatile SingularAttribute<Cadence, Long> cadenceId;
    public static volatile SingularAttribute<Cadence, BigDecimal> datapoint;
    public static volatile SingularAttribute<Cadence, BigInteger> secondstamp;
    public static volatile CollectionAttribute<Cadence, CadenceLink> cadenceLinkCollection;

}