package fr.utbm.gestion.ecole.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"fr.utbm.gestion.ecole.service", "fr.utbm.gestion.ecole.service.impl"})
@ComponentScan({"fr.utbm.gestion.ecole.service","fr.utbm.gestion.ecoleservice.impl","fr.utbm.gestion.ecole.repository"})
public class CoreConfig {

}
