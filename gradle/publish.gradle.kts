import java.net.URI

// https://help.github.com/en/github/managing-packages-with-github-packages/configuring-gradle-for-use-with-github-packages#example-using-gradle-groovy-for-multiple-packages-in-the-same-repository
configure<PublishingExtension> {
    repositories {
        maven {
            name = "github"

            // Because upper case letters aren't supported, you must use lowercase letters for
            // the repository owner even if the GitHub user or organization name contains
            // uppercase letters.
            //
            // https://help.github.com/en/github/managing-packages-with-github-packages/configuring-gradle-for-use-with-github-packages#authenticating-with-a-personal-access-token
            url = URI("https://maven.pkg.github.com/juullabs/swift-klib-plugin")

            credentials {
                username = project.findProperty("githubPackagesUsername") as? String
                password = project.findProperty("githubPackagesPassword") as? String
            }
        }
    }
}
