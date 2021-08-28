/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.termin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Termin;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOEditTermin extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Termin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Termin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ado.vratiUpitZaIzmenu(DBBroker.getInstance().getConnection()).execute();
    }
    
}
