package repp.spring.demo.service;

import repp.spring.demo.model.Subscriber;

import java.util.List;

/**
 * @author Denis.Repp
 */
public interface SubscriptionService {
    int addSubscriber(final Subscriber subscriber);

    int unsubscribe(Long chatId);

    List<Subscriber> getSubscribers();
}
