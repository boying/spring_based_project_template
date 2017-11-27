package boying.service.book;

import boying.BaseTest;
import boying.domain.book.Pic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by boying on 17-11-23.
 */
public class SpringTransactionSelfInvocationTest extends BaseTest{
    @Autowired
    private IPicService picServiceImp;
    /**
     * 当proxy-target-class="false"时，容器启动失败
     * org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'boying.service.book.SpringTransactionSelfInvocationTest': Unsatisfied dependency expressed through field 'picServiceImpx'; nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'picServiceImp' is expected to be of type 'boying.service.book.PicServiceImp' but was actually of type 'com.sun.proxy.$Proxy31'
     * spring aop使用java dynamic proxy实现代理，spring创建IPicService子类对象，PicServiceImp对象无法供容器外使用，因而Autowired失败
     *
     * 当proxy-target-class="true"时，容器启动成功
     * 使用CGLIB实现代理，创建PicServiceImp子类，容器中有该子类对象，因此可以供外部使用，Autowire成功
     *
     */
    /*
    @Autowired
    private PicServiceImp picServiceImpx;
    */

    private Pic pic;

    @Before
    public void before(){
        pic = new Pic();
        pic.setName("pic_name");
        pic.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        pic.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
    }

    /**
     * In proxy mode (which is the default), only external method calls coming in through the proxy are intercepted. This means that self-invocation, in effect, a method within the target object calling another method of the target object, will not lead to an actual transaction at runtime even if the invoked method is marked with @Transactional. Also, the proxy must be fully initialized to provide the expected behaviour so you should not rely on this feature in your initialization code, i.e. @PostConstruct.
     *
     * 虽然addPicThrowException annotated by @Transactional，但是并没有生效
     */
    @Test
    public void addPicSelfInvocationTest() {
        try {
            picServiceImp.addPicSelfInvocation(pic);
        }catch (Throwable t){
            t.printStackTrace();
        }

        Pic pic1 = picServiceImp.getPic(pic.getId());
        Assert.assertNotNull(pic1);
    }

    @Test
    public void addPicTest() {
        try {
            picServiceImp.addPicThrowException(pic);
        }catch (Throwable t){
            t.printStackTrace();
        }

        Pic pic1 = picServiceImp.getPic(pic.getId());
        Assert.assertNull(pic1);
    }

    @Test
    public void realClass(){
        PicServiceImp obj = new PicServiceImp();
        /**
         * when proxy-target-class is true, output:
         * container's IPicService instance's class is class boying.service.book.PicServiceImp$$EnhancerBySpringCGLIB$$3a7274ad
         *
         * when proxy-target-class is false, output:
         * container's IPicService instance's class is class com.sun.proxy.$Proxy31
         */
        System.out.println("Spring container's IPicService instance's class is " + picServiceImp.getClass());

        /**
         * newed PicServiceImp obj's class is class boying.service.book.PicServiceImp
         */
        System.out.println("newed PicServiceImp obj's class is " + obj.getClass());
        Assert.assertNotEquals(picServiceImp.getClass(), obj.getClass());
    }

}
