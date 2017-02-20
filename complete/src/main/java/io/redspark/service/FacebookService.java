package io.redspark.service;

import io.redpsark.controller.dto.FacebookLocalDTO;
import io.redspark.domain.FacebookLocal;

import java.util.List;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.ui.Model;

public interface FacebookService {

    String getFeed(Model model, Facebook facebook, ConnectionRepository connectionRepository);

    String post(Model model, Facebook facebook, ConnectionRepository connectionRepository);

    List<FacebookLocal> getAll();

}
