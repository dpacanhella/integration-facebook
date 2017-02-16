package io.redspark.service;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.ui.Model;

public interface FacebookService {

    String getFeed(Model model, Facebook facebook, ConnectionRepository connectionRepository);

    void post(Model model, Facebook facebook, ConnectionRepository connectionRepository);

}
