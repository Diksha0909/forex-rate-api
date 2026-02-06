# Forex Exchange Rate API

A Spring Boot REST API that provides currency exchange rates by integrating with the public **FreeForexAPI** service.

This project was built as part of a hiring assessment to demonstrate backend development skills such as:
- REST API design
- Validation & error handling
- External API integration
- Clean architecture and modular code structure

---

## Features

- Fetch exchange rate between two currencies (example: USD → EUR)
- Validates request body for correct currency format
- Uses FreeForexAPI for real-time exchange rates
- Proper error handling with meaningful HTTP status codes
- Spring Boot based clean project structure

---

## Tech Stack

- Java 25
- Spring Boot (Web MVC)
- RestClient (Spring HTTP Client)
- Maven
- Lombok
- Spring Validation
- Spring Modulith (optional module structuring)

---

## API Endpoint

### Get Exchange Rate

**GET**
```
/api/exchange-rate
```

**Request Body (JSON):**
```json
{
  "source": "USD",
  "destination": "EUR"
}
```

**Success Response (200 OK):**
```json
{
  "rate": 1.08,
  "updatedAt": "2026-02-04T12:34:56.000Z"
}
```

---

## Error Handling

### Invalid Request (400 Bad Request)

If request body is invalid or missing required fields:

```json
{
  "error": "Invalid request"
}
```

### External API Failure (502 Bad Gateway)

If the external API is unreachable or returns invalid data:

```json
{
  "error": "Failed to fetch exchange rate from external API"
}
```

### Unexpected Errors (5xx)

All unexpected errors return:

```json
{
  "error": "Internal server error"
}
```

---

## External API Integration

This project uses:

**FreeForexAPI**
- Base URL: `https://www.freeforexapi.com`

The exchange rate is fetched using:

```
/api/live?pairs=PAIR
```

Example:

```
https://www.freeforexapi.com/api/live?pairs=USDEUR
```

---

## How to Run the Application

### Clone Repository
```sh
git clone <your-repo-url>
cd forex-rate-api
```

### Build Project
```sh
mvn clean install
```

### Run Application
```sh
mvn spring-boot:run
```

Application will start on:

```
http://localhost:8080
```

---

## Testing via Postman / Curl

```sh
curl -X GET http://localhost:8080/api/exchange-rate \
-H "Content-Type: application/json" \
-d '{"source":"USD","destination":"EUR"}'
```

---

## Project Structure

```
src/main/java/com/example/forex
│
├── exchange
│   ├── controller
│   ├── service
│   ├── client
│   ├── model
│   └── exception
│
└── common
    ├── config
    ├── exception
    └── response
```

---

## Virtual Threads

Virtual threads are enabled via configuration:

```yaml
spring:
  threads:
    virtual:
      enabled: true
```

This improves scalability when the application makes blocking external HTTP calls.

---

## Assumptions

- Source and destination are expected to be valid 3-letter ISO currency codes (USD, EUR, GBP, etc.)
- External API is called directly with the requested pair (ex: USDEUR)
- If external API returns an unsupported pair or invalid response, the service returns an error response

---

