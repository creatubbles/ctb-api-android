package com.creatubbles.api.model.comment;

import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * @author Pawel Szymanski
 */
@Type("comments")
public class Comment {
    @Id
    private String id;
}
