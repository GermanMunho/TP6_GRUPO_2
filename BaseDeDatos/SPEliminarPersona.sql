CREATE DEFINER=`root`@`localhost` PROCEDURE `SPEliminarPersona`(XDni varchar(20))
BEGIN
DELETE FROM personas WHERE DNI = XDni;
END