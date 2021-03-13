package Game.Maps;

import Game.RefLinks;

/*!
    \class FactoryMakerMap
    \brief Prin optiunea data va returna harta dorita prin getMap
 */
public class FactoryMakerMap {
    public static int index_map = 0;
    private static Map pfactory = null; ///< referinta pentru Map
    /*!
        \fn  public static Map getMap(String opt, RefLinks refLinks)
        \brief returneaza harta dorita prin variabila opt
        \refLinks - referinta la RefLinks
        \opt - optiunea pentru harta
     */
    public static Map getMap(String opt, RefLinks refLinks){
        if(opt.equals("0"))
            pfactory = new Map_menu(refLinks);
        if(opt.equals("1"))
            pfactory = new Map1(refLinks);
        if(opt.equals("2"))
            pfactory = new Map2(refLinks);
        if(opt.equals("3"))
            pfactory = new Map3(refLinks);
        if(opt.equals("4"))
            pfactory = new Map4(refLinks);
        if(opt.equals("5"))
            pfactory = new Map5(refLinks);
        if(opt.equals("6"))
            pfactory = new Map6(refLinks);
        if(opt.equals("7"))
            pfactory = new Map7(refLinks);
        if(opt.equals("8"))
            pfactory = new Map_Dead(refLinks);
        if(opt.equals("9"))
            pfactory = new Map_help(refLinks);
        return pfactory;
    }
}
