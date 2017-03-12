package repp.spring.demo.service;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import repp.spring.demo.Application;
import repp.spring.demo.model.Subscriber;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


/**
 * @author Denis.Repp
 */
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = Application.class)
public class SubscriptionServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SubscriptionService subscriptionService;

    @Test
    public void testGetSubscribers() throws Exception {
        final List<Subscriber> subscribers = subscriptionService.getSubscribers();
        assertThat(subscribers).as("excepted subscriber").isNotNull();
    }

    @Test
    public void testAddSubscriber() throws Exception {
        final Subscriber subs = new Subscriber(1L, "OLOLO");
        final int i = subscriptionService.addSubscriber(subs);
        assertThat(i).isGreaterThan(0);
    }

    @Test
    public void testUnsubscribe() throws Exception {

        final Subscriber subs = new Subscriber(1L, "OLOLO");
        final int i = subscriptionService.addSubscriber(subs);
        assertThat(i).isGreaterThan(0);

        final int unsubscribe = subscriptionService.unsubscribe(1L);
        assertThat(unsubscribe).isGreaterThan(0);



    }
}