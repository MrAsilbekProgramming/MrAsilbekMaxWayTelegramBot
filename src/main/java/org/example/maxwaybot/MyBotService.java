package org.example.maxwaybot;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBotService {
    public SendMessage SendContack(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDCDE Ro'yxatdan o'tish uchun telefon raqamingizni kiriting. \n" +
                " \n" +
                " Raqamni +998********* shaklida yuboring.");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("Send Number");
        row.add(button);
        rows.add(row);
        replyKeyboardMarkup.setResizeKeyboard(true);
        button.setRequestContact(true);
        replyKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;

    }
    public SendMessage MainMenu(Long chatid){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatid);
        sendMessage.setText("Buyurtma berishni boshlash uchun \uD83D\uDECD Buyurtma berish tugmasini bosing\n" +
                "\n" +
                "Shuningdek, aksiyalarni ko'rishingiz va bizning filiallar bilan tanishishingiz mumkin\n\n" +
                "<a href=\"https://maxway.uz/?ysclid=m2l879g9tf99587619\">menu</a>");
        sendMessage.setParseMode(ParseMode.HTML);
        ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
        replyKeyboardRemove.setRemoveKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardRemove);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton("\uD83D\uDECD Buyurtma berish");
        button1.setCallbackData("buyurtma");
        row1.add(button1);
        rowsList.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button2 = new InlineKeyboardButton("\uD83C\uDF89 Aksiya");
        button2.setCallbackData("aksiya");
        row2.add(button2);

        InlineKeyboardButton button3 = new InlineKeyboardButton("\uD83C\uDFD8 Barcha filiallar");
        button3.setCallbackData("fullmanzil1");
        row2.add(button3);
        rowsList.add(row2);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton button4 = new InlineKeyboardButton("\uD83D\uDCCB Mening buyurtmalarim");
        button4.setCallbackData("buyurtmalarim");
        row4.add(button4);

        InlineKeyboardButton button5 = new InlineKeyboardButton("✍\uFE0FIzoh qoldirish");
        button5.setCallbackData("qoldirish");
        row4.add(button5);
        rowsList.add(row4);

        List<InlineKeyboardButton> row6 = new ArrayList<>();
        InlineKeyboardButton button6 = new InlineKeyboardButton("\uD83D\uDCBC Vakansiyalar");
        button6.setCallbackData("vakansiyalar");
        row6.add(button6);
        InlineKeyboardButton button7 = new InlineKeyboardButton("ℹ\uFE0F Biz haqimizda");
        button7.setCallbackData("biz");
        row6.add(button7);
        rowsList.add(row6);
        List<InlineKeyboardButton> row8 = new ArrayList<>();
        InlineKeyboardButton button8 = new InlineKeyboardButton("⚙\uFE0F Sozlamalar");
        button8.setCallbackData("sozlamalar");
        row8.add(button8);
        rowsList.add(row8);

        inlineKeyboardMarkup.setKeyboard(rowsList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage buyurtma(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Yetkazib berish turini tanlang");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsList = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton("Olib ketish");
        button1.setCallbackData("olibketish");
        row1.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton("Yetkazib berish");
        button2.setCallbackData("jonatish");
        row1.add(button2);
        rowsList.add(row1);
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button3 = new InlineKeyboardButton("⬅\uFE0F Orqaga");
        button3.setCallbackData("orqaga1");
        row2.add(button3);
        rowsList.add(row2);
        inlineKeyboardMarkup.setKeyboard(rowsList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage olibketish(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filialni tanlang");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton("⬅\uFE0F Orqaga");

        button1.setCallbackData("orqaga2");
        row1.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton("\uD83D\uDCCD End yaqin filialni aniqlash");
        button2.setCallbackData("joylashuv");

        row1.add(button2);
        rowsList.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button3 = new InlineKeyboardButton("MAX WAY BERUNIY");

        button3.setCallbackData("erindim");
        row2.add(button3);

        InlineKeyboardButton button4 = new InlineKeyboardButton("MAX WAY AVIASOZLAR");
        button4.setCallbackData("erindim");

        row2.add(button4);
        rowsList.add(row2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton button5 = new InlineKeyboardButton("MAX WAY RISOVIY");

        button5.setCallbackData("erindim");
        row3.add(button5);

        InlineKeyboardButton button6 = new InlineKeyboardButton("MAX WAY PARUS");
        button6.setCallbackData("erindim");

        row3.add(button6);
        rowsList.add(row3);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton button7 = new InlineKeyboardButton("MAX WAY PARKENT");

        button7.setCallbackData("erindim");
        row4.add(button7);

        InlineKeyboardButton button8 = new InlineKeyboardButton("MAX WAY ROYSON");
        button8.setCallbackData("erindim");

        row4.add(button8);
        rowsList.add(row4);

        List<InlineKeyboardButton> row5 = new ArrayList<>();
        InlineKeyboardButton button9 = new InlineKeyboardButton("MAX WAY MUQUMIY");

        button9.setCallbackData("erindim");
        row5.add(button9);

        InlineKeyboardButton button10 = new InlineKeyboardButton("MAX WAY GRAND MIR");
        button10.setCallbackData("erindim");

        row5.add(button10);
        rowsList.add(row5);

        List<InlineKeyboardButton> row6 = new ArrayList<>();
        InlineKeyboardButton button11 = new InlineKeyboardButton("MAX WAY SAYRAM");

        button11.setCallbackData("erindim");
        row6.add(button11);

        InlineKeyboardButton button12 = new InlineKeyboardButton("MAX WAY MAKSIM GORKIY");
        button12.setCallbackData("erindim");

        row6.add(button12);
        rowsList.add(row6);

        List<InlineKeyboardButton> row7 = new ArrayList<>();
        InlineKeyboardButton button13 = new InlineKeyboardButton("MAX WAY SERGELI");

        button13.setCallbackData("erindim");
        row7.add(button13);

        InlineKeyboardButton button14 = new InlineKeyboardButton("MAX WAY FONTAN");
        button14.setCallbackData("erindim");

        row7.add(button14);
        rowsList.add(row7);

        List<InlineKeyboardButton> row8 = new ArrayList<>();
        InlineKeyboardButton button15 = new InlineKeyboardButton("MAX WAY MINOR");

        button15.setCallbackData("erindim");
        row8.add(button15);

        rowsList.add(row8);
        inlineKeyboardMarkup.setKeyboard(rowsList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }
    public SendMessage joylashuv(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Buyurtmani davom ettirish uchun iltimos lokatsiyangizni yuboring!");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton("Locatsiya yuborish");
        button1.setRequestLocation(true);
        row1.add(button1);
        rows.add(row1);
        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton button2 = new KeyboardButton("⬅\uFE0F Orqaga.");
        row2.add(button2);
        rows.add(row2);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage tipa_location(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Manzilingiz:\n" +
                "\uD83D\uDCCD Oʻzbekiston, Toshkent, Sergeli tumani, Bunyodobod mahalla fuqarolar yigʻini\n" +
                " Manzilni tasdiqlaysizmi?");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton("Lakatsiyani qayta yuborish!");
        button1.setRequestLocation(true);
        row1.add(button1);
        KeyboardButton button2 = new KeyboardButton("✅ Tasdiqlash");
        row1.add(button2);
        rows.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton button3 = new KeyboardButton("Mening manzillarimga qo'shish!");
        row2.add(button3);
        KeyboardButton button4 = new KeyboardButton("⬅\uFE0F Orqaga.");
        row2.add(button4);
        rows.add(row2);

        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage OlibKetish(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Kategoriyani tanlang");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList1 = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton("Interaktiv Menyu");
        //button1.setWebApp(new WebAppInfo("http://maxway.uz/"));
        row1.add(button1);
        rowList1.add(row1);


        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton button2 = new KeyboardButton("⬅\uFE0F Orqaga");
        row2.add(button2);

        KeyboardButton button3 = new KeyboardButton("\uD83D\uDCE5 Savat");
        row2.add((button3));
        rowList1.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        KeyboardButton button4 = new KeyboardButton("Aksiya Lavash mini 1+1=3");
        row3.add(button4);

        KeyboardButton button5 = new KeyboardButton("Yangilik \uD83D\uDCE3");
        row3.add(button5);
        rowList1.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        KeyboardButton button6 = new KeyboardButton("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");
        row4.add(button6);

        KeyboardButton button7 = new KeyboardButton("\uD83E\uDD6AKlab-Sendvich");
        row4.add(button7);
        rowList1.add(row4);

        KeyboardRow row5 = new KeyboardRow();
        KeyboardButton button8 = new KeyboardButton("\uD83C\uDF2FLavash");
        row5.add(button8);

        KeyboardButton button9 = new KeyboardButton("\uD83C\uDF2EShaurma");
        row5.add(button9);
        rowList1.add(row5);

        KeyboardRow row6 = new KeyboardRow();
        KeyboardButton button10 = new KeyboardButton("\uD83C\uDF54Burger");
        row6.add(button10);

        KeyboardButton button11 = new KeyboardButton("\uD83C\uDF71Donar kebab");
        row6.add(button11);
        rowList1.add(row6);

        KeyboardRow row7 = new KeyboardRow();
        KeyboardButton button12 = new KeyboardButton("\uD83C\uDF2DLonger");
        row7.add(button12);

        KeyboardButton button13 = new KeyboardButton("\uD83C\uDF5FGazaklar");
        row7.add(button13);
        rowList1.add(row7);

        KeyboardRow row8 = new KeyboardRow();
        KeyboardButton button14 = new KeyboardButton("\uD83C\uDF5ATamaddilar");
        row8.add(button14);

        KeyboardButton button15 = new KeyboardButton("\uD83C\uDF70Desertlar");
        row8.add(button15);
        rowList1.add(row8);

        KeyboardRow row9 = new KeyboardRow();
        KeyboardButton button16 = new KeyboardButton("\uD83E\uDD64Ichimliklar");
        row9.add(button16);

        KeyboardButton button17 = new KeyboardButton("\uD83E\uDD6BSouslar");
        row9.add(button17);
        rowList1.add(row9);

        replyKeyboardMarkup.setKeyboard(rowList1);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage Savat(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Savat: 0\n\nHozircha savatingiz bo'sh");
        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton("Buyurtmani davom ettirish");
        button1.setCallbackData("asosiymenu");
        row1.add(button1);
        rowList.add(row1);
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button2 = new InlineKeyboardButton("\uD83D\uDD04 Tozalash");
        button2.setCallbackData("no");
        row2.add(button2);
        rowList.add(row2);
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton button3 = new InlineKeyboardButton("⬅\uFE0F Orqaga");
        button3.setCallbackData("asosiymenu");
        row3.add(button3);
        rowList.add(row3);
        replyKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public InlineKeyboardMarkup aksiya(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F8aa70d78-367e-4178-80bf-02f2c41b6fd7&w=1920&q=75"));
        sendPhoto.setCaption("Aksiya Lavash mini 1+1=3 \n" +
                " Mini lavash SOVG'A \uD83C\uDF81\n" +
                "Ikkita mini lavash sotib oling - uchinchisini esa mutlaqo BEPUL oling!\uD83D\uDE0D");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton("⬅\uFE0F Orqaga");
        button.setCallbackData("mainmenu");
        row.add(button);
        rowList.add(row);
        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }
    public SendMessage fullmanzil1(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filialni tanlang");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton("⬅\uFE0F Orqaga");

        button1.setCallbackData("back1");
        row1.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton("▶\uFE0F Oldinga");
        button2.setCallbackData("start1");

        row1.add(button2);
        rowsList.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button3 = new InlineKeyboardButton("MAX WAY BERUNIY");

        button3.setCallbackData("salomlar");
        row2.add(button3);

        InlineKeyboardButton button4 = new InlineKeyboardButton("MAX WAY AVIASOZLAR");
        button4.setCallbackData("salomlar");

        row2.add(button4);
        rowsList.add(row2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton button5 = new InlineKeyboardButton("MAX WAY RISOVIY");

        button5.setCallbackData("salomlar");
        row3.add(button5);

        InlineKeyboardButton button6 = new InlineKeyboardButton("MAX WAY PARUS");
        button6.setCallbackData("salomlar");

        row3.add(button6);
        rowsList.add(row3);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton button7 = new InlineKeyboardButton("MAX WAY PARKENT");

        button7.setCallbackData("salomlar");
        row4.add(button7);

        InlineKeyboardButton button8 = new InlineKeyboardButton("MAX WAY ROYSON");
        button8.setCallbackData("salomlar");

        row4.add(button8);
        rowsList.add(row4);

        List<InlineKeyboardButton> row5 = new ArrayList<>();
        InlineKeyboardButton button9 = new InlineKeyboardButton("MAX WAY MUQUMIY");

        button9.setCallbackData("salomlar");
        row5.add(button9);

        InlineKeyboardButton button10 = new InlineKeyboardButton("MAX WAY GRAND MIR");
        button10.setCallbackData("salomlar");

        row5.add(button10);
        rowsList.add(row5);

        List<InlineKeyboardButton> row6 = new ArrayList<>();
        InlineKeyboardButton button11 = new InlineKeyboardButton("MAX WAY SAYRAM");

        button11.setCallbackData("salomlar");
        row6.add(button11);

        InlineKeyboardButton button12 = new InlineKeyboardButton("MAX WAY MAKSIM GORKIY");
        button12.setCallbackData("salomlar");

        row6.add(button12);
        rowsList.add(row6);

        List<InlineKeyboardButton> row7 = new ArrayList<>();
        InlineKeyboardButton button13 = new InlineKeyboardButton("MAX WAY SERGELI");

        button13.setCallbackData("salomlar");
        row7.add(button13);

        InlineKeyboardButton button14 = new InlineKeyboardButton("MAX WAY FONTAN");
        button14.setCallbackData("salomlar");

        row7.add(button14);
        rowsList.add(row7);

        List<InlineKeyboardButton> row8 = new ArrayList<>();
        InlineKeyboardButton button15 = new InlineKeyboardButton("MAX WAY MINOR");

        button15.setCallbackData("salomlar");
        row8.add(button15);

        rowsList.add(row8);
        inlineKeyboardMarkup.setKeyboard(rowsList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }
    public SendMessage fullmanzil2(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Bizning filiallarimiz :");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton("⬅\uFE0F Orqaga");

        button1.setCallbackData("back3");
        row1.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton("MAX WAY SERGELI");
        button2.setCallbackData("salomlar");

        row1.add(button2);
        rowsList.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button3 = new InlineKeyboardButton("MAX WAY FONTAN");

        button3.setCallbackData("salomlar");
        row2.add(button3);

        InlineKeyboardButton button4 = new InlineKeyboardButton("MAX WAY MINOR");
        button4.setCallbackData("salomlar");

        row2.add(button4);
        rowsList.add(row2);

        inlineKeyboardMarkup.setKeyboard(rowsList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }

}