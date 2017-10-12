package com.github.siiilas.testcodeanalyzer;

import com.github.siiilas.testcodeanalyzer.builder.FilesControllerBuilder;
import com.github.siiilas.testcodeanalyzer.exception.ServiceException;
import com.github.siiilas.testcodeanalyzer.log.Logger;
import com.github.siiilas.testcodeanalyzer.model.FilesController;
import com.github.siiilas.testcodeanalyzer.service.CodeAnalyzerService;

public class Starter {

    public static void main(String[] args) {
        try {
            Logger.log("Iniciando análise");
            FilesController controller = FilesControllerBuilder.from(args);
            new CodeAnalyzerService().review(controller);
            Logger.log("Concluindo análise");
        } catch (ServiceException e) {
            Logger.error("Erro ao executar aplicação", e);
        } catch (Exception e) {
            Logger.error("Erro ao executar aplicação", e);
        }
    }

}
