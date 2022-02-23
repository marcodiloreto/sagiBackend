
use `SagiDB`;

INSERT INTO Persona VALUES  ( null ,'nada','juan','asdevd',5.00),
							( null ,'nada','juan','garcia',4.6),
							( null ,'nada','santi','garcia',3.8),
							( null ,'nada','tomi','pinedo',3.5),
							( null ,'nada','marco','diloreto',4.0);
                            
select * from Persona;

Insert into Disciplina VALUES (NULL,'slack','te subis y haces pum pum pum','PORAHORANADA','usd.net.tumami');
SELECT * FROM Disciplina;

INSERT INTO Actividad VALUES
(NULL,'slack en casa','nos juntamos en casa a hacer slack','NADA =( ME GANA LA INFLACION','no tein',NULL,'LUNES','1999-9-29','2022-2-14','12:59:59','14:22:34',
'libertador al 800000000', 1 ),
(NULL,'Slack en libertador','nos vamosssss','500','b',null,'MARTES','1999-9-29','2022-2-14','12:59:59','14:22:34',
'libertador al 800000000', 1),
(NULL,'Slack en algun lado','nos vamosssss','600','b',null,'MIERCOLES','1999-9-29','2022-2-14','12:59:59','14:22:34',
'san martin al 4000', 1),
(NULL,'Slack en el zoologico','nos vamosssss','400','b',null,'JUEVES','1999-9-29','2022-2-14','12:59:59','14:22:34',
'gorriti al 2', 1);

SELECT * from Actividad;

INSERT INTO PersonaActividad VALUES 
(NULL,1,2,'ANOTADO'),
(NULL,1,3,'ANOTADO'),
(NULL,1,4,'ANOTADO'),
(NULL,2,1,'ANOTADO'),
(NULL,2,3,'ANOTADO'),
(NULL,2,4,'ANOTADO'),
(NULL,3,1,'ANOTADO'),
(NULL,4,1,'ANOTADO'),
(NULL,4,2,'ANOTADO'),
(NULL,4,4,'ANOTADO'),
(NULL,5,4,'ANOTADO');