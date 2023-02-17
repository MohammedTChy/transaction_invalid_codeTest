# transaction_invalid_codeTest
codeTest - February 2023


In order to protect our customers we need to identify invalid transactions, a transaction is invalid if:

    The amout exceeds $2000, or;
    It occurs within (and including) 60 minutes of another transaction with the same name and the exact same price, or;
    It occurs within (and including) 60 minutes of another transaction with the same name in a different city, or;
    It occurs at the exact same time of another transaction with the same name.
