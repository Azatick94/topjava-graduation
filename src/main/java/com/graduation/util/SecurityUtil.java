package com.graduation.util;

import com.graduation.AuthUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static Integer getAuthUserId() {
        // https://stackoverflow.com/questions/31159075/how-to-find-out-the-currently-logged-in-user-in-spring-boot
        // https://stackoverflow.com/questions/22678891/how-to-get-user-id-from-customuser-on-spring-security
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authUser.getUser().getId();
    }
}
