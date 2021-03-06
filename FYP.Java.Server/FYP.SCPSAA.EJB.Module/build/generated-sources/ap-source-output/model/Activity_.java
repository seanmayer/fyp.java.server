package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ActivitySummary;
import model.Athlete;
import model.CadenceLink;
import model.PowerLink;
import model.SpeedLink;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-19T09:21:25")
@StaticMetamodel(Activity.class)
public class Activity_ { 

    public static volatile SingularAttribute<Activity, Long> activityId;
    public static volatile CollectionAttribute<Activity, PowerLink> powerLinkCollection;
    public static volatile SingularAttribute<Activity, ActivitySummary> activitySummaryId;
    public static volatile CollectionAttribute<Activity, SpeedLink> speedLinkCollection;
    public static volatile SingularAttribute<Activity, Athlete> athleteId;
    public static volatile SingularAttribute<Activity, Long> stravaid;
    public static volatile SingularAttribute<Activity, String> name;
    public static volatile SingularAttribute<Activity, String> timeZone;
    public static volatile CollectionAttribute<Activity, CadenceLink> cadenceLinkCollection;
    public static volatile SingularAttribute<Activity, Date> startDate;

}