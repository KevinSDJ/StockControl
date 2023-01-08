package com.stockControl.utils.ObserverUtils;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private static Subject instance = new Subject();
 
    private Subject(){}
    
    public static Subject getInstance() {
        return instance;
    }
    public void attach(Observer observer){
       observers.add(observer);		
    }
    public void notifyAction(){
        notifyAllObservers();
    }
 
    private void notifyAllObservers(){
       for (Observer observer : observers) {
          observer.update();
       }
    } 	
    
}
