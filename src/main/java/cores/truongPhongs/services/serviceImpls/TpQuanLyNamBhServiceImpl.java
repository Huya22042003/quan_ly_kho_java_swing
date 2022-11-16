/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpQuanLyNamBhCustom;
import cores.truongPhongs.repositories.TpQuanLyNamBhRepository;
import cores.truongPhongs.services.TpQuanLyNamBhService;
import domainModels.NamBaoHanh;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Acer
 */
public class TpQuanLyNamBhServiceImpl implements TpQuanLyNamBhService{
    private TpQuanLyNamBhRepository repo;

    public TpQuanLyNamBhServiceImpl() {
        repo = new TpQuanLyNamBhRepository();
    }
    
    @Override
    public List<TpQuanLyNamBhCustom> getListNamBh() {
        return repo.getListNamBh();
    }

    @Override
    public NamBaoHanh addNamBh(NamBaoHanh n) {
        return repo.addNamBh(n);
    }

    @Override
    public boolean updateNamBh(NamBaoHanh n) {
        return repo.updateNamBh(n);
    }
    @Override
    public boolean deleteNamBh(UUID id) {
        return repo.deleteNamBh(id);
    }
    
    
}
