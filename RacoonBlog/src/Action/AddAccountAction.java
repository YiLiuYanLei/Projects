
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

public class AddAccountAction extends ActionSupport implements ModelDriven<Userbean> {
    private Userbean userbean = new Userbean();
    private Map session = (Map) ActionContext.getContext().getSession();
    public Userbean getModel() {
        return userbean;
    }

    public String execute() throws Exception {
        if(UserDAO.find(userbean.getUsername()).getUsername()!=null){
            session.put("ERROR","Same UserName");
            return "error";
        }
        System.out.println(userbean.getUsername());
        System.out.println(userbean.getPassword());
        UserDAO.insert(userbean);
        return "success";
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
