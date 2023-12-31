package hello.proxy.pureproxy.proxy.jdkDynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements Ainterface {
    @Override
    public String call() {
        log.info("A호출");
        return null;
    }
}
