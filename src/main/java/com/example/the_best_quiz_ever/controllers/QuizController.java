package com.example.the_best_quiz_ever.controllers;import com.example.the_best_quiz_ever.services.QuizService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;@RestController@RequestMapping(value = "/quizzes")public class QuizController{    @Autowired    QuizService quizService;    //maybe will have to autowire more classes}