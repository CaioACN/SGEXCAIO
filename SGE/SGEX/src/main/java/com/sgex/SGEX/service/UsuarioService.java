package com.sgex.SGEX.service;

import com.sgex.SGEX.domain.Usuario;
import com.sgex.SGEX.repository.UsuarioRepository;
import com.sgex.SGEX.service.dto.UsuarioDTO;
import com.sgex.SGEX.service.error.UsuarioNaoEcontradoException;
import com.sgex.SGEX.service.mapper.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);







}

