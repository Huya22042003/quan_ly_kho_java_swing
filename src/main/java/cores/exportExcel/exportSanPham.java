package cores.exportExcel;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author QUOC HUY
 */
public class exportSanPham {

    public static void main(String[] args) throws IOException {
        //Loading an existing document
        File file = new File("D:\\Du_an_1\\src\\main\\resources\\testExportPDF.pdf");
        PDDocument doc = new PDDocument();
        
        PDPage page = new PDPage();
        
        PDFont font = PDType0Font.load(doc, new File("D:\\Du_an_1\\src\\main\\resources\\font\\vuArial.ttf"));
        
        doc.addPage(page);

        PDImageXObject pdImage = PDImageXObject.createFromFile("D:\\Du_an_1\\src\\main\\resources\\demo.png", doc);

        PDPageContentStream contents = new PDPageContentStream(doc, page);
        
        contents.drawImage(pdImage, 400, 550);
        
        
        contents.beginText();
        
        String title = "Sản phẩm A";
        
        String text = "This is the sample document and we are adding content to it.";
        String text1 = "This is the sample document and we are adding content to it.";
        String text2 = "This is the sample document and we are adding content to it.";
        String text3 = "This is the sample document and we are adding content to it.";
        String text4 = "This is the sample document and we are adding content to it.";
        String text5 = "This is the sample document and we are adding content to it.";
        String text6 = "This is the sample document and we are adding content to it.";
        String text7 = "This is the sample document and we are adding content to it.";
        String text8 = "This is the sample document and we are adding content to it.";
        String text9 = "This is the sample document and we are adding content to it.";
        String text0 = "This is the sample document and we are adding content to it.";
        
        contents.setFont(font, 30);
        contents.newLineAtOffset(70, 700);
        contents.setLeading(30f);
        contents.showText(title);
        contents.newLine();
        
        contents.setFont(font, 12);
        contents.setLeading(18f);
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
        contents.showText(text8);
        contents.newLine();
        contents.showText(text9);
        contents.newLine();
        contents.showText(text0);
        contents.newLine();
        contents.endText();
        contents.close();

        System.out.println("Image inserted");

        //Saving the document
        doc.save(file);

        //Closing the document
        doc.close();

    }
}
