# Pasta-Monte-Carlo-Simulation
A Monte Carlo Simulation of a variation of a coupon collector problem. Featuring multithreading, HashSets, and Java's Random API.

A short time ago, I decided that I would attempt to collect all unique numbers from one of my local dining courts which serves pasta. Every time you get pasta, you are also given a tag, which ranges in value from 1 to 100. In order to determine the average amount of days that it would take to complete the collection, I created this program, which takes the average of 7,000,000 independent trials. The program is multithreaded, and each thread runs 1,000,000 trials.  

For those who have slower PCs, the average tends to 518 days to complete the collection of unique integers from 1-100.
