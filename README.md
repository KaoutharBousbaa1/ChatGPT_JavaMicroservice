# ChatGPT Microservice
## A command line application that uses the ChatGPT API to retrieve answers to natural language questions, and saves the questions and answers to a CSV file.

This project is a Java microservice that communicates with the AI's API endpoint. Note that to communicate with the AI's API endpoint, first you will need to create an API key. You can use this key to authenticate your API requests and access the AI's functionality.

Here's what the code does in more detail:

The main method starts by printing a message asking the user to input a question. The user input is read and stored in a string variable.

The getAnswerFromChatGpt method is then called, passing the user's question as a parameter. This method sends an HTTP GET request to the ChatGpt API endpoint, including the API key and the question as parameters.

The response from the API is read and returned as a string. If the API returns an error code, an error message is printed to the console.

The appendQuestionAndAnswerToCsv method is called, passing the question and answer as parameters. This method opens the "questions_and_answers.csv" file (or creates it if it doesn't exist), appends a new line with the question and answer separated by a semicolon, and closes the file. If there's an error writing to the file, an error message is printed to the console.

Finally, the answer is printed to the console.


## Prerequisites
Before you begin, make sure you have a valid API key for the ChatGPT API and an API endpoint

## Installation
Clone the repository to your local machine and import the project into your preferred Java development environment.

## Usage

1- Open the "ChatGptMicroservice.java" file.

2- Replace the placeholder text for the API_KEY and API_ENDPOINT constants with your own API key and API endpoint.

3- Run the application. You will be prompted to enter a question.

4- The answer to your question will be retrieved from the OpenAI API and printed to the console. The question and answer will also be saved to a CSV file named "questions_and_answers.csv".
