set DATESTYLE to DMY;

INSERT INTO Employees (Employee_id, Name, Last_name, Position, Login, Password, User_role) VALUES
 (0, 'admin', 'admin', 'lawyer', 'admin', 'admin', 'ADMIN');


INSERT INTO Employees (Employee_id, Name, Last_name, Position, Login, Password) VALUES
 (1, 'Геральд', 'Ривов', 'lawyer', 'Vedmak', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5'),
 (2, 'Владимир', 'Иванов', 'lawyer', 'Ivanov', '3bced02e0341dad74c304d06c4c1f69efb9aab8c148b327bc71d7ec08e252a42'),
 (3, 'Василий', 'Кустиков', 'intern', 'Bush', '24ae0794fd20c797223700756cd4d422ce34a4d06967d2f590945d0f13c29d21');


 INSERT INTO Services (Service_id, Service_name) VALUES
 (1, 'Marriage Separation Agreement'), --развод
 (2, 'Simple Real Estate Lease'), --простая аренда
 (3, 'Power of Attorney'), --доверенность
 (4, 'Bankruptcy Worksheet'); -- лист банкротства

 INSERT INTO History (Event_id, Service_id, Date, Description, Contract) VALUES
 (1, 2, '01/12/2019', 'Аренда квартиры в Бутово', 'file:///kvartira_butovo.docx'),
 (2, 1, '05/09/2019', 'Развод со скандалом', 'file:///razvod_ivanovs.docx'),
 (3, 4, '31/12/2019', '', 'file:///bankrot_shlyapik.docx');


 INSERT INTO Clients (Client_id, Name, Last_name, Phone_number) VALUES
 (1, 'Дмитрий', 'Иванов', '8(800)555-35-35'),
 (2, 'Ольга', 'Иванова', '+3(875)123-67-87'),
 (3, 'Татьяна', 'Финкельман', '8(987)665-43-21'),
 (4, 'Александр', 'Шляпик', '');


 INSERT INTO Clients_histories (clients_Client_id, histories_Event_id) VALUES
 (1, 2),
 (2, 2),
 (3, 1),
 (4, 3);

 INSERT INTO Employees_histories (histories_Event_id, employees_Employee_id) VALUES
 (1, 3),
 (2, 1),
 (3, 2);

