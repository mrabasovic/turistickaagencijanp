/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.aranzman;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Aranzman;
import domain.Termin;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOEditAranzman extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Aranzman)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Aranzman!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ado.vratiUpitZaIzmenu(DBBroker.getInstance().getConnection()).execute();
        
        Aranzman a = (Aranzman) ado;
        
        if(a.getTermini().isEmpty()){
            a.getTermini().get(0).vratiUpitZaBrisanje(DBBroker.getInstance().getConnection()).execute();
        }else{
            a.getTermini().get(0).vratiUpitZaBrisanje(DBBroker.getInstance().getConnection()).execute();
            for (Termin termin : a.getTermini()) {
                termin.setAranzman(a);
                termin.vratiUpitZaUbacivanje(DBBroker.getInstance().getConnection()).execute();
            }
        }
        
    }
    
}
