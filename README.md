
## Badges

Add badges from somewhere like: [shields.io](https://shields.io/)

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)


# ForoHub

SpringBoot APP


## Overview


ForoHub is an API built with Spring Boot that serves as a forum for programming students. The platform allows students to seek help with topics they are learning in their courses and receive answers from other students. The project includes authentication and authorization processes using Spring Security and JWT tokens, and it features a CRUD (Create, Read, Update, Delete) functionality for forum topics.
## Features

Features
+ User Authentication and Authorization: Secure user authentication and authorization using Spring Security and JWT tokens.

+ CRUD Operations for Forum Topics: Full CRUD functionality for managing forum topics.

+ Search Functionality: Users can search for specific topics within the forum.

+ User Interaction: Students can post questions and respond to topics, facilitating peer-to-peer learning.


## Technologies Used

+ Spring Boot: Backend framework used for building the API.
+ Spring Security: Used for implementing security features.
+ JWT Tokens: Used for handling authentication and authorization.
+ JPA/Hibernate: For database interaction.
+ H2 Database: In-memory database for development and testing.
+ Maven: For project management and build automation.


## Getting Started

#### Prerequisites

+ Java 11 or higher
+ Maven 3.6.3 or higher

#### Installation
Clone the repository:
```bash
  git clone https://github.com/luifer991/foro-hub.git
  cd foro-hub
```
The API will be available at `http://localhost:8080`.
## API endpoints

#### Forum Topics

+ Get All Topics: `GET /topics`
+ Get Topic by ID: `GET /topics/{id}`
+ Create Topic: `POST /api/topics`
+ Update Topic: `PUT /topics/{id}`
+ Delete Topic: `DELETE /topics/{id}`




## Authors

- [Jorge Morales](https://github.com/luifer991)


## 🚀 About Me
Hi there! I'm Jorge Morales, a passionate fullstack programming student and data analyst. Throughout my journey, I've gained skills in a variety of technologies including React.js, Node.js, Next.js, TypeScript, and I'm currently delving into Java for backend development, specifically with Spring Boot. I enjoy exploring new tools and frameworks to enhance my skills and craft innovative solutions. Connect with me and let's talk about the exciting world of software development and data analysis!



## Contributing

Contributions are welcome! Please fork the repository and create a pull request.

+ Fork the Project
+ Create your Feature Branch (git checkout -b feature/AmazingFeature)
+ Commit your Changes (git commit -m 'Add some AmazingFeature')
+ Push to the Branch (git push origin feature/AmazingFeature)
+ Open a Pull Request




## Documentation

[Documentation](https://linktodocumentation)

