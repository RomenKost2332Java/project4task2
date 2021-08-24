import com.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestModel  {
    private Model model;

    @Before
    public void resetBounds() {
        model = new Model(50);
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
    public void testGuessNumberOutOfBounds(){
        Assert.assertEquals(Model.OUT_OF_BOUNDS, model.guessNumber(105));
    }

    @Test
    public void testGuessNumberUpdateMinBound() {
        model.guessNumber(25);
        Assert.assertEquals(26, model.getMinBoundInt());
    }

    @Test
    public void testGuessNumberUpdateMaxBound() {
        model.guessNumber(75);
        Assert.assertEquals(74, model.getMaxBoundInt());
    }

    @Test
    public void testGuessNumberGuesses() {
        final var rightGuesses =  new ArrayList<Integer>();
        rightGuesses.add(75);
        rightGuesses.add(60);
        rightGuesses.add(55);
        model.guessNumber(75);
        model.guessNumber(80);
        model.guessNumber(60);
        model.guessNumber(55);
        Assert.assertEquals(model.getGuesses(), rightGuesses);
    }
}
