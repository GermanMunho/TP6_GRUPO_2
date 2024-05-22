CREATE DEFINER=`root`@`localhost` PROCEDURE `SPEliminarPersona`(Dni varchar(20))
BEGIN
DELETE FROM personas WHERE DNI = Dni;
END