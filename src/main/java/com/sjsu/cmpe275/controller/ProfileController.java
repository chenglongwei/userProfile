package com.sjsu.cmpe275.controller;

import com.sjsu.cmpe275.exception.ProfileException;
import com.sjsu.cmpe275.model.Profile;
import com.sjsu.cmpe275.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by chenglongwei on 3/24/16.
 */

@Controller
public class ProfileController {
    @Autowired
    ProfileService service;
    private static final int DEFAULT_PAGE_NUM = 0;
    private static final int DEFAULT_PAGE_SIZE = 15;

    @RequestMapping(value = "/profile/list")
    public String list(@RequestParam(value = "page", required = false) Integer page,
                       Model model) {
        int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
        Page<Profile> paging = service.findAll(pageNum, DEFAULT_PAGE_SIZE);
        model.addAttribute("page", paging);
        return "profile/list";
    }

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
    public String create() {
        return "profile/create";
    }

    // Insert or update user profile.
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    public String create(@PathVariable("id") long id,
                         @RequestParam(value = "firstname") String firstname,
                         @RequestParam(value = "lastname") String lastname,
                         @RequestParam(value = "address") String address,
                         @RequestParam(value = "organization") String organization,
                         @RequestParam(value = "aboutmyself") String aboutmyself,
                         BindingResult bindingResult,
                         Model model) {
        // Check params.
        if (bindingResult.hasErrors()) {
            model.addAllAttributes(bindingResult.getModel());
            String message = "Create or update user with ID " + id + " Error.";
            throw new ProfileException(message);
        }

        Profile profile = new Profile();
        profile.setId(id);
        profile.setFirstname(firstname);
        profile.setLastname(lastname);
        profile.setAddress(address);
        profile.setOrganization(organization);
        profile.setAboutMyself(aboutmyself);

        // Insert or update profile.
        if (service.findById(profile.getId()) == null) {
            service.insert(profile);
        } else {
            service.update(profile);
        }

        return "redirect:/profile/" + id;
    }

    // Delete a profile.
    // Todo Delete method
    @RequestMapping(value = "/profile/delete/{userID}", method = RequestMethod.GET)
    public String delete(
            @RequestParam(value = "page", required = false) Integer page,
            @PathVariable("userID") long id) {

        service.deleteById(id);

        return "redirect:/profile";
    }
}
