package org.example;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Mojo(name = "copy-resources", defaultPhase = LifecyclePhase.PACKAGE)
public class FileCopierMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.basedir}/src/main/resources", required = true)
    private File resourcesDirectory;

    @Parameter(defaultValue = "${project.build.directory}/${project.build.finalName}", required = true)
    private File outputDirectory;

    public void execute() throws MojoExecutionException {
        getLog().info("Copying resources from " + resourcesDirectory + " to " + outputDirectory);

        if (!resourcesDirectory.exists()) {
            getLog().warn("Resources directory does not exist: " + resourcesDirectory);
            return;
        }

        try {
            Files.walk(resourcesDirectory.toPath())
                    .forEach(sourcePath -> {
                        File destination = new File(outputDirectory, resourcesDirectory.toPath().relativize(sourcePath).toString());
                        if (sourcePath.toFile().isDirectory()) {
                            destination.mkdirs();
                        } else {
                            try {
                                Files.copy(sourcePath, destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException e) {
                                getLog().error("Failed to copy " + sourcePath + " to " + destination, e);
                            }
                        }
                    });
        } catch (IOException e) {
            throw new MojoExecutionException("Error copying resources", e);
        }
    }
}
