package A2Z;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Vector;

public class StoreOwnerController
{
    private StoreOwner so = new StoreOwner() {
        @Override
        public String NumberOfViewsForEachProduct() {
            return null;
        }

        @Override
        public String MostViewiedProductInEachStore() {
            return null;
        }
    } ;

    public StoreOwner getSo() {
        return so;
    }

    public void setSo(StoreOwner so) {
        this.so = so;
    }

    public StoreOwnerController() {
    }


    public Boolean AddStoreCont(String name, String id , String linkoradd , Boolean link , Boolean address) {
        Store store;
        if(link ==  true)
        {
            store = new OnlineStore(name, id , linkoradd);
        }
        else
        {
            store = new OnsiteStore(name , id , linkoradd);
        }
        for (Store s : so.getStores()){
            if(s.getStoreID().equals(id)) return false;
        }
        system.StoreCon.AddStoreToDB(name,id, store.getProducts());
        return so.updateStores(store);
    }

    public Boolean RemoveStoreCont(String name,String id) {
        system.StoreCon.RemoveStoreToDB(name,id);
        for (int i=0;i<so.getStores().size();i++)
        {
            if(so.getStores().get(i).getStoreID().equals(id))
            {
                return so.deleteStore(so.getStores().get(i));
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

    public void NumberOfViewsForEachProduct() //number of views of each model in a store
    {
        System.out.println(so.NumberOfViewsForEachProduct());
    }
    public void MostViewiedProductInEachStore() //	Get the most viewed product in a store
    {
        System.out.println(so.MostViewiedProductInEachStore());
    }

    public Boolean AddStoreOwnerToDBCont(String name, String email,String username,String password,boolean p) {
        if (p) {
            StoreOwner storeOwner = new StoreOwnerRegular(name, email, username, password);
            system.storeOwners.add(storeOwner);
        }
        else{
            StoreOwner storeOwner = new StoreOwnerPremuim(name, email, username, password);
            system.storeOwners.add(storeOwner);
        }
        return true;
    }

    public Boolean RemoveStoreOwnerToDBCont(String username,String email) {
        for (StoreOwner storeOwner : system.storeOwners)
        {
            if(storeOwner.getUsername().equals(username) && storeOwner.getEmail().equals(email))
            {
                system.storeOwners.remove(storeOwner);
                return true;
            }
        }
        return false;
    }

    public Boolean UpdateStoreOwnerNameToDBCont(String name) {

        for (StoreOwner storeOwner : system.storeOwners)
        {
            if(storeOwner.getName().equals(so.getName()))
            {
                storeOwner.setName(name);
                return true;
            }
        }
        return false;
    }

    public Boolean UpdateStoreOwnerPasswordToDBCont(String password) {
        for (StoreOwner storeOwner : system.storeOwners)
        {
            if(storeOwner.getPassword().equals(so.getPassword()))
            {
                storeOwner.setPassword(password);
                return true;
            }
        }
        return false;
    }

}