package com.github.siiilas.testcodeanalyzer.model;

import java.io.File;

public class FilesController {

    private File resultFile;
    private File filesDirectory;

    public File getResultFile() {
        return resultFile;
    }

    public void setResultFile(File resultFile) {
        this.resultFile = resultFile;
    }

    public File getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(File filesDirectory) {
        this.filesDirectory = filesDirectory;
    }

}
