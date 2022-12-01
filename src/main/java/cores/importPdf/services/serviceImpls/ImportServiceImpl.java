package cores.importPdf.services.serviceImpls;

import cores.importPdf.customModels.MessAlert;
import cores.importPdf.customModels.SanPhamCustom;
import cores.importPdf.repositories.ImportRepository;
import java.awt.Rectangle;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import cores.importPdf.services.ImportService;
import domainModels.ChiTietSanPham;
import domainModels.DonVi;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import utilities.DateTimeUtil;
import utilities.MaTuSinh;

/**
 *
 * @author QUOC HUY
 */
public class ImportServiceImpl implements ImportService {

    private ImportRepository rp;

    private ConcurrentHashMap<String, DonVi> mapDonVi;

    private ConcurrentHashMap<String, SanPham> mapSanPham;

    public ImportServiceImpl() {
        rp = new ImportRepository();
    }

    @Override
    public List<SanPhamCustom> importList(String fileName) {
        try {
            List<SanPhamCustom> list = new ArrayList<>();

            File file = new File(fileName);
            PDDocument document = PDDocument.load(file);

            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);
            Rectangle rect1 = new Rectangle(0, 300, 1000, 1000);
            stripper.addRegion("row1column1", rect1);
            PDPage firstPage = document.getPage(0);
            stripper.extractRegions(firstPage);
            String text = stripper.getTextForRegion("row1column1");
            String textData = text.substring(0, text.indexOf("Cộng"));
            String[] arrayData = textData.split("VND. ");
            String[] newArraya = null;
            for (int i = 0; i < arrayData.length; i++) {
                SanPhamCustom sp = new SanPhamCustom();
                String string = arrayData[i];
                if (string.trim().length() == 0) {
                    continue;
                }
                String[] elData = string.split("  ");
                List<Integer> locations = new ArrayList<>();
                for (int j = 0; j < elData.length; j++) {
                    String string1 = elData[j];
                    if (string1.trim().length() == 0) {
                        continue;
                    }
                    locations.add(j);
                    System.out.println(string1.trim() + " - " + j);
                }

                Integer get = locations.get(1);

                sp.setStt(elData[locations.get(0)].trim());
                sp.setMa(elData[locations.get(1)].trim());
                sp.setTen(elData[locations.get(2)].trim());
                sp.setSoLuongTon(Integer.parseInt(elData[locations.get(5)].trim()));
                sp.setMau(elData[locations.get(3)].trim());
                sp.setSize(Integer.parseInt(elData[locations.get(4)].trim()));
                sp.setNamBaoHanh(Integer.parseInt(elData[locations.get(6)].trim()));
                sp.setDonVi(elData[locations.get(7)].trim());
                sp.setGiaNhap(new BigDecimal(elData[locations.get(8)].trim()));
                list.add(sp);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void loadMap() {
        mapDonVi = new ConcurrentHashMap<>();
        mapSanPham = new ConcurrentHashMap<>();

        for (DonVi el : rp.findDonViByDonViQuyDoi()) {
            mapDonVi.put(el.getDonViQuyDoi(), el);
        }

        for (SanPham el : rp.findSanPhamByTenSanPham()) {
            mapSanPham.put(el.getTen(), el);
        }

    }

    private MauConstant convertMau(String mau) {
        switch (mau.toLowerCase()) {
            case "Vàng":
                return MauConstant.VANG;
            case "Xanh":
                return MauConstant.XANH_LA;
            case "Đỏ":
                return MauConstant.DO;
            case "Hồng":
                return MauConstant.HONG;
            case "Cam":
                return MauConstant.CAM;
            case "Đen":
                return MauConstant.DEN;
            case "Trắng":
                return MauConstant.TRANG;
            default:
                return MauConstant.KHAC;
        }
    }

    @Override
    public MessAlert importData(List<SanPhamCustom> listPdf) {
        loadMap();
        MessAlert alert = new MessAlert();
        Queue que = new ArrayDeque();
        try {
            listPdf.parallelStream().forEach(el -> {
                if (!mapSanPham.containsKey(el.getTen())) {
                    SanPham sp = new SanPham();
                    sp.setMa(MaTuSinh.gen("SP"));
                    sp.setTen(el.getTen());
                    mapSanPham.put(sp.getTen(), sp);
                }

                if (!mapDonVi.containsKey(el.getDonVi())) {
                    DonVi dv = new DonVi();
                    dv.setSoLuong(100);
                    dv.setDonViGoc("Đôi");
                    dv.setDonViQuyDoi(el.getDonVi());
                    mapDonVi.put(dv.getDonViQuyDoi(), dv);
                }

                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMau(convertMau(el.getMau()));
                ctsp.setSoLuongTon(el.getSoLuongTon());
                ctsp.setNamBaoHanh(el.getNamBaoHanh());
                ctsp.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
                ctsp.setSanPham(mapSanPham.get(el.getTen()));
                ctsp.setGiaNhap(el.getGiaNhap());
                ctsp.setDonVi(mapDonVi.get(el.getDonVi()));
                ctsp.setTrangThai(TrangThaiSanPhamConstanst.CHO_XAC_NHAN);
                que.add(ctsp);
                alert.setStatus(true);
            });
            if (!que.isEmpty()) {
                for (Object object : que) {
                    rp.insertChiTietSanPham((ChiTietSanPham) que.poll());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            alert.setStatus(false);
            alert.setMess("Lỗi hệ thống");
        }

        return alert;
    }
}
