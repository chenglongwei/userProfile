package com.sjsu.cmpe275.repository;

import com.sjsu.cmpe275.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author chenglongwei
 * @version 1.0
 * @since 2016-03-24
 * <p>
 * ProfileRepository will deal with database data C.R.U.D.
 */
public interface ProfileRepository extends CrudRepository<Profile, String> {
}
