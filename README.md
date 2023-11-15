# The Best Quiz Ever Project
## Overview
This is a Java Spring Boot project for creating and managing quizzes. It includes model classes for Outcome, Reply, Answer, Quiz, and Question. The QuizController provides endpoints to interact with the quiz functionalities.
## Model Classes
- **Outcome**: Represents the outcome of a quiz.
- **Reply**: Represents the reply to a quiz question.
- **Answer**: Represents an answer to a quiz question.
- **Quiz**: Represents a quiz.
- **Question**: Represents a question in a quiz.
## QuizController Endpoints
### Display Available Quizzes
- **Endpoint:** `GET /quizzes`
- **Description:** Get a list of all available quizzes.
- **Response:** Returns a list of Quiz objects.
- **HTTP Status:** 200 OK
### Start a New Quiz
- **Endpoint:** `GET /quizzes/{id}`
- **Description:** Start a new quiz by selecting a quiz with the given ID.
- **Response:** Returns a Reply object containing the first question and options.
- **HTTP Status:** 200 OK
### Handle Answer Question:
- **Endpoint:** `PATCH /quizzes/{id}`
- **Description:** Choose an option for a quiz question.
- **Request Body:** ChoiceDTO containing answerId, qNumber, etc.
- **Response:** Returns an Optional<Reply> with the result of the answered question.
- **HTTP Status:** 200 OK
## Usage
1. Clone the repository:
   ```bash
   git clone https://github.com/H323K14H/the-best-quiz-ever.git