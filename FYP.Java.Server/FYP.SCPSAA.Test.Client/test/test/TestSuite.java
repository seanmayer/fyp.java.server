/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import api.WebHookFactoryIT;
import controller.ActivityClientIT;
import controller.AthleteClientIT;
import controller.CredentialsClientIT;
import org.junit.runner.RunWith;  
import org.junit.runners.Suite;  
  
@RunWith(Suite.class)  
@Suite.SuiteClasses({ WebHookFactoryIT.class, AthleteClientIT.class, CredentialsClientIT.class,ActivityClientIT.class })  
public class TestSuite  
{  
      
}  