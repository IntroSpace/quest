package com.zodiac33.quest;

import java.util.Random;

public class Story {

    private Situation start_story;
    public Situation current_situation;
    private int random = (new Random()).nextInt(2);

    Story() {
        start_story = new Situation(
                "Начало пути",
                "Мне исполнилось 18 лет. Пришло время выбирать\n"
                        + "(1)пойти учиться в университет\n"
                        + "(2)пойти в армию\n",
                2, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "Поступление в университет",
                "Ну что же, пора уже отправлять документы\n"
                        + "(1)отправить документы сейчас\n"
                        + "(2)отправлю позже, зачем торопиться?",
                2, 0, 0, 0);
        start_story.direction[0].direction[0] = new Situation("Отправление документов",
                "Хорошо, что я сдал документы взаранее. Приём заявок закончился раньше\n"
                        + "(1)сосредоточиться только на учёбе\n" +
                        "(2)начать паралельно работать",
                2, 0, 0, 10);
        start_story.direction[0].direction[0].direction[0] = new Situation(
                "Конец учёбы",
                "Я закончил учёбу с большими успехами. Меня уже приглашают в одну известную компанию\n" +
                        "(1)Согласиться работать\n" +
                        "(2)Работать на себя",
                2, 1, 50, 100);

        start_story.direction[0].direction[0].direction[0].direction[0] = new Situation(
                "Хорошая работа",
                "Я думаю, это был правильный выбор. Большая зарплата, много нового опыта, много повышений",
                0, 2, 1000, 200);

        start_story.direction[0].direction[0].direction[0].direction[1] = new Situation(
                "Удачный выбор",
                "Теперь я понимаю, что лучше работать на себя. Никаких ограничений, полная свобода",
                0, 0, 1000, 100);

        start_story.direction[0].direction[0].direction[1] = new Situation(
                "Немного подзаработал",
                "Я еле-еле закончил учёбу. Но с такими знаниями врядле кто-то позовёт меня работать\n" +
                        "(1)Подождать подходящих вакансий\n" +
                        "(2)Работать на себя",
                2, 0, 500, 30);

        start_story.direction[0].direction[0].direction[1].direction[1] = start_story.direction[0].direction[0].direction[0].direction[1];

        if (random==0) start_story.direction[0].direction[0].direction[1].direction[0] = new Situation(
                "Неудача",
                "Подходящих вакансий так и не нашлось. Это полный провал(",
                0, 0, 1000, 200);
        else
            start_story.direction[0].direction[0].direction[1].direction[0] = new Situation(
                    "Везение",
                    "Появилась вакансия, которая полностью подходит для вас. Вам повезло",
                    0, 1, 200, 50);

        start_story.direction[0].direction[1] = new Situation("Приём заявок закончен",
                "Остался лишь один выход из ситуации...\n"
                        + "(1)продолжить",
                1, 0, 0, 5);
        start_story.direction[1] = new Situation(
                "Пора в армию",
                "Вот она, святая всех святых... ВОЕНКОМАТ\n"
                        + "(1)Да ну, его всё к чёрту. Лучше отмажусь\n" +
                        "(2)Потерпим годик, ничего страшного",
                2, 0, 0, 0);
        start_story.direction[1].direction[0] = new Situation(
                "Плохое решение",
                "Я лишь ухудшил ситуацию. Теперь для меня подготовлены ОСОБЫЕ задания\n" +
                        "(1)продолжить",
                1, 0, 0, 5);
        start_story.direction[1].direction[1] = new Situation(
                "Здравствуй, армия",
                "Я всё-таки привыкаю к этим заданиям, но даётся мне это сложно\n" +
                        "(1)продолжить",
                1, 0, 0, 5);
        start_story.direction[1].direction[0].direction[0] = new Situation(
                "Прощай, армия",
                "После армии я решил пойти в грузчики, ведь это настоящее мужское дело!\n" +
                        "(1)продолжить",
                1, 0, 0, 10);
        start_story.direction[1].direction[0].direction[0].direction[0] = new Situation(
                "Грузчик - это круто",
                "Я заработал денег. И грыжу...",
                0, 1, 300, 0);
        start_story.direction[1].direction[1].direction[0] = start_story.direction[1].direction[0].direction[0];
        start_story.direction[0].direction[1].direction[0] = start_story.direction[1];
        current_situation = start_story;
    }

    public void go(int num) throws Exception {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            throw new Exception("ERROR");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}