plugins {
    id("com.gradle.enterprise") version "3.12.3"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "1.1.3"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishOnFailure()
    }
}

gitHooks {
    preCommit {
        tasks("ktlintCheck")
    }
    commitMsg { conventionalCommits() }
    createHooks(true)
}

rootProject.name = "git-sensitive-semantic-versioning-gradle-plugin"
