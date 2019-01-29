package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Athlete;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-29T19:15:11")
@StaticMetamodel(Credentials.class)
public class Credentials_ { 

    public static volatile SingularAttribute<Credentials, String> password;
    public static volatile SingularAttribute<Credentials, Athlete> athleteId;
    public static volatile SingularAttribute<Credentials, Long> credentialsId;
    public static volatile SingularAttribute<Credentials, String> username;

}