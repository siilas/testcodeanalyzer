package com.github.siiilas.testcodeanalyzer.builder;

import java.io.File;

import com.github.siiilas.testcodeanalyzer.exception.ServiceException;
import com.github.siiilas.testcodeanalyzer.model.FilesController;

public class FilesControllerBuilder {

    private FilesControllerBuilder() {
    }

    public static FilesController from(String[] args) {
        if (args == null || args.length < 2) {
            throw new ServiceException("Você deve passar os parâmetros <diretório de testes> <arquivo de resultado>");
        }
        FilesController filesController = new FilesController();
        filesController.setFilesDirectory(createDirectory(args[0]));
        filesController.setResultFile(createFile(args[1]));
        return filesController;
    }

    private static File createDirectory(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            throw new ServiceException("Diretório de testes não existe");
        }
        if (!directory.canRead()) {
            throw new ServiceException("Diretório de testes não pode ser lido");
        }
        return directory;
    }

    private static File createFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            throw new ServiceException("Arquivo de resultado já existe");
        }
        if (file.isDirectory()) {
            throw new ServiceException("Arquivo de resultado é um diretório");
        }
        return file;
    }

}
