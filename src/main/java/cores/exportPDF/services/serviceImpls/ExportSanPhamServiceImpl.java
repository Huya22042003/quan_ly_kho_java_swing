package cores.exportPDF.services.serviceImpls;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import cores.exportPDF.repositoris.ExportSanPhamRepository;
import cores.exportPDF.services.ExportSanPhamService;
import domainModels.ChiTietSanPham;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import utilities.Converter;

/**
 *
 * @author QUOC HUY
 */
public class ExportSanPhamServiceImpl implements ExportSanPhamService {

    private ExportSanPhamRepository rp;
    private String partFileQrCode = "demo.png";

    public ExportSanPhamServiceImpl() {
        rp = new ExportSanPhamRepository();
    }

    public void createQR(String data)
            throws WriterException, IOException {

        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);

        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        System.out.println("QR Code Generated!!! ");

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200);

        MatrixToImageWriter.writeToFile(
                matrix,
                partFileQrCode.substring(partFileQrCode.lastIndexOf('.') + 1),
                new File(partFileQrCode));
    }

    @Override
    public boolean exportSanPham(String fileName, UUID idSanPham) {
        try {
            ChiTietSanPham ctsp = findChiTietSanPhamById(idSanPham);

            createQR(idSanPham.toString());

            //Loading an existing document
            File file = new File(fileName);
            PDDocument doc = new PDDocument();

            PDPage page = new PDPage();

            PDFont font = PDType0Font.load(doc, new File(getClass().getResource("\\font\\vuArial.ttf").toString()));

            doc.addPage(page);

            PDImageXObject pdImage = PDImageXObject.createFromFile(partFileQrCode, doc);

            File fileQr = new File(partFileQrCode);
            file.delete();

            PDPageContentStream contents = new PDPageContentStream(doc, page);
            if (ctsp.getHinhAnh() != null) {
                PDImageXObject pdImageGiay = PDImageXObject.createFromFile(ctsp.getHinhAnh(), doc);
                contents.drawImage(pdImageGiay, 400, 200);
            }
            contents.drawImage(pdImage, 400, 550);

            contents.beginText();

            String title = "Thông tin sản phẩm";

            String text = "Tên sản phẩm : " + ctsp.getSanPham().getTen();
            String text1 = "Mã sản phẩm : " + ctsp.getSanPham().getMa();
            String text2 = "Màu sắc : " + Converter.trangThaiMauSac(ctsp.getMau());
            String text3 = "Đơn vị : " + ctsp.getDonVi().getDonViQuyDoi();
            String text4 = "Size : " + ctsp.getSize();
            String text5 = "Ngày nhập : " + new Date(ctsp.getNgayTao()).toString();
            String text6 = "Năm bảo hành : " + ctsp.getNamBaoHanh();
            String text7 = "Giá bán : " + ctsp.getGiaBan();

            contents.setFont(font, 30);
            contents.newLineAtOffset(70, 700);
            contents.setLeading(30f);
            contents.showText(title);
            contents.newLine();

            contents.setFont(font, 16);
            contents.setLeading(25f);
            contents.showText(text);
            contents.newLine();
            contents.showText(text1);
            contents.newLine();
            contents.showText(text2);
            contents.newLine();
            contents.showText(text3);
            contents.newLine();
            contents.showText(text4);
            contents.newLine();
            contents.showText(text5);
            contents.newLine();
            contents.showText(text6);
            contents.newLine();
            contents.showText(text7);
            contents.newLine();
            contents.endText();
            contents.close();

            //Saving the document
            doc.save(file);

            //Closing the document
            doc.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public ChiTietSanPham findChiTietSanPhamById(UUID idSanPham) {
        return rp.findChiTietSanPham(idSanPham);
    }
}
