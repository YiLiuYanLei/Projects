
package Action;

import Bean.Userbean;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Map;

public class DelAccountAction extends ActionSupport implements ModelDriven<Userbean> {
    private Userbean userbean = new Userbean();
    private Map session = (Map) ActionContext.getContext().getSession();
    public Userbean getModel() {
        return userbean;
    }

    public String execute() throws Exception {
        if(UserDAO.find(userbean.getUsername())==null){
            session.put("ERROR","Can't find username");
            return "error";
        }
        UserDAO.delete(userbean.getUsername());
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
