package hello.proxy.pureproxy.proxy.jdkDynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 프록시가 호출하는 공통로직!
 */
@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;  //프록시는 항상 프록시가 호출할 대상이 있어야함

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("TimeProxy 실행");

        long startTIme = System.currentTimeMillis();

        //어떤 메서드가 호출될지 인수로 넘어옴
        Object result = method.invoke(target, args);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTIme;
        log.info("Time: {} ", resultTime);

        return result;
    }
}
