/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.Aranzman;
import domain.Klijent;
import domain.Termin;
import domain.Vodic;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author PC
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request req = (Request) in.readObject();
                Response res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) {
        Response res = new Response(null, null, ResponseStatus.Success);
        try {
            switch (req.getOperation()) {
                case Operation.ADD_ADMINISTRATOR:
                    ServerController.getInstance().addAdministrator((Administrator) req.getData());
                    break;
                case Operation.ADD_ARANZMAN:
                    ServerController.getInstance().addAranzman((Aranzman) req.getData());
                    break;
                case Operation.ADD_KLIJENT:
                    ServerController.getInstance().addKlijent((Klijent) req.getData());
                    break;
                case Operation.ADD_TERMIN:
                    ServerController.getInstance().addTermin((Termin) req.getData());
                    break;
                case Operation.ADD_VODIC:
                    ServerController.getInstance().addVodic((Vodic) req.getData());
                    break;
                case Operation.DELETE_ADMINISTRATOR:
                    ServerController.getInstance().deleteAdministrator((Administrator) req.getData());
                    break;
                case Operation.DELETE_KLIJENT:
                    ServerController.getInstance().deleteKlijent((Klijent) req.getData());
                    break;
                case Operation.DELETE_VODIC:
                    ServerController.getInstance().deleteVodic((Vodic) req.getData());
                    break;
                case Operation.EDIT_ADMINISTRATOR:
                    ServerController.getInstance().editAdministrator((Administrator) req.getData());
                    break;
                case Operation.EDIT_ARANZMAN:
                    ServerController.getInstance().editAranzman((Aranzman) req.getData());
                    break;
                case Operation.EDIT_KLIJENT:
                    ServerController.getInstance().editKlijent((Klijent) req.getData());
                    break;
                case Operation.EDIT_TERMIN:
                    ServerController.getInstance().editTermin((Termin) req.getData());
                    break;
                case Operation.EDIT_VODIC:
                    ServerController.getInstance().editVodic((Vodic) req.getData());
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    res.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_ARANZMAN:
                    res.setData(ServerController.getInstance().getAllAranzman());
                    break;
                case Operation.GET_ALL_HOTEL:
                    res.setData(ServerController.getInstance().getAllHotel());
                    break;
                case Operation.GET_ALL_KLIJENT:
                    res.setData(ServerController.getInstance().getAllKlijent());
                    break;
                case Operation.GET_ALL_TERMIN:
                    res.setData(ServerController.getInstance().getAllTermin());
                    break;
                case Operation.GET_ALL_TIP_PREVOZA:
                    res.setData(ServerController.getInstance().getAllTipPrevoza());
                    break;
                case Operation.GET_ALL_VODIC:
                    res.setData(ServerController.getInstance().getAllVodic());
                    break;

                case Operation.LOGIN:
                    ArrayList<Administrator> lista = ServerController.getInstance().getAllAdministrator();
                    Administrator a = (Administrator) req.getData();
                    for (Administrator administrator : lista) {
                        if (administrator.getUsername().equals(a.getUsername()) && 
                                administrator.getPassword().equals(a.getPassword())) {
                            res.setData(administrator);
                        }
                    }
                    if (res.getData() == null) {
                        throw new Exception("Ne postoji administrator sa unetim parametrima.");
                    } else {
                        break;
                    }
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setData(null);
            res.setResponseStatus(ResponseStatus.Error);
        }
        return res;
    }

}
