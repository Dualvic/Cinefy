package org.foobarspam.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InterceptorAcceso extends AbstractInterceptor {
    private String actionsPublicos;
    private List<String> actionsSinFiltrar = new ArrayList<String>();

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String login = Action.LOGIN;
        Map<String, Object> session = ActionContext.getContext().getSession();
        boolean sessionOK = session.containsKey("usuario");
        long now = new Date().getTime();

//        if (sessionOK) {
//            KumoRequestContext.setUsuario((Usuario) session.get("usuario"));
//            if ((now - (Long) session.get("fechaUltimaAction")) > Long.valueOf(PropertyRegistry.getProperties().getProperty("timeSessionExpired"), 10)) {
//                session.remove("usuario");
//                return "sesionExpirada";
//            }
//        }


        String actionActual = (String) ActionContext.getContext().get(ActionContext.ACTION_NAME);
        if (!sessionOK && !actionsSinFiltrar.contains(actionActual)) {
            return "sesionExpirada";
        }

        session.put("fechaUltimaAction", now);

        return actionInvocation.invoke();
    }

    public void setActionsPublicos(String actionsPublicos) {
        this.actionsPublicos = actionsPublicos;
    }
}
