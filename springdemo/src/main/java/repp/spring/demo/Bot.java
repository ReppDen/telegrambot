package repp.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import repp.spring.demo.model.Subscriber;
import repp.spring.demo.service.SubscriptionService;

/**
 * @author Denis.Repp
 */
public class Bot extends TelegramLongPollingBot {

    @Autowired
    SubscriptionService subscriptionService;

    private enum Command {
        SUBSCRIBE,
        UNSUBSCRIBE;

        public static Command of(final String text) {
            return valueOf(text.substring(1).toUpperCase());
        }
    }

    @Override
    public String getBotToken() {
        return "360154389:AAH3xXsvMbb_AOOqovHl8qDJE5TVCI0ffjA";
    }

    public void onUpdateReceived(final Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            final String text = update.getMessage().getText();
            switch (Command.of(text)) {
                case SUBSCRIBE:
                    subscriptionService.addSubscriber(new Subscriber(update.getMessage().getChatId(), update.getMessage().getChat().getUserName()));
                    break;
                case UNSUBSCRIBE:
                    subscriptionService.unsubscribe(update.getMessage().getChatId());
                    break;
            }
        }

    }

    public String getBotUsername() {
        return "Repp test Bot";
    }
}
