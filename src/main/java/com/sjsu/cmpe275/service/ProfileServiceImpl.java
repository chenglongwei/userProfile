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
 * @author chenglongwei
 * @version 1.0
 * @since 2016-03-24
 * Implements ProfileService interface.
 */

@Service
public class ProfileServiceImpl implements ProfileService {
    /**
     * Auto wire a profile repository, @see com.sjsu.cmpe275.repository.ProfileRepository.
     * The repository deal with database read/write/delete/update.
     */
    @Autowired
    ProfileRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Profile findById(String id) {
        return repository.findOne(id);
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
    public void deleteById(String id) {
        repository.delete(id);
    }
}
