CREATE TABLE IF NOT EXISTS `AchadosEDescontos`.`usuario` (
  `id_Usuario` INT NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  PRIMARY KEY (`id_Usuario`))
ENGINE = InnoDB;

insert into usuario (id_Usuario, senha, email, nome, tipo) values(1, "6969", "Jubiscreid69@yahoo.com.br", "Jubscreide", 1);
insert into usuario (id_Usuario, senha, email, nome, tipo) values(2, "3000", "Bys@hotmail.com", "Baldrake", 0);
insert into usuario (id_Usuario, senha, email, nome, tipo) values(3, "4500", "Saro@gmail.com", "Saronir", 0);
insert into usuario (id_Usuario, senha, email, nome, tipo) values(4, "123456", "CorinthiansNaVeia@gmail.com", "AdminOnFodao", 1);
