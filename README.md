# Simple Banking Application  

## Banking Application Overview  
This Spring Boot banking application serves as a simple yet functional platform for managing bank accounts and performing basic banking operations.  
The application supports:  
- Creating bank accounts  
- Fetching account details  
- Making deposits and withdrawals  
- Deleting accounts  
- Transferring funds between accounts  
- Viewing transaction histories
---

## Requirement 1 - Account Management  
The Account Management feature allows users to:  
- Create an account  
- Get specific account details  
- Get all accounts  
- Withdraw an amount  
- Deposit an amount  
- Delete an account  

### Build Account REST APIs:  
1. **Create Account**: Create a new account  
2. **Get Account**: Retrieve specific account details  
3. **Get All Accounts**: Retrieve all accounts  
4. **Withdraw Amount**: Withdraw an amount from the account  
5. **Deposit Amount**: Deposit an amount to the account  
6. **Delete Account**: Delete an existing account  


---

## Requirement 2 - Exception Handling  
The REST APIs should return proper error responses as shown below:  


---

## Requirement 3 - Transferring Funds Between Accounts  
This feature involves debiting an amount from one account and crediting it into another.  


## Requirement 4 - Transaction History Management  
This feature maintains the transaction history of every deposit, withdrawal, and transfer operation.  

### Features:  
- Log the transactions for **DEPOSIT**, **WITHDRAW**, and **TRANSFER**  
- Fetch transaction history: Get an account's transaction history  
