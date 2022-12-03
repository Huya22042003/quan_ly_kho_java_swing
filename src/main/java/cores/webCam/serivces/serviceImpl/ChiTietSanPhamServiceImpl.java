/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.webCam.serivces.serviceImpl;

import cores.webCam.customModels.ChiTietSanPhamCustom;
import cores.webCam.repositories.ChiTietSanPhamRepository;
import cores.webCam.serivces.ChiTietSanPhamService;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author QUOC HUY
 */
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService{

    private ChiTietSanPhamRepository rp;
    
    public ChiTietSanPhamServiceImpl() {
        rp = new ChiTietSanPhamRepository();
    }

    @Override
    public ConcurrentHashMap<UUID, ChiTietSanPhamCustom> getMapChiTietSanPham() {
        ConcurrentHashMap<UUID, ChiTietSanPhamCustom> ctsp = new ConcurrentHashMap<>();
        rp.getListChiTietSanPham().parallelStream().forEach(el -> {
            ctsp.put(el.getId(), el);
        });
        return ctsp;
    }
    
}
