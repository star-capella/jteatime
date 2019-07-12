/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jteatime;

/**
 *
 * @author tcurtis
 */
public class Tea {

    /**
     * name
     */
    private String name;
    /**
     * timer
     */
    private Timer timer;

    /**
     * @param name
     * @param steepTime
     */
    public Tea(String name, Long steepTime) {
        super();
        this.name = name;
        this.timer = new Timer(steepTime);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    /**
     * Start Timer
     */
    public void startTimer() {
        timer.startTimer();
    }

    public void cancelTimer() {
        timer.cancelTimer();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Tea [name=" + name + ", steepTime=" + timer.getLength() + "]";
    }
}
