# grupo-14-OO2-2023

Repositorio para el Trabajo Practico cuatrimestral de Orientación a Objetos 2 (2023)

### Reference Documentation

For further reference, please consider the following sections:

README grupo-14-OO2-2023

Para poder correr satisfactoriamente el trabajo, en mySQL se debe crear un schema llamado “db-grupo-14”, lo cual se puede hacer con el siguiente script:

CREATE SCHEMA `db-grupo-14`;


Luego, hay que correr el proyecto, teniendo en properties, dentro de la carpeta resources, la opción en create:


Una vez hecho esto, se cambia la opción a update:





Y finalmente se corre el siguiente script a continuación en mySQL:


SELECT * FROM `db-grupo-14`.role;
INSERT INTO `db-grupo-14`.role (id,created_at, enabled, name,updated_at) VALUES (1, '2022-01-01 00:00:00',b'1', 'admin','2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.role (id,created_at, enabled, name,updated_at) VALUES (2, '2022-01-01 00:00:00',b'1', 'audit','2022-01-01 00:00:00');
SELECT * FROM `db-grupo-14`.user;
INSERT INTO `db-grupo-14`.user (id, birth_date, created_at, email, enabled, name, password, updated_at, id_role) VALUES (1, '2022-01-01 00:00:00', '2022-01-01 00:00:00', 'hola', b'1', 'pablo', '$2y$04$OZqsQ9erMwFOoBS6NUT2PeB/ttQR5gjF0uh0qM2Wnl6Of0B/hL9zu', '2022-01-01 00:00:00', 1);
INSERT INTO `db-grupo-14`.user (id, birth_date, created_at, email, enabled, name, password, updated_at, id_role) VALUES (2, '2022-01-01 00:00:00', '2022-01-01 00:00:00', '@gmail', b'1', 'facu', '$2y$04$OZqsQ9erMwFOoBS6NUT2PeB/ttQR5gjF0uh0qM2Wnl6Of0B/hL9zu', '2022-01-01 00:00:00', 2);

INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('1', '2022-01-01 00:00:00', 'Hernandez', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('2', '2022-01-01 00:00:00', 'Comedor Universitario', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('3', '2022-01-01 00:00:00', 'E.S discepolo', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('4', '2022-01-01 00:00:00', 'Lola Mora', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('5', '2022-01-01 00:00:00', 'Hernandez Arregui', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('6', '2022-01-01 00:00:00', 'Gimnasio', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('7', '2022-01-01 00:00:00', 'Quincho Fontanarrosa', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('8', '2022-01-01 00:00:00', 'Juana Manso', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('9', '2022-01-01 00:00:00', 'Inadi', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('10', '2022-01-01 00:00:00', 'Campo Dep', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('11', '2022-01-01 00:00:00', 'Irma Laciar', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('12', '2022-01-01 00:00:00', 'Leonardo Werthein', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('13', '2022-01-01 00:00:00', 'Oscar Varsavsky', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('14', '2022-01-01 00:00:00', 'Jardin Maternal', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('15', '2022-01-01 00:00:00', 'Hector Oesternal', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('16', '2022-01-01 00:00:00', 'Cine', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('17', '2022-01-01 00:00:00', 'Casa del E', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('18', '2022-01-01 00:00:00', 'Lisandro de la T', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('19', '2022-01-01 00:00:00', 'Macedonio', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('20', '2022-01-01 00:00:00', 'Ortiz', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('21', '2022-01-01 00:00:00', 'Jaureche', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('22', '2022-01-01 00:00:00', 'Ugarte', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('23', '2022-01-01 00:00:00', 'Mnzi', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('24', '2022-01-01 00:00:00', 'PeÃ±a', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('25', '2022-01-01 00:00:00', 'Marechal', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('26', '2022-01-01 00:00:00', 'Azurduy', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('27', '2022-01-01 00:00:00', 'Conturi', '2022-01-01 00:00:00');
INSERT INTO `db-grupo-14`.`sector` (`id_sector`, `created_at`, `name`, `updated_at`) VALUES ('28', '2022-01-01 00:00:00', 'Kirchner', '2022-01-01 00:00:00');

Este script crea los users y sus roles, que permiten el acceso al login, y también todos los sectores para la creación de las Aulas.

Los users con role “audit” solamente podrán acceder a la vista de eventos, y también entrar a los eventos específicos de cada tipo de dispositivo, y en ellos, buscarlos por filtros.

Los users con role “admin” podrán hacer todo esto, y además, ver los dispositivos, crearlos y darlos de baja.

Para loguearse como Admin:
Username: pablo
Contraseña: 1234


Para loguearse como Audit:
Username: facu
Contraseña: 1234

