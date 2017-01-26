package com.reactive.user;

import com.reactive.subscribers.*;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(eager = true, name = "userSubscriber")
@RequestScoped()
public class UserSubscriber implements Serializable {

    @ManagedProperty(value = "#{politicalNewsSubscriber}")
    private PoliticalNewsSubscriber politicalNewsSubscriber;
   

    public UserSubscriber() {
       
    }
    
    @PostConstruct
    public void init(){
        
    }
    
    public void updateList(){
        
    }
    
    public List<String> getNewsList(){        
        return politicalNewsSubscriber.fetchAllNews();
    }

    public void setPoliticalNewsSubscriber(PoliticalNewsSubscriber politicalNewsSubscriber) {
        this.politicalNewsSubscriber = politicalNewsSubscriber;
    }
    


}
