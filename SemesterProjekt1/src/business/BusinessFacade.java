/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.IBusiness;
import acquaintance.IData;

/**
 *
 * @author Nikolaj Frank-Jensen
 */
public class BusinessFacade implements IBusiness{
    private IData data;
    
    @Override
    public void injectData(IData dataLayer) {
        data = dataLayer;
    }
    
}
