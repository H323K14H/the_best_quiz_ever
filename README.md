# :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar:

### :point_down:  :point_down: :point_down: :point_down: HEY :point_down: YOU!  :point_down:  :point_down: :point_down: :point_down:

# YEAH _YOU!_ :punch:

#### :scream_cat: ARE YOU TIRED OF THESE QUIZZES THAT CAN'T TELL YOU ACCURATELY WHAT ANIMAL YOU'D BE? :scream_cat:

# WELL SAME HERE!!! :information_desk_person:

## :no_good: FRET NO LONGER! :no_good:

This is a Java Spring Boot project for playing and managing quizzes. It includes model classes for Outcome, Reply,
Answer, Quiz, and Question. The QuizController provides endpoints to interact with the quiz functionalities.

# :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar: :guitar:

### Key Functionality:

The MVP is able to:

* Add quizzes, questions, answers and **4** possible outcomes within a DataLoader
* Display a particular quiz by its id via **Endpoint:** `GET /quizzes/{id}`
* Display all quizzes **Endpoint:** `GET /quizzes`
* Answer a quiz question via **Endpoint:** `PATCH /quizzes/{id}`
* Provide an outcome based on the answers
* Provide multiple options per questions

### Extensions:

* Display all quiz questions

## Model Classes:

- **Outcome**: Represents the outcome of a quiz
- **Reply**: Represents the reply to a quiz question
- **Answer**: Represents an answer to a quiz question
- **Quiz**: Represents a quiz
- **Question**: Represents a question in a quiz

## QuizController Endpoints:

### DISPLAY ALL AVAILABLE QUIZZES:

- **Endpoint:** `GET /quizzes`
- **Description:** Get a list of all available quizzes
- **Response:** Returns a list of Quiz objects

```json
   [
    {
        "id": 1,
        "name": "Animal Quiz",
        "currentQuestion": 1,
        "size": 5
    },
    {
        "id": 2,
        "name": "Disney Princess Quiz",
        "currentQuestion": 2,
        "size": 5
    }
 
  ]
```
- **HTTP Status:** 200 OK

### GET A SPECIFIC QUIZ BY ID:

- **Endpoint:** `GET /quizzes/{id}`
- **Description:** Get a quiz by its id
- **Response:** Return the corresponding quiz

```json
   {
   "id": 1,
   "name": "Animal Quiz",
   "currentQuestion": 1,
   "size": 5,
   "allQuestions": [
      {
         "id": 1,
         "questionNumber": 1,
         "questionText": "If you could have any superpower, which would you choose?",
         "answers": [
            {
               "id": 1,
               "answerText": "Teleportation"
            },
            {
               "id": 2,
               "answerText": "Flight"
            },
            {
               "id": 3,
               "answerText": "Invisibility"
            },
            {
               "id": 4,
               "answerText": "Super Strength"
            }
         ]
      },
      {
         "id": 2,
         "questionNumber": 2,
         "questionText": "If you could live anywhere in the world, where would it be",
         "answers": [
            {
               "id": 5,
               "answerText": "Tranquil Countryside"
            },
            {
               "id": 6,
               "answerText": "Seaside Town"
            },
            {
               "id": 7,
               "answerText": "Bustling Metropolis"
            },
            {
               "id": 8,
               "answerText": "Mountainous Region"
            }
         ]
      },
      {
         "id": 3,
         "questionNumber": 3,
         "questionText": "If you could change anything in the world, what would you change?",
         "answers": [
            {
               "id": 9,
               "answerText": "Free Global Healthcare"
            },
            {
               "id": 10,
               "answerText": "Protect the Environment"
            },
            {
               "id": 11,
               "answerText": "Promote Equality and Justice"
            },
            {
               "id": 12,
               "answerText": "Obliterate War"
            }
         ]
      },
      {
         "id": 4,
         "questionNumber": 4,
         "questionText": "How are you feeling?",
         "answers": [
            {
               "id": 13,
               "answerText": "Lackadaisical"
            },
            {
               "id": 14,
               "answerText": "Vivacious"
            },
            {
               "id": 15,
               "answerText": "Inquisitive"
            },
            {
               "id": 16,
               "answerText": "Discombobulated"
            }
         ]
      },
      {
         "id": 5,
         "questionNumber": 5,
         "questionText": "If you could have a pet, which animal would it be?",
         "answers": [
            {
               "id": 17,
               "answerText": "Afrikan Sneil (big snel)"
            },
            {
               "id": 18,
               "answerText": "Chiwawa (smol doge in bag)"
            },
            {
               "id": 19,
               "answerText": "Centypeed (bare legz)"
            },
            {
               "id": 20,
               "answerText": "Torteaz (master Oogway)"
            }
         ]
      }
   ]
}
```

### INSTANTIATE A NEW QUIZ INSTANCE:

- **Endpoint:** `POST /quizzes/start-new-game`
- **Description:** Create a new instance of the specified quiz
- **Request Body** 

```json
{
  "id": 1
}
```

- **Response:** Return the first question of specified quiz

```json
{
  "nextQuestion": {
    "id": 1,
    "questionNumber": 1,
    "questionText": "If you could have any superpower, which would you choose?",
    "answers": [
      {
        "id": 1,
        "answerText": "Teleportation"
      },
      {
        "id": 2,
        "answerText": "Flight"
      },
      {
        "id": 3,
        "answerText": "Invisibility"
      },
      {
        "id": 4,
        "answerText": "Super Strength"
      }
    ]
  },
  "outcomeDTO": null
}
```
- **HTTP Status:** 201 CREATED

### HANDLE ANSWER TO A QUESTION:

- **Endpoint:** `PATCH /quizzes/{id}`
- **Description:** Choose an option for a quiz question
- **Request Body:** ChoiceDTO containing answerId and qNumber:

```json
{
  "qNumber": 1,
  "answerId": 2
}
```

- **Response:** Stores the outcome, associated with the answer, in the question database and responds with the following:

```json
{
  "nextQuestion": {
    "id": 2,
    "questionNumber": 2,
    "questionText": "If you could live anywhere in the world, where would it be",
    "answers": [
      {
        "id": 5,
        "answerText": "Tranquil Countryside"
      },
      {
        "id": 6,
        "answerText": "Seaside Town"
      },
      {
        "id": 7,
        "answerText": "Bustling Metropolis"
      },
      {
        "id": 8,
        "answerText": "Mountainous Region"
      }
    ]
  },
  "outcomeDTO": null
}
```

- **HTTP Status:** 200 OK

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/H323K14H/the-best-quiz-ever.git