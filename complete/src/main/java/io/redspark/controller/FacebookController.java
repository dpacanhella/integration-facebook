package io.redspark.controller;

import java.util.List;

import io.redspark.domain.FacebookLocal;
import io.redspark.mapper.FacebookMapper;
import io.redspark.service.FacebookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(basePath = "/facebook", value = "facebook", description = "FacebookController", produces = "application/json")
@RequestMapping("/facebook")
public class FacebookController {
    
    @Autowired
    private FacebookService facebookService;

    @Autowired
    private FacebookMapper facebookMapper;

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    @RequestMapping(method = RequestMethod.GET, value="/feed")
    @ApiOperation(value = "Get", notes = "Recupera feed do usuario logado", response = String.class)
    @ApiResponses(value = { @ApiResponse(code = 401, message = "Not Unauthorized"), @ApiResponse(code = 200, message = "OK") })
    public String getFeed(Model model) {
        return facebookService.getFeed(model, facebook, connectionRepository);
    }
    
    @GetMapping
    @RequestMapping(method = RequestMethod.POST, value="/post")
    @ApiOperation(value = "Post", notes = "Posta e salva alguns dados", response = String.class)
    @ApiResponses(value = { @ApiResponse(code = 401, message = "Not Unauthorized"), @ApiResponse(code = 200, message = "OK") })
    public String post(Model model) {
        return facebookService.post(model, facebook, connectionRepository);
    }
    
    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET, value = "/todos")
    @ApiOperation(value = "Get", notes = "Recupera dados de todos os usuário inseridos", response = FacebookLocal.class)
    @ApiResponses(value = { @ApiResponse(code = 401, message = "Not Unauthorized"), @ApiResponse(code = 200, message = "OK") })
    public List<FacebookLocal> get() {
        return facebookService.getAll();
    }

}
