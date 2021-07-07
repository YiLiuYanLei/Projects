package Action;

import Bean.Blogbean;
import Bean.Userbean;
import DAO.BlogDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Map;

public class Page2Action extends ActionSupport {
    private String toURL = "login";
    private String blogID = null;
    private Map session = (Map) ActionContext.getContext().getSession();

    @Override
    public String execute() throws Exception{
        if(toURL.equals("mainBlog")){
            Userbean user = (Userbean)session.get("Userbean");
            ArrayList<Blogbean> BB = BlogDAO.getBlogbeansByUsername(user.getUsername());
            session.put("Blogbeans",BB);
        }
        if(toURL.equals("blogPage") || toURL.equals("blogPage2")){
            Blogbean tmp = BlogDAO.getBlogbeanByID(blogID);
            session.put("Blogbean",tmp);
        }
        if(toURL.equals("index") || toURL.equals("index2")){
            ArrayList<Blogbean> BB = BlogDAO.getAll();
            session.put("Blogbeans",BB);
        }
        return toURL;
    }

    public void setToURL(String toURL) {
        this.toURL = toURL;
    }
    public String getToURL(){
        return this.toURL;
    }

    public void setBlogID(String blogID) {
        this.blogID = blogID;
    }
    public String getBlogID(){return this.blogID;}
}
