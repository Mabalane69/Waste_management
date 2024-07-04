# Waste Management Application

This is a Spring Boot application designed to serve as an educational tool for the community, providing guidance on proper waste disposal and encouraging recycling habits. The application features functionalities including waste category lookup, disposal guidelines retrieval, and recycling tips.

## Features

- **Waste Category Lookup**: Provides a list of waste categories.
- **Disposal Guidelines Retrieval**: Offers guidelines on how to dispose of various types of waste properly.
- **Recycling Tips**: Shares tips to encourage and facilitate recycling.

## Technologies Used

- **Spring Boot**: Backend framework.
- **H2 Database**: In-memory database for storing data.
- **Maven**: Build and dependency management tool.

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6.3 or later

### Installation

1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/waste-management-app.git
   cd waste-management-app
   ```

2. **Build the project**:
   ```sh
   mvn clean install
   ```

3. **Run the application**:
   ```sh
   mvn spring-boot:run
   ```

## Project Structure

```
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── wasteapp
    │               ├── controller
    │               │   ├── WasteCategoryController.java
    │               │   ├── DisposalGuidelineController.java
    │               │   └── RecyclingTipController.java
    │               ├── exception
    │               │   ├── GlobalExceptionHandler.java
    │               │   └── ResourceNotFoundException.java
    │               ├── model
    │               │   ├── WasteCategory.java
    │               │   ├── DisposalGuideline.java
    │               │   └── RecyclingTip.java
    │               ├── repository
    │               │   ├── WasteCategoryRepository.java
    │               │   ├── DisposalGuidelineRepository.java
    │               │   └── RecyclingTipRepository.java
    │               └── WasteAppApplication.java
    └── resources
        ├── application.properties
        └── data.sql  // optional: to pre-load some initial data
```

## Pre-loaded Data

The application can pre-load the following data into the H2 database at startup using `data.sql`:

- **Waste Categories**:
  - Plastic
  - Metal

- **Recycling Tips**:
  - Separate plastics from metals
  - Clean recyclables before disposing

- **Disposal Guidelines**:
  - Dispose of batteries at designated points
  - Do not mix hazardous waste with general waste

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.


## Contact

If you have any questions or need further assistance, feel free to contact us at Phumimabalane@gmail.com.
```
