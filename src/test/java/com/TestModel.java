package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestModel  {
    private Model model;

    @Before
    public void resetBounds() {
        model = new Model(50, 0, 100);
    }

    @Test
    public void testGuessNumberEquals(){
        Assert.assertEquals(Model.EQUALS, model.guessNumber(50));
    }

    @Test
    public void testGuessNumberBigger(){
        Assert.assertEquals(Model.BIGGER, model.guessNumber(45));
    }

    @Test
    public void testGuessNumberSmaller(){
        Assert.assertEquals(Model.SMALLER, model.guessNumber(55));
    }

    @Test
    public void testGuessNumberUpdateMinBound() {
        model.guessNumber(25);
        Assert.assertEquals(25, model.getMinBoundInt());
    }

    @Test
    public void testGuessNumberUpdateMaxBound() {
        model.guessNumber(75);
        Assert.assertEquals(75, model.getMaxBoundInt());
    }

    @Test
    public void testIsInBoundsFalse() {
        Assert.assertFalse(model.isInBounds(0));
    }

    @Test
    public void testIsInBoundsTrue() {
        Assert.assertFalse(model.isInBounds(1));
    }
}
