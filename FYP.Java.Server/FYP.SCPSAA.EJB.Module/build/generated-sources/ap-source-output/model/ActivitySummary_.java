package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Activity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-15T11:49:17")
@StaticMetamodel(ActivitySummary.class)
public class ActivitySummary_ { 

    public static volatile SingularAttribute<ActivitySummary, BigDecimal> kilojoules;
    public static volatile SingularAttribute<ActivitySummary, Activity> activityId;
    public static volatile SingularAttribute<ActivitySummary, Long> activitySummaryId;
    public static volatile SingularAttribute<ActivitySummary, BigDecimal> averageCadence;
    public static volatile SingularAttribute<ActivitySummary, BigDecimal> distance;
    public static volatile SingularAttribute<ActivitySummary, BigInteger> movingTime;
    public static volatile SingularAttribute<ActivitySummary, BigDecimal> averageSpeed;
    public static volatile SingularAttribute<ActivitySummary, BigDecimal> maxSpeed;
    public static volatile SingularAttribute<ActivitySummary, BigDecimal> maxWatts;
    public static volatile SingularAttribute<ActivitySummary, BigDecimal> averageWatts;

}