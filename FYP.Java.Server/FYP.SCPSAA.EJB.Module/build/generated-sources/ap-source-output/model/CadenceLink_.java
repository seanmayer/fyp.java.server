package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Activity;
import model.Cadence;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T08:26:04")
@StaticMetamodel(CadenceLink.class)
public class CadenceLink_ { 

    public static volatile SingularAttribute<CadenceLink, Long> cadenceLinkId;
    public static volatile SingularAttribute<CadenceLink, Activity> activityId;
    public static volatile SingularAttribute<CadenceLink, Cadence> cadenceId;

}