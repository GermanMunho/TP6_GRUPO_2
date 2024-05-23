DELIMITER //

CREATE DEFINER=`root`@`localhost` PROCEDURE SPEliminarPersona(IN XDni varchar(20))
BEGIN
	DELETE FROM personas WHERE Dni = XDni;
END //

DELIMITER ;