INSERT INTO Employees (Employee_id, Name, Last_name, Position, Login, Password) VALUES
 (1, 'Екатерина', 'Шульман', 'lawyer', 'Shulman', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5'),
 (2, 'Владимир', 'Путин', 'lawyer', 'Putin', '3bced02e0341dad74c304d06c4c1f69efb9aab8c148b327bc71d7ec08e252a42'),
 (3, 'Василий', 'Пупкин', 'intern', 'Pupkin', '24ae0794fd20c797223700756cd4d422ce34a4d06967d2f590945d0f13c29d21');


 INSERT INTO Services (Service_id, Service_name) VALUES
 (1, 'concluded agreement'),
 (2, 'payment'),
 (3, 'call'),
 (4, 'meeting');

 INSERT INTO History (Event_id, Service_id, Date, Description, Contract) VALUES
 (1, 2, '01/12/2019', 'Покупка недвижимости в Москве для ', 'https://blank-dogovor-kupli-prodazhi.ru/'),
 (2, 3, '05/09/2019', 'Звонок клиента с просьбой расмотреть дело сети', ''),
 (3, 3, '31/12/2019', 'Холодный звонок', '');

 INSERT INTO History (Event_id, Service_id, Date, Contract) VALUES
 (4, 4, '01/01/2000', 'http://www.consultant.ru/document/cons_doc_LAW_346055/'),
 (5, 4, '23/02/2005', 'http://www.consultant.ru/document/cons_doc_LAW_305/');

 INSERT INTO Clients (Client_id, Name, Last_name, Phone_number) VALUES
 (1, 'Жока', 'Валиев', '8(800)555-35-35'),
 (2, 'Otis', 'Lindeman', '+3(875)123-67-87'),
 (3, 'Татьяна', 'Финкельман', '8(987)665-43-21');

 INSERT INTO Clients (Client_id, Name, Middle_name, Last_name, Phone_number, Email) VALUES
 (4, 'Артемий', 'Aндреевич', 'Лебедев', '8(100)500-14-88', 'tema@tema.ru'),
 (5, 'Carl', 'ALBUS', 'Coral', '5050401', 'carl@yahoo.com'),
 (6, 'Валерий', 'Альбертович', 'Пистолетов', '456-78-12', 'pis4on@asd1.ua');

 INSERT INTO History_clients (Client_id, Event_id) VALUES
 (1, 1),
 (2, 3),
 (4, 4),
 (4, 1),
 (2, 4);

 INSERT INTO History_employees (Event_id, Employee_id) VALUES
 (1, 3),
 (2, 1),
 (4, 2);

