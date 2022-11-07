package com.example.demo;

import java.io.Serializable;

public final class TABLES implements Serializable {
    // Prefix
    public static final String PREFIX = "demo_";

    public static final class USER implements Serializable {
        public static final String TABLE_NAME = PREFIX + "user";
    }

    public static final class ROLE implements Serializable {
        public static final String TABLE_NAME = PREFIX + "role";
    }

    public static final class USER_ROLE implements Serializable {
        public static final String TABLE_NAME = PREFIX + "user_role";
    }
}
