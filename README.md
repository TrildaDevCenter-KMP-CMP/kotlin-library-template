# Kotlin Library Template [![CI](https://github.com/christian-draeger/kotlin-library-template/actions/workflows/build.yml/badge.svg)](https://github.com/christian-draeger/kotlin-library-template/actions/workflows/build.yml) ![Maven Central Version](https://img.shields.io/maven-central/v/codes.draeger/kotlin-library-template-example?logo=sonatype&label=Release)

An **opinionated Kotlin library template** designed to jumpstart your Kotlin library projects with ease. This template provides a robust and scalable foundation for library development, with built-in automation tools to guide you from initial setup to publishing and maintaining your library effortlessly.

## 🚀 Features

- **⏩️ Quick Start:** No complex setup required. Simply fork this template, adjust the settings, and start coding.
- **🧱 Modular Structure:** Designed from the ground up to support splitting your library into multiple smaller libraries, enabling more granular access and flexibility for users of your project.
- **🌈 Powered by Kotlin Multiplatform:** Offers full flexibility in choosing your target platforms
- **📦 Automated Publishing:** Fully configured Gradle setup for publishing to Maven Central or other package repositories.
- **🗽 CI independent:** Every crucial task like build, test, release, lining, coverage measurement and version catalog update can be executed manually via Gradle tasks.
- **🔋 Ready to go:** Everything you need to get started with your library included:
    - [x] [Explicit API mode](https://kotlinlang.org/docs/whatsnew14.html#explicit-api-mode-for-library-authors) to enforce visibility to be specifically declared.
    - [x] Automatic versioning following [Semantic Versioning](https://semver.org/) principles.
    - [x] [Gradle version catalog](https://docs.gradle.org/current/userguide/version_catalogs.html) for easy and clean cross module dependency management.
    - [ ] [Gradle convention plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html) for consistent and reusable project configuration.
    - [x] Automatic dependency version checks and updates via [Gradle Versions Plugin](https://github.com/littlerobots/version-catalog-update-plugin).
    - [x] static code analysis and linting via [detekt](https://detekt.dev/) and [ktlint](https://ktlint.github.io/).
    - [ ] [OSS Review Toolkit](https://oss-review-toolkit.org/ort/docs/intro) integration for automated license compliance checks.
    - [ ] Testing setup and coverage reporting out of the box.
- **🟢 CI/CD Ready:** Preconfigured GitHub Actions workflows for seamless builds, releases and maintenance.
    - [x] Build, test and release snapshot version on every push to main.
    - [x] One-Click publish to Maven Central with automatic versioning.
    - [x] Scheduled automatic version catalog update updates via PR by using gradle task.

---

## 📦 Benefits of the Automated Publisher

This template comes with a powerful **automated publishing system**:

1. **Secure Configuration:**
    - Handles sensitive data such as access tokens securely through environment variables.
    - Built-in support for CI/CD workflows ensures safe and consistent deployments.

2. **Automatic Versioning:**
    - Semantic Versioning is automatically managed based on tags or commit messages.
    - No manual updates required in your `build.gradle.kts`.

---

## 🛠️ Installation and Usage

Even though this template tries to reduce necessary manual steps as much as possible, 
there are still some things you need to do, since you can not inherit some settings from github template repository.

Please follow the [initial setup guide](INITIAL_SETUP.md) to get started. It won't take more than a few minutes.

---

## 🤖 Preconfigured CI/CD Workflows

This template includes ready-to-use GitHub Actions workflows for:
- **Build & Test:** Ensures your library is reliable and bug-free.
- **Release:** Automatically publishes new versions when a release tag is created.
- **Linting:** Keeps your code clean and adherent to Kotlin standards.
- **Maintenance:** Automatic updates of your dependencies via Pull Request.
---

## ⚡️ Troubleshooting
### How to get the signing key
Please change the `<key id>` placeholder in the following command to your signing key id.
```bash
gpg --export-secret-keys --armor <key id> | grep -v '\-\-' | grep -v '^=.' | tr -d '\n'
```

---

## 📄 License

This repository is licensed under the [MIT License](LICENSE).

---

With this template, you can focus on writing great code while the boilerplate tasks are taken care of. Happy coding! 🎉
