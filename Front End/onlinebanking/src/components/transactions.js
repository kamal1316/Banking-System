import React, { useState } from 'react';
import './transactions.css';

const transactionsData = [
  {
    id: 1,
    type: 'Credit',
    toAccount: '123456789',
    accountName: 'Shresth',
    amount: 1000,
    date: '2023-08-09 09:15:00',
  },
  {
    id: 2,
    type: 'Debit',
    toAccount: '987654321',
    accountName: 'Anand Bhai',
    amount: 500,
    date: '2023-08-08 14:30:00',
  },
  {
    id: 3,
    type: 'Debit',
    toAccount: '723496861',
    accountName: 'Swiggy',
    amount: 350,
    date: '2023-08-08 08:30:00',
  },
  {
    id: 4,
    type: 'Debit',
    toAccount: '371209584',
    accountName: 'Amazon',
    amount: 1575,
    date: '2023-08-07 21:30:00',
  },
  {
    id: 5,
    type: 'Credit',
    toAccount: '612509847',
    accountName: 'KRK',
    amount: 500,
    date: '2023-08-07 10:30:00',
  },
  {
    id: 6,
    type: 'Credit',
    toAccount: '696969696',
    accountName: 'Wells Fargo',
    amount: 30000,
    date: '2023-08-06 17:30:00',
  },
  {
    id: 7,
    type: 'Debit',
    toAccount: '190274963',
    accountName: 'Zomato',
    amount: 800,
    date: '2023-08-05 18:30:00',
  },
];

function Transactions() {
    return (
      <div>
        <h2>Transaction History</h2>
        <table className="transaction-table">
          <thead>
            <tr>
              <th>Transaction Type</th>
              <th>Transaction To Account</th>
              <th>Account Name</th>
              <th>Amount Transferred</th>
              <th>Transaction Date and Time</th>
            </tr>
          </thead>
          <tbody>
            {transactionsData.map((transaction) => (
              <tr key={transaction.id}>
                <td>{transaction.type}</td>
                <td>{transaction.toAccount}</td>
                <td>{transaction.accountName}</td>
                <td>₹{transaction.amount}</td>
                <td>{transaction.date}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
  

export default Transactions;
