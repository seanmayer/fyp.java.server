package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Activity;
import model.Power;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-26T20:18:03")
@StaticMetamodel(PowerLink.class)
public class PowerLink_ { 

    public static volatile SingularAttribute<PowerLink, Power> powerId;
    public static volatile SingularAttribute<PowerLink, Activity> activityId;
    public static volatile SingularAttribute<PowerLink, Long> powerLinkId;

}