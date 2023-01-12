package com.example.googlelogin.constant;

public class CommonConstant {
    public static final String SERVER_UI = "http://localhost:3000";
    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    public static final String JWT_SECRET = "secret";

    //Thời gian có hiệu lực của chuỗi jwt
    public static final long JWT_EXPIRATION = 604800000L;

    public static final String SIX_DIGITS_FORMAT = "%06d";
    /**
     * User id
     */
    public static final String USERID = "userId";
    /**
     * System
     */
    public static final String SYSTEM = "System";

}
