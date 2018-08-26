/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import javax.swing.JFrame;

/**
 *
 * @author Leo
 */
public interface Method {
    public abstract void goM(JFrame jf);
    
    public abstract void init(JFrame jf,String title);
    
    public abstract boolean checkInt(String input);
    public abstract boolean checkStr(String input);
}
