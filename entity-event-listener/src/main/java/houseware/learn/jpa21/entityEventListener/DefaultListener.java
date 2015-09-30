package houseware.learn.jpa21.entityEventListener;

import houseware.learn.jpa21.entityEventListener.oldskool.Oldskool;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;

@Slf4j
public class DefaultListener {

    public void pre(Object data) {
        log.info("Pre ", data);
    }

    public void post(Object data) {
        log.info("Post ", data);
    }
}
