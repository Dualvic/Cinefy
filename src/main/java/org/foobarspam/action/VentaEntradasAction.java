package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class VentaEntradasAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }
}
