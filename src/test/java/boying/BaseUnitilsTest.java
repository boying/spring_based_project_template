package boying;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * Created by boying on 2017/7/6.
 */
@SpringApplicationContext("classpath:applicationContext.xml")
public class BaseUnitilsTest extends UnitilsJUnit4 {
    @Before
    public void initMocks() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore
    public void run(){}
}
