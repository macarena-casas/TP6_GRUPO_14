DELIMITER $$
CREATE PROCEDURE agregarPersona (
	IN auxDNI VARCHAR(20),
    IN auxNombre VARCHAR(45),
    IN auxApellido VARCHAR(45)
)
BEGIN
    INSERT INTO personas (Dni,Nombre, Apellido) 
    VALUES (auxDNI,auxNombre, auxApellido);
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE modificarPersona (
    IN auxDNI VARCHAR(20),
    IN auxNombre VARCHAR(45),
    IN auxApellido VARCHAR(45)
)
BEGIN
    UPDATE personas 
    SET Nombre = auxNombre, Apellido = auxApellido 
    WHERE Dni = auxDNI;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE eliminarPersona (
	IN auxDNI VARCHAR(20),
    IN auxNombre VARCHAR(45),
    IN auxApellido VARCHAR(45)
)
BEGIN
    DELETE FROM personas
    WHERE Dni = auxDNI
      AND Nombre = auxNombre
      AND Apellido = auxApellido;
END$$
DELIMITER ;


