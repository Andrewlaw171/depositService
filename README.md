# Term Deposit Calculator Service

## Getting Started
### Requirements
- Java 17

### Running the service locally
After checking out the project you should be able to run the service locally 
using the intellij `DepositServiceApplication` run configuration, alternatively you can run the application 
with `./mvnw spring-boot:run`

### Usage 
Calculate term deposit final balance API

Example request: \
`POST http://localhost:8080/deposit-calculator/final-balance`

JSON Payload:
```json
{
  "startDeposit": 10000,
  "interestRatePerAnnum": 0.011,
  "investmentTermMonths": 36,
  "interestType": "MATURITY"
}
```
Response
```json
{
    "finalBalance": 10330
}
```