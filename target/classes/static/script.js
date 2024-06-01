const questions = [
    "Вопрос 1: Какова причина болезни?",
    "Вопрос 2: Каковы симптомы болезни?",
    "Вопрос 3: Какие методы диагностики используются?",
    "Вопрос 4: Какие методы лечения существуют?",
    "Вопрос 5: Каков прогноз болезни?",
    "Вопрос 6: Какие профилактические меры существуют?",
    "Вопрос 7: Какие осложнения могут возникнуть?",
    "Вопрос 8: Каковы пути передачи инфекции?",
    "Вопрос 9: Какие факторы риска существуют?",
    "Вопрос 10: Как проводится реабилитация пациентов?"
];

let currentQuestionIndex = 0;

document.getElementById('nextButton').addEventListener('click', function() {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length) {
        document.getElementById('question').innerText = questions[currentQuestionIndex];
    } else {
        document.getElementById('questionContainer').innerHTML = '<p>Вы прошли тест!</p>';
    }
});
