# Person Registry API
This repository contains a simple Person Registry API built using Spring Boot. The API allows users to store and fetch information about persons and their family members, including spouses and children.

# Features
- Store a person's information, including their name and social security number.
- Save a person's spouse name.
- Save a person's children's names and ages.
- Fetch a person's information using their social security number.
- Retrieve the name of the oldest child for a person.

# Prerequisites
- Java 8 or higher
- Maven

# Getting Started
Clone the repository:

```sh
git clone https://github.com/anazri/peoplecase.git
cd person-registry-api
```

Build the project:
```sh
mvn clean install
```

Run the application:

```sh
mvn spring-boot:run
```

The API will be available at http://localhost:8088.

API Endpoints
The following API endpoints are available:

Save a person's information, including their spouse and children's information.
```sh
POST /persons
```
Example request body:
```sh
{
  "name": "John Doe",
  "spouseName": "Jane Doe",
  "ssn": "123-456-789",
  "children": [
    {
      "name": "Alice Doe",
      "age": 10
    },
    {
      "name": "Bob Doe",
      "age": 7
    }
  ]
}
```

Fetch a person's information using their SSN.
```sh
GET /persons/{ssn}
```

Retrieve the name of the oldest child for a person with the given SSN.
```sh
GET /persons/{ssn}/oldest-child
```

# Thank you
