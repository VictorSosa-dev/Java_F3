insert into materias(id,nombre) values (1,'Java');
insert into materias(id,nombre) values (2,'Spring');

insert into cursos(id,ciclo,materias_fk) values (1,'2020-1',1);
insert into cursos(id,ciclo,materias_fk) values (2,'2020-1',2);

insert into estudiantes(id,nombre_completo) values (1,'Juan Perez');
insert into estudiantes(id,nombre_completo) values (2,'Maria Lopez');

insert into cursos_has_estudiantes(cursos_fk,calificacion,estudiantes_fk) values (1,10,1);
insert into cursos_has_estudiantes(cursos_fk,calificacion,estudiantes_fk) values (1,9,2);