package com.sjsu.cmpe275.service;

import com.sjsu.cmpe275.model.Profile;
import com.sjsu.cmpe275.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenglongwei on 3/24/16.
 */

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Profile> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(
                Sort.Direction.DESC, "id"));
        Page<Profile> profiles = repository.findAll(pageable);
        return profiles;
    }

    @Override
    @Transactional(readOnly = true)
    public Profile findById(long id) {
        Profile profile = repository.findOne(id);
        return profile;
    }

    @Override
    @Transactional
    public Profile insert(Profile profile) {
        return repository.save(profile);
    }

    @Override
    @Transactional
    public Profile update(Profile profile) {
        return repository.save(profile);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        repository.delete(id);
    }
}
