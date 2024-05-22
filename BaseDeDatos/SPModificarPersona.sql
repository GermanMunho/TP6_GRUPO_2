CREATE DEFINER=`root`@`localhost` PROCEDURE `SPModificarPersona`(
    IN pDNI VARCHAR(15),
    IN pNombre VARCHAR(50),
    IN pApellido VARCHAR(50)
)
BEGIN
    UPDATE personas
    SET Nombre = pNombre, Apellido = pApellido
    WHERE DNI = pDNI;
END