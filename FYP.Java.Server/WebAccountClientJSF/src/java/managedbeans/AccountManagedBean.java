package managedbeans;

import banks.SavingsaccountFacadeRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import utils.SavingsAccountDetails;


@Named(value = "accountManagedBean")
@SessionScoped

public class AccountManagedBean implements Serializable {

    private static SavingsaccountFacadeRemote sa;
    private Long id;
    private String firstname;
    private String lastname;
    private BigDecimal balance;
    private String message;
    private Long deletedaccount;
    private ArrayList<SavingsAccountDetails> list;
    private Logger logger = Logger.getLogger("managedbeans.AccountManagedBean");


    public AccountManagedBean() 
    {
        try 
        {
            Context initial = new InitialContext();
            sa = (SavingsaccountFacadeRemote) initial.lookup("savingsaccountfacade");
        } 
        catch (Exception ex) 
        {
            System.err.println("Caught an exception:");
            ex.printStackTrace();
        }
    }


    public ArrayList<SavingsAccountDetails> getList() 
    {
        return (ArrayList) sa.findAll();
    }
    
    public void setList(ArrayList<SavingsAccountDetails> list) 
    {
        this.list = list;
    }
    
    public Long getId() 
    {
        return id;
    }
    
    public void setId(Long id) 
    {
        this.id = id;
    }
    
    public String getFirstname() 
    {
        return firstname;
    }
    
    public void setFirstname(String firstname) 
    {
        this.firstname = firstname;
    }
    
    public String getLastname() 
    {
        return lastname;
    }
    
    public void setLastname(String lastname) 
    {
        this.lastname = lastname;
    }
    
    public BigDecimal getBalance() 
    {
        return balance;
    }
    
    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }
    
    public String createAccount() 
    {
        try 
        {
            sa.createAccount(new SavingsAccountDetails(id, firstname, lastname, balance));
            message="Account successfully added";
        } 
        catch (Exception e) 
        {
            logger.warning("Couldn't add account.");
            message = e.getMessage() + "\n" + ", Couldn't add account.";
        }
        return "message";
    }
    
    public String getAccount() 
    {
        try 
        {
            SavingsAccountDetails temp = sa.find(id);
            firstname = temp.getFirstname();
            lastname = temp.getLastname();
            balance = temp.getBalance();
            return "showaccount";
        } 
        catch (Exception e) 
        {
            logger.warning("Couldn't get account.");
            message = e.getMessage() + "\n" + ", Couldn't edit account.";
            return "message";
        }
    }


    public String editAccount() 
    {
        try 
        {
            sa.editAccount(new SavingsAccountDetails(id, firstname, lastname, balance));
            message="Account successfully edited";
            deletedaccount=null;
            id=null;
            firstname=null;
            lastname=null;
            balance=null;
        } 
        catch (Exception e) 
        {
            message = e.getMessage() + "\n" + ", Couldn't edit account.";
        }
        return "message";
    }
    public String deleteAccount()
    {
        try
        {
            sa.removeAccount(deletedaccount);
            message="Account successfully deleted";
        }
        catch(Exception e)
        {
            message = e.getMessage() + "\n" + ", Couldn't delete account.";
        }
        return "message";
    }
    
    public String getMessage() 
    {
        return message;
    }
    
    public void setMessage(String message) 
    {
        this.message = message;
    }
    
    public Long getDeletedaccount() 
    {
        return deletedaccount;
    }
    
    public void setDeletedaccount(Long deletedaccount) 
    {
        this.deletedaccount = deletedaccount;
    }
}