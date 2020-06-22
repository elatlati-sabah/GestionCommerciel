package com.pfe.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.pfe.entity.Produit;
import com.pfe.repository.ProduitRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ProduitRepository produitRepository;


   /* public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\Sabah El Atlati\\Desktop\\Factures";
        List<Produit> produits = produitRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:devis.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(produits);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "openITC");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\factures.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\factures.pdf");
        }

        return "report generated in path : " + path;
    }*/
}
