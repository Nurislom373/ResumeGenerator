package com.elbar.cv_gen.service.project.template_gen;

import com.elbar.cv_gen.dto.project.template_gen.TemplateGenCreateDTO;
import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import com.elbar.cv_gen.repository.project.template.TemplateRepository;
import com.elbar.cv_gen.service.BaseService;
import com.itextpdf.html2pdf.HtmlConverter;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
@Transactional
@RequiredArgsConstructor
public class TemplateGenService implements BaseService {

    private final TemplateRepository templateRepository;
    private final Configuration configuration;

    private final static String uploadDirectory = "src/main/resources/uploads/";
    private final static int name = (int) (Math.random() * (1000 - 1 + 1) + 1);

    private String generateTemplate(TemplateGenCreateDTO dto) {
        try {
            Template template = configuration.getTemplate("srt-resume.html");
            TemplateEntity templateEntity = templateRepository.findById(dto.getTemplateId()).orElseThrow(() -> new RuntimeException("Template not found"));
            JSONObject object = new JSONObject(templateEntity.getFields());
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createTemplate(TemplateGenCreateDTO dto) {
        try {
            String template = generateTemplate(dto);
            System.out.println(template);
            OutputStream pdfStream = new FileOutputStream(uploadDirectory + name + "_gen_template.pdf");
            HtmlConverter.convertToPdf(template, pdfStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Resource gen(TemplateGenCreateDTO dto) {
        createTemplate(dto);
        return new ClassPathResource(uploadDirectory + name + "_gen_template.pdf");
    }
}
