    BEGIN;
    set DATESTYLE to DMY;

    CREATE TYPE POSIT AS ENUM ('lawyer', 'intern');

    CREATE TYPE EDUC AS ENUM ('school', 'bachelor', 'master', 'PHD');

    CREATE TABLE Employees (
      Employee_id INTEGER PRIMARY KEY,
      Name VARCHAR(50) NOT NULL,
      Middle_name VARCHAR(50),
      Last_name VARCHAR(50) NOT NULL,
      Phone_number VARCHAR(50),
      Address TEXT,
      Email VARCHAR(50),
      Education_level EDUC,
      Position POSIT NOT NULL,
      Login VARCHAR(50) UNIQUE NOT NULL,
      Password CHAR(64) NOT NULL
    );

    CREATE TABLE Services (
      Service_id INTEGER PRIMARY KEY,
      Service_name VARCHAR(50) UNIQUE NOT NULL,
      Description TEXT
    );

    CREATE TABLE History (
      Event_id INTEGER PRIMARY KEY,
      Service_id INTEGER REFERENCES Services (Service_id) ON DELETE RESTRICT ON UPDATE CASCADE,
      Date DATE,
      Description TEXT,
      Contract TEXT
    );

    CREATE TABLE Clients (
      Client_id INTEGER PRIMARY KEY,
      Name VARCHAR(50),
      Middle_name VARCHAR(50),
      Last_name VARCHAR(50) NOT NULL,
      Phone_number VARCHAR(50),
      Address TEXT,
      Email VARCHAR(50)
    );


    CREATE TABLE History_clients (
      Client_id INTEGER REFERENCES Clients (Client_id) ON DELETE CASCADE ON UPDATE CASCADE,
      Event_id INTEGER REFERENCES History (Event_id) ON DELETE CASCADE ON UPDATE CASCADE,
      PRIMARY KEY(Client_id, Event_id)
    );

    CREATE TABLE History_employees (
      Event_id INTEGER REFERENCES History (Event_id) ON DELETE CASCADE ON UPDATE CASCADE,
      Employee_id INTEGER REFERENCES Employees (Employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
      PRIMARY KEY(Event_id, Employee_id)
    );
  COMMIT;
