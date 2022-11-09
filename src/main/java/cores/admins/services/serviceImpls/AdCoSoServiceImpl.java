/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.admins.services.serviceImpls;

import cores.admins.customModels.AdGetTenCoSoCustom;
import cores.admins.repositories.AdCoSoRepository;
import cores.admins.services.AdCoSoService;
import java.util.List;

/**
 *
 * @author Acer
 */
public class AdCoSoServiceImpl implements AdCoSoService{
    private AdCoSoRepository repoCoSo;

    public AdCoSoServiceImpl() {
        repoCoSo = new AdCoSoRepository();
    }
    
    @Override
    public List<AdGetTenCoSoCustom> getCbbCoSo() {
        return repoCoSo.getCBBCoSo();
    }
    
}
