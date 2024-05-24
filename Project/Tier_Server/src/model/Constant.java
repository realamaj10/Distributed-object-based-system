package model;

/**
 * Database & RMI Connection Properties.
 */
public final class Constant {

    private static final String COLON = ":";

    /**
     * RMI Type
     */
    public static final String RMI = "rmi://";

    /**
     * RMI Name
     */
    public static final String RMI_NAME = "/remote_electronic_shop";

    /**
     * RMI IP
     */
    public static final String RMI_IP = "127.0.0.1" + COLON;

    /**
     * RMI Port
     */
    public static final Integer RMI_PORT = 30;

    /**
     * Database Credentials Username
     */
    public static final String USERNAME = "root"; //Username of MySQL 

    /**
     * Database Credentials Password
     */
    public static final String PASSWORD = ""; //Password of MySQL

    /**
     * Database Host or Ip
     */
    public static final String HOST = "localhost" + COLON;

    /**
     * Database Port
     */
    public static final String PORT = "3306"; //Default Port of MySQL

    /**
     * Database Name
     */
    public static final String DB_NAME = "electronic_shop";

}
