CREATE TABLE IF NOT EXISTS `AchadosEDescontos`.`cupom` (
  `id_Cupom` INT NOT NULL,
  `qtd_Cupom` INT NOT NULL,
  `data_Validade` DATETIME NULL,
  `instituicao_CNPJ` VARCHAR(45) NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  `categoria` VARCHAR(45) NULL,
  PRIMARY KEY (`id_Cupom`),
  INDEX `fk_Cumpom_Instituicao1_idx` (`instituicao_CNPJ` ASC) VISIBLE,
  CONSTRAINT `fk_cumpom_Instituicao1`
    FOREIGN KEY (`instituicao_CNPJ`)
    REFERENCES `AchadosEDescontos`.`instituicao` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into cupom (id_Cupom, qtd_Cupom, data_Validade, instituicao_CNPJ , url, categoria, descricao) Values(6969, 3, "2024-10-08 15:30:00", "69696969", "https://trello.com/b/lCVR1hHo/projeto-buscopom-achados-e-descontos", "Desconto acucarado", "Desconto Vip para Fregueses ");
insert into cupom (id_Cupom, qtd_Cupom, data_Validade, instituicao_CNPJ , url, categoria, descricao) Values(6968, 3, "2024-10-08 15:30:00", "69696969", "https://trello.com/b/lCVR1hHo/projeto-buscopom-achados-e-descontos", "Desconto acucarado", "Ate 85% de decontos para amigos do Nosso querido Matheus");

