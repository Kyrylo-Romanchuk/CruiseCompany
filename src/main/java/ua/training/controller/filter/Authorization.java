package ua.training.controller.filter;

import ua.training.model.User;

import java.util.*;
import java.util.regex.Pattern;

public class Authorization {

    private HashMap<Pattern, Set<User.Role>> authorization;

    private static Authorization instances;

    private Authorization(){
        Set<User.Role> all = new HashSet<>(
                Arrays.asList(User.Role.GUEST, User.Role.USER, User.Role.ADMIN)
        );
        Set<User.Role> authorized = new HashSet<>(
                Arrays.asList(User.Role.USER, User.Role.ADMIN)
        );
        Set<User.Role> unauthorized = new HashSet<>(
                Collections.singletonList(User.Role.GUEST)
        );
        Set<User.Role> admin = new HashSet<>(
                Collections.singletonList(User.Role.ADMIN)
        );
        authorization = new HashMap<>();
        /*-------UNAUTHORIZED-------*/
        authorization.put(Pattern.compile("/cruiseCompany/login"), unauthorized);
        authorization.put(Pattern.compile("/cruiseCompany/registration"), unauthorized);
        authorization.put(Pattern.compile("/cruiseCompany/signin"), unauthorized);
        authorization.put(Pattern.compile("/cruiseCompany/signup"), unauthorized);
        /*-------ALL------*/
        authorization.put(Pattern.compile("/cruiseCompany/main"), all);
        authorization.put(Pattern.compile("/cruiseCompany"), all);
        authorization.put(Pattern.compile("/cruiseCompany/aboutus"), all);
        authorization.put(Pattern.compile("/cruiseCompany/contact"), all);
        authorization.put(Pattern.compile("/cruiseCompany/cruise/\\d{1,9}"),all);
        authorization.put(Pattern.compile("/cruiseCompany/cruise"), all);
        authorization.put(Pattern.compile("/"), all);
       /* -------ADMIN-------*/
        authorization.put(Pattern.compile("/cruiseCompany/country"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/countryadd/\\d{1,9}"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/countryadd"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/countryadded"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/countryedit/\\d{1,9}"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/countryedit"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/countrydelete/\\d{1,9}"),admin);
        authorization.put(Pattern.compile("/cruiseCompany/countrydelete"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/countryupdate"),admin);
        authorization.put(Pattern.compile("/cruiseCompany/ship"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/shipadd"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/shipadd/\\d{1,9}"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/shipedit"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/shipedit/\\d{1,9}"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/shipdelete"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/shipdelete/\\d{1,9}"), admin);
        authorization.put(Pattern.compile("/cruiseCompany/orderall"),admin);
        /*-------AUTHORIZED-------*/
        authorization.put(Pattern.compile("/cruiseCompany/excursionlist"), authorized);
        authorization.put(Pattern.compile("/cruiseCompany/logout"), authorized);
        authorization.put(Pattern.compile("/cruiseCompany/profile"), authorized);
        authorization.put(Pattern.compile("/cruiseCompany/cruise_card"), authorized);
        authorization.put(Pattern.compile("/cruiseCompany/cart"), authorized);
        authorization.put(Pattern.compile("/cruiseCompany/pay"), authorized);


    }

    public static Authorization getInstances(){
        if (instances == null) {
            synchronized (Authorization.class) {
                if (instances == null) {
                    instances = new Authorization();
                }
            }
        }
        return instances;
    }

    public HashMap<Pattern, Set<User.Role>> getAuthorization() {
        return authorization;
    }
}
