package com.extrade.autoconfigure.notification;

import com.extrade.autoconfigure.message.MailMessageServiceAutoConfiguration;
import com.extrade.autoconfigure.message.TextMessageServiceAutoConfiguration;
import com.extrade.autoconfigure.message.ThymeleafMessagePreparatorAutoConfiguration;
import com.extrade.connect.manager.DefaultNotificationManagerImpl;
import com.extrade.connect.preparator.ThymeleafMessagePreparatorImpl;
import com.extrade.connect.service.MailMessageServiceImpl;
import com.extrade.connect.service.TextMessageServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter({ThymeleafMessagePreparatorAutoConfiguration.class, TextMessageServiceAutoConfiguration.class, MailMessageServiceAutoConfiguration.class})
@ConditionalOnClass({MailMessageServiceImpl.class, ThymeleafMessagePreparatorImpl.class})
public class DefaultNoticationManagerAutoConfiguration {

    @Bean
    public DefaultNotificationManagerImpl defaultNotificationManager(ThymeleafMessagePreparatorImpl thymeleafMessagePreparator,
                                                                     TextMessageServiceImpl textMessageService,
                                                                     MailMessageServiceImpl messageService) {
        return new DefaultNotificationManagerImpl(thymeleafMessagePreparator, textMessageService, messageService);
    }

}
