package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        // Input and output file paths
        String sourcePdfPath = "English Vocabulary in Use Pre-Intermediate and Intermediate.pdf";  // Path to the original PDF
        String adv = "English Vocabulary in Use Advanced.pdf";
        String outputPdfPath = "20250103.pdf";  // Path for the new PDF
        try (InputStream resourceStream = Main.class.getClassLoader().getResourceAsStream(sourcePdfPath);
             InputStream advStream = Main.class.getClassLoader().getResourceAsStream(adv);
             PDDocument sourceDocument = PDDocument.load(resourceStream);
             PDDocument advDocument = PDDocument.load(advStream);

             PDDocument targetDocument = new PDDocument()) {

            // Extract specific pages (e.g., pages 1 and 3)
            int[] pagesToExtract = {19, 20}; // Page numbers are 1-based

            for (int pageNumber : pagesToExtract) {
                // Remember: Pages in PDFBox are 0-based index
                PDPage page = sourceDocument.getPage(pageNumber - 1);
                targetDocument.addPage(page);
            }

            // Extract specific pages (e.g., pages 1 and 3)
            int[] advToExtract = {22, 23}; // Page numbers are 1-based

            for (int pageNumber : advToExtract) {
                // Remember: Pages in PDFBox are 0-based index
                PDPage page = advDocument.getPage(pageNumber - 1);
                targetDocument.addPage(page);
            }

            // Save the new PDF
            targetDocument.save(outputPdfPath);
            System.out.println("Pages extracted and saved to: " + outputPdfPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
