package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Activity;
import model.Speed;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-03T17:49:39")
@StaticMetamodel(SpeedLink.class)
public class SpeedLink_ { 

    public static volatile SingularAttribute<SpeedLink, Activity> activityId;
    public static volatile SingularAttribute<SpeedLink, Long> speedLinkId;
    public static volatile SingularAttribute<SpeedLink, Speed> speedId;

}