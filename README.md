# Trapezoid

This is a Kotlin Multiplatform project targeting Android, Web, Server.

## Development

### Prerequisites

- Install Android Studio
- Install Java 17+

### Project Structure

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/server` is for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

### Running

- Android app: Use the `composeApp` task pre-configured for Android Studio.
- Server: `./gradlew :server:run` to start the server on <localhost:8080>.

## Team Details

### Team Members
- Anne Sun (anne.sun@uwaterloo.ca)
- Hannah Hwang (hannah.hwang@uwaterloo.ca)
- Justin Chung (justin.chung@uwaterloo.ca)
- Laura Tan (l3tan@uwaterloo.ca)

### Team Number
LEC002/LAB102 - 004

[Team Contract](https://git.uwaterloo.ca/j24chung/trapezoid/-/wikis/Team-Contract)

[Project Proposal](https://git.uwaterloo.ca/j24chung/trapezoid/-/wikis/Project-Proposal)

[Design Proposal](https://git.uwaterloo.ca/j24chung/trapezoid/-/wikis/Design-Proposal)

## License

This is proprietary :)
