package hello.proxy.pureproxy.proxy.jdkDynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection() {
        Hello target = new Hello();


        //공통 로직1 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result1:{}", result1);
        //공통 로직1 끝

        //공통 로직2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result2:{}", result2);
        //공통 로직2 끝


    }


    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //클래스 메타정보 획득
        Class<?> classHello = Class.forName("hello.proxy.pureproxy.proxy.jdkDynamic.ReflectionTest$Hello");//내부에 있을때는 $를 붙여줘야함

        Hello target = new Hello();

        // CallA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);//target 인스턴스에 있는 callA를 호출해라
        log.info("result1:{}", result1);

        //CallB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);//target 인스턴스에 있는 callB를 호출해라
        log.info("result2:{}", result2);

    }

    @Test
    void reflection2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //클래스 메타정보 획득
        Class<?> classHello = Class.forName("hello.proxy.pureproxy.proxy.jdkDynamic.ReflectionTest$Hello");//내부에 있을때는 $를 붙여줘야함

        Hello target = new Hello();


        // CallA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        //CallB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);

    }


    //박혀있는 메서드를 리플렉션을 활용해 메타정보로 바꿔치기
    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {

        log.info("start");
       // String result1 = target.callA(); // 메서드가 박혀있어서 동적으로 사용 불가
        Object result1 = method.invoke(target);
        log.info("result1:{}", result1);

    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }

}
