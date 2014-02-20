/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.astar.taxi360.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import sg.edu.astar.taxi360.bo.PassengerFacade;
import sg.edu.astar.taxi360.entity.Passenger;

/**
 *
 * @author Thilak
 */
@Stateless
public class PassengerEJB {
    @EJB PassengerFacade passengerFacade;
   
    public Passenger getPassenger(long id) {
        return passengerFacade.find(id);
    }
    
    public long loginPassenger( Passenger p ) {
        Passenger pass = passengerFacade.findByEmail(p);
        if ( pass != null ) {
            passengerFacade.updateAccessKey(pass);
            return pass.getId();
        }
        else
            return (long)0;
            
    }
    
    public long createPasenger( Passenger pass ) {
        return passengerFacade.createPassenger(pass);
    }
    
    public Passenger getDetails(Long id){
        return passengerFacade.find(id);
    }

    public void updateAccessKey(Passenger pass) {
        passengerFacade.updateAccessKey(pass);
    }
}
