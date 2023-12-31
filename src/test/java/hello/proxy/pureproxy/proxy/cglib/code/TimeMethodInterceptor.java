package hello.proxy.pureproxy.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        log.info("TimeProxy 실행");

        long startTIme = System.currentTimeMillis();

        Object result = methodProxy.invoke(target, args); //메뉴얼에 이게 더 빠르다고함, 내부적으로 최적화 하는듯
        //Object result = method.invoke(target, args);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTIme;
        log.info("Time: {} ", resultTime);

        return result;
    }
}
