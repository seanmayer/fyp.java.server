/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import controller.Athlete_FacadeRemote;
import javax.naming.InitialContext;


/**
 *test class
 * @author 2008s
 */
public class AthleteClient {


  private Athlete_FacadeRemote request;  
    
    public AthleteClient()
    {
        request = (Athlete_FacadeRemote)getEJBBean("athletefacade"); //cant find athlete facade bug!
        
        requestActivities();
        
        //insertInfo();
        //displayInfo();
        //editInfo();
        //displayInfo();
        //deleteInfo();
    }
  
  
  
    public static void main(String[] args) {
        AthleteClient sac = new AthleteClient();
    }
    
    public Object getEJBBean(String beanName)
    {
        try
        {
            InitialContext ctx=new InitialContext();
            return ctx.lookup(beanName);
        }
        catch (Exception ex)
        {
            System.err.println("ERROR: while locating bean from the server " + ex.getMessage());
            return null;
        }
    }

private void requestActivities()
{
    
}

private void insertInfo()
{
    try
    {
        //request.createAccount(new SavingsAccountDetails(parseLong("1"), "Fred", "Flintstone", new BigDecimal("200")));
        //request.createAccount(new SavingsAccountDetails(parseLong("2"), "John", "Smith", new BigDecimal("100")));
        //request.createAccount(new SavingsAccountDetails(parseLong("3"), "Emma", "North", new BigDecimal("200")));
    }
    catch (Exception ex)
    {
        System.err.println("Caught an exception:");
        ex.printStackTrace();
    }
}

//private void editInfo()
//{
//    request.editAccount(new SavingsAccountDetails(parseLong("1"), "Thelma", "Flintstone", new BigDecimal("100")));
//}
//
//private void deleteInfo()
//{
//    List<SavingsAccountDetails> acctlist = request.findAll();
//    
//    for(SavingsAccountDetails ad:acctlist)
//    {
//        request.removeAccount(parseLong(ad.getId().toString())); 
//    }
//}
//
//private void displayInfo()
//{
//    List<SavingsAccountDetails> acctlist = request.findAll();
//    
//    for(SavingsAccountDetails ad:acctlist)
//    {
//        System.out.println(ad.getId() + " " + ad.getFirstname() + " " + ad.getLastname()+" " + ad.getBalance());
//    }
//}
    
    
}
