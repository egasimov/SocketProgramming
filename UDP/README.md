### This project contains an example for Client-Server model via **U**ser **D**atagram **P**rotocol

What classes , functions used in this project :

DatagramSocket -> packets are sent and received over this object
DatagramPacket ->contains information about data , destination address  and port on which server listens

### Creation of DatagramSocket: - First, a datagramSocket object is created to carry the packet to the destination and to receive it whenever the server sends any data. To create a datagramSocket following constructors can be used:

```

Syntax: public DatagramSocket()
              throws SocketException
Creates a datagramSocket and binds it to any available
port on local machine. If this constructor is used, the
OS would assign any port to this socket.
```
```
Syntax: public DatagramSocket(int port)
                        throws SocketException
Parameters:
port - port to which socket is to be bound
Throws:
SocketException - If the socket cannot be bound to the 
specific local port. Creates a DatagramSocket and binds 
to the specified port on the local machine.
```

```
Syntax: public DatagramSocket(int port,
                       InetAddress inetaddress)
                        throws SocketException
Parameters:
port - port to which socket is to be bound.
inetaddress - local address to which socket is to be bound.
Throws:
SocketException - If the socket cannot be bound to the 
specific local port. It creates a DatagramSocket and 
binds it to specified port and ip-address.
```
### Creation of DatagramPacket: In this step, the packet for sending/receiving data via a datagramSocket is created.


### Constructor to send data: 
```
Syntax: public DatagramPacket(byte[] buf,
              int offset,
              int length,
              SocketAddress address)
Parameters:
buf - the packet data.
offset - the packet data offset.
length - the packet data length.
address - the destination socket address.
Constructs a DatagramPacket for sending data at specified address
 and specified port.
```
### Constructor to receive the data:
```
Syntax: public DatagramPacket(byte buf[],
              int length)
Parameters:
buf - the packet data.
length - the packet data length.
Constructs a DatagramPacket for recieving the data of length length
in the byte array buf.
```

### In a nutshell, we can summarize the steps of sending and recieving data over UDP as follows:-

**For sending a packet via UDP, we should know 4 things, the message to send, its length, ipaddress of destination, port at which destination is listening.**

- Once we know all these things, we can create the socket object for carrying the packets and packets which actually possess the data.
- Invoke send()/receive() call for actually sending/recieving packets.
- Extract the data from the received packet.


I tried to demonstrate the following scenario ,basically communication between client and server via UDP .
Client send any integer number to server and then server responses with square of that number.
to finish communication from side of client , enter '/quit' , so client is disconnected .
and as well as server finish its job

### Resources : 
[### GeeksForGeeks](https://www.geeksforgeeks.org/working-udp-datagramsockets-java/)
[### Telusko ](https://www.youtube.com/watch?v=A5fFxs_DUsQ)
