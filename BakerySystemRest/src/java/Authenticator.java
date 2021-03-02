/**
 *
 * @author Themba
 */
public class Authenticator {
    
    // LOGIN
    //                                                                             whatever comes from txtUsername
    //                                                                             whatever comes from txtPassword, hash it
    // retrieve user ( txtUsername & txtPassword = SELECT * FROM users WHERE username = '' AND password = ''
    
     public static User login(String username, String email, String password ){
        //   username password 
        
        /*   should be testing if the user is customer 
             check and know if the user is in the table
        */
        return null; // might even be void letting the dbclient or dao create or send to db
    }
    
    // REGISTER
    /*
    //
    // create user (
        - username
        - email
        - password and cofirm password
       
        - test if username exists
        - test if email has already be used
    
    */
    
    //might change
    // - should create user based on details recieved
    public static User register(String username, String email, String password ){
        //return (new User(username,email,password,"customer"));
        return null; // might even be void letting the dbclient or dao create or send to db
    }
    
    // information to create the sessions should be generated
    //  - using userid
    //  - can have that to print name on account tag for user
    
}
