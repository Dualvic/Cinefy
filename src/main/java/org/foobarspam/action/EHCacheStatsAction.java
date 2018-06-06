package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.apache.struts2.interceptor.SessionAware;

import java.util.HashMap;
import java.util.Map;


public class EHCacheStatsAction extends ActionSupport implements SessionAware {

    private Map<String,Object> session;

    public Map<String, String> mapCache = new HashMap<String, String>();


    public Map<String,Object> getSession() {
        return session;
    }

    public void setSession(Map<String,Object> session) {
        this.session = session;
    }


    public String execute() throws Exception {
        CacheManager cacheManager = CacheManager.newInstance();
        for (String cacheName : cacheManager.getCacheNames()) {
            Cache c = cacheManager.getCache(cacheName);
            mapCache.put(cacheName + " cacheHitCount", String.valueOf(c.getStatistics().cacheHitCount()));
            mapCache.put(cacheName + " cacheHitRatio", String.valueOf(c.getStatistics().cacheHitRatio()));
            mapCache.put(cacheName + " cacheMissCount", String.valueOf(c.getStatistics().cacheMissCount()));
        }
        return SUCCESS;
    }


}