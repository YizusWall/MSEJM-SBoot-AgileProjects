package org.yizus.microservices.business.clock;

import java.util.stream.Stream;

import org.springframework.util.StopWatch;
import org.yizus.microservices.generics.MessageToException;

public class ClockServiceImpl implements ClockService {

    private boolean verbose=false;
    private int minutes=0;
    private boolean isBall =false;
    private int ball=0;
    private double days=0;

    


    public ClockServiceImpl(boolean verbose, int minutes, int ball) {
        this.verbose = verbose;
        this.minutes = minutes;
        this.ball=ball;
        this.isBall= ball > 26 && ball < 128;
    }

    @Override
    public void getBalls() throws MessageToException {
        
        if(!isBall) throw new MessageToException(ball+" "+ClockServiceConst.messIsBall);

      //  StopWatch stopWatch=new StopWatch();
      StopWatch stopWatch=new StopWatch();
      stopWatch.start();
      days=iterateBalls();
      stopWatch.stop();


        }

        @Override
        public double iterateBalls() {

            int cycles=1;

            do {
                
                
            } while (isBall);
            return cycles/(60d*4);
        }

    }
    
