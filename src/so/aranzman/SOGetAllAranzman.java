/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.aranzman;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Aranzman;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOGetAllAranzman extends AbstractSO {
    
    private ArrayList<Aranzman> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Aranzman)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Aranzman!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        String upitZaSve = ado.vratiUpitZaSve();
        
        Statement stat = DBBroker.getInstance().getConnection().createStatement();
        ResultSet rs = stat.executeQuery(upitZaSve);
        
        ArrayList<AbstractDomainObject> listaAranzmana = ado.vratiListu(rs);
        lista = (ArrayList<Aranzman>) (ArrayList<?>) listaAranzmana;
    }
    
    public ArrayList<Aranzman> getLista() {
        return lista;
    }
    
}
