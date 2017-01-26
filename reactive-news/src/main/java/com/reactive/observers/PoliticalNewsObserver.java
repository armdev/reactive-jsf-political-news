package com.reactive.observers;

import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import rx.Observable;
import rx.Subscriber;

@ManagedBean(eager = false, name = "politicalNewsObserver")
@RequestScoped()
public class PoliticalNewsObserver implements Serializable {

    public PoliticalNewsObserver() {

    }

    
    private  Observable<String> politicalNewsGenerator = Observable.create(
            new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> sub) {
            Random randomGenerator = new Random(); 
            for (int idx = 1; idx <= 50; ++idx) {
                int randomInt = randomGenerator.nextInt(100);
                String str = "Generated News with id  " + randomInt;
              //  sub.add(sub);
                sub.onNext(str);
              
               // sub.onCompleted();
            }
        }
    }
    );

    public Observable<String> getPoliticalNewsGenerator() {
        return politicalNewsGenerator;
    }


}
