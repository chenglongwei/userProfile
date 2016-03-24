package com.sjsu.cmpe275.repository;

import com.sjsu.cmpe275.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chenglongwei on 3/24/16.
 */
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Page<Profile> findAll(Pageable pageable);
}
