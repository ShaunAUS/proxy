package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {

    private Component component; // 프록시라 실제 객체 알아야함

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");

        String operation = component.operation(); // 실제객체 호출
        String decoResult = "****" + operation + "*****";
        return decoResult;
    }
}
