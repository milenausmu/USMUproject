package com.example.graduate.Controller;



import com.example.graduate.Data.OpenAiResponse;
import com.example.graduate.Data.Question;
import com.example.graduate.Service.QuizService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {

    @Autowired
    private QuizService quizService;

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    private final ObjectMapper objectMapper;

    public MainController(RestTemplateBuilder restTemplateBuilder,
                          @Value("${openai.api.url}") String apiUrl,
                          @Value("${openai.api.key}") String apiKey, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    this.objectMapper = objectMapper;}


    @GetMapping("/")
    public String getMainPage(Model model){
        return "index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        List<Question> questions = quizService.getQuestions();
        model.addAttribute("questions", questions);
        return "test";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam("answer1") String answer1,
                         @RequestParam("answer2") String answer2,
                         @RequestParam("answer3") String answer3,
                         @RequestParam("answer4") String answer4,
                         @RequestParam("answer5") String answer5,
                         @RequestParam("answer6") String answer6,
                         @RequestParam("answer7") String answer7,
                         @RequestParam("answer8") String answer8,
                         @RequestParam("answer9") String answer9,
                         @RequestParam("answer10") String answer10,
                         @RequestParam("answer11") String answer11,
                         @RequestParam("answer12") String answer12,
                         @RequestParam("answer13") String answer13,
                         @RequestParam("answer14") String answer14,
                         @RequestParam("answer15") String answer15,
                         @RequestParam("answer16") String answer16,
                         @RequestParam("answer17") String answer17,
                         @RequestParam("answer18") String answer18,
                         Model model
                         ) throws JsonProcessingException {
        String mes = "Составь описание пациента, риск возможного развития сердечно сосудистых заболеваний по его описанию: " +
                "пол - " + answer1 + ", возраст - " + answer2 + ", курит - " + answer3 +
                ", частота употребляния алкогольных напитков - " + answer4 + ", употребление жирной пиши на постонной основе - " +
                answer5 + ", болел ангиной или скарлатиной - " + answer6 + ", встает ночью в туалет более 1 раза - " + answer7 +
                ", у ближайших родственников имеются сердечно-сосудистые заболевания - " + answer8 +
                ", наблюдается ли повышенное систолическое артериальное давление (больше 130 мм.рт.ст.) в обычные дни - " + answer9 +
                ", работа связана с 24-часовым дежурством - " + answer10 + ", случалось находиться в стрессе более 2 лет - " + answer11 +
                ", возникают отдышка при физической нагрузке - " + answer12 +
                ", возникают боли за грудиной при физической нагрузке или эмоциональных переживаний - " + answer13 +
                ", периодически возникает чувство сердцебиения - " + answer14 +
                ", замечали ли себя расширение вен на нижних конечностях - " + answer15 +
                ", показатель гематокрита в % - " + answer16+
                ", показатель тромбоцитов, введите первое число (число х 10 в 9 / л) - " + answer17 +
                ", основные жалобы - " + answer18 +
                ". Описание сократи до минимума. Плюс дай рекомендации в более подрбном варианте. " +
                "Потенциально необходимых врачей дай списком." +
                "Так же напиши возможные заболевания ссс списком. Не используй никакую разметку";


        System.out.println(mes);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-4o");  // Укажите необходимую модель
        body.put("messages", new Object[]{Map.of("role", "user", "content", mes)});
        body.put("max_tokens", 1000);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);
        OpenAiResponse openAiResponse = objectMapper.readValue(response.getBody(), OpenAiResponse.class);

        // Извлекаем содержимое (content)
        String content = openAiResponse.getChoices().get(0).getMessage().getContent();
        model.addAttribute("result", content);
        return "result";
    }

    @GetMapping("/result")
    public String getResult(Model model){
        model.addAttribute("result", "тут должен быть результат теста");
        return "result";
    }



}
