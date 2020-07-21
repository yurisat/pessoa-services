DROP TABLE IF EXISTS pessoa;
 
CREATE TABLE pessoa (
 id INT AUTO_INCREMENT PRIMARY KEY,
 nome VARCHAR(250) NOT NULL,
 cpf VARCHAR(11) NOT NULL,
 data_nascimento DATETIME NOT NULL
);

INSERT INTO pessoa (nome, cpf, data_nascimento) VALUES
  ('Yuri', '11111111111', PARSEDATETIME('31/07/1982', 'dd/MM/yyyy'));