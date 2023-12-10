# IT-Trouble-Ticket-Management-App
The IT Trouble Ticket Management App is a comprehensive solution designed to streamline the process of handling and tracking IT-related issues within an organization. This application serves as a centralized system for users to report problems, and administrators to efficiently manage and resolve them.

Login Credentials:
Here’s the login credentials for the user as well as for the admin.
User Login Credentials:
Admin username = "Rabia";
password = "12345";

Admin Login Credentials:

username = "Nadia";
password = "toffi";

Features:
User Interaction:
•	User Login: Users can log in with their credentials to access the application.
•	Create New Tickets: Users can create new trouble tickets, providing essential information about the issue they’ll be experiencing.
•	Update Tickets: Users can update their own tickets, modifying details as needed.
•	Close Tickets: Users can mark their tickets as resolved or close.
Admin/Manager Tools:
•	Admin Login: Administrators log in separately to access advanced functionalities.
•	View All Tickets: Admins can view a comprehensive list of all trouble tickets in the system.
•	Update Any Ticket: Admins have the ability to update details for any ticket in the database.
•	Close Tickets: Admins can mark any ticket as resolved.
•	Delete Tickets: Admins can delete tickets, ensuring efficient database management.
Database Structure:
The application relies on two MySQL database tables: rsajj and rsajj_users. The former stores ticket information, while the latter manages user credentials. This structure ensures a systematic approach to data organization.
Connectivity:
The app connects to the MySQL server using the provided credentials:
•	URL: jdbc:mysql://www.papademas.net:3307/tickets?autoReconnect=true&useSSL=false
•	Username: fp411
•	Password: 411
How to Use:
1.	User Login:
•	Enter valid credentials to access user-specific functionalities (provided on 1st page).
2.	Admin Login:
•	Use admin credentials to unlock additional features (provided on 1st page).
3.	Create Ticket:
•	Users can create new tickets, providing details about the issue.
4.	Update Ticket:
•	Users and admins can update ticket details as the status evolves.
5.	Close Ticket:
•	Mark a ticket as resolved/close when the issue is addressed.
6.	View All Tickets:
•	Admins can view a comprehensive list of all trouble tickets.
7.	Delete Ticket:
•	Admins can delete tickets for efficient database management.
