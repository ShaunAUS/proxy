package hello.proxy.app.V3;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV3 {

    public void save(String itemId) {
        if(itemId.equals("ex)")){
            throw new IllegalArgumentException("예외발생");
        }
        sleep(1000);
    }

    private void sleep(int mills) {

        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
