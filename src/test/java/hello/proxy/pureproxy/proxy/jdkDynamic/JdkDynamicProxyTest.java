package hello.proxy.pureproxy.proxy.jdkDynamic;

import hello.proxy.pureproxy.proxy.jdkDynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * 프록시 관련 클래스를 하나만 만들어 놓고 인터페이스만 바꿔서 사용할 수 있음
 */
@Slf4j
public class JdkDynamicProxyTest {


    @Test
    void dynamicA() {
        Ainterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        //어느 클래스에 대한 프록시를 만들지, 어떤 인터페이스를 기반으로 할지, 어떤 로직을 사용할지
        Ainterface proxy = (Ainterface) Proxy.newProxyInstance(Ainterface.class.getClassLoader(), new Class[]{Ainterface.class}, handler);
        proxy.call(); // 먼저 프록시를 호출하고 프록시가 실제 타겟을 호출함
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());


    }

    @Test
    void dynamicB() {
        Binterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        //어느 클래스에 대한 프록시를 만들지, 어떤 인터페이스를 기반으로 할지, 어떤 로직을 사용할지
        Binterface proxy = (Binterface) Proxy.newProxyInstance(Binterface.class.getClassLoader(), new Class[]{Binterface.class}, handler);
        proxy.call(); // 먼저 프록시를 호출하고 프록시가 실제 타겟을 호출함
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());


    }
}
