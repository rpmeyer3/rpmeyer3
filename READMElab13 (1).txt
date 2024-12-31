Ryan Meyer	
811274184

Lab 13: Client and Server Programs

This lab involves implementing a client program (lab13.c) and a server program (server.c) that communicate over sockets in a UNIX environment. The client sends a short text message (less than 80 bytes) to the server, which prints it to standard output.

Files
lab13.c: The client source code, which connects to the server, sends a message, and closes the connection.
server.c: The server source code, which listens on a specified port, receives a message from the client, prints it to standard output, and closes the connection.
Compilation Instructions
To compile the client and server programs:

Compile the Client:

gcc lab13.c -o lab13.out
Compile the Server:

gcc server.c -o server.out
Running the Programs
Start the Server: Run the server first, specifying a port number between 60000 and 65535.

./server.out <port>
Example:

./server.out 62010
Run the Client: In a different terminal, start the client and specify the server’s IP address, port number, and a message.

./lab13.out <ip_address> <port> <message>
Example (assuming the server is on the same machine):

./lab13.out 127.0.0.1 62010 "Hello from the client!"
Expected Output:

On the server’s terminal, you should see:
The server received: Hello from the client!

The client will exit after sending the message.
Valid Ports: The port number must be between 60000 and 65535.
IP Address: Use 127.0.0.1 for local testing or find the server’s IP with ifconfig or ipconfig for remote testing.
Requirements: The programs should run on vcf nodes and are compatible with GCC version 11.2.0.

Troubleshooting
Ensure that both client and server are running on the same network for testing.
Verify that the specified port is not in use by any other service.
If any socket-related error occurs, check if the IP address and port match correctly on both client and server.