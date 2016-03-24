package com.sjsu.cmpe275.controller;

import com.sjsu.cmpe275.model.Profile;
import com.sjsu.cmpe275.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by chenglongwei on 3/24/16.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Map<String, Object> model) {
        Profile profile = new Profile();
        profile.setFirstname("First");
        profile.setLastname("Test");
        profileRepository.save(profile);

        model.put("title", "list");
        model.put("msg", "list");

        return "index";
    }

}
