CREATE TABLE IF NOT EXISTS `ada_test_db`.`version` (
  `version_id` INT NOT NULL,
  `version` VARCHAR(45) NULL,
  `version_description` VARCHAR(45) NULL,
  PRIMARY KEY (`version_id`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `ada_test_db`.`application` (
  `app_id` INT NOT NULL,
  `app_code` VARCHAR(45) NULL,
  `app_name` VARCHAR(45) NULL,
  `app_description` VARCHAR(45) NULL,
  `version_id` INT NOT NULL,
  PRIMARY KEY (`app_id`),
  UNIQUE INDEX `app_code_UNIQUE` (`app_code` ASC) VISIBLE,
  INDEX `fk_application_version_idx` (`version_id` ASC) VISIBLE,
  CONSTRAINT `fk_application_version`
    FOREIGN KEY (`version_id`)
    REFERENCES `ada_test_db`.`version` (`version_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB


CREATE TABLE IF NOT EXISTS `ada_test_db`.`company` (
  `id_company` INT NOT NULL,
  `codigo_company` VARCHAR(45) NULL,
  `name_company` VARCHAR(45) NULL,
  `description_company` VARCHAR(45) NULL,
  `app_id` INT NOT NULL,
  PRIMARY KEY (`id_company`),
  UNIQUE INDEX `codigo_company_UNIQUE` (`codigo_company` ASC) VISIBLE,
  INDEX `fk_company_application1_idx` (`app_id` ASC) VISIBLE,
  CONSTRAINT `fk_company_application1`
    FOREIGN KEY (`app_id`)
    REFERENCES `ada_test_db`.`application` (`app_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `ada_test_db`.`version_company` (
  `version_company_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `version_id` INT NOT NULL,
  `version_company_description` VARCHAR(45) NULL,
  PRIMARY KEY (`version_company_id`),
  INDEX `fk_version_company_company1_idx` (`company_id` ASC) VISIBLE,
  INDEX `fk_version_company_version1_idx` (`version_id` ASC) VISIBLE,
  CONSTRAINT `fk_version_company_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `ada_test_db`.`company` (`id_company`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_version_company_version1`
    FOREIGN KEY (`version_id`)
    REFERENCES `ada_test_db`.`version` (`version_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `ada_test_db`.`TMP_LLENAR_CAMPOS` (
  `id_company` INT NULL,
  `codigo_company` VARCHAR(45) NULL,
  `name_company` VARCHAR(45) NULL,
  `description_company` VARCHAR(45) NULL,
  `version_id` INT NULL,
  `app_id` INT NULL,
  `version` VARCHAR(45) NULL,
  `version_description` VARCHAR(45) NULL,
  `version_company_id` INT NULL,
  `company_id` INT NULL,
  `version_company_description` VARCHAR(45) NULL,
  `app_code` VARCHAR(45) NULL,
  `app_name` VARCHAR(45) NULL,
  `app_description` VARCHAR(45) NULL)
ENGINE = InnoDB

INSERT INTO `ada_test_db`.`tmp_llenar_campos`
(`id_company`,
`codigo_company`,
`name_company`,
`description_company`,
`version_id`,
`app_id`,
`version`,
`version_description`,
`version_company_id`,
`company_id`,
`version_company_description`,
`app_code`,
`app_name`,
`app_description`)
VALUES
(1,
"ABD",
"PLS",
"A juice company",
1,
1,
"2.0",
"The second version",
1,
1,
"A version company desc",
"ALD1",
"Send email grant",
"APp for sending a lot");

DELIMITER $$
CREATE PROCEDURE ada_test_db.insert_info()
BEGIN

	DECLARE id_company int DEFAULT null;
    DECLARE codigo_company VARCHAR(45) DEFAULT "";
    DECLARE name_company VARCHAR(45) DEFAULT "";
    DECLARE description_company VARCHAR(45) DEFAULT "";
    DECLARE version_id int DEFAULT null;
    DECLARE app_id int DEFAULT null;
    DECLARE version VARCHAR(45) DEFAULT "";
    DECLARE version_description VARCHAR(45) DEFAULT "";
    DECLARE version_company_id int DEFAULT null;
    DECLARE company_id int DEFAULT null;
    DECLARE version_company_description VARCHAR(45) DEFAULT "";
    DECLARE app_code VARCHAR(45) DEFAULT "";
    DECLARE app_name VARCHAR(45) DEFAULT "";
    DECLARE app_description VARCHAR(45) DEFAULT "";
    
	DECLARE done BOOL DEFAULT false;
	
	-- declare cursor for employee email
	DECLARE cur_tmp_llenar_campos 
		CURSOR FOR SELECT * FROM ada_test_db.TMP_LLENAR_CAMPOS;
    
    -- declare NOT FOUND handler
	DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET done = true;
    
    OPEN cur_tmp_llenar_campos;
    
		insert_data: LOOP
    
			FETCH cur_tmp_llenar_campos INTO id_company, codigo_company, name_company,
				description_company, version_id, app_id, version, version_description,
				version_company_id, company_id, version_company_description, app_code, app_name,
				app_description;
				
        IF done = true THEN 
					LEAVE insert_data;
				END IF;
                
				select concat('entro ', version_id, ' ', version, ' ', version_description);
				INSERT INTO ada_test_db.version 
					VALUES (version_id, version, version_description);
				select concat('salio ', version_id, ' ', version, ' ', version_description);
				
                INSERT INTO ada_test_db.application 
					VALUES (app_id, app_code, app_name, app_description, version_id);
                
                INSERT INTO ada_test_db.company 
					VALUES (id_company, codigo_company, name_company, description_company, app_id);
                    
				INSERT INTO ada_test_db.version_company 
					VALUES (version_company_id, company_id, version_id, version_company_description);
		END LOOP;
        
	CLOSE cur_tmp_llenar_campos;
    
END$$
DELIMITER ;

CALL ada_test_db.insert_info();
