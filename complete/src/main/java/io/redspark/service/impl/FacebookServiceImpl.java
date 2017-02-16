package io.redspark.service.impl;

import io.redpsark.controller.dto.FacebookLocalDTO;
import io.redspark.mapper.FacebookMapper;
import io.redspark.repository.FacebookRepository;
import io.redspark.service.FacebookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FacebookServiceImpl implements FacebookService {

    @Autowired
    private FacebookRepository facebookRepository;

    @Autowired
    private FacebookMapper facebookMapper;

    @Override
    public String getFeed(Model model, Facebook facebook, ConnectionRepository connectionRepository) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        String[] fields = { "id", "email", "first_name", "last_name" };

        model.addAttribute("facebookProfile", facebook.fetchObject("me", User.class, fields));
        PagedList<Post> feed = facebook.feedOperations().getFeed();

        model.addAttribute("feed", feed);
        return "hello";
    }

    @Override
    public void post(Model model, Facebook facebook, ConnectionRepository connectionRepository) {
        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);

        if (connection != null) {
            Facebook api = connection.getApi();

            User profile = facebook.userOperations().getUserProfile();


//            FacebookLocalDTO dto = new FacebookLocalDTO();
//            dto.setEmail(userProfile.getEmail());
//            dto.setNome(userProfile.getFirstName());
//            dto.setSobrenome(userProfile.getLastName());
//            dto.setDescricaoPost("Teste");
//            facebookRepository.save(facebookMapper.toEntity(dto));

            // FAZER O POST
            api.feedOperations().updateStatus("Teste");
            System.out.println("testes");

        }
    }
}
