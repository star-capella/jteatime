/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jteatime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tcurtis
 */
public class Timer {

    /**
     * length of time for timer
     */
    private Long length;
    /**
     * state of timer
     */
    private Boolean active;
    /**
     * service to run timer
     */
    private ScheduledExecutorService timerService;
    /**
     * for logging
     */
    private static final Logger LOGGER = Logger.getLogger(Timer.class.getName());

    /**
     * Constructor
     *
     * @param length
     */
    public Timer(Long length) {
        super();
        this.length = length;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Method to start timer
     */
    public void startTimer() {
        active = true;
        timerService = Executors.newScheduledThreadPool(1);
        LOGGER.log(Level.INFO, "Timer: starting...");
        timerService.schedule((() -> {
            java.awt.Toolkit.getDefaultToolkit().beep();
            LOGGER.log(Level.INFO, "Timer: done.");
            active = false;
        }), this.length, SECONDS);
    }

    /**
     * Method to cancel an ongoing timer
     */
    public void cancelTimer() {
        if (active) {
            timerService.shutdownNow();
            active = false;
            LOGGER.log(Level.INFO, "Timer: cancelled");
        } else {
            LOGGER.log(Level.INFO, "Timer: not running.");
        }
    }
}
