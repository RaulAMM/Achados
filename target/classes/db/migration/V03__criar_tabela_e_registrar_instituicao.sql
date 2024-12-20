CREATE TABLE IF NOT EXISTS `AchadosEDescontos`.`instituicao` (
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cnpj`))
ENGINE = InnoDB;

insert into instituicao(nome, cnpj, categoria, telefone, descricao) Values("CasaDasPrimas LTDA", "69696969", "Servicos gerais", "(69)3336969", "Convento de freiras que oferecem servicos variados... Muito variados. OBS:Rezas semanais com desconto");
