/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jteatimetest;

import jteatime.Timer;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * JUnit class to test Timer
 *
 * @author curttre
 *
 */
public class TimerTest {

    private static final Long ARBITRARY_TIME = 3L;

    /**
     * Test method for {@link jTeaTime.Timer#startTimer()}.
     */
    @Test
    public void testStartTimer() {
        final Timer aTimer = new Timer(ARBITRARY_TIME);
        aTimer.startTimer();
        assertTrue(aTimer.getActive());
    }

    @Test
    public void testTimerLength() throws InterruptedException {
        final Timer aTimer = new Timer(ARBITRARY_TIME);
        aTimer.startTimer();
        assertTrue(aTimer.getActive());
        Thread.sleep((ARBITRARY_TIME + 1) * 1000L);
        assertFalse(aTimer.getActive());
    }

    /**
     * Test method for {@link jTeaTime.Timer#cancelTimer()}.
     */
    @Test
    public void testCancelTimer() {
        final Timer aTimer = new Timer(ARBITRARY_TIME);
        aTimer.startTimer();
        aTimer.cancelTimer();
        assertFalse(aTimer.getActive());
    }
}
