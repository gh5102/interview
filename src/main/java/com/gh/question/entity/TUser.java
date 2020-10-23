package com.gh.question.entity;

import java.time.LocalDateTime;
import com.gh.question.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gh
 * @since 2020-10-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TUser extends Model {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userName;

    private String password;

    private String salt;

    private LocalDateTime lastLoginTime;

    private Integer loginTimes;


}
