package com.sjsu.cmpe275.service;

import com.sjsu.cmpe275.model.Profile;
import org.springframework.data.domain.Page;

/**
 * @author chenglongwei
 * @version 1.0
 * @since 2016-03-24
 * ProfileService interface
 */

public interface ProfileService {
    Profile findById(String id);

    Profile insert(Profile profile);

    Profile update(Profile profile);

    void deleteById(String id);
}
