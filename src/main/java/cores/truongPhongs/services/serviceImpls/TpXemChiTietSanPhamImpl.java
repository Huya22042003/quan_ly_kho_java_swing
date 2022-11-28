package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom;
import cores.truongPhongs.repositories.TpXemChiTietSanPhamRepository;
import cores.truongPhongs.services.TpXemChiTietSanPhamService;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TpXemChiTietSanPhamImpl implements TpXemChiTietSanPhamService{
    private TpXemChiTietSanPhamRepository repo ;

    public TpXemChiTietSanPhamImpl() {
        repo = new TpXemChiTietSanPhamRepository();
    }
    
    @Override
    public List<TpXemChiTietSanPhamCustom> listCtsp() {
        return repo.getAll();
    }
    
}
