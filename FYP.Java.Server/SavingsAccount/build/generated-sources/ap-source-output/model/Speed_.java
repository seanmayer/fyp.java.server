package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.SpeedLink;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-24T15:00:00")
@StaticMetamodel(Speed.class)
public class Speed_ { 

    public static volatile SingularAttribute<Speed, BigDecimal> datapoint;
    public static volatile SingularAttribute<Speed, BigInteger> secondstamp;
    public static volatile CollectionAttribute<Speed, SpeedLink> speedLinkCollection;
    public static volatile SingularAttribute<Speed, Long> speedId;

}