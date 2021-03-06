package com.mulodo.survey.batch.tasklet;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

import com.mulodo.survey.util.Util;

public class SurveyBackupTasklet implements Tasklet
{
	// fromDirectory is folder that contain zip file
    private Resource fromDirectory;
    // toDirectory is folder that we want to move
    private Resource toDirectory;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception
    {
        String dateString = Util.formatDate(new Date());
        File fromFolder = fromDirectory.getFile();
        File toFolder = new File(toDirectory.getFile(), dateString);

        if (!toFolder.exists()) {
            FileUtils.forceMkdir(toFolder);
        } else {
            if (!toFolder.isDirectory()) {
                throw new IllegalArgumentException("To folder isn't folder");
            }
        }

        File[] files = fromFolder.listFiles();

        File desFile;
        for (File file : files) {
            desFile = new File(toFolder, file.getName());
            if (desFile.exists()) {
                desFile.delete();
            }
            FileUtils.moveFileToDirectory(file, toFolder, false);
        }

        return RepeatStatus.FINISHED;
    }

    public Resource getFromDirectory()
    {
        return fromDirectory;
    }

    public void setFromDirectory(Resource fromDirectory)
    {
        this.fromDirectory = fromDirectory;
    }

    public Resource getToDirectory()
    {
        return toDirectory;
    }

    public void setToDirectory(Resource toDirectory)
    {
        this.toDirectory = toDirectory;
    }

}
