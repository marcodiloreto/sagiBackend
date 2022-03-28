
use `SagiDB`;

ALTER TABLE Persona AUTO_INCREMENT = 1;
INSERT INTO Persona VALUES  ( null ,'nada','juan','asdevd',5.00,false),
							( null ,'nada','juan','garcia',4.6,false),
							( null ,'nada','santi','garcia',3.8,false),
							( null ,'nada','tomi','pinedo',3.5,false),
							( null ,'nada','marco','diloreto',4.0,false);
                            
select * from Persona;

ALTER TABLE Disciplina AUTO_INCREMENT = 1;
Insert into Disciplina VALUES (NULL,'slack','te subis y haces pum pum pum','PORAHORANADA','usd.net.tumami');
SELECT * FROM Disciplina;

ALTER TABLE Actividad AUTO_INCREMENT = 1;
INSERT INTO Actividad VALUES
(NULL,'slack en casa','nos juntamos en casa a hacer slack','NADA =( ME GANA LA INFLACION',2.4,NULL,'1999-9-29','2022-2-14',
'libertador al 800000000', 1,20, 1.1, 2.2 ),
(NULL,'Slack en libertador','nos vamosssss','500',4.5,null,'1999-9-29','2022-2-14',
'libertador al 800000000', 1,10, 1.1, 2.2),
(NULL,'Slack en algun lado','nos vamosssss','600',5,null,'1999-9-29','2022-2-14',
'san martin al 4000', 1,9,1.1, 2.2),
(NULL,'Slack en el zoologico','nos vamosssss','400',3.2,null,'1999-9-29','2022-2-14',
'gorriti al 2', 1,22 ,1.1, 2.2);

SELECT * from Actividad;

ALTER TABLE Creadores AUTO_INCREMENT = 1;
INSERT INTO Creadores VALUES
(NULL,1,1),
(NULL,2,2),
(NULL,3,3),
(NULL,4,4);

SELECT * FROM Creadores;

ALTER TABLE Interesados AUTO_INCREMENT = 1;
INSERT INTO Interesados VALUES 
(NULL,1,2),
(NULL,1,3),
(NULL,1,4),
(NULL,2,1),
(NULL,2,4),
(NULL,2,3),
(NULL,3,1),
(NULL,4,1),
(NULL,4,2),
(NULL,4,4),
(NULL,5,4);

SELECT * FROM Interesados;

ALTER TABLE DiasSemana AUTO_INCREMENT = 1;
INSERT INTO DiasSemana VALUES
(null,'LUNES'),
(null,'MARTES'),
(null,'MIERCOLES'),
(null,'JUEVES'),
(null,'VIERNES'),
(null,'SABADO'),
(null,'DOMINGO');

SELECT * FROM  DiasSemana;


ALTER TABLE Plan AUTO_INCREMENT = 1;
INSERT INTO Plan VALUES
(NULL,"12:57:43","15:00:00",1,1),
(NULL,"15:00:00","17:00:00",1,4),
(NULL,"10:00:00","12:00:00",2,3),
(NULL,"16:00:00","18:00:00",3,6),
(NULL,"13:00:00","15:00:00",4,2),
(NULL,"19:00:00","22:00:00",4,5);

SELECT  * FROM Planes;


INSERT INTO DisciplinaMadre VALUES
(2,1);

SELECT * FROM DisciplinaMadre;

INSERT INTO DisciplinaHija VALUES
(1,2);

SELECT * FROM DisciplinaHija;