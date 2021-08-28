/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipprevoza;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.TipPrevoza;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOGetAllTipPrevoza extends AbstractSO {
    
    private ArrayList<TipPrevoza> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TipPrevoza)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipPrevoza!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        String upitZaSve = ado.vratiUpitZaSve();
        
        Statement stat = DBBroker.getInstance().getConnection().createStatement();
        ResultSet rs = stat.executeQuery(upitZaSve);
        
        ArrayList<AbstractDomainObject> listaTipova = ado.vratiListu(rs);
        lista = (ArrayList<TipPrevoza>) (ArrayList<?>) listaTipova;
    }
    
    public ArrayList<TipPrevoza> getLista() {
        return lista;
    }
    
}
