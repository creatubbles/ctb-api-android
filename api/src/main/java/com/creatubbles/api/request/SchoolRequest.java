package com.creatubbles.api.request;

import com.creatubbles.api.model.school.School;

/**
 * @author Pawel Szymanski
 */
public class SchoolRequest {

    private School school;

    public SchoolRequest(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

}
