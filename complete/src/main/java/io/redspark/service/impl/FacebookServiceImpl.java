package io.redspark.service.impl;

import java.util.List;

import io.redpsark.controller.dto.FacebookLocalDTO;
import io.redspark.domain.FacebookLocal;
import io.redspark.mapper.FacebookMapper;
import io.redspark.repository.FacebookRepository;
import io.redspark.service.FacebookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
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

        PagedList<Post> feed = facebook.feedOperations().getPosts();

        for (Post post : feed) {
            FacebookLocalDTO dto = new FacebookLocalDTO();

            dto.setNome(post.getFrom().getName());
            dto.setMensagem(post.getMessage());
            
            if (post.getTo() != null) {
                dto.setDestinatario(post.getTo().get(0).getName());
            }

            if (post.getPicture() != null) {
                dto.setUrl(post.getPicture());
            }
            
            facebookRepository.save(facebookMapper.toEntity(dto));

        }

        model.addAttribute("feed", feed);
        return "hello";
    }

    @Override
    public String post(Model model, Facebook facebook, ConnectionRepository connectionRepository) {
        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);

        if (connection != null) {

            String accessToken = "EAARlalBh64sBAOFM8mfcu7WZCUZBk8k8fzILisYZBomKoZCG74Px7lVyZA1UQ5TecySq8NXzZC3iYWATj4l21Pcn4Asih6gH9nxT6eoaZCaKrG3NQol6jAiTBqnZCU3eLdDQo61le0WOVxZAdZAesi4zDiZBuNXyMgjgC0yzxEFEjqe8gZDZD";

            Facebook face = new FacebookTemplate(accessToken);

            PagedList<String> friendIds = face.friendOperations().getFriendIds();

            model.addAttribute("friends", friendIds);
            // /return "home";

            // User profile = facebook.userOperations().getUserProfile();

            // FacebookLocalDTO dto = new FacebookLocalDTO();
            // dto.setEmail(userProfile.getEmail());
            // dto.setNome(userProfile.getFirstName());
            // dto.setSobrenome(userProfile.getLastName());
            // dto.setDescricaoPost("Teste");
            // facebookRepository.save(facebookMapper.toEntity(dto));

            // FAZER O POST
            // facebook.feedOperations().updateStatus("Teste");
            // System.out.println("testes");

        }
        return "home";
    }

    @Override
    public List<FacebookLocal> getAll() {
        return facebookRepository.findAll();
    }
}
