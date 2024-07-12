package com.example.coffee_time.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;


@Service
@Data
public class TGBotService implements LongPollingSingleThreadUpdateConsumer {

    // Используется для отправки сообщений в бот
    private final TelegramClient telegramClient;

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // получаем переменные
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            String messageToSend = "/start".equals(message_text)
                    ? "Привет! Я бот, повторяю твой текст. Напиши мне что-нибудь"
                    : message_text;

            SendMessage message = SendMessage // Создаем объект сообщения
                    .builder()
                    .chatId(chat_id)
                    .text(messageToSend)
                    .build();
            try {
                telegramClient.execute(message); // Отправляем сообщение через ТГ-клиента
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
