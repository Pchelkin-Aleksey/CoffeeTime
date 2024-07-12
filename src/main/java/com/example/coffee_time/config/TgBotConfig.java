package com.example.coffee_time.config;

import com.example.coffee_time.service.TGBotService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Configuration
public class TgBotConfig {
    @Value("${telegram.bot-name}")
    private String name;

    @Value("${telegram.bot-token}")
    private String token;

    @Bean
    public TelegramBotsLongPollingApplication tgBotApp(
            TGBotService tgBotService // наш класс обработчик сообщений
    ) throws TelegramApiException {
        TelegramBotsLongPollingApplication botsApi = new TelegramBotsLongPollingApplication();
        // Регистрируем бота, передаем токен и класс обработчик
        botsApi.registerBot(token, tgBotService);
        return botsApi;
    }

    @Bean
    public TelegramClient telegramClient() {
        // Создание клиента для отправки сообщений
        return new OkHttpTelegramClient(token);
    }
}