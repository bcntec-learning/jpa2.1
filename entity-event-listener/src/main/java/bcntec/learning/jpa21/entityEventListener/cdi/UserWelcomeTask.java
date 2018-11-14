package bcntec.learning.jpa21.entityEventListener.cdi;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserWelcomeTask implements Runnable {
    @Inject
    private UserController controller;
    @Getter
    @Setter
    private User  user;

    @Override
    public void run() {
        controller.sendWelcomeEmail(user);
    }

}
