package boying.other;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test
    public void testDivide(){
        BigDecimal a = BigDecimal.valueOf(8);
        BigDecimal b = BigDecimal.valueOf(2);
        BigDecimal c = BigDecimal.valueOf(3);
        BigDecimal ret = a.divide(b);
        System.out.println(ret);
        ret = a.divide(c, 2, BigDecimal.ROUND_CEILING);
        System.out.println(ret);
        try {
            ret = a.divide(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
