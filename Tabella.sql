/* Creazione database e tabella Libri */
CREATE DATABASE libreria_db;

USE libreria_db;

CREATE TABLE libri (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(255) NOT NULL,
    autore VARCHAR(255) NOT NULL,
    anno INT NOT NULL
);
