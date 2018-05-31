package com.chmmaestro.maisvidabackend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.chmmaestro.maisvidabackend.domain.Cidade;
import com.chmmaestro.maisvidabackend.domain.Especialidade;
import com.chmmaestro.maisvidabackend.domain.Estado;
import com.chmmaestro.maisvidabackend.domain.Medico;
import com.chmmaestro.maisvidabackend.domain.Status;
import com.chmmaestro.maisvidabackend.domain.User;
import com.chmmaestro.maisvidabackend.domain.enums.Perfil;
import com.chmmaestro.maisvidabackend.repository.CidadeRepository;
import com.chmmaestro.maisvidabackend.repository.EspecialidadeRepository;
import com.chmmaestro.maisvidabackend.repository.EstadoRepository;
import com.chmmaestro.maisvidabackend.repository.MedicoRepository;
import com.chmmaestro.maisvidabackend.repository.StatusRepository;
import com.chmmaestro.maisvidabackend.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired BCryptPasswordEncoder bcrypt;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		statusRepository.deleteAll();
		estadoRepository.deleteAll();
		cidadeRepository.deleteAll();
		especialidadeRepository.deleteAll();
		medicoRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com", bcrypt.encode("123456"), true);
		maria.addPerfil(Perfil.ADMIN);
		User alex = new User(null, "Alex Green", "alex@gmail.com", bcrypt.encode("654321"), true);
		User bob = new User(null, "Bob Grey", "bob@gmail.com", bcrypt.encode("0246810"), true);
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Status st1 = new Status(null, "Ocupado");
		Status st2 = new Status(null, "Disponível");
		statusRepository.saveAll(Arrays.asList(st1, st2));

		Estado df = new Estado(null, "Distrito Federal", "DF");
		Estado go = new Estado(null, "Goiás", "GO");
		Estado sp = new Estado(null, "São Paulo", "SP");
		estadoRepository.saveAll(Arrays.asList(df, go, sp));

		Cidade bsb = new Cidade(null, "Brasília", df);
		Cidade cd1 = new Cidade(null, "Campinas", sp);
		Cidade cd2 = new Cidade(null, "São Paulo", sp);
		Cidade cd3 = new Cidade(null, "Pirenópolis", go);
		Cidade cd4 = new Cidade(null, "Jaraguá", go);
		cidadeRepository.saveAll(Arrays.asList(bsb, cd1, cd2, cd3, cd4));

		Especialidade esp1 = new Especialidade(null, "Cardiologista");
		Especialidade esp2 = new Especialidade(null, "Pediatra");
		Especialidade esp3 = new Especialidade(null, "Obstetra");
		especialidadeRepository.saveAll(Arrays.asList(esp1, esp2, esp3));

		Medico mde1 = new Medico(null, "José", "Carlos", true, esp1, st1, cd1, "jose.carlos@gmail.com");
		Medico mde2 = new Medico(null, "Luiz", "Alencar", true, esp2, st2, cd4, "luiz.alencar@gmail.com");
		Medico mde3 = new Medico(null, "Thiago", "Costa", true, esp3, st1, cd2, "thiago.costa@gmail.com");
		medicoRepository.saveAll(Arrays.asList(mde1, mde2, mde3));
	}

}
