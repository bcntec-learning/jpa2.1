package bcntec.learning.jpa21.entityEventListener.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

interface DoIt {
        void doIt(EntityManager entityManager, EntityTransaction tx);
    }