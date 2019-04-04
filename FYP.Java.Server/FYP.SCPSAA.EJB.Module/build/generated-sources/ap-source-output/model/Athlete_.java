package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Credentials;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T21:17:17")
@StaticMetamodel(Athlete.class)
public class Athlete_ { 

    public static volatile SingularAttribute<Athlete, String> firstname;
    public static volatile SingularAttribute<Athlete, Long> athleteId;
    public static volatile SingularAttribute<Athlete, Long> stravaid;
    public static volatile SingularAttribute<Athlete, Credentials> credentialsId;
    public static volatile SingularAttribute<Athlete, String> lastname;

}