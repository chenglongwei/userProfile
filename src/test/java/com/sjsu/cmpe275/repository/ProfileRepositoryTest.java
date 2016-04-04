package com.sjsu.cmpe275.repository;

import static org.junit.Assert.*;

import com.sjsu.cmpe275.model.Profile;
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
public class ProfileRepositoryTest {
    @Autowired
    ProfileRepository profileRepository;

    @Before
    public void setUp() {
        for (int i = 1; i <= 20; i++) {
            Profile p = new Profile();
            p.setId("testId" + i);
            p.setFirstname("name" + i);
            profileRepository.save(p);
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 1; i <= 20; i++) {
            profileRepository.delete("testId" + i);
        }
    }

    @Test
    public void testCount() {
        assertEquals(20, profileRepository.count());
    }

}
