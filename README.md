# Weather App

## Overview

The Weather App is a simple web application that fetches weather forecast data from an external API and presents it to users. The frontend is developed using HTML, CSS, and JavaScript, while the backend is powered by Spring Boot.

## Features

- Retrieve weather forecast data based on user input location.
- Display forecast summary and hourly forecast.

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Maven

## Setup Instructions

### Backend (Spring Boot)

1. Clone the repository:

   ```bash
   git clone <repository-url>
   ```

2. Navigate to the `backend` directory:

   ```bash
   cd backend
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

   The backend server will start running on `http://localhost:8888`.

### Frontend (HTML, CSS, JavaScript)

1. Navigate to the `frontend` directory:

   ```bash
   cd WeatherApp-Frontend
   ```

2. Open the `index.html` file in a web browser or serve the front end using a web server of your choice.

3. Use Swagger UI (Optional):

Swagger is integrated into the application to provide interactive API documentation. You can access the Swagger UI by navigating to http://localhost:8888/swagger-ui/index.html# after starting the application.
4. Use customClientId = abhishek and customClientSecret = 123. 

## Usage

1. Open the Weather App in a web browser.
2. Enter the desired location for which you want to retrieve the weather forecast.
3. Click on the "Get Forecast" button.
4. The forecast summary and hourly forecast will be displayed on the page.
