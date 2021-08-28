/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vodic;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Vodic;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOEditVodic extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Vodic)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Vodic!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ado.vratiUpitZaIzmenu(DBBroker.getInstance().getConnection()).execute();
    }
    
}
