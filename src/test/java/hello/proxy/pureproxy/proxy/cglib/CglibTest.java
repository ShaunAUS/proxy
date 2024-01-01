package hello.proxy.pureproxy.proxy.cglib;

import hello.proxy.pureproxy.proxy.cglib.code.TimeMethodInterceptor;
import hello.proxy.pureproxy.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

//구체 클래스 기반
@Slf4j
public class CglibTest {

    @Test
    void cglib(){
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer(); // cglib를 만들어주는 코드
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));

        ConcreteService proxy = (ConcreteService) enhancer.create();

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());

        proxy.call();
    }
}
