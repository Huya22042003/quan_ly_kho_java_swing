package cores.exportExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author QUOC HUY
 */
public class exportSanPham {

    public static String output = "rest-with-spring.docx";

    private static XWPFDocument document;

    public exportSanPham() {
        document = new XWPFDocument();
    }

    private String path(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }

//    private String fileName(String name) {
//        return name + new Date(DateTimeUtil.convertDateToTimeStampSecond()).toString();
//    }
//
//    private void title(String tieuDe) {
//        // tạo phu đề
//        XWPFParagraph title = document.createParagraph();
//        title.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun titleRun = title.createRun();
//        titleRun.setText(tieuDe);
//        titleRun.setColor("000000");
//        titleRun.setBold(true);
//        titleRun.setFontFamily("Courier");
//        titleRun.setFontSize(20);
//    }
//
//    private void subTitle(String phuDe) {
//        // tiêu đề phụ
//        XWPFParagraph subTitle = document.createParagraph();
//        XWPFRun subTitleRun = subTitle.createRun();
//        subTitleRun.setText(phuDe);
//        subTitleRun.setColor("000000");
//        subTitleRun.setFontFamily("Courier");
//        subTitleRun.setFontSize(16);
//        subTitleRun.setTextPosition(20);
//        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
//    }
//
//    private void chonAnh(String phuDe, String tenAnh,JFrame frame) {
//        try {
//            // chèn ảnh
//            XWPFParagraph image = document.createParagraph();
//            image.setAlignment(ParagraphAlignment.CENTER);
//            XWPFRun imageRun = image.createRun();
//            imageRun.setTextPosition(20);
//
//            Path imagePath = Paths.get(ClassLoader.getSystemResource(tenAnh).toURI());
//            imageRun.addPicture(Files.newInputStream(imagePath),
//                    XWPFDocument.PICTURE_TYPE_PNG, imagePath.getFileName().toString(),
//                    Units.toEMU(100), Units.toEMU(100));
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(frame, "Lỗi ảnh");
//        }
//    }
//
//    private void chonBang(List<ChiTietSanPham> demoTable) {
//        // chèn bảng
//        XWPFTable table = document.createTable(1, 9);
//        XWPFTableRow row1 = table.getRow(0);
//        row1.getCell(0).setText("STT");
//        row1.getCell(1).setText("Tên");
//        row1.getCell(2).setText("Ảnh");
//        for (int i = 0; i < demoTable.size(); i++) {
//            ChiTietSanPham ct = demoTable.get(i);
//            XWPFTableRow row = null;
//            if (row == null) {
//                row = table.createRow();
//                row.getCell(0).setText(String.valueOf(i + 1));
//                row.getCell(1).setText(ct.getSanPham().getMa());
//                row.getCell(2).setText(ct.getSanPham().getTen());
//                row.getCell(3).setText(Converter.trangThaiMauSac(ct.getMau()));
//                row.getCell(4).setText(ct.getGiaNhap().toString());
//                row.getCell(5).setText(ct.getGiaBan().toString());
//                row.getCell(6).setText(String.valueOf(ct.getNamBaoHanh()));
//                row.getCell(7).setText(String.valueOf(ct.getSoLuongTon()));
//                row.getCell(8).setText(ct.getDonVi().getDonViQuyDoi());
//                if (ct.getHinhAnh() != null) {
//                    try {
//                        Path imagePath = Paths.get(ClassLoader.getSystemResource("test_acvsad.png").toURI());
//                        XWPFRun run = row.getCell(2).addParagraph().createRun();
//                        run.addPicture(Files.newInputStream(imagePath),
//                                XWPFDocument.PICTURE_TYPE_PNG, imagePath.getFileName().toString(),
//                                Units.toEMU(100), Units.toEMU(100));
//                    } catch (Exception ex) {
//                        JOptionPane.showMessageDialog(frame, "Lỗi ảnh");
//                    }
//                }
//
//            }
//        }
//    }

//    private void themBang()
    public static void main(String[] args) throws InvalidFormatException, IOException, URISyntaxException {
document = new XWPFDocument();
        // tạo phu đề
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = title.createRun();
        titleRun.setText("Sản phẩm");
        titleRun.setColor("000000");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);

        // tiêu đề phụ
        XWPFParagraph subTitle = document.createParagraph();
        subTitle.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun subTitleRun = subTitle.createRun();
        subTitleRun.setText("Sản phẩm aaaaaa");
        subTitleRun.setColor("000000");
        subTitleRun.setFontFamily("Courier");
        subTitleRun.setFontSize(16);
        subTitleRun.setTextPosition(20);
        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);

        // chèn ảnh
        XWPFParagraph image = document.createParagraph();
        image.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun imageRun = image.createRun();
        imageRun.setTextPosition(20);

        Path imagePath = Paths.get(ClassLoader.getSystemResource("test_acvsad.png").toURI());
        imageRun.addPicture(Files.newInputStream(imagePath),
                XWPFDocument.PICTURE_TYPE_PNG, imagePath.getFileName().toString(),
                Units.toEMU(100), Units.toEMU(100));

        // List demo
        List<String> demoTable = new ArrayList<>();
        demoTable.add("bdsaknkas");
        demoTable.add("bdsaknkas");
        demoTable.add("bdsaknkas");

        // chèn bảng
        XWPFTable table = document.createTable(1, 3);
        XWPFTableRow row1 = table.getRow(0);
        row1.getCell(0).setText("STT");
        row1.getCell(1).setText("Tên");
        row1.getCell(2).setText("Ảnh");
        for (int i = 0; i < demoTable.size(); i++) {
            XWPFTableRow row = null;
            if (row == null) {
                row = table.createRow();
                row.getCell(0).setText(String.valueOf(i + 1));
                row.getCell(1).setText(demoTable.get(i));
                XWPFRun run = row.getCell(2).addParagraph().createRun();
                run.addPicture(Files.newInputStream(imagePath),
                        XWPFDocument.PICTURE_TYPE_PNG, imagePath.getFileName().toString(),
                        Units.toEMU(100), Units.toEMU(100));
            }
        }

        // suất file
        FileOutputStream out = new FileOutputStream(output);
        document.write(out);
        out.close();
        document.close();
    }
}
