package A2Z;

import A2Z.StoreOwner;

/**
 * 
 */
public class StoreOwnerController {
    private StoreOwner so;

    public StoreOwnerController() {
    }

    public Boolean AddStoreCont(String id,String name) {
        Store store = new Store(name,id);
        so.getStores().add(store);
        system.sc.AddStoreToDB(name,id);
        return true;
    }

    public Boolean RemoveStoreCont(String id,String name) {
        system.sc.RemoveStoreToDB(name,id);
        for (Store store : so.getStores())
        {
            if(store.getStoreID() == id && store.getName() == name)
            {
                so.getStores().remove(store);
                return true;
            }
        }
        return false;
    }

    public void SuggestModelCont(String name,String id,Brand b) {
         Model model = new Model(id,name,b);
         system.suggestModels.add(model);
    }
    public void SuggestBrandCont(String id,String name) {
         Brand brand = new Brand(name,id);
         system.suggestBrands.add(brand);
    }

    public String ViewStatCont() {

        return "";
    }

    /**
     * @return
     */
    public Boolean AddStoreOwnerToDBCont(String name,String id ,String email,String password) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean RemoveStoreOwnerToDBCont(String name,String id,String email,String password) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean UpdateStoreOwnerNameToDBCont(String name) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean VerifyCont(String Address) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean UpdateStoreOwnerPasswordToDBCont(String password) {
        // TODO implement here
        return null;
    }

}