/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.ThongKeCustom;
import cores.nhanVienQuanLy.repositories.ThongKeRepository;
import cores.nhanVienQuanLy.services.ThongKeService;
import java.util.List;

/**
 *
 * @author window
 */
public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeRepository rp;

    public ThongKeServiceImpl() {
        rp = new ThongKeRepository();
    }

    @Override
    public List<ThongKeCustom> thongKeSoLuongTonNhieuNhat() {
        return rp.thongKeSoLuongTonNhieuNhat();
    }

}
