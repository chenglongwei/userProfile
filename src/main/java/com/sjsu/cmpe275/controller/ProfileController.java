package com.sjsu.cmpe275.controller;

import com.sjsu.cmpe275.exception.ProfileException;
import com.sjsu.cmpe275.model.Profile;
import com.sjsu.cmpe275.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenglongwei
 * @version 1.2
 * @since 2016-03-24
 * Profile Controller, support C.R.U.D. of user Profile.
 */

@Controller
public class ProfileController {
    /**
     * Auto wire a profile service, @see com.sjsu.cmpe275.service.ProfileService.
     * The service has transaction to deal with database read/write/delete/update.
     */
    @Autowired
    ProfileService service;

    /**
     * The index page will display the profile creation page.
     * @return creation profile page.
     */
    @RequestMapping(value = "/")
    public String index() {
        return "profile/create_bak";
    }

    /**
     * Get a profile as HTML or Get a profile as plain text.
     * <p>
     * If the brief paras if not set this returns an HTML that renders the given user’s profile.
     * The profile fields are part of an HTML form.
     * If the brief param is true this returns an HTML that encapsulates the given
     * user’s full profile in plain text format with the HTML <pre> tag.
     * If the profile of the given user ID does not exist, a customized 404 HTML page
     * with the message “Sorry, the requested user with ID XXX does not exist.”
     * </p>
     * @param id profile id
     * @param brief whether get a profile as plain text.
     * @param model contains profile data to be displayed.
     * @return a string indicates profile display page.
     * @throws ProfileException, which will display the profile id not exist.
     */
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") String id,
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


    /**
     * Get the profile creation HTML.
     * <p>
     * This method should support DELETE method, since the @see ProfileController.delete
     * will redirect here which bring DELETE method.
     * </p>
     *
     * @return a string indicates the profile creation page.
     */
    @RequestMapping(value = "/profile", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String create() {
        return "profile/create_bak";
    }

    /**
     * Create or Update a user profile.
     * <p>
     * This request creates or update the profile for the given user ID.
     * For simplicity, all the profile fields other than the ID (firstname,
     * lastname, email, address, organization, and aboutMyself) are passed
     * as query parameters,
     * If the profile already exists in database, update it; otherwise,
     * create a new item and save in database.
     * </p>
     *
     * @param id           @see profile id.
     * @param firstname    profile firstname.
     * @param lastname     profile lastname.
     * @param email        profile email.
     * @param address      profile address.
     * @param organization profile organization.
     * @param aboutMyself  profile aboutMyself.
     * @return a string which makes the framework redirect to the newly created/updated
     * profile in HTML.
     */
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    public String create(
            @PathVariable("id") String id,
            @RequestParam(value = "firstname", required = false, defaultValue = "") String firstname,
            @RequestParam(value = "lastname", required = false, defaultValue = "") String lastname,
            @RequestParam(value = "email", required = false, defaultValue = "") String email,
            @RequestParam(value = "address", required = false, defaultValue = "") String address,
            @RequestParam(value = "organization", required = false, defaultValue = "") String organization,
            @RequestParam(value = "aboutMyself", required = false, defaultValue = "") String aboutMyself) {

        /**
         * Create profile by the params.
         */
        Profile profile = new Profile();
        profile.setId(id);
        profile.setFirstname(firstname);
        profile.setLastname(lastname);
        profile.setEmail(email);
        profile.setAddress(address);
        profile.setOrganization(organization);
        profile.setAboutMyself(aboutMyself);

        /**
         * Insert or update profile.
         */
        if (service.findById(id) == null) {
            service.insert(profile);
        } else {
            service.update(profile);
        }

        /**
         * Redirect to newly update or create profile.
         */
        return "redirect:/profile/" + profile.getId();
    }

    /**
     * Delete the profile for the given user ID.
     * <p>
     * If the profile does not exist, it returns profile not exist page.
     * Otherwise, delete the corresponding profile, and redirect
     * the request to the profile creation page.
     * </p>
     *
     * @param id profile id
     * @return a string which makes the framework redirect to the profile creation page.
     * @throws ProfileException, which will display the profile id not exist.
     */
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id) {

        /**
         * If the profile does not exist, throw ProfileException.
         */
        if (service.findById(id) == null) {
            String message = "Sorry, the requested user with ID " + id + " does not exist.";
            throw new ProfileException(message);
        }

        /**
         * Delete the profile.
         */
        service.deleteById(id);

        /**
         * Redirect to profile creation page.
         */
        return "redirect:/profile";
    }
}
