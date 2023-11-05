# E-commerce Website

[![Java CI with Maven](https://github.com/Hanocybous/e-commerce/actions/workflows/maven.yml/badge.svg)](https://github.com/Hanocybous/e-commerce/actions/workflows/maven.yml)
![Maintenance](https://img.shields.io/maintenance/yes/2023)
![GitHub](https://img.shields.io/github/license/Hanocybous/e-commerce)

---
![GitHub last commit (by committer)](https://img.shields.io/github/last-commit/Hanocybous/e-commerce)
![GitHub issues](https://img.shields.io/github/issues/Hanocybous/e-commerce)
![GitHub closed issues](https://img.shields.io/github/issues-closed/Hanocybous/e-commerce)
![GitHub pull requests](https://img.shields.io/github/issues-pr/Hanocybous/e-commerce)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/Hanocybous/e-commerce)

---
![GitHub repo file count (file type)](https://img.shields.io/github/directory-file-count/Hanocybous/e-commerce)
![GitHub repo size](https://img.shields.io/github/repo-size/Hanocybous/e-commerce)
![GitHub top language](https://img.shields.io/github/languages/top/Hanocybous/e-commerce)
![GitHub language count](https://img.shields.io/github/languages/count/Hanocybous/e-commerce)
![GitHub contributors](https://img.shields.io/github/contributors/Hanocybous/e-commerce)

---
![GitHub followers](https://img.shields.io/github/followers/Hanocybous)

---

## Description

This is an E-commerce website that allows users to buy and sell products. Users can create an account, login, and logout. Users can also add products to their cart, checkout, and view their order history. Users can also add products to sell, edit their products, and delete their products.

## Table of Contents
    
* [Installation](#installation)
* [Usage](#usage)
* [License](#license)
* [Contributors](#contributors)
* [Tests](#tests)
* [Questions](#questions)
* [Screenshots](#screenshots)
* [Links](#links)
* [Credits](#credits)
* [Technologies](#technologies)
* [Author](#author)
* [Acknowledgements](#acknowledgements)
* [Code of Conduct](CODE_OF_CONDUCT.md)
* [Contributing](CONTRIBUTING.md)
* [Changelog](CHANGELOG.md)
* [Security](SECURITY.md)
* [License](LICENSE.md)

## Installation

To install necessary dependencies, run the following command:

```
mvn clean install
```

If you want to run the application locally, you will need to have MySQL installed on your computer. You will also need to create a .env file in the root directory of the project. The .env file should contain the following information:

```
DB_NAME=ecommerce_db
DB_USER=root
DB_PW=yourpassword
```

When you run the application, the database and tables will be created for you. You will need to seed the database with data. To do this, run the following command:

```
mvn spring-boot:run -Dspring-boot.run.arguments=--spring-boot.run.arguments=--spring.datasource.initialization-mode=always
```

## Usage

To use this application, go to the deployed link.

## License

This project is licensed under the MIT license.

## Contributors

* [Charilaos Chatzidimitriou](github.com/Hanocybous)

## Tests

To run tests, run the following command:

```
mvn test
```

## Questions

If you have any questions about the repo, open an issue or contact me directly at 
[E-mail](mailto:harrychatz5@gmail.com)

You can find more of my work at [GitHub](github.com/Hanocybous)

## Screenshots

## Links

## Credits

## Technologies

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* PostgreSQL

## Author

![GitHub profile pic](https://github.com/Hanocybous.png?size=100)

## Acknowledgements
    
* [Professor Panos Vassiliadis](mailto:pvassil@cs.uoi.gr)
* [Professor Apostolos Zarrass](mailto:zarras@cs.uoi.gr)
