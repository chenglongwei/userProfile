package com.sjsu.cmpe275.service;

import com.sjsu.cmpe275.model.Profile;
import org.springframework.data.domain.Page;

/**
 * Created by chenglongwei on 3/24/16.
 */

public interface ProfileService {
    Page<Profile> findAll(int page, int size);

    Profile findById(long id);

    Profile insert(Profile profile);

    Profile update(Profile profile);

    void deleteById(long id);
}
