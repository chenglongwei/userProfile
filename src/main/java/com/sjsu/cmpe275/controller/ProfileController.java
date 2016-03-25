package com.sjsu.cmpe275.controller;

import com.sjsu.cmpe275.exception.ProfileException;
import com.sjsu.cmpe275.model.Profile;
import com.sjsu.cmpe275.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenglongwei on 3/24/16.
 */

@Controller
public class ProfileController {
    @Autowired
    ProfileService service;

    // Update or Delete one user profile.
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id,
                       @RequestParam(value = "brief", required = false, defaultValue = "false") String brief,
                       Model model) {
        // Get the profile.
        Profile profile = service.findById(id);

        // If null, no user profile exists.
        if (profile == null) {
            String message = "Sorry, the requested user with ID " + id + " does not exist.";
            throw new ProfileException(message);
        }

        // Whether readonly or editable.
        model.addAttribute(profile);
        if ("true".equals(brief)) {
            return "profile/read";
        }
        return "profile/edit";
    }

    // Create user profile.
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("profile", new Profile());
        return "profile/create";
    }

    // Insert or update user profile.
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    public String create(
            @PathVariable("id") long id,
            @ModelAttribute("profile") Profile profile) {

        // Insert or update profile.
        if (service.findById(profile.getId()) == null) {
            service.insert(profile);
        } else {
            service.update(profile);
        }

        return "redirect:/profile/" + profile.getId();
    }

    // Delete a profile.
    // Todo Delete method
    @RequestMapping(value = "/profile/delete/{userID}", method = RequestMethod.GET)
    public String delete(
            @RequestParam(value = "page", required = false) Integer page,
            @PathVariable("userID") long id) {

        if (service.findById(id) == null) {
            String message = "Sorry, the requested user with ID " + id + " does not exist.";
            throw new ProfileException(message);
        }

        service.deleteById(id);

        return "redirect:/profile";
    }
}
