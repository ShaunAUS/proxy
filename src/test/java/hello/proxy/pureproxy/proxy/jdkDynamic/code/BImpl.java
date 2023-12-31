package hello.proxy.pureproxy.proxy.jdkDynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements Binterface{
    @Override
    public String call() {
        log.info("B호출");
        return "b";
    }
}
