
package Action;

import Bean.Blogbean;
import Bean.Userbean;
import DAO.BlogDAO;
import DAO.UserDAO;
import Tool.Encryption;
import Tool.SimpleTime;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Date;
import java.util.Map;

public class EditorAction extends ActionSupport implements ModelDriven<Blogbean> {
    private Blogbean blogbean = new Blogbean();
    private Map session = (Map) ActionContext.getContext().getSession();
    public Blogbean getModel() {
        return blogbean;
    }

    public String execute() throws Exception {
        System.out.println(new Date());
        System.out.println(SimpleTime.Date2String(new Date(),0));
        blogbean.setWrittenTime(SimpleTime.Date2String(new Date(),0));
        blogbean.setLastTime(SimpleTime.Date2String(new Date(),0));
        blogbean.setBlogID(Integer.toString(BlogDAO.getNextBlogID()));
        Userbean user = (Userbean)session.get("Userbean");
        blogbean.setWritter(user.getUsername());
        blogbean.setContents(blogbean.getContents().replace('\'','‘'));
        BlogDAO.insert(blogbean);
        session.put("Blogbean",blogbean);
        return "success";
    }

    public void setContents(String contents) {
        blogbean.setContents(contents);
    }

    public void setIsPrivate(String isPrivate) {
        if(isPrivate.equals("true")) blogbean.setPrivate(true);
        else blogbean.setPrivate(false);
    }
}
