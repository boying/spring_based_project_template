package boying.common.redis;

import boying.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by boying on 2017/9/27.
 */
public class RedisUtilsTest extends BaseTest{
    @Autowired
    private RedisTemplate redisTemplate;

    private RedisUtils redisUtils;

    @Before
    public void init() {
        redisUtils = new RedisUtils(redisTemplate);
    }


    @Test
    public void setTest() throws Exception {
        redisUtils.set("jzw_test", "jzw_value");
    }

    @Test
    public void setTest1() throws Exception {
    }

    @Test
    public void getTest() throws Exception {
        String value = redisUtils.get("jzw_test");
        Assert.assertEquals(value, "jzw_value");

    }

}