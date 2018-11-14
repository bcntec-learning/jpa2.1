package bcntec.learning.jpa21.entityEventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultListener {

    public void pre(Object data) {
        log.info("Pre ", data);
    }

    public void post(Object data) {
        log.info("Post ", data);
    }
}
