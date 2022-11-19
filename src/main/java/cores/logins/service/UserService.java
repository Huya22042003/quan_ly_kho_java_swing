/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.logins.service;

import cores.logins.custom.NhanVienCustom;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author QUOC HUY
 */
public interface UserService {
    ConcurrentHashMap<String , NhanVienCustom> mapUserKeyEmail();
}
