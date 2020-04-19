package com.gilbert.design;

import java.util.concurrent.CopyOnWriteArrayList;

public class Observer {
    public class Subject {
        private CopyOnWriteArrayList<IObserver> observers;

        public boolean addObserver(IObserver observer) {
            return observers.add(observer);
        }

        public boolean removeObserver(IObserver observer) {
            return observers.remove(observer);
        }

        public void notifyEvent() {
            observers.stream().forEach(e -> e.notifyEvent(null));
        }

    }

    interface IObserver {
        void notifyEvent(Object data);
    }
}
