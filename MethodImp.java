/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import viewer.window.Menu;
import javax.swing.JFrame;
import util.Uiutil;

/**
 *
 * @author Leo
 */
public class MethodImp implements Method{

    @Override
    public void goM(JFrame jf) {
        
       new Menu().setVisible(true);
       jf.dispose();
    }

    @Override
    public void init(JFrame jf,String title) {
        jf.setTitle(title);
       Uiutil.setFrameCenter(jf);
    }

    @Override
    public boolean checkInt(String input) {
         String regex="[0-9]{1,3}";
        
        if(!input.matches(regex)){
            
           
            return false;
        }else{
            return true;
        }
        
    }

    @Override
    public boolean checkStr(String input) {
        String usernameRegex="[a-zA-Z]{0,20}";
    
        
   
            if(!input.matches(usernameRegex)){
               
                return false;
            }else{
                return true;
            }
            
            
    }

   
    
}
