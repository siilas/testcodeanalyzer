package com.github.siiilas.testcodeanalyzer.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.github.siiilas.testcodeanalyzer.exception.ServiceException;
import com.github.siiilas.testcodeanalyzer.model.FilesController;
import com.github.siiilas.testcodeanalyzer.model.JavaFile;

public class CodeAnalyzerService {

    private List<JavaFile> javaFiles = new ArrayList<>();
    private List<File> filesForReview = new ArrayList<>();

    public void review(FilesController controller) {
        findFiles(controller.getFilesDirectory());
        reviewFiles();
        saveResults(controller.getResultFile());
    }

    void findFiles(File directory) {
        try {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    findFiles(file);
                } else if (file.isFile() && isJavaFile(file)) {
                    filesForReview.add(file);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erro ao ler arquivos de teste");
        }
    }

    void reviewFiles() {
        if (filesForReview == null || filesForReview.isEmpty()) {
            throw new ServiceException("Sem arquivos de test para análise");
        }
        JavaFile javaFile;
        for (File file : filesForReview) {
            javaFile = new JavaFile();
            // Analisar arquivos
            if (javaFile.isValid()) {
                javaFiles.add(javaFile);
            }
            filesForReview.remove(file);
        }
    }

    void saveResults(File result) {
        // Salvar resultados
    }

    boolean isJavaFile(File file) {
        return file.getName().toLowerCase().endsWith(".java");
    }

}
