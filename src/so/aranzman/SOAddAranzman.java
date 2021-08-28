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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOAddAranzman extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Aranzman)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Aranzman!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        PreparedStatement ps = ado.vratiUpitZaUbacivanje(DBBroker.getInstance().getConnection());
        ps.execute();
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long aranzmanID = tableKeys.getLong(1);

        Aranzman a = (Aranzman) ado;
        
        a.setAranzmanID(aranzmanID);

        if (a.getTermini() != null) {
            for (Termin termin : a.getTermini()) {
                termin.setAranzman(a);
                termin.vratiUpitZaUbacivanje(DBBroker.getInstance().getConnection()).execute();
            }
        }

    }

}
