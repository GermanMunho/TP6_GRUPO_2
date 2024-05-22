CREATE DEFINER=`root`@`localhost` PROCEDURE `SPModificarPersona`(Udni varchar(20),
    Unombre VARCHAR(45),
	Uapellido VARCHAR(45))
BEGIN
UPDATE personas
    SET nombre = Unombre,  apellido = Uapellido
    WHERE dni = Udni;
    END