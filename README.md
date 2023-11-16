 # :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: 

 ### :point_down:  :point_down: :point_down: :point_down: HEY :point_down: YOU!  :point_down:  :point_down: :point_down: :point_down:

# YEAH _YOU!_ :punch:

#### :scream_cat: ARE YOU TIRED OF THESE QUIZZES THAT CAN'T TELL YOU ACCURATELY WHAT ANIMAL YOU'D BE? :scream_cat:

# WELL SAME HERE!!! :information_desk_person:

## :no_good: FRET NO LONGER! :no_good:

This is a Java Spring Boot project for playing and managing quizzes. It includes model classes for Outcome, Reply,
Answer, Quiz, and Question. The QuizController provides endpoints to interact with the quiz functionalities.

# :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar:


### Key Functionality

The MVP is able to:

* Add quizzes, questions, answers and **4** possible outcomes within a DataLoader
* Display a particular quiz by its id via **Endpoint:** `GET /quizzes/{id}`
* Display all quizzes **Endpoint:** `GET /quizzes`
* Answer a quiz question via **Endpoint:** `PATCH /quizzes/{id}`
* Provide an outcome based on the answers
* Provide multiple options per questions

### Extensions

* Display all quiz questions

## Model Classes

- **Outcome**: Represents the outcome of a quiz
- **Reply**: Represents the reply to a quiz question
- **Answer**: Represents an answer to a quiz question
- **Quiz**: Represents a quiz
- **Question**: Represents a question in a quiz

## QuizController Endpoints

### Display Available Quizzes

- **Endpoint:** `GET /quizzes`
- **Description:** Get a list of all available quizzes
- **Response:** Returns a list of Quiz objects
- **HTTP Status:** 200 OK

### Start a New Quiz

- **Endpoint:** `GET /quizzes/{id}`
- **Description:** Start a new quiz by selecting a quiz with the given ID
- **Response:** Returns a Reply object containing the first question and options
- **HTTP Status:** 200 OK

### Handle Answer to a Question:

- **Endpoint:** `PATCH /quizzes/{id}`
- **Description:** Choose an option for a quiz question
- **Request Body:** ChoiceDTO containing answerId and qNumber
- **Response:** Returns an Optional<Reply> with the result of the answered question
- **HTTP Status:** 200 OK

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/H323K14H/the-best-quiz-ever.git