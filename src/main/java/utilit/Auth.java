package utilit;


public class Auth {

    public static String name;
    private String passWord ;
    
//    private

    public static void clear() {
        Auth.name = "";
    }

    public static boolean isLogin() {
        
        return Auth.name != null;
    }

//    public static boolean isManager() {
//        return Auth.isLogin() && user.;
//    }
}
