package org.yizus.microservices.business.clock;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class CarriableServiceImpl implements CarriableService {
 
    public Deque<Integer> rail=null;
    private int capacity=0;

    public CarriableServiceImpl(){
        rail = new LinkedBlockingDeque<>(capacity);
    }
    
    public void popToNext() { nextRail.flush(rail.pollFirst()); }

    @Override
    public void flush(Integer ball) {
        // TODO Auto-generated method stub
        pushOrFlush(ball, this, feed, nextRail);

    }

    
}