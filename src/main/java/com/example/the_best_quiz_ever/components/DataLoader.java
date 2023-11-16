package com.example.the_best_quiz_ever.components;

import com.example.the_best_quiz_ever.models.Answer;
import com.example.the_best_quiz_ever.models.Outcome;
import com.example.the_best_quiz_ever.models.Question;
import com.example.the_best_quiz_ever.models.Quiz;
import com.example.the_best_quiz_ever.repositories.AnswerRepository;
import com.example.the_best_quiz_ever.repositories.OutcomeRepository;
import com.example.the_best_quiz_ever.repositories.QuestionRepository;
import com.example.the_best_quiz_ever.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    OutcomeRepository outcomeRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        quiz 1
        Quiz quiz1 = new Quiz("Animal Quiz", 1L);
        quizRepository.save(quiz1);

//        create questions
        Question q1 = new Question(quiz1, "If you could have any superpower, which would you choose?", 1);
        questionRepository.save(q1);
        quiz1.addQuestion(q1);

        Question q2 = new Question(quiz1, "If you could live anywhere in the world, where would it be", 2);
        questionRepository.save(q2);
        quiz1.addQuestion(q2);

        Question q3 = new Question(quiz1, "If you could change anything in the world, what would you change?", 3);
        questionRepository.save(q3);
        quiz1.addQuestion(q3);

        Question q4 = new Question(quiz1, "How are you feeling?", 4);
        questionRepository.save(q4);
        quiz1.addQuestion(q4);

        Question q5 = new Question(quiz1, "If you could have a pet, which animal would it be?", 5);
        questionRepository.save(q5);
        quiz1.addQuestion(q5);

        quizRepository.save(quiz1);

//      create outcomes
        Outcome sloth = new Outcome(quiz1, "Sloth");
        outcomeRepository.save(sloth);

        Outcome flamingo = new Outcome(quiz1, "Flamingo");
        outcomeRepository.save(flamingo);

        Outcome octopus = new Outcome(quiz1, "Octopus");
        outcomeRepository.save(octopus);

        Outcome panda = new Outcome(quiz1, "Panda");
        outcomeRepository.save(panda);

        //        answers for q1
        Answer a1 = new Answer(q1, sloth, "Teleportation");
        answerRepository.save(a1);
        q1.addAnswer(a1);

        Answer a2 = new Answer(q1, flamingo, "Flight");
        answerRepository.save(a2);
        q1.addAnswer(a2);

        Answer a3 = new Answer(q1, octopus, "Invisibility");
        answerRepository.save(a3);
        q1.addAnswer(a3);

        Answer a4 = new Answer(q1, panda, "Super Strength");
        answerRepository.save(a4);
        q1.addAnswer(a4);



//        answers for q2
        Answer a5 = new Answer(q2, sloth, "Tranquil Countryside");
        answerRepository.save(a5);
        q2.addAnswer(a5);

        Answer a6 = new Answer(q2, flamingo, "Seaside Town");
        answerRepository.save(a6);
        q2.addAnswer(a6);

        Answer a7 = new Answer(q2, octopus, "Bustling Metropolis");
        answerRepository.save(a7);
        q2.addAnswer(a7);

        Answer a8 = new Answer(q2, panda, "Mountainous Region");
        answerRepository.save(a8);
        q2.addAnswer(a8);

      
        //        answers for q3
        Answer a9 = new Answer(q3, sloth, "Free Global Healthcare");
        answerRepository.save(a9);
        q3.addAnswer(a9);

        Answer a10 = new Answer(q3, flamingo, "Protect the Environment");
        answerRepository.save(a10);
        q3.addAnswer(a10);

        Answer a11 = new Answer(q3, octopus, "Promote Equality and Justice");
        answerRepository.save(a11);
        q3.addAnswer(a11);

        Answer a12 = new Answer(q3, panda, "Obliterate War");
        answerRepository.save(a12);
        q3.addAnswer(a12);


        //        answers for q4
        Answer a13 = new Answer(q4, sloth, "Lackadaisical");
        answerRepository.save(a13);
        q4.addAnswer(a13);

        Answer a14 = new Answer(q4, flamingo, "Vivacious");
        answerRepository.save(a14);
        q4.addAnswer(a14);

        Answer a15 = new Answer(q4, octopus, "Inquisitive");
        answerRepository.save(a15);
        q4.addAnswer(a15);

        Answer a16 = new Answer(q4, panda, "Discombobulated");
        answerRepository.save(a16);
        q4.addAnswer(a16);


        //        answers for q5
        Answer a17 = new Answer(q5, sloth, "Afrikan Sneil (big snel)");
        answerRepository.save(a17);
        q5.addAnswer(a17);

        Answer a18 = new Answer(q5, flamingo, "Chiwawa (smol doge in bag)");
        answerRepository.save(a18);
        q5.addAnswer(a18);

        Answer a19 = new Answer(q5, octopus, "Centypeed (bare legz)");
        answerRepository.save(a19);
        q5.addAnswer(a19);

        Answer a20 = new Answer(q5, panda, "Torteaz (master Oogway)");
        answerRepository.save(a20);
        q5.addAnswer(a20);

//        quiz 2
        Quiz quiz2 = new Quiz("Disney Princess Quiz", 1L);
        quizRepository.save(quiz2);

//        questions for quiz 2
        Question q2_1 = new Question(quiz2, "What do you value most in friendship?", 1);
        questionRepository.save(q2_1);
        quiz1.addQuestion(q2_1);

        Question q2_2 = new Question(quiz2, "What fictional world would you most like to inhabit?", 2);
        questionRepository.save(q2_2);
        quiz1.addQuestion(q2_2);

        Question q2_3 = new Question(quiz2, "Describe your aura in one word", 3);
        questionRepository.save(q2_3);
        quiz1.addQuestion(q2_3);

        Question q2_4 = new Question(quiz2, "What would you rather watch - Disney, Netflix or HBO?", 4);
        questionRepository.save(q2_4);
        quiz1.addQuestion(q2_4);

        Question q2_5 = new Question(quiz2, "Do you consider yourself an extrovert or an introvert?", 5);
        questionRepository.save(q2_5);
        quiz1.addQuestion(q2_5);

        quizRepository.save(quiz2);


    }



} // last