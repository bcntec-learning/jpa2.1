package houseware.learn.jpa21.entityEventListener.cdi;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
@Stateless
public class UserWelcomeEJB {
    @Getter
    @Inject
    Instance<UserWelcomeTask> userWelcomeTaskInstance;


}
