/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.hotel;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Hotel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOGetAllHotel extends AbstractSO {
    
    private ArrayList<Hotel> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Hotel)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Hotel!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        String upitZaSve = ado.vratiUpitZaSve();
        
        Statement stat = DBBroker.getInstance().getConnection().createStatement();
        ResultSet rs = stat.executeQuery(upitZaSve);
        
        ArrayList<AbstractDomainObject> listaHotela = ado.vratiListu(rs);
        lista = (ArrayList<Hotel>) (ArrayList<?>) listaHotela;
    }
    
    public ArrayList<Hotel> getLista() {
        return lista;
    }
    
}
