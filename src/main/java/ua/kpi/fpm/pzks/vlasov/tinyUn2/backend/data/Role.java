package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data;

public class Role {
    public static final String ADMIN = "admin";
    public static final String STUDENT = "student";
    public static final String TEACHER = "teacher";

    private Role(){

    }

    public static String[] getAllRoles() {
        return new String[] {ADMIN, STUDENT};
    }
}
