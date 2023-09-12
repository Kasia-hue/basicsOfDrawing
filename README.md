# Basics Of Drawing
A mobile application for learning basics of drawing created for an Android Operating system.

## General Information
This project is practical part of my Engineering Thesis. The application was created for those, who want to start learning drawing from scratch. It contains 4 chapters: Tools, Shapes, Still Life and Landscape. Those topics were selected, because I consider them fundamentals of drawing. Every chapter is divided into 3 sections: Theory, Exercises and References Photos. User can first read about the subject, then do some exercises that help apply knowledge in practice. Finally you can practice your drawing skills with references photos.
System provides register, log in functionalities and unlocking next chapters. User starts with first chapter unlocked and after completing it, next one is available. Room library is used to store data about users and retrieve it from local database. Lifecycle library provides lifecycle-aware components. Gradle is used for building the project.

## Use Cases
Scenarios that system handles:
- sign up
- sign in
- view chapters
- choose chapter
- choose section of chapter
- unlock another chapter

## Technologies
Project is created with:
| Tool | Version |
| :- | :-: |
| Java | 8 |
| Room | 2.4.3 |
| Lifecycle | 2.5.1 |
| Gradle | 7.5 |

## Setup
To run this project, use download zip function or clone this repository into your local one. Then you can use Android Studio to open it and run.
The following are the system requirements to run on mobile device:
- Minimal Android SDK/API level: 21 (Android 5)
- Target Android SDK/API level: 32 (Android 12)