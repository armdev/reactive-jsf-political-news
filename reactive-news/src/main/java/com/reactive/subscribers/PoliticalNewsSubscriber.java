package com.reactive.subscribers;

import com.reactive.observers.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import rx.Subscriber;

@ManagedBean(eager = true, name = "politicalNewsSubscriber")
@RequestScoped()
public class PoliticalNewsSubscriber implements Serializable {

    @ManagedProperty(value = "#{politicalNewsObserver}")
    private PoliticalNewsObserver politicalNewsObserver;

    private List<String> politicalNews = new ArrayList<>();

    public PoliticalNewsSubscriber() {

    }

    @PostConstruct
    public void init() {
        politicalNewsObserver.getPoliticalNewsGenerator().subscribe(politicalSubscriber);
    }

    public List<String> fetchAllNews() {

        return politicalNews;
    }

    private Subscriber<String> politicalSubscriber = new Subscriber<String>() {
        @Override
        public void onNext(String s) {
            //System.out.println("Subscriber " + s);
            politicalNews.add(s);
        }

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }
    };

    public void setPoliticalNewsObserver(PoliticalNewsObserver politicalNewsObserver) {
        this.politicalNewsObserver = politicalNewsObserver;
    }

}
