package fr.dawid.cap_poec_java.mapping;

public class UrlRoute {

    public final static String URL_LOGIN = "/login";
    public final static String URL_LOGOUT = "/logout";
    public final static String URL_REGISTER = "/s-inscrire";
    public final static String URL_EXPORT= "/telecharger-export-excel";

    public final static String URL_GAMES = "/jeux";
    public final static String URL_GAME_NEW = "/admin"+ URL_GAMES + "/nouveau";
    public final static String URL_GAMES_SHOW = URL_GAMES + "/{slug}";

    public final static String URL_REVIEWS = "/avis";
    public final static String URL_REVIEW_MODERATE = URL_REVIEWS + "/{id}/{moderate}";



}
