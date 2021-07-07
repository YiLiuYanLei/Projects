package Action;

import Bean.Userbean;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.SQLOutput;
import java.util.Map;

public class RegisterAction extends ActionSupport implements ModelDriven<Userbean> {
    private Userbean userbean = new Userbean();
    private Map session = (Map) ActionContext.getContext().getSession();
    @Override
    public Userbean getModel(){
        return this.userbean;
    }

    @Override
    public String execute() throws Exception{
        // Empty Inputs
        if(userbean.getUsername() == null || userbean.getUsername().length() == 0){
            session.put("ERROR","Empty Username");
            return "error";
        }

        if(userbean.getPassword() == null || userbean.getPassword().length() == 0){
            session.put("ERROR","Empty Password");
            return "error";
        }
        userbean.setAdmin(false);
//        System.out.println(userbean.getUsername());
//        System.out.println(userbean.getPassword());
//        System.out.println(userbean.isAdmin());

        Userbean user = UserDAO.find(userbean.getUsername());
        if(user.getUsername() == null){
            UserDAO.insert(userbean);
            session.put("ERROR","");
            return "success";
        }else{
            session.put("ERROR","Same Username");
            return "error";
        }


    }
    private void SessionUserbean(){
        session.put("Userbean",userbean);
    }
}