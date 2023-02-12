# ChatGPT Microservice

This project is a Java microservice that communicates with the AI's API endpoint. Note that to communicate with the AI's API endpoint, first you will need to create an API key. You can use this key to authenticate your API requests and access the AI's functionality.

This Java project is using framework Spring Boot. This will allow to build and deploy the microservice as a standalone application.

The project code makes an API request to the ChatGPT API endpoint using the provided question. That is why we have to pass in the API key as part of the request headers to authenticate the request.

Then the code extract the answer from the API response and return it.

The question and its answer are stored in a CSV file. The CSV file is mapped in the container, so that it survives after the container is stopped and can continue to be appended to each time the app is executed.

Finally, we have to package the microservice as a Docker container and deploy it in a production environment.
