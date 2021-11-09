package com.example.springcoredojo;

import com.example.springcoredojo.Usuario.Config;
import com.example.springcoredojo.Usuario.Usuario;
import com.example.springcoredojo.Youtube.Youtuber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreDojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDojoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			creacionBean();
			creacionBeanXmlYoutuber();
			creacionBeanXmlUsuario();
		};
	}

	private void creacionBean(){
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Usuario usuarioGeneradoPorBean = context.getBean("usuario",Usuario.class);
		System.out.println("Usuario: "+usuarioGeneradoPorBean);
	}

	public void creacionBeanXmlYoutuber(){
		ApplicationContext context = new ClassPathXmlApplicationContext("user-bean-config.xml");
		Youtuber youtuberGeneradoPorBean = context.getBean(Youtuber.class);
		System.out.println("Youtuber: "+youtuberGeneradoPorBean.getNombre());
	}

	public void creacionBeanXmlUsuario(){
		ApplicationContext context = new ClassPathXmlApplicationContext("user-bean-config.xml");
		Usuario usuarioGeneradoPorBean = context.getBean(Usuario.class);
		System.out.println("Nombre: "+usuarioGeneradoPorBean.getAlumno().getNombre());
		System.out.println("Apellido: "+usuarioGeneradoPorBean.getAlumno().getApellido());
		System.out.println("Edad: "+usuarioGeneradoPorBean.getAlumno().getEdad());
	}
}
