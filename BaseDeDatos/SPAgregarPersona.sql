DELIMITER //

CREATE DEFINER=`root`@`localhost` PROCEDURE `SPAgregarPersona`(NewDNI varchar(20),NewNombre varchar (45),NewApellido varchar (45))
BEGIN
INSERT INTO personas(DNI, Nombre, Apellido) VALUES(NewDNI, NewNombre, NewApellido);
END //

DELIMITER ;