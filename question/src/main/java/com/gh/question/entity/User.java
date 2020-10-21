package com.gh.question.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guohao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String id;
    private String userName;
    private String password;
    private String salt;
    private Date lastLoginTime;
    private int loginTimes;
}
