package org.example.maxwaybot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    MyBotService myBotService = new MyBotService();
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            text_Shart(update);
        } else if (update.hasMessage() && update.getMessage().hasContact()) {
            contack_shart(update);
        } else if (update.hasCallbackQuery()) {
            data_shart(update);
        } else if (update.hasMessage() && update.getMessage().hasLocation()) {
            location(update);
        }

    }

    private void location(Update update) {
        Long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Qabul qilindi!");
        ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
        replyKeyboardRemove.setRemoveKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardRemove);
        try {
            execute(sendMessage);
            execute(myBotService.tipa_location(chatId));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void data_shart(Update update) {
        Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        String data = update.getCallbackQuery().getData();

        if (data.equals("buyurtma")) {
            SendMessage sendMessage = myBotService.buyurtma(chatId);

            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("olibketish")) {
            SendMessage sendMessage = myBotService.olibketish(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("orqaga2")) {
            SendMessage sendMessage = myBotService.buyurtma(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("orqaga1")) {
            SendMessage sendMessage = myBotService.MainMenu(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (data.equals("joylashuv")){
            try {
                execute(myBotService.joylashuv(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("⬅\uFE0F Orqaga.")) {
            try {
                execute(myBotService.olibketish(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (data.equals("jonatish")){
            try {
                execute(myBotService.joylashuv(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (data.equals("aksiya")){
            EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
            editMessageReplyMarkup.setChatId(chatId);
            editMessageReplyMarkup.setMessageId(messageId);
            editMessageReplyMarkup.setReplyMarkup(myBotService.aksiya(chatId));
            try {
                execute(editMessageReplyMarkup);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("mainmenu")) {
            SendMessage sendMessage = myBotService.MainMenu(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (data.equals("erindim")){
            try {
                execute(myBotService.OlibKetish(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("asosiymenu")) {
            try {
                execute(myBotService.OlibKetish(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("no")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText("Shundoq ham sizning savatingizda hech nima yoq!");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (data.equals("fullmanzil")){
            try {
                execute(myBotService.olibketish(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("back1")) {
            SendMessage sendMessage = myBotService.MainMenu(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("fullmanzil1")) {
            SendMessage sendMessage = myBotService.fullmanzil1(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("start1")) {
            SendMessage sendMessage = myBotService.fullmanzil2(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("back3")) {
            SendMessage sendMessage = myBotService.fullmanzil1(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(messageId);
            editMessageText.setText(sendMessage.getText());
            editMessageText.setReplyMarkup((InlineKeyboardMarkup) sendMessage.getReplyMarkup());
            try {
                execute(editMessageText);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("salomlar")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText("Firillarimiz haqidagi barcha malumotlarni ushbu saytimisdan olishingiz mumkin\n" +
                    "<a href=\"https://maxway.uz/?ysclid=m2l879g9tf99587619\">Malumotlar Bazasi va Sayt</a>");
            sendMessage.setParseMode(ParseMode.HTML);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("biz")) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(chatId);
            sendPhoto.setPhoto(new InputFile("https://t.me/BunyodOkaDarslari/9"));
            sendPhoto.setCaption("\uD83C\uDF5F Max Way \n" +
                    "☎\uFE0F Aloqa markazi: +998712005400");
            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("qoldirish")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText("Sizning fikringiz biz uchun muhim emas!😁");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (data.equals("buyurtmalarim")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText("Sizda buyurtmalar yo'q");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void contack_shart(Update update) {
        Long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Registratsiadan yaxshi o'tdingiz");
        ReplyKeyboardRemove removeKeyboard = new ReplyKeyboardRemove();
        removeKeyboard.setRemoveKeyboard(true);
        sendMessage.setReplyMarkup(removeKeyboard);
        try {
            execute(sendMessage);
            execute(myBotService.MainMenu(chatId));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void text_Shart(Update update) {
        String text = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();

        if (text.equals("/start")){
            try {
                execute(myBotService.SendContack(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (text.equals("⬅\uFE0F Orqaga")) {
            sendMessage.setChatId(chatId);
            sendMessage.setText("Ok");
            ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
            replyKeyboardRemove.setRemoveKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardRemove);
            try {
                execute(sendMessage);
                execute(myBotService.olibketish(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (text.equals("⬅\uFE0F Orqaga.")){
            sendMessage.setChatId(chatId);
            sendMessage.setText("Ok");
            ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
            replyKeyboardRemove.setRemoveKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardRemove);
            try {
                execute(sendMessage);
                execute(myBotService.buyurtma(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (text.equals("✅ Tasdiqlash")){
            sendMessage.setChatId(chatId);
            sendMessage.setText("Hozirda filial yopiq.");
            try {
                execute(sendMessage);
                execute(myBotService.joylashuv(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if(text.equals("Mening manzillarimga qo'shish!")){
            sendMessage.setChatId(chatId);
            sendMessage.setText("Manzil qo'shildi!");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (text.equals("/help")) {
            sendMessage.setChatId(chatId);
            sendMessage.setText("Sizga eng kerakli yordam bu YouTubedan " +
                    "'Bunyod Oka Darslari' kanaliga kirib videolarni ko'rish " +
                    "agar shunda ham hech nima qila olmasangiz unda biz sizga " +
                    "yordam bera olmas ekanmiz!!!\nMana kanalga kirish uchun havola 'topishda ham qiynalmaslik uchun'\n" +
                    "https://www.youtube.com/@BunyodOkaDarslari");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else  if (text.equals("\uD83D\uDCE5 Savat")){
            sendMessage.setChatId(chatId);
            sendMessage.setText("Ok");
            ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
            replyKeyboardRemove.setRemoveKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardRemove);
            try {
                execute(sendMessage);
                execute(myBotService.Savat(chatId));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if (text.equals("Interaktiv Menyu")){
            sendMessage.setChatId(chatId);
            sendMessage.setText(""+
                    " Salom Marxamat bemalol Online food ordering \n(yani online zakaz) buyurtma berishingiz mumkin!"+
                    "\nhttps://maxway.uz/?ysclid=m2l879g9tf99587619");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "maxweymasterfood_bot";
    }

    @Override
    public String getBotToken() {
        return "7707243831:AAFZRWpCwYIr3sisHS04OrSjLmwYvRUdvVA";
    }
}
