--A user will have their ID for quick reference in the database,
--along with their username and password to log in. Additionally,
--they should provide an email in case they forget their login
--credentials.
--A user might also be an admin, if we decide to give special
--permissions within the app itself.
CREATE TABLE Users (
--should we use UserID or UserName as key?
UserID INT(5) NOT NULL AUTO_INCREMENT,
UserName VARCHAR(15) NOT NULL,
Password VARCHAR(20) NOT NULL,
Email VARCHAR(25),
AdminStatus BOOLEAN DEFAULT FALSE,
PRIMARY KEY (UserID)
);

--A user will have several rows associated with their inventory
--These rows will list the food (FoNo) along with the amount they
--have of it, and when it expires.
CREATE TABLE UserInventory (
UserID NUMBER(5),
FoNo NUMBER(5),
Amt VARCHAR(15),
Measured VARCHAR(20),
ExpireDate DATE,
FOREIGN KEY (UserID) REFERENCES Users(UserID)
FOREIGN KEY (FoNo) REFERENCES Food(FoNo)
);