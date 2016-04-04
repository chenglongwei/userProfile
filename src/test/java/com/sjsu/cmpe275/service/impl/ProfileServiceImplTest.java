package com.sjsu.cmpe275.service.impl;

import static org.junit.Assert.*;


import com.sjsu.cmpe275.model.Profile;
import com.sjsu.cmpe275.repository.ProfileRepository;
import com.sjsu.cmpe275.service.ProfileService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration(locations = "classpath*:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProfileServiceImplTest {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    ProfileService profileService;

    @Before
    public void setUp() throws Exception {
        for (int i = 1; i <= 20; i++) {
            Profile p = new Profile();
            p.setId("testId" + i);
            p.setFirstname("name" + i);
            profileRepository.save(p);
        }
    }

    @After
    public void tearDown() throws Exception {
        for(int i = 1; i <= 20; i++) {
            profileRepository.delete("testId" + i);
        }
        profileRepository.delete("testId" + 50);
    }

    @Test
    public void testFindById() {
        Profile profile = profileService.findById("testID" + 1);
        assertNotNull(profile);
        assertEquals("name" + 1, profile.getFirstname());
    }

    @Test
    public void testInsert() {
        Profile p = new Profile();
        p.setId("testID" + 50);
        p.setFirstname("name" + 50);
        profileService.insert(p);

        p = profileService.findById("testID" + 50);
        assertNotNull(p);
        assertEquals("name" + 50, p.getFirstname());
    }

    @Test
    public void testUpdate() {
        Profile p = profileService.findById("1");
        p.setFirstname("changeName");
        profileService.update(p);
        p = profileService.findById("1");
        assertEquals("changeName", p.getFirstname());
    }

    @Test
    public void testDeleteById() {
        profileService.deleteById("1");
        Profile p = profileService.findById("1");
        assertNull(p);
    }
}
