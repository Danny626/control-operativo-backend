package com.albo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//INICIO entorno desarrollo
@SpringBootApplication
public class ControlOperativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlOperativoApplication.class, args);
	}

}
//FIN entorno desarrollo


//INICIO despliege
//@SpringBootApplication
//public class ControlOperativoApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ControlOperativoApplication.class, args);
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(ControlOperativoApplication.class);
//	}
//}
//FIN despliege
