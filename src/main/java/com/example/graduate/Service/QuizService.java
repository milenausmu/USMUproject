package com.example.graduate.Service;

import com.example.graduate.Data.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizService {
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(" Ваш пол",
                null));
        questions.add(new Question(" Ваш возраст",
                null));
        questions.add(new Question(" Курите ли вы?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" С какой частотой употребляете алкогольные напитки? ",
                Arrays.asList("Не пью вообще", "Пью только по праздникам", "Регулярно")));
        questions.add(new Question(" Употребляете жирную, жареную пищу на постоянной основе? (более 2 раз в день)",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Вы болели ангиной или скарлатиной? ",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Встаете ли вы ночью в туалет более 1 раза?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" У ваших ближайших родственников имеются сердечно-сосудистые заболевания?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Наблюдаете ли вы у себя повышенное систолическое артериальное давление (больше 130 мм.рт.ст.) в обычные дни?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Ваша работа связана с 24-часовым дежурством?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Вам случалось находиться в стрессе более 2 лет?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Возникают ли у Вас отдышка при физической нагрузке?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" У Вас возникают боли за грудиной при физической нагрузке или эмоциональных переживаний?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Периодически у Вас возникает чувство сердцебиения?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Замечали ли вы у себя расширение вен на нижних конечностях?",
                Arrays.asList("Да", "Нет")));
        questions.add(new Question(" Ваш показатель гематокрита в %:",
                null));
        questions.add(new Question(" Ваш показатель тромбоцитов, введите первое число (число х 10 в 9 / л): ",
                null));
        questions.add(new Question(" Основные жалобы: ",
                null));

        return questions;
    }
}
