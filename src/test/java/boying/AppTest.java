package boying;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AppTest extends BaseTest{
    @Autowired
    private App app;

    @Test
    public void addTest(){
        int add = app.add(1, 2);
        Assert.assertEquals(3, add);
    }
}
