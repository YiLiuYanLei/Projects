
package Bean;

import java.util.Date;

public class Blogbean {
    private String writter;
    private String blogID;
    private String writtenTime;
    private String lastTime;
    private boolean isPrivate;
    private String contents;

    public Blogbean() {
        this.writter = null;
        this.blogID = null;
        this.writtenTime = null;
        this.lastTime = null;
        this.isPrivate = false;
        this.contents = null;
    }
    public Blogbean(String writter, String blogID, String writtenTime, String lastTime, boolean isPrivate, String contents) {
        this.writter = writter;
        this.blogID = blogID;
        this.writtenTime = writtenTime;
        this.lastTime = lastTime;
        this.isPrivate = isPrivate;
        this.contents = contents;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public String getBlogID() {
        return blogID;
    }

    public void setBlogID(String blogID) {
        this.blogID = blogID;
    }

    public String getWrittenTime() {
        return writtenTime;
    }

    public void setWrittenTime(String writtenTime) {
        this.writtenTime = writtenTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
