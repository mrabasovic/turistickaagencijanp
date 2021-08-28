/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vodic;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Vodic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38160
 */
public class SOGetAllVodic extends AbstractSO {
    
    private ArrayList<Vodic> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Vodic)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Vodic!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        String upitZaSve = ado.vratiUpitZaSve();
        
        Statement stat = DBBroker.getInstance().getConnection().createStatement();
        ResultSet rs = stat.executeQuery(upitZaSve);
        
        ArrayList<AbstractDomainObject> listaVodica = ado.vratiListu(rs);
        lista = (ArrayList<Vodic>) (ArrayList<?>) listaVodica;
    }
    
    public ArrayList<Vodic> getLista() {
        return lista;
    }
    
}
