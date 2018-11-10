package fr.utbm.fr.gestion.ecole.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.utbm.gestion.ecole.config.CoreConfig;

@Configuration
@Import({CoreConfig.class})
@ComponentScan({"fr.utbm.gestion.ecole.controller"})
public class ApplicationConfig {

}
