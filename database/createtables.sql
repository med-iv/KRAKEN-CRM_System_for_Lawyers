    BEGIN;
    set DATESTYLE to DMY;

    CREATE TYPE POSIT AS ENUM ('lawyer', 'intern');

    CREATE TYPE EDUC AS ENUM ('school', 'bachelor', 'master', 'PHD');

    CREATE TABLE Employees (
      Employee_id BIGINT PRIMARY KEY,
      Name VARCHAR(50) NOT NULL,
      Middle_name VARCHAR(50),
      Last_name VARCHAR(50) NOT NULL,
      Phone_number VARCHAR(50),
      Address TEXT,
      Email VARCHAR(50),
      Education_level VARCHAR(50),
      Position VARCHAR(50),
      Login VARCHAR(50) UNIQUE NOT NULL,
      Password VARCHAR(64) NOT NULL,
      User_role VARCHAR(50) DEFAULT 'USER' NOT NULL
    );

    CREATE TABLE Services (
      Service_id BIGINT PRIMARY KEY,
      Service_name VARCHAR(50) UNIQUE NOT NULL,
      Description TEXT
    );

    CREATE TABLE History (
      Event_id BIGINT PRIMARY KEY,
      Service_id BIGINT REFERENCES Services (Service_id) ON DELETE RESTRICT ON UPDATE CASCADE,
      Date DATE,
      Description TEXT,
      Contract TEXT
    );

    CREATE TABLE Clients (
      Client_id BIGINT PRIMARY KEY,
      Name VARCHAR(50),
      Middle_name VARCHAR(50),
      Last_name VARCHAR(50) NOT NULL,
      Phone_number VARCHAR(50),
      Address TEXT,
      Email VARCHAR(50)
    );


    CREATE TABLE Clients_histories (
      clients_Client_id BIGINT REFERENCES Clients (Client_id) ON DELETE CASCADE ON UPDATE CASCADE,
      histories_Event_id BIGINT REFERENCES History (Event_id) ON DELETE CASCADE ON UPDATE CASCADE,
      PRIMARY KEY(clients_Client_id, histories_Event_id)
    );

    CREATE TABLE Employees_histories (
      histories_Event_id BIGINT REFERENCES History (Event_id) ON DELETE CASCADE ON UPDATE CASCADE,
      employees_Employee_id BIGINT REFERENCES Employees (Employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
      PRIMARY KEY(histories_Event_id, employees_Employee_id)
    );

    CREATE SEQUENCE Client_id_seq;
    CREATE SEQUENCE Service_id_seq;
    CREATE SEQUENCE History_id_seq;
    CREATE SEQUENCE Employee_id_seq;

    alter sequence Client_id_seq restart with 10;
    alter sequence Service_id_seq restart with 10;
    alter sequence History_id_seq restart with 10;
    alter sequence Employee_id_seq restart with 10;

  COMMIT;
