
package Action;

import Bean.Blogbean;
import Bean.Userbean;
import DAO.BlogDAO;
import DAO.UserDAO;
import Tool.Encryption;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.Map;

public class LoginAction extends ActionSupport implements ModelDriven<Userbean> {
    private Userbean userbean = new Userbean();
    private Userbean user = new Userbean();
    private Map session = (Map) ActionContext.getContext().getSession();
    public Userbean getModel() {
        return userbean;
    }

    public String execute() throws Exception {
        userbean.setPassword(Encryption.encrypByMD5(userbean.getPassword()));

        if(userbean.getUsername() == null || userbean.getUsername().length()==0){
            session.put("ERROR","Empty Username");
            return "error";
        }

        if(userbean.getPassword() == null || userbean.getPassword().length()==0){
            session.put("ERROR","Empty Password");
            return "error";
        }
        user = UserDAO.find(userbean.getUsername());
        if (user.getUsername() == null) {
            session.put("ERROR","Can't find username");
            return "error";
        }

        if(!user.getPassword().equals(userbean.getPassword())){
            session.put("ERROR","Wrong Username or Password");
            return "error";
        }

        if(userbean.isAdmin() && !user.isAdmin()){
            session.put("ERROR","Admin Level Deny");
            return "error";
        }else if(userbean.isAdmin() && user.isAdmin()){
            session.put("Userbean",user);
            return "admin";
        }else{
            ArrayList<Blogbean> BB = BlogDAO.getAll();
            session.put("Blogbeans",BB);
            session.put("Userbean",user);
            return "success";
        }
    }

    public void setUsername(String username) {
        userbean.setUsername(username);
    }
    public void setPassword(String password) {
        userbean.setPassword(password);
    }
    public void setIsAdmin(boolean isAdmin) {
        userbean.setAdmin(isAdmin);
    }

}
