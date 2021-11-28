package com.albo.controlop.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.Usuario;
import com.albo.controlop.repository.ILoginRepository;


@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

//	@Autowired
//	private IUsuarioDAO userDAO;
	
	@Autowired
	private ILoginRepository loginDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario user = userDAO.findOneByUsername(username);
		Usuario user = loginDao.verificarNombreUsuario(username, "ACT");

		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRol().getNombre()));
//		user.getRoles().forEach(role -> {
//			authorities.add(new SimpleGrantedAuthority(role.getNombre()));
//		});

		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), authorities);

		return userDetails;
	}

}