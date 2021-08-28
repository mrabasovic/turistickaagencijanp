/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Aranzman;
import domain.Hotel;
import domain.Klijent;
import domain.Termin;
import domain.TipPrevoza;
import domain.Vodic;
import java.util.ArrayList;
import so.AbstractSO;
import so.administrator.SOAddAdministrator;
import so.administrator.SODeleteAdministrator;
import so.administrator.SOEditAdministrator;
import so.administrator.SOGetAllAdministrator;
import so.aranzman.SOAddAranzman;
import so.aranzman.SOEditAranzman;
import so.aranzman.SOGetAllAranzman;
import so.hotel.SOGetAllHotel;
import so.klijent.SOAddKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOEditKlijent;
import so.klijent.SOGetAllKlijent;
import so.termin.SOAddTermin;
import so.termin.SODeleteTermin;
import so.termin.SOEditTermin;
import so.termin.SOGetAllTermin;
import so.tipprevoza.SOGetAllTipPrevoza;
import so.vodic.SOAddVodic;
import so.vodic.SODeleteVodic;
import so.vodic.SOEditVodic;
import so.vodic.SOGetAllVodic;

/**
 *
 * @author PC
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public void addAdministrator(Administrator administrator) throws Exception {
        AbstractSO aso = new SOAddAdministrator();
        aso.templateExecute(administrator);
    }

    public void addAranzman(Aranzman aranzman) throws Exception {
        AbstractSO aso = new SOAddAranzman();
        aso.templateExecute(aranzman);
    }

    public void addKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SOAddKlijent();
        aso.templateExecute(klijent);
    }

    public void addTermin(Termin termin) throws Exception {
        AbstractSO aso = new SOAddTermin();
        aso.templateExecute(termin);
    }

    public void addVodic(Vodic vodic) throws Exception {
        AbstractSO aso = new SOAddVodic();
        aso.templateExecute(vodic);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception {
        AbstractSO aso = new SODeleteAdministrator();
        aso.templateExecute(administrator);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SODeleteKlijent();
        aso.templateExecute(klijent);
    }

    public void deleteVodic(Vodic vodic) throws Exception {
        AbstractSO aso = new SODeleteVodic();
        aso.templateExecute(vodic);
    }

    public void editAdministrator(Administrator administrator) throws Exception {
        AbstractSO aso = new SOEditAdministrator();
        aso.templateExecute(administrator);
    }

    public void editAranzman(Aranzman aranzman) throws Exception {
        AbstractSO aso = new SOEditAranzman();
        aso.templateExecute(aranzman);
    }

    public void editKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SOEditKlijent();
        aso.templateExecute(klijent);
    }

    public void editTermin(Termin termin) throws Exception {
        AbstractSO aso = new SOEditTermin();
        aso.templateExecute(termin);
    }

    public void editVodic(Vodic vodic) throws Exception {
        AbstractSO aso = new SOEditVodic();
        aso.templateExecute(vodic);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<Aranzman> getAllAranzman() throws Exception {
        SOGetAllAranzman so = new SOGetAllAranzman();
        so.templateExecute(new Aranzman());
        return so.getLista();
    }

    public ArrayList<Hotel> getAllHotel() throws Exception {
        SOGetAllHotel so = new SOGetAllHotel();
        so.templateExecute(new Hotel());
        return so.getLista();
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOGetAllKlijent so = new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<Termin> getAllTermin() throws Exception {
        SOGetAllTermin so = new SOGetAllTermin();
        so.templateExecute(new Termin());
        return so.getLista();
    }

    public ArrayList<TipPrevoza> getAllTipPrevoza() throws Exception {
        SOGetAllTipPrevoza so = new SOGetAllTipPrevoza();
        so.templateExecute(new TipPrevoza());
        return so.getLista();
    }

    public ArrayList<Vodic> getAllVodic() throws Exception {
        SOGetAllVodic so = new SOGetAllVodic();
        so.templateExecute(new Vodic());
        return so.getLista();
    }

    public void deleteTermin(Termin termin) throws Exception {
        AbstractSO aso = new SODeleteTermin();
        aso.templateExecute(termin);
    }
    
}
