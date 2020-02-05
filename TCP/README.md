**Java Socket programming is used for communication between the applications running on different JRE.**

Java Socket programming can be **connection-oriented** or **connection-less.**
This an example for connection-oriented , in other words connection over **T**ransmission **C**ontrol **P**rotocol .
What used in this project : 

- Multi threading feature 
- Socket Programming < java.util.net >
- Input/Output  <java.io >

### Let's look at little scenario .
When client tried to connect server over socket 
Each thread is created and running for  to handle each client's requests
Thanks for Multi threading that gives server machine  to server multiple client simultaneously .

**What Client to know to connect Server ?**
* IP adress of server machine and port on which server application is running
*using these information , client communicates with server over socket 



**What Server should do handle clients` requests?**
- In serverside ,We just create ServerSocket and each time new client is connected , new socket is created and assigned to Thread to  handle client`s requests

