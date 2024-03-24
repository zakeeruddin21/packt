package com.packt;
import org.apache.maven.model.Model;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "validate-group-id")
public class GroupIdValidatorMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Validating groupId...");

        Model model = project.getModel();
        String groupId = model.getGroupId();

        if (!isValidGroupId(groupId)) {
            String errorMessage = "Invalid groupId: " + groupId + ". GroupId must be set to 'com.packt'.";
            getLog().error(errorMessage);
            throw new MojoExecutionException(errorMessage);
        } else {
            getLog().info("GroupId is valid: " + groupId);
        }
    }

    private boolean isValidGroupId(String groupId) {
        return "com.packt".equals(groupId);
    }
}
